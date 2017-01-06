package de.illilli.opendata.service.wahlgebiet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;

import org.geojson.Feature;
import org.geojson.FeatureCollection;
import org.geojson.GeoJsonObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.illilli.jdbc.Select;
import de.illilli.opendata.service.Facade;
import de.illilli.opendata.service.wahlgebiet.wahllokal.jdbc.SelectWahllokale;
import de.illilli.opendata.service.wahlgebiet.wahllokal.jdbc.WahllokalDTO;

public class GeoJsonWahllokalFacade implements Facade {

	List<Feature> featureList = new ArrayList<>();
	private FeatureCollection featureCollection = new FeatureCollection();

	public GeoJsonWahllokalFacade() throws SQLException, NamingException, IOException {

		Select<WahllokalDTO> select = new SelectWahllokale();
		List<WahllokalDTO> dtoList = select.getDbObjectList();

		for (WahllokalDTO dto : dtoList) {
			Feature feature = new Feature();
			feature.setId(dto.getStimmbezirk() + "");

			Map<String, Object> properties = new HashMap<>();
			properties.put("WLK_NAME", dto.getName());
			properties.put("WLK_ADRESSE", dto.getAdresse());
			properties.put("POSTZUSTELLBEZIRK", dto.getPostzustellbezirk());

			feature.setProperties(properties);

			GeoJsonObject geomertry = new ObjectMapper().readValue(dto.getGeojson(), GeoJsonObject.class);
			feature.setGeometry(geomertry);
			featureList.add(feature);
		}

		featureCollection.addAll(featureList);
	}

	@Override
	public String getJson() throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(featureCollection);
	}
}
