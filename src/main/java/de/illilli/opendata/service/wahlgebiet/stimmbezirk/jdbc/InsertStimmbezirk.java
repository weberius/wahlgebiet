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
 * Insertiert einen Stimmbezirk in die Tabelle STIMMBEZIRK. Erwartet, dass das
 * SQL in der Datei '/src/main/resources/insertStimmbezirkRecord.sql' definiert
 * ist.
 */
public class InsertStimmbezirk implements UpdateData {

	private int rowsUpdated;
	private Connection conn;

	/**
	 * Erwartet neben der Stimmbezirk-Information eine Connection. Kann z.B. zu
	 * Testzwecken verwendet werden, wenn die testeshalber eingefügten Daten
	 * zurückgerollt werden sollen. Connection muss nach der Abfrage geschlossen
	 * werden.
	 * 
	 * @param dto
	 *            ein Stimmbezirk
	 * @param conn
	 *            die sql-Connection
	 * @throws IOException
	 * @throws SQLException
	 */
	InsertStimmbezirk(StimmbezirkDTO dto, Connection conn) throws IOException, SQLException {

		this.conn = conn;
		InputStream inputStream = this.getClass().getResourceAsStream("/insertStimmbezirkRecord.sql");
		String sql = IOUtils.toString(inputStream);
		QueryRunner run = new QueryRunner();
		rowsUpdated = run.update(conn, sql, dto.getId(), dto.getNummer(), dto.getkWahl(), dto.getlWahl(),
				dto.getbWahl(), dto.getNrStb(), dto.getStb(), dto.getNrStt(), dto.getStt(), dto.getShapeArea(),
				dto.getShapeLen(), dto.getGeom());
	}

	/**
	 * Erwartet eine Stimmbezirk-Information. Die Connection wird über die
	 * ConnectionFactory bestimmt. Die Connection wird nach der Abfrage wieder
	 * zurückgegeben.
	 * 
	 * @param dto
	 *            ein Stimmbezirk
	 * @throws IOException
	 * @throws SQLException
	 * @throws NamingException
	 * @see ConnectionFactory
	 */
	public InsertStimmbezirk(StimmbezirkDTO dto) throws IOException, SQLException, NamingException {

		this(dto, ConnectionFactory.getConnection());
		closeConnection();
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
