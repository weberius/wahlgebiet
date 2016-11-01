package de.illilli.opendata.service.wahlgebiet;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.geojson.FeatureCollection;
import org.geotools.data.DataStore;
import org.geotools.data.DataStoreFinder;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureSource;
import org.opengis.geometry.MismatchedDimensionException;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.opengis.referencing.operation.TransformException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.illilli.opendata.koeln.arcgis.Feature;
import de.illilli.opendata.koeln.arcgis.StimmbezirkeArcgis;
import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.Config;
import de.illilli.opendata.service.Facade;
import de.illilli.opendata.service.wahlgebiet.askFor.AskForStimmbezirke;
import de.illilli.opendata.service.wahlgebiet.stimmbezirk.GeoToolsGeoJsonTransformer;

public class GeoJsonStimmbezirkeFacade implements Facade {

	private static final Logger logger = Logger.getLogger(GeoJsonStimmbezirkeFacade.class);

	private Map<String, Object> params;
	SimpleFeatureSource featureSource;
	private static DataStore dataStore;
	private String json;
	FeatureCollection featureCollection = new FeatureCollection();

	@Deprecated
	public GeoJsonStimmbezirkeFacade(URL url) throws MismatchedDimensionException, NoSuchAuthorityCodeException,
			IOException, FactoryException, TransformException {
		setFeatureSource(url);
		setJsonFromShape();
	}

	public GeoJsonStimmbezirkeFacade() throws MalformedURLException, IOException {

		AskFor<StimmbezirkeArcgis> askFor = new AskForStimmbezirke();
		StimmbezirkeArcgis stimmbezirkeFromArcgis = askFor.getData();
		List<Feature> featureList = stimmbezirkeFromArcgis.getFeatures();
		featureCollection = new ArcgisFeatureList2GeojsonFeatureCollection(featureList).getFeatureCollection();
		json = new ObjectMapper().writeValueAsString(featureCollection);
	}

	@Deprecated
	void setFeatureSource(URL url) throws IOException {
		if (dataStore == null) {
			params = new HashMap<String, Object>();
			params.put("url", url);
			params.put("create spatial index", false);
			params.put("memory mapped buffer", false);
			params.put("charset", Config.getProperty("shp.encoding"));

			dataStore = DataStoreFinder.getDataStore(params);
		}
		featureSource = dataStore.getFeatureSource(dataStore.getTypeNames()[0]);
	}

	@Deprecated
	void setJsonFromShape() {

		try {
			CoordinateTransformer coordinateTransformer = new CoordinateTransformer(featureSource);
			SimpleFeatureCollection simpleFeatureCollection = coordinateTransformer.transform();
			GeoJsonTransformer shape2GeoJsonTransformer = new GeoToolsGeoJsonTransformer(simpleFeatureCollection);
			json = shape2GeoJsonTransformer.getJson();
		} catch (MismatchedDimensionException e) {
			logger.error(e);
		} catch (NoSuchAuthorityCodeException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		} catch (FactoryException e) {
			logger.error(e);
		} catch (TransformException e) {
			logger.error(e);
		}
	}

	@Override
	public String getJson() throws JsonProcessingException {
		return json;
	}

}
