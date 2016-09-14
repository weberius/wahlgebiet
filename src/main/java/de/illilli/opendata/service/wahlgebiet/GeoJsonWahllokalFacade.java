package de.illilli.opendata.service.wahlgebiet;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.geojson.Feature;
import org.geojson.FeatureCollection;
import org.geojson.LngLatAlt;
import org.geotools.feature.SchemaException;
import org.geotools.geometry.GeneralDirectPosition;
import org.geotools.referencing.CRS;
import org.opengis.geometry.DirectPosition;
import org.opengis.geometry.MismatchedDimensionException;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.MathTransform;
import org.opengis.referencing.operation.TransformException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.illilli.opendata.service.Config;
import de.illilli.opendata.service.Facade;
import de.illilli.opendata.service.wahlgebiet.wahllokal.WahllokalCSV;
import de.illilli.opendata.service.wahlgebiet.wahllokal.WahllokalCSVReader;

/**
 * <p>
 * <a href=
 * "http://docs.geotools.org/latest/userguide/tutorial/feature/csv2shp.html">
 * Feature Tutorial - CSV2SHP</a>
 * </p>
 * <p>
 * <a href="https://sis.apache.org/tables/CoordinateReferenceSystems.html">
 * Apache SIS™ Coordinate Reference System (CRS) codes</a>
 * </p>
 * <p>
 * <a href="https://maps.omniscale.com/en/openstreetmap/epsg-32632">
 * OpenStreetMap in EPSG: 32632 – WGS 84 / UTM zone 32N</a>
 * </p>
 * 
 *
 */
public class GeoJsonWahllokalFacade implements Facade {

	CoordinateReferenceSystem sourceCRS = CRS.decode("EPSG:32632");
	CoordinateReferenceSystem targetCRS = CRS.decode("EPSG:4326");

	List<Feature> featureList = new ArrayList<>();
	private FeatureCollection featureCollection;

	public GeoJsonWahllokalFacade() throws URISyntaxException, IOException, SchemaException,
			NoSuchAuthorityCodeException, FactoryException, MismatchedDimensionException, TransformException {

		URL url = GeoJsonWahllokalFacade.class.getResource(Config.getProperty("wahllokal.csv.file"));
		WahllokalCSVReader wahllokalReader = new WahllokalCSVReader(url);
		List<WahllokalCSV> wahllokalList = wahllokalReader.getList();

		for (WahllokalCSV csv : wahllokalList) {

			MathTransform transform = CRS.findMathTransform(sourceCRS, targetCRS, true);
			double lon = Double.parseDouble(csv.koory);
			double lat = Double.parseDouble(csv.koorx);
			DirectPosition ptScr = new GeneralDirectPosition(lon, lat);
			DirectPosition ptDst = new GeneralDirectPosition(targetCRS);
			transform.transform(ptScr, ptDst);

			double[] punt = ptDst.getCoordinate();

			Feature feature = new Feature();
			feature.setId(csv.nr_stimmbezirk800);
			org.geojson.Point point = new org.geojson.Point();
			double longitude = punt[0];
			double latitude = punt[1];

			LngLatAlt geometry = new LngLatAlt(longitude, latitude);
			point.setCoordinates(geometry);
			feature.setGeometry(point);

			Map<String, Object> properties = new Hashtable<String, Object>();
			properties.put("WLK_NAME", csv.wlk_name);
			feature.setProperties(properties);

			featureList.add(feature);
		}
		featureCollection = new FeatureCollection();
		featureCollection.addAll(featureList);
	}

	@Override
	public String getJson() throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(featureCollection);
	}
}
