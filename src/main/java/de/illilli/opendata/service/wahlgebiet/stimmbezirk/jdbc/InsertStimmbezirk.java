package de.illilli.opendata.service.wahlgebiet.stimmbezirk.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import de.illilli.jdbc.ConnectionFactory;
import de.illilli.jdbc.UpdateData;

/**
 * Insertiert einen Stimmbezirk in die Tabelle STIMMBEZIRK. Erwartet, dass das
 * SQL in der Datei '/src/main/resources/insertStimmbezirkRecord.sql' definiert
 * ist.
 */
public class InsertStimmbezirk implements UpdateData {

	private static final Logger logger = Logger.getLogger(InsertStimmbezirk.class);
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
	 * @throws ClassNotFoundException
	 */
	InsertStimmbezirk(StimmbezirkDTO dto, Connection conn) throws IOException, SQLException, ClassNotFoundException {

		this.conn = conn;
		// PGConnection pgCon = conn.unwrap(PGConnection.class);
		// pgCon.addDataType("geometry",
		// Class.forName("org.postgis.PGgeometry"));

		InputStream inputStream = this.getClass().getResourceAsStream("/insertStimmbezirkRecord.sql");
		String sql = IOUtils.toString(inputStream);

		PreparedStatement psSE = this.conn.prepareStatement(sql);

		psSE.setString(1, dto.getId());
		psSE.setInt(2, dto.getNummer());
		psSE.setInt(3, dto.getkWahl());
		psSE.setInt(4, dto.getlWahl());
		psSE.setInt(5, dto.getbWahl());
		psSE.setInt(6, dto.getNrStb());
		psSE.setString(7, dto.getStb());
		psSE.setInt(8, dto.getNrStt());
		psSE.setString(9, dto.getStt());
		psSE.setDouble(10, dto.getShapeArea());
		psSE.setDouble(11, dto.getShapeLen());
		psSE.setObject(12, dto.getGeom());

		psSE.execute();
		rowsUpdated = psSE.getUpdateCount();
		psSE.close();

		// QueryRunner run = new QueryRunner();
		// Object[] params = new Object[] { dto.getId(), dto.getNummer(),
		// dto.getkWahl(), dto.getlWahl(), dto.getbWahl(),
		// dto.getNrStb(), dto.getStb(), dto.getNrStt(), dto.getStt(),
		// dto.getShapeArea(), dto.getShapeLen(),
		// dto.getGeom() };
		// rowsUpdated = run.update(conn, sql, params);

		logger.info("insert " + dto.toString());
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
	 * @throws ClassNotFoundException
	 * @see ConnectionFactory
	 */
	public InsertStimmbezirk(StimmbezirkDTO dto)
			throws IOException, SQLException, NamingException, ClassNotFoundException {

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
