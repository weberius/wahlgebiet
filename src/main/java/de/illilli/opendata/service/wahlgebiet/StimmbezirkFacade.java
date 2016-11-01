package de.illilli.opendata.service.wahlgebiet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

import de.illilli.opendata.service.Facade;
import de.illilli.opendata.service.wahlgebiet.stimmbezirk.Stimmbezirk;
import de.illilli.opendata.service.wahlgebiet.stimmbezirk.jdbc.SelectStimmbezirkWherePoint;

public class StimmbezirkFacade implements Facade {

	private List<Stimmbezirk> stimmbezirkList;

	public StimmbezirkFacade(double lng, double lat) throws SQLException, NamingException, IOException {
		SelectStimmbezirkWherePoint select = new SelectStimmbezirkWherePoint(lng, lat);
		this.stimmbezirkList = select.getData();
	}

	@Override
	public String getJson() throws JsonProcessingException {
		return new Gson().toJson(stimmbezirkList);
	}

}
