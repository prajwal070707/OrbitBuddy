package com.cowtown.orbitbuddy.repository;



import com.cowtown.orbitbuddy.entity.Satellite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SatelliteRepository extends JpaRepository<Satellite, Long> {
}
