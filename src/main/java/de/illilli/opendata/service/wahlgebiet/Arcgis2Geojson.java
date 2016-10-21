package de.illilli.opendata.service.wahlgebiet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.geojson.FeatureCollection;
import org.geojson.LngLatAlt;
import org.geojson.MultiPolygon;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.illilli.opendata.koeln.arcgis.Feature;
import de.illilli.opendata.koeln.arcgis.StimmbezirkeArcgis;

/**
 * Diese Klasse wandelt ein StimmbezirkeArcgis - Objekt in eine geojson -
 * Struktur.
 */
public class Arcgis2Geojson {

	private FeatureCollection featureCollection = new FeatureCollection();

	public Arcgis2Geojson(StimmbezirkeArcgis stimmbezirkeFromArcgis) {
		List<Feature> featureList = stimmbezirkeFromArcgis.getFeatures();

		for (de.illilli.opendata.koeln.arcgis.Feature feature : featureList) {

			List<List<LngLatAlt>> elements = new ArrayList<>();

			de.illilli.opendata.koeln.arcgis.Geometry geometry = feature.getGeometry();
			double[][][] rings = geometry.getRings();
			for (double[][] ring1 : rings) {
				List<LngLatAlt> lngLatAltList = new ArrayList<>();
				for (double[] ring2 : ring1) {
					LngLatAlt lngLatAlt = new LngLatAlt(ring2[0], ring2[1]);
					lngLatAltList.add(lngLatAlt);
				}
				elements.add(lngLatAltList);
			}

			// System.out.println(sb.toString());
			org.geojson.Feature geojsonFeature = new org.geojson.Feature();
			geojsonFeature.setId(feature.getAttributes().getNummer());

			MultiPolygon geojsonGeometry = new MultiPolygon();
			geojsonGeometry.add(elements);

			geojsonFeature.setGeometry(geojsonGeometry);

			Map<String, Object> properties = new HashMap<String, Object>();
			properties.put("bundestagwahlkreis", feature.getAttributes().getBundestagswahlkreis());
			properties.put("kommunalwahlkreis", feature.getAttributes().getKommunalwahlbezirk());
			properties.put("landtagswahlkreis", feature.getAttributes().getLandtagswahlkreis());
			properties.put("nrstadtbezirk", feature.getAttributes().getNrStadtbezirk());
			properties.put("nrstadtteil", feature.getAttributes().getNrStadtteil());
			properties.put("objectid", feature.getAttributes().getObjectid());
			properties.put("stadtbezirk", feature.getAttributes().getStadtbezirk());
			properties.put("stadtteil", feature.getAttributes().getStadtteil());
			geojsonFeature.setProperties(properties);
			featureCollection.add(geojsonFeature);
		}
	}

	public String getGeojson() throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(featureCollection);
	}

}
