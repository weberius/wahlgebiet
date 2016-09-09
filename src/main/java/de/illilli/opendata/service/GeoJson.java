package de.illilli.opendata.service;

import java.util.Map;

import org.geojson.GeoJsonObject;

public interface GeoJson {

	String getId();

	Map<String, Object> getProperties();

	GeoJsonObject getGeometry();

}
