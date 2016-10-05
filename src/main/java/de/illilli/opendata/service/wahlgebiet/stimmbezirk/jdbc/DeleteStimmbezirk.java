package de.illilli.opendata.service.wahlgebiet.stimmbezirk.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.io.IOUtils;

import de.illilli.jdbc.ConnectionFactory;
import de.illilli.jdbc.UpdateData;

/**
 * Mit dieser Klasse ist es möglich, die Einträge in der Tabelle Stimmbezirk zu
 * löschen.
 */
public class DeleteStimmbezirk implements UpdateData {

	private int rowsUpdated;
	private Connection conn;

	/**
	 * 
	 * @throws SQLException
	 * @throws NamingException
	 * @throws IOException
	 */
	public DeleteStimmbezirk() throws SQLException, NamingException, IOException {
		this(ConnectionFactory.getConnection());
		closeConnection();
	}

	DeleteStimmbezirk(Connection conn) throws IOException, SQLException {
		this.conn = conn;
		InputStream inputStream = this.getClass().getResourceAsStream("/deleteStimmbezirk.sql");
		String sql = IOUtils.toString(inputStream);
		QueryRunner run = new QueryRunner();
		rowsUpdated = run.update(conn, sql);
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
