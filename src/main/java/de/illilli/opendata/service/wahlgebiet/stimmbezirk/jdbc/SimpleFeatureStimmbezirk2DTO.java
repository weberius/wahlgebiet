package de.illilli.opendata.service.wahlgebiet.stimmbezirk.jdbc;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.geojson.GeoJsonObject;
import org.opengis.feature.simple.SimpleFeature;
import org.postgis.PGgeometry;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vividsolutions.jts.geom.MultiPolygon;

import de.illilli.opendata.koeln.arcgis.Feature;

public class SimpleFeatureStimmbezirk2DTO {

	private StimmbezirkDTO dto;

	/**
	 * Index of keys: STB=6, null=0, NR_STT=7, SHAPE_LEN=10, STT=8, L_Wahl=3,
	 * B_Wahl=4, K_WAHL=2, the_geom=0, SHAPE_AREA=9, NUMMER=1, NR_STB=5}
	 * 
	 * @param feature
	 */
	public SimpleFeatureStimmbezirk2DTO(SimpleFeature feature) {

		dto = new StimmbezirkDTO();
		dto.setkWahl(Integer.parseInt((String) feature.getAttribute(2)));
		dto.setlWahl(Integer.parseInt((String) feature.getAttribute(3)));
		dto.setbWahl(Integer.parseInt((String) feature.getAttribute(4)));
		dto.setNrStb(Integer.parseInt((String) feature.getAttribute(5)));
		dto.setStb((String) feature.getAttribute(6));
		dto.setNrStt(Integer.parseInt((String) feature.getAttribute(7)));
		dto.setStt((String) feature.getAttribute(8));
		dto.setShapeArea((Double) feature.getAttribute(9));
		dto.setShapeLen((Double) feature.getAttribute(10));

		MultiPolygon multiPolygon = (MultiPolygon) feature.getDefaultGeometry();
		// new Stimmbezirk2Multipolygon(multiPolygon).getGeometry();
		// dto.setGeom(new PGgeometry(new
		// Stimmbezirk2Multipolygon(multiPolygon).getGeometry()));

	}

	/**
	 * Sample for geom:
	 * 
	 * <pre>
	 * SELECT ST_AsText(ST_GeomFromGeoJSON('{"type": "MultiPolygon", "coordinates": [ [ [ [100.0, 0.0], [101.0, 0.0], [101.0, 1.0], [100.0, 1.0], [100.0, 0.0] ] ] ] }, "crs" : {"type":"name","properties":{"name":"EPSG:4326"}}')) As wkt;
	 * </pre>
	 * 
	 * @param feature
	 * @param geom
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	public SimpleFeatureStimmbezirk2DTO(Feature feature, String geoJson)
			throws JsonParseException, JsonMappingException, IOException {
		dto = new StimmbezirkDTO();
		dto.setId(feature.getAttributes().getNummer());
		dto.setkWahl(Integer.parseInt(feature.getAttributes().getKommunalwahlbezirk()));
		dto.setlWahl(Integer.parseInt(feature.getAttributes().getLandtagswahlkreis()));
		dto.setbWahl(Integer.parseInt(feature.getAttributes().getBundestagswahlkreis()));
		dto.setNrStb(Integer.parseInt(feature.getAttributes().getNrStadtbezirk()));
		dto.setStb(feature.getAttributes().getStadtbezirk());
		dto.setNrStt(Integer.parseInt(feature.getAttributes().getNrStadtteil()));
		dto.setStt(feature.getAttributes().getStadtteil());

		GeoJsonObject object = new ObjectMapper().readValue(IOUtils.toInputStream(geoJson), GeoJsonObject.class);
		PGgeometry geom = new PGgeometry(new GeoJson2PostgisMultipolygon(object).getGeometry());
		dto.setGeom(geom);
	}

	public StimmbezirkDTO getDto() {
		return dto;
	}

}
