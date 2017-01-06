package de.illilli.opendata.service.wahlgebiet.wahllokal.jdbc;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import de.illilli.jdbc.Select;

public class SelectWahllokale extends Select<WahllokalDTO> {

	private final static String queryString = "/selectWahllokale.sql";
	
	public SelectWahllokale() throws SQLException, NamingException, IOException {
		setQueryString(queryString);
		Object[] params = new Object[] { };
		runSelect(new BeanListHandler<WahllokalDTO>(WahllokalDTO.class), params);
	}
}
