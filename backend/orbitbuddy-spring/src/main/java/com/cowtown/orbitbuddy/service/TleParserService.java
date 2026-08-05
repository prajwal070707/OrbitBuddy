package com.cowtown.orbitbuddy.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import com.cowtown.orbitbuddy.entity.Satellite;
import com.cowtown.orbitbuddy.repository.SatelliteRepository;
import com.cowtown.orbitbuddy.service.TleService;

@Service
public class TleParserService {

    private final SatelliteRepository repository;
    
    @Autowired
    private final TleService tleService;
    
  
    

    public TleParserService(SatelliteRepository repository, TleService tleService) {
        this.repository = repository;
        this.tleService = tleService;
    }
    public void saveTleData(String tleRaw) {
        String[] lines = tleRaw.split("\n");
        List<Satellite> satellites = new ArrayList<>();

        for (int i = 0; i < lines.length; i += 3) {
            if (i + 2 < lines.length) {
                satellites.add(new Satellite(lines[i].trim(), lines[i+1].trim(), lines[i+2].trim()));
            }
        }

        repository.saveAll(satellites);
        System.out.println("Saved " + satellites.size() + " satellites to the database!");
    }
    @Scheduled(cron = "0 0 2 * * ?")
    public void fetchAndSaveDaily() {
        System.out.println("Fetching TLE data at: " + java.time.LocalDateTime.now());

        String tleRaw = tleService.fetchTleData();
        String[] lines = tleRaw.split("\\r?\\n");

        for (int i = 0; i < lines.length; i += 3) {
            if (i + 2 < lines.length) {
                repository.save(new Satellite(lines[i].trim(), lines[i+1].trim(), lines[i+2].trim()));
            }
        }

        System.out.println("TLE data saved successfully!");
    }
}
