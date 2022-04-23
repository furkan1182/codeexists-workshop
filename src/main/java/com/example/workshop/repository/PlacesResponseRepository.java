package com.example.workshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.workshop.entities.PlacesResponse;
import com.example.workshop.entities.Query;

public interface PlacesResponseRepository extends JpaRepository<PlacesResponse, Long>{
	
	Optional<PlacesResponse> findByQuery(Query query);
}
