package de.illilli.opendata.service.wahlgebiet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.geojson.Feature;
import org.geojson.FeatureCollection;
import org.geojson.GeoJsonObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.illilli.jdbc.Select;
import de.illilli.opendata.service.Facade;
import de.illilli.opendata.service.wahlgebiet.stimmbezirk.jdbc.SelectStimmbezirke;
import de.illilli.opendata.service.wahlgebiet.stimmbezirk.jdbc.StimmbezirkDTO;

public class GeoJsonStimmbezirkeFacade implements Facade {

	private static final Logger logger = Logger.getLogger(GeoJsonStimmbezirkeFacade.class);

	private List<Feature> featureList = new ArrayList<>();
	private FeatureCollection featureCollection = new FeatureCollection();

	public GeoJsonStimmbezirkeFacade() throws SQLException, NamingException, IOException {
		Select<StimmbezirkDTO> select = new SelectStimmbezirke();
		List<StimmbezirkDTO> dtoList = select.getDbObjectList();
		for (StimmbezirkDTO dto : dtoList) {
			Feature feature = new Feature();
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
			featureList.add(feature);
		}
		featureCollection.addAll(featureList);
	}

	@Override
	public String getJson() throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(featureCollection);
	}

}
