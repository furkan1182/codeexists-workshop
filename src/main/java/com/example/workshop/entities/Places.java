package com.example.workshop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Places {

	@Id
	@GeneratedValue
	private long id;

	@Column
	private String name;
	@Column
	private String address;
	@Column
	private double point;
	@Column
	private double latitude;
	@Column
	private double longtitude;

	public Places() {
		super();
	}

	public Places(String name, String address, double point, double latitude, double longtitude) {
		super();
		this.name = name;
		this.address = address;
		this.point = point;
		this.latitude = latitude;
		this.longtitude = longtitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}

}
