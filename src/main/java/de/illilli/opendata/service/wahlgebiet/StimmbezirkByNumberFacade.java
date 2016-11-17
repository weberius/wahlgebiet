package de.illilli.opendata.service.wahlgebiet;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

import de.illilli.jdbc.Select;
import de.illilli.opendata.service.Facade;
import de.illilli.opendata.service.wahlgebiet.stimmbezirk.jdbc.SelectStimmbezirkByNummer;
import de.illilli.opendata.service.wahlgebiet.stimmbezirk.jdbc.StimmbezirkDTO;

public class StimmbezirkByNumberFacade implements Facade {

	private StimmbezirkDTO dto;

	public StimmbezirkByNumberFacade(int number) throws SQLException, NamingException, IOException {
		Select<StimmbezirkDTO> select = new SelectStimmbezirkByNummer(number);
		dto = select.getDbObject();
	}

	@Override
	public String getJson() throws JsonProcessingException {
		return new Gson().toJson(dto);
	}

}
