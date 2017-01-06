package de.illilli.opendata.service.wahlgebiet.stimmbezirk.jdbc;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import de.illilli.jdbc.Select;

public class SelectStimmbezirke extends Select<StimmbezirkDTO> {

	private final static String queryString = "/selectStimmbezirke.sql";

	public SelectStimmbezirke() throws SQLException, NamingException, IOException {
		setQueryString(queryString);
		Object[] params = new Object[] {};
		runSelect(new BeanListHandler<StimmbezirkDTO>(StimmbezirkDTO.class), params);
	}

}
