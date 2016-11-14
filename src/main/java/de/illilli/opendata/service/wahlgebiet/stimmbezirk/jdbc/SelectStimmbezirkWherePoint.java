package de.illilli.opendata.service.wahlgebiet.stimmbezirk.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.io.IOUtils;

import de.illilli.jdbc.ConnectionFactory;
import de.illilli.jdbc.DbUtilsBeanListHandler;

public class SelectStimmbezirkWherePoint {

	private String queryString = "/selectStimmbezirkWherePoint.sql";
	private static final int SRID = 4326;
	private List<StimmbezirkDTO> stimmbezirkList;

	public SelectStimmbezirkWherePoint(double lng, double lat) throws SQLException, NamingException, IOException {

		Connection conn = ConnectionFactory.getConnection();
		InputStream inputStream = this.getClass().getResourceAsStream(queryString);
		String sql = IOUtils.toString(inputStream);

		Object[] params = new Object[] { lng, lat, SRID };

		BeanListHandler<StimmbezirkDTO> beanListHandler = new BeanListHandler<StimmbezirkDTO>(StimmbezirkDTO.class);
		DbUtilsBeanListHandler<StimmbezirkDTO> rsh = new DbUtilsBeanListHandler<StimmbezirkDTO>(conn, beanListHandler,
				sql, params);
		stimmbezirkList = rsh.getList();

		conn.close();
	}

	public List<StimmbezirkDTO> getData() {
		return stimmbezirkList;
	}
}
