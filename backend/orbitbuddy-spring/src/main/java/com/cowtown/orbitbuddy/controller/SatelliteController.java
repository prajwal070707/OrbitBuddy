package com.cowtown.orbitbuddy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cowtown.orbitbuddy.entity.Satellite;
import com.cowtown.orbitbuddy.repository.SatelliteRepository;

@RestController
@RequestMapping("/orbitbuddy")
@CrossOrigin
public class SatelliteController {
	
	
	private  SatelliteRepository satelliteRepository;
	
	SatelliteController(SatelliteRepository satelliteRepository){
		this.satelliteRepository = satelliteRepository;
	}
	
	@GetMapping("/satellites")
	public List<Satellite> satellites(){
		
		return satelliteRepository.findAll();
		
	}
	
	@GetMapping("/satellite")
	public String thisIsTest() {
		return "This is not a test";
	}
	

}
