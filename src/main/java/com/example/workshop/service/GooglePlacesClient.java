package com.example.workshop.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.workshop.entities.Places;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class GooglePlacesClient {
	@Value("${google.places.api.key}")
	private String apiKey;

	private static final String BASE_URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?";

	public List<Places> search(double longtitude, double latitude, double radius) throws IOException {
		OkHttpClient client = new OkHttpClient().newBuilder().build();
		Request request = new Request.Builder().url(BASE_URL + "location=" + longtitude + "%2C" + latitude + "&radius="
				+ (int) radius + "&type=restaurant&keyword=cruise&key=" + apiKey).method("GET", null).build();

		var places = new ArrayList<Places>();
		Response response = client.newCall(request).execute();

		if (response.isSuccessful()) {
			JSONObject json = new JSONObject(response.body().string());
			JSONArray results = (JSONArray) json.get("results");
			for (Object result : results) {
				JSONObject placeObj = (JSONObject) result;
				places.add(new Places(placeObj.getString("name"), placeObj.getString("vicinity"),
						placeObj.getDouble("rating"),
						placeObj.getJSONObject("geometry").getJSONObject("location").getDouble("lat"),
						placeObj.getJSONObject("geometry").getJSONObject("location").getDouble("lng")));
			}
		}

		return places;
	}
}