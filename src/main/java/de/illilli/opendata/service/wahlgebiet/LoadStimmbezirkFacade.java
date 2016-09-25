package de.illilli.opendata.service.wahlgebiet;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.naming.NamingException;

import org.geotools.data.DataStore;
import org.geotools.data.DataStoreFinder;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.geotools.data.simple.SimpleFeatureSource;
import org.opengis.feature.simple.SimpleFeature;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vividsolutions.jts.geom.MultiPolygon;

import de.illilli.opendata.service.Config;
import de.illilli.opendata.service.Facade;
import de.illilli.opendata.service.wahlgebiet.stimmbezirk.jdbc.SimpleFeatureStimmbezirk2DTO;
import de.illilli.opendata.service.wahlgebiet.stimmbezirk.jdbc.StimmbezirkDTO;

public class LoadStimmbezirkFacade implements Facade {

	private Map<String, Object> params;
	SimpleFeatureSource featureSource;
	private static DataStore dataStore;

	public LoadStimmbezirkFacade(URL url) throws IOException, SQLException, NamingException {

		setFeatureSource(url);

		SimpleFeatureCollection collection = featureSource.getFeatures();

		SimpleFeatureIterator iterator = collection.features();
		while (iterator.hasNext()) {
			SimpleFeature feature = iterator.next();
			MultiPolygon polygon = (MultiPolygon) feature.getDefaultGeometry();
			StimmbezirkDTO dto = new SimpleFeatureStimmbezirk2DTO(feature).getDto();
			// InsertStimmbezirk insert = new InsertStimmbezirk(dto);
		}

	}

	void setFeatureSource(URL url) throws IOException {
		if (dataStore == null) {
			params = new HashMap<String, Object>();
			params.put("url", url);
			params.put("create spatial index", false);
			params.put("memory mapped buffer", false);
			params.put("charset", Config.getProperty("encoding"));
			dataStore = DataStoreFinder.getDataStore(params);
		}
		featureSource = dataStore.getFeatureSource(dataStore.getTypeNames()[0]);
	}

	@Override
	public String getJson() throws JsonProcessingException {
		// TODO Auto-generated method stub
		return null;
	}

}
