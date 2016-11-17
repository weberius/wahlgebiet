package de.illilli.opendata.service.wahlgebiet.stimmbezirk.jdbc;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.commons.dbutils.handlers.BeanHandler;

import de.illilli.jdbc.Select;

public class SelectStimmbezirkByNummer extends Select<StimmbezirkDTO> {

	private final static String queryString = "/selectStimmbezirkByNummer.sql";

	public SelectStimmbezirkByNummer(int number) throws SQLException, NamingException, IOException {
		setQueryString(queryString);
		Object[] params = new Object[] { number };
		runSelect(new BeanHandler<StimmbezirkDTO>(StimmbezirkDTO.class), params);
	}

}
