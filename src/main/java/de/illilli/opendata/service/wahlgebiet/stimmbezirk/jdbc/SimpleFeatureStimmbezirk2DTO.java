package de.illilli.opendata.service.wahlgebiet.stimmbezirk.jdbc;

import org.opengis.feature.simple.SimpleFeature;

public class SimpleFeatureStimmbezirk2DTO {

	private StimmbezirkDTO dto;

	public SimpleFeatureStimmbezirk2DTO(SimpleFeature feature) {

	}

	public StimmbezirkDTO getDto() {
		return dto;
	}

}
