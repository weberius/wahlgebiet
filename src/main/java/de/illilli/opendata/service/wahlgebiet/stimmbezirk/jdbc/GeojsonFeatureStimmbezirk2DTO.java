package de.illilli.opendata.service.wahlgebiet.stimmbezirk.jdbc;

import org.geojson.Feature;
import org.postgis.PGgeometry;

public class GeojsonFeatureStimmbezirk2DTO {

	private StimmbezirkDTO dto;

	public GeojsonFeatureStimmbezirk2DTO(Feature feature) {

		dto = new StimmbezirkDTO();
		dto.setId(feature.getProperty("objectid"));
		dto.setNummer(Integer.parseInt(feature.getId()));
		dto.setbWahl(Integer.parseInt(feature.getProperty("bundestagwahlkreis")));
		dto.setkWahl(Integer.parseInt(feature.getProperty("kommunalwahlkreis")));
		dto.setlWahl(Integer.parseInt(feature.getProperty("landtagswahlkreis")));
		dto.setNrStb(Integer.parseInt(feature.getProperty("nrstadtbezirk")));
		dto.setNrStt(Integer.parseInt(feature.getProperty("nrstadtteil")));
		dto.setStb(feature.getProperty("stadtbezirk"));
		dto.setStt(feature.getProperty("stadtteil"));

		PGgeometry geom = new PGgeometry(new GeoJson2PostgisMultipolygon(feature.getGeometry()).getGeometry());
		dto.setGeom(geom);
	}

	public StimmbezirkDTO getDto() {
		return dto;
	}
}
