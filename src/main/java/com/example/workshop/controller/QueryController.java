package com.example.workshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.workshop.entities.dto.QueryRequest;
import com.example.workshop.entities.dto.QueryResponse;
import com.example.workshop.service.QueryService;

@RestController
@RequestMapping("/queries")

public class QueryController {

	private QueryService queryService;

	@Autowired
	public QueryController(QueryService queryService) {

		this.queryService = queryService;
	}

	@GetMapping({ "/", "" })
	public ResponseEntity<QueryResponse> fetchPlaces(@RequestParam("longtitude") double longtitude,
			@RequestParam("latitude") double latitude, @RequestParam("radius") double radius) {
		try {
			var request = new QueryRequest(longtitude, latitude, radius);
			return ResponseEntity.ok(queryService.fetchPlaces(request));
		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}
	}
}
