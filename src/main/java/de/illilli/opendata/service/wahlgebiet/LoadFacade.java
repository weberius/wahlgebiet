package de.illilli.opendata.service.wahlgebiet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

import de.illilli.opendata.service.Facade;

public class LoadFacade implements Facade {

	Result result = new Result();

	public LoadFacade() {

	}

	public LoadFacade(String msg) {
		result.msg = msg;
	}

	@Override
	public String getJson() throws JsonProcessingException {
		return new Gson().toJson(result);
	}

	class Result {
		int dataInserted = 0;
		int dataNotInserted = 0;
		String msg = "no data loaded";
	}

}
