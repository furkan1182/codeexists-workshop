package com.example.workshop.entities.dto;

public class PlacesDto {
	private final String name;
	private final String address;
	private final double point;
	private final double latitude;
	private final double longtitude;

	public PlacesDto(String name, double point, String address, double latitude, double longtitude) {
		super();
		this.name = name;
		this.point = point;
		this.address = address;
		this.latitude = latitude;
		this.longtitude = longtitude;
	}

	public String getName() {
		return name;
	}

	public double getPoint() {
		return point;
	}

	public String getAddress() {
		return address;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongtitude() {
		return longtitude;
	}

}
