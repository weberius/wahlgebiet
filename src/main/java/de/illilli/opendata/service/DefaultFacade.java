package de.illilli.opendata.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

public class DefaultFacade implements Facade {

	public static final String INFO = "info";
	public static final String ERROR = "error";

	private Log log;

	public class Log {
		public String level;
		public String msg;
	}

	public DefaultFacade(String level, String msg) {
		this.log = new Log();
		this.log.level = level;
		this.log.msg = msg;
	}

	public String getJson() throws JsonProcessingException {
		return new Gson().toJson(log);
	}

}
