package de.illilli.opendata.service.wahlgebiet.stimmbezirk.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.io.IOUtils;

import de.illilli.jdbc.ConnectionFactory;

public class InsertStimmbezirk {

	private int inserts;
	private Connection conn;

	public InsertStimmbezirk(StimmbezirkDTO dto, Connection conn) throws IOException, SQLException {

		this.conn = conn;
		InputStream inputStream = this.getClass().getResourceAsStream("/insertStimmbezirkRecord.sql");
		String sql = IOUtils.toString(inputStream);
		QueryRunner run = new QueryRunner();
		inserts = run.update(conn, sql, dto.getId(), dto.getNummer(), dto.getkWahl(), dto.getlWahl(), dto.getbWahl(),
				dto.getNrStb(), dto.getStb(), dto.getNrStt(), dto.getStt(), dto.getShapeArea(), dto.getShapeLen(),
				dto.getGeom());
	}

	public InsertStimmbezirk(StimmbezirkDTO dto) throws IOException, SQLException, NamingException {

		this(dto, ConnectionFactory.getConnection());
	}

	/**
	 * Get Number of inserts in Database.
	 * 
	 * @return number of inserts.
	 */
	public int getInserts() {

		return inserts;
	}

	/**
	 * Please don't forget to return the connection.
	 * 
	 * @throws SQLException
	 */
	public void closeConnection() throws SQLException {

		conn.close();
	}
}
