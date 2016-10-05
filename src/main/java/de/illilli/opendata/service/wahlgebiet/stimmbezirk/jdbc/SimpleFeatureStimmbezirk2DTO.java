package de.illilli.opendata.service.wahlgebiet.stimmbezirk.jdbc;

import org.opengis.feature.simple.SimpleFeature;
import org.postgis.PGgeometry;

import com.vividsolutions.jts.geom.MultiPolygon;

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
		dto.setGeom(new PGgeometry(new Stimmbezirk2Multipolygon(multiPolygon).getGeometry()));

	}

	public StimmbezirkDTO getDto() {
		return dto;
	}

}
