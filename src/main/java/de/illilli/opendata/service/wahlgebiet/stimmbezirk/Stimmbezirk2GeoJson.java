package de.illilli.opendata.service.wahlgebiet.stimmbezirk;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.geojson.Feature;
import org.geojson.GeoJsonObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.illilli.opendata.service.wahlgebiet.stimmbezirk.jdbc.StimmbezirkDTO;

public class Stimmbezirk2GeoJson {

	private Feature feature = new Feature();

	public Stimmbezirk2GeoJson(StimmbezirkDTO dto) throws JsonParseException, JsonMappingException, IOException {

		feature.setId(dto.getNummer() + "");

		Map<String, Object> properties = new HashMap<>();
		properties.put("nummer", dto.getNummer());
		properties.put("kWahl", dto.getkWahl());
		properties.put("lWahl", dto.getlWahl());
		properties.put("bWahl", dto.getbWahl());
		properties.put("nrStb", dto.getNrStb());
		properties.put("stb", dto.getStb());
		properties.put("nrStt", dto.getNrStt());
		properties.put("stt", dto.getStt());
		feature.setProperties(properties);

		GeoJsonObject geomertry = new ObjectMapper().readValue(dto.getGeojson(), GeoJsonObject.class);
		feature.setGeometry(geomertry);
	}

	public Feature getFeature() {
		return feature;
	}
}
