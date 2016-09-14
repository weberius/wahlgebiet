package stimmbezirk;

import java.io.IOException;
import java.io.StringWriter;

import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.geojson.feature.FeatureJSON;
import org.geotools.geojson.geom.GeometryJSON;

import com.fasterxml.jackson.core.JsonProcessingException;

import de.illilli.opendata.service.wahlgebiet.GeoJsonTransformer;

public class GeoToolsGeoJsonTransformer implements GeoJsonTransformer {

	/**
	 * Number of decimals used; check <a href=
	 * "http://docs.geotools.org/latest/javadocs/org/geotools/geojson/geom/GeometryJSON.html">
	 * Class GeometryJSON</a>
	 */
	static final int DECIMALS = 8;

	private String json;

	public GeoToolsGeoJsonTransformer(SimpleFeatureCollection simpleFeatureCollection) throws IOException {

		FeatureJSON fjson = new FeatureJSON(new GeometryJSON(GeoToolsGeoJsonTransformer.DECIMALS));
		StringWriter writer = new StringWriter();
		fjson.writeFeatureCollection(simpleFeatureCollection, writer);
		json = writer.toString();

	}

	public String getJson() throws JsonProcessingException {
		return json;
	}

}
