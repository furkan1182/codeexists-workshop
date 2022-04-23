package com.example.workshop.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "query")

public class Query {

	@Id
	@GeneratedValue
	private long id;

	@Column
	private double longtitude;
	@Column
	private double latitude;
	@Column
	private double radius;

	public Query() {
		super();
	}

	public Query(long id, double longtitude, double latitude, double radius) {
		super();
		this.id = id;
		this.longtitude = longtitude;
		this.latitude = latitude;
		this.radius = radius;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Query other = (Query) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Query [id=" + id + ", longtitude=" + longtitude + ", latitude=" + latitude + ", radius=" + radius + "]";
	}

}
