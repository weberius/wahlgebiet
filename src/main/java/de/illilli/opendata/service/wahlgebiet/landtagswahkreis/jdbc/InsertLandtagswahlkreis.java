package de.illilli.opendata.service.wahlgebiet.landtagswahkreis.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import de.illilli.jdbc.ConnectionFactory;
import de.illilli.jdbc.UpdateData;

public class InsertLandtagswahlkreis implements UpdateData {

	private static final Logger logger = Logger.getLogger(InsertLandtagswahlkreis.class);
	private int rowsUpdated;
	private Connection conn;

	public InsertLandtagswahlkreis(LandtagswahlkreisDTO dto) throws IOException, SQLException, NamingException {
		this(dto, ConnectionFactory.getConnection());
		closeConnection();
	}

	public InsertLandtagswahlkreis(LandtagswahlkreisDTO dto, Connection conn) throws IOException, SQLException {
		this.conn = conn;

		InputStream inputStream = this.getClass().getResourceAsStream("/insertLandtagswahlkreis.sql");
		String sql = IOUtils.toString(inputStream);

		QueryRunner run = new QueryRunner();
		Object[] params = new Object[] { dto.getId(), dto.getNummer(), dto.getBezeichnung(), dto.getGeom() };
		rowsUpdated = run.update(conn, sql, params);

		logger.info("insert " + dto.toString());

	}

	@Override
	public int getRowsUpdated() {
		return rowsUpdated;
	}

	@Override
	public void closeConnection() throws SQLException {
		conn.close();
	}

}
