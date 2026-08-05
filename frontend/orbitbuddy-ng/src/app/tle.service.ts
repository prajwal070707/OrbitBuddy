import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { interval, switchMap } from 'rxjs';
import { Tle } from './tle.model';

@Injectable({ providedIn: 'root' })
export class TleService {

  constructor(private http: HttpClient) {}

  getTle() {
  return interval(2000).pipe(
    switchMap(() => this.http.get<Tle[]>('http://localhost:8080/orbitbuddy/satellites'))
  );
}
}
