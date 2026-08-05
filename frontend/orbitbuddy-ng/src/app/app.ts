import { Component, OnInit } from '@angular/core';
import * as Cesium from 'cesium';
import * as satellite from 'satellite.js';
import { TleService } from './tle.service';
import { Tle } from './tle.model';



@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.html',
  styleUrls: ['./app.css'],
   providers: [TleService] 
})


export class App implements OnInit {
   constructor(private tleService: TleService) {}

  async ngOnInit() {
    (window as any).CESIUM_BASE_URL = '/cesium/';

    Cesium.Ion.defaultAccessToken = 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJqdGkiOiIwZDdmZjRkMC00NmM1LTRkN2UtOTgyNC0xODFmMjQ1ZjFjYTMiLCJpZCI6NDYyOTE4LCJpc3MiOiJodHRwczovL2FwaS5jZXNpdW0uY29tIiwiYXVkIjoidW5kZWZpbmVkX2RlZmF1bHQiLCJpYXQiOjE3ODU1OTkxODJ9.wD_kRZ3zeKmkgwxKft52XxhVrrEuobrziRoXeEmX9k4';

    const viewer = new Cesium.Viewer('cesiumContainer', {
      terrainProvider: await Cesium.CesiumTerrainProvider.fromIonAssetId(1),
      baseLayerPicker: false
    });

     const issLatitude = 0.0;        // Equator
  const issLongitude = 0.0;       // Prime meridian
  const issAltitude = 420000;     // 420 km above Earth

  const issPosition = Cesium.Cartesian3.fromDegrees(
    issLongitude,
    issLatitude,
    issAltitude
  );
viewer.entities.add({
  id: 'iss',
  name: 'ISS',
  position: issPosition,
  model: {
    uri: '/assets/iss.glb',
    scale: 1500,
    minimumPixelSize: 64,
    maximumScale: 1500,
   
  }
});


  viewer.flyTo(viewer.entities);

 this.tleService.getTle().subscribe(tleArray => {

  if (!tleArray || tleArray.length === 0) {
    console.warn('No TLE data received');
    return;
  }

  const tle = tleArray[0];   // ⭐ your backend returns an array

  this.updateSatellitePosition(tle.line1, tle.line2, viewer);
});

  
}
 updateSatellitePosition(line1: string, line2: string, viewer: Cesium.Viewer) {

  const satrec = satellite.twoline2satrec(line1, line2);

  const now = new Date();
  const pv = satellite.propagate(satrec, now);

  // FIX: prevent null propagation crash
  if (!pv || !pv.position) {
    console.warn('Propagation failed');
    return;
  }

  const gmst = satellite.gstime(now);
  const gd = satellite.eciToGeodetic(pv.position, gmst);

  const longitude = satellite.degreesLong(gd.longitude);
  const latitude = satellite.degreesLat(gd.latitude);
  const altitude = gd.height * 1000;

  const pos = Cesium.Cartesian3.fromDegrees(longitude, latitude, altitude);

  // FIX: Cesium requires a PositionProperty
 const issEntity = viewer.entities.getById('iss');
if (!issEntity) {
  console.warn('ISS entity not found');
  return;
}

issEntity.position = new Cesium.ConstantPositionProperty(pos);

}

}

