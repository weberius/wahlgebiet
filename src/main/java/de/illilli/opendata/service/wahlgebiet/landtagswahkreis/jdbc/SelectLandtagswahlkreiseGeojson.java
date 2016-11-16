package de.illilli.opendata.service.wahlgebiet.landtagswahkreis.jdbc;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import de.illilli.jdbc.Select;

public class SelectLandtagswahlkreiseGeojson extends Select<LandtagswahlkreisDTO> {

	private final static String queryString = "/selectLandtagswahlkreise.sql";

	public SelectLandtagswahlkreiseGeojson() throws SQLException, NamingException, IOException {
		setQueryString(queryString);
		Object[] params = new Object[] {};
		runSelect(new BeanListHandler<LandtagswahlkreisDTO>(LandtagswahlkreisDTO.class), params);
	}
}
