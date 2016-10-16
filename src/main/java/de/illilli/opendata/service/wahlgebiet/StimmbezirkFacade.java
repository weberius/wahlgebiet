package de.illilli.opendata.service.wahlgebiet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

import de.illilli.opendata.service.Facade;
import de.illilli.opendata.service.wahlgebiet.stimmbezirk.Stimmbezirk;

public class StimmbezirkFacade implements Facade {

	private Stimmbezirk stimmbezirk;

	public StimmbezirkFacade(double lat, double lng) {
		this.stimmbezirk = new Stimmbezirk();
	}

	StimmbezirkFacade(Stimmbezirk stimmbezirk) {
		this.stimmbezirk = stimmbezirk;
	}

	@Override
	public String getJson() throws JsonProcessingException {
		return new Gson().toJson(stimmbezirk);
	}

}
