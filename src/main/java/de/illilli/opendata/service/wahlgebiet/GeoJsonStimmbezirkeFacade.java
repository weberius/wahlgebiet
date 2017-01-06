package de.illilli.opendata.service.wahlgebiet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.geojson.Feature;
import org.geojson.FeatureCollection;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.illilli.jdbc.Select;
import de.illilli.opendata.service.Facade;
import de.illilli.opendata.service.wahlgebiet.stimmbezirk.Stimmbezirk2GeoJson;
import de.illilli.opendata.service.wahlgebiet.stimmbezirk.jdbc.SelectStimmbezirkWherePointGeoJson;
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
			featureList.add(new Stimmbezirk2GeoJson(dto).getFeature());
		}
		featureCollection.addAll(featureList);
	}

	public GeoJsonStimmbezirkeFacade(double lng, double lat) throws SQLException, NamingException, IOException {
		Select<StimmbezirkDTO> select = new SelectStimmbezirkWherePointGeoJson(lng, lat);
		List<StimmbezirkDTO> dtoList = select.getDbObjectList();
		for (StimmbezirkDTO dto : dtoList) {
			featureList.add(new Stimmbezirk2GeoJson(dto).getFeature());
		}
		featureCollection.addAll(featureList);
	}

	@Override
	public String getJson() throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(featureCollection);
	}

}
