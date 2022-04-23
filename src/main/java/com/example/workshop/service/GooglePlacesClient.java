package com.example.workshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.workshop.entities.Places;

@Service
public class GooglePlacesClient {
	public List<Places> search(double longtitude, double latitude, double radius) {
		return List.of(new Places("Bedirhan Pub", "Bahçelievler", 4.0, 27.0, 35.1),
				new Places("Kebabçı Ali", "Bahçelievler", 5.0, 27.0, 35.2),	
				new Places("Tatlıcı Nuri", "Bahçelievler", 3.2, 27.0, 35.3),
				new Places("Özen Butik", "Bahçelievler", 2.4, 27.0, 35.4));
	}
}