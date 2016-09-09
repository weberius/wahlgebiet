package de.illilli.opendata.service.wahlgebiet;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface GeoJsonTransformer {
	String getJson() throws JsonProcessingException;
}
