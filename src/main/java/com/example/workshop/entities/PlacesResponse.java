package com.example.workshop.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class PlacesResponse {
	@Id
	private long id;

	@OneToOne(fetch = FetchType.LAZY)
	private Query query;

	@OneToMany(fetch = FetchType.EAGER)
	private List<Places> places;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Query getQuery() {
		return query;
	}

	public void setQuery(Query query) {
		this.query = query;
	}

	public List<Places> getPlaces() {
		return places;
	}

	public void setPlaces(List<Places> places) {
		this.places = places;
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
		PlacesResponse other = (PlacesResponse) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "PlacesResponse [id=" + id + ", query=" + query + ", places=" + places + "]";
	}

}
