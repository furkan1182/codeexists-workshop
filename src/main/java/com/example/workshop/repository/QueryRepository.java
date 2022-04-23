package com.example.workshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.workshop.entities.Query;

public interface QueryRepository extends JpaRepository<Query, Long> {
	
	Optional<Query> findByLongtitudeAndLatitudeAndRadius(double longtitude, double latitude, double radius);

}
