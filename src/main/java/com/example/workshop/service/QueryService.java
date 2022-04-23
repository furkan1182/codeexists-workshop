package com.example.workshop.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.workshop.entities.Places;
import com.example.workshop.entities.PlacesResponse;
import com.example.workshop.entities.Query;
import com.example.workshop.entities.dto.PlacesDto;
import com.example.workshop.entities.dto.QueryRequest;
import com.example.workshop.entities.dto.QueryResponse;
import com.example.workshop.repository.PlacesRepository;
import com.example.workshop.repository.PlacesResponseRepository;
import com.example.workshop.repository.QueryRepository;

@Service
public class QueryService {

	private QueryRepository queryRepository;
	private PlacesResponseRepository placesResponseRepository;
	private PlacesRepository placesRepository;
	private GooglePlacesClient client;

	public QueryService(QueryRepository queryRepository, PlacesResponseRepository placesResponseRepository,
			PlacesRepository placesRepository, GooglePlacesClient client) {
		super();
		this.queryRepository = queryRepository;
		this.placesResponseRepository = placesResponseRepository;
		this.placesRepository = placesRepository;
		this.client = client;
	}

	public QueryResponse fetchPlaces(QueryRequest request) {
		var savedQuery = queryRepository.findByLongtitudeAndLatitudeAndRadius(request.getLongtitude(),
				request.getLatitude(), request.getRadius());
		Optional<PlacesResponse> queryResponse;
		List<PlacesDto> placesDto;

		if (savedQuery.isPresent()) {
			queryResponse = placesResponseRepository.findByQuery(savedQuery.get());
			placesDto = convertToDto(queryResponse.get().getPlaces());
		} else {
			var places = client.search(request.getLatitude(), request.getLongtitude(), request.getRadius());

			var newSavedQuery = new Query();

			newSavedQuery.setLatitude(request.getLatitude());
			newSavedQuery.setLongtitude(request.getLongtitude());
			newSavedQuery.setRadius(request.getRadius());

			queryRepository.save(newSavedQuery);

			placesRepository.saveAll(places);
			
			var placesResponse = new PlacesResponse();

			placesResponse.setPlaces(places);
			placesResponse.setQuery(newSavedQuery);

			placesResponseRepository.save(placesResponse);

			placesDto = convertToDto(places);

		}
		return QueryResponse.of(placesDto);
	}

	private List<PlacesDto> convertToDto(List<Places> places) {
		var placesDto = new ArrayList<PlacesDto>();

		for (Places place : places) {
			placesDto.add(new PlacesDto(place.getName(), place.getPoint(), place.getAddress(), place.getLatitude(),
					place.getLongtitude()));
		}

		return placesDto;
	}

}
