package com.example.workshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.workshop.entities.Places;

public interface PlacesRepository extends JpaRepository<Places, Long> {

}
