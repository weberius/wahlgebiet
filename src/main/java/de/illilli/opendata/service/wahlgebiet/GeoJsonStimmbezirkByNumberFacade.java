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
import de.illilli.opendata.service.wahlgebiet.stimmbezirk.jdbc.SelectStimmbezirkByNummerGeoJson;
import de.illilli.opendata.service.wahlgebiet.stimmbezirk.jdbc.StimmbezirkDTO;

public class GeoJsonStimmbezirkByNumberFacade implements Facade {

	private StimmbezirkDTO dto;
	private FeatureCollection featureCollection;

	public GeoJsonStimmbezirkByNumberFacade(int number) throws SQLException, NamingException, IOException {

		List<Feature> featureList = new ArrayList<>();
		Select<StimmbezirkDTO> select = new SelectStimmbezirkByNummerGeoJson(number);
		dto = select.getDbObject();

		Feature feature = new Feature();
		feature.setId(dto.getId());

		// {"id":"3456","nummer":10101,"kWahl":1,"lWahl":13,"bWahl":94,"nrStb":1,"stb":"Innenstadt","nrStt":101,"stt":"Altstadt/Süd"}
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
		// eigentlich multipolygon
		GeoJsonObject polygon = new ObjectMapper().readValue(dto.getGeojson(), GeoJsonObject.class);
		feature.setGeometry(polygon);

		featureList.add(feature);

		featureCollection = new FeatureCollection();
		featureCollection.addAll(featureList);
	}

	@Override
	public String getJson() throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(featureCollection);
	}

}
