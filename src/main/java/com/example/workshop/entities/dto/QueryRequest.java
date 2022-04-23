package com.example.workshop.entities.dto;

public class QueryRequest {
	private double longtitude;
	private double latitude;
	private double radius;

	public QueryRequest() {
		super();
	}

	public QueryRequest(double longtitude, double latitude, double radius) {
		super();
		this.longtitude = longtitude;
		this.latitude = latitude;
		this.radius = radius;
	}

	public double getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

}
