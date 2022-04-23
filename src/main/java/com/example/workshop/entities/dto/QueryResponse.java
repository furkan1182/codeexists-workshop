package com.example.workshop.entities.dto;

import java.util.List;

public class QueryResponse {

	private List<PlacesDto> places;

	public static QueryResponse of(List<PlacesDto> places) {
		var response = new QueryResponse();
		response.setPlaces(places);
		return response;
	}
	
	public List<PlacesDto> getPlaces() {
		return places;
	}

	public void setPlaces(List<PlacesDto> places) {
		this.places = places;
	}
	
	

}
