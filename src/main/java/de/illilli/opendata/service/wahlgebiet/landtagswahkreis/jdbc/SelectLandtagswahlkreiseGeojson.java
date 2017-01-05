package de.illilli.opendata.service.wahlgebiet.landtagswahkreis.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.io.IOUtils;

import de.illilli.jdbc.Select;

public class SelectLandtagswahlkreiseGeojson extends Select<LandtagswahlkreisDTO> {

	private final static String queryString = "/selectLandtagswahlkreise.sql";

	public SelectLandtagswahlkreiseGeojson() throws SQLException, NamingException, IOException {
		setQueryString(queryString);
		Object[] params = new Object[] {};
		runSelect(new BeanListHandler<LandtagswahlkreisDTO>(LandtagswahlkreisDTO.class), params);
	}

	public SelectLandtagswahlkreiseGeojson(String wahlkreise) throws SQLException, NamingException, IOException {
		Object[] params = new Object[] {};
		runSelect(new BeanListHandler<LandtagswahlkreisDTO>(LandtagswahlkreisDTO.class), SelectLandtagswahlkreiseGeojson.getSQL(wahlkreise), params);
	}

	public static String getSQL(String wahlkreise) throws IOException {
		InputStream inputStream = SelectLandtagswahlkreiseGeojson.class.getResourceAsStream(queryString);
		StringBuffer sql = new StringBuffer(IOUtils.toString(inputStream));
		sql.append(" where ");
		sql.append(" nummer ");
		sql.append(" in ( ");
		sql.append(wahlkreise);
		sql.append(" ) ");
		return sql.toString();
	}

}
