package de.illilli.opendata.service.wahlgebiet.wahllokal.jdbc;

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

/**
 * <pre>
    objectid,
	stimmbezirk,
	name,
	adresse,
	rollstuhlgerecht,
	bemerkung,
	abstimmbezirk,
	stadtteil,
	postzustellbezirk,
	adNummer,
	stimmbezirkStadtteil,
	kommunalwahlbezirk,
	landtagswahlkreis,
	bundestagswahlkreis,
	geom
 * 
 * </pre>
 */
public class InsertWahllokal implements UpdateData {

	private static final Logger logger = Logger.getLogger(InsertWahllokal.class);
	private int rowsUpdated;
	private Connection conn;

	public InsertWahllokal(WahllokalDTO dto) throws IOException, SQLException, NamingException {
		this(dto, ConnectionFactory.getConnection());
		closeConnection();
	}

	InsertWahllokal(WahllokalDTO dto, Connection conn) throws IOException, SQLException {
		this.conn = conn;

		InputStream inputStream = this.getClass().getResourceAsStream("/insertWahllokalRecord.sql");
		String sql = IOUtils.toString(inputStream);

		QueryRunner run = new QueryRunner();
		Object[] params = new Object[] { dto.getObjectid(), dto.getStimmbezirk(), dto.getName(), dto.getAdresse(),
				dto.getRollstuhlgerecht(), dto.getBemerkung(), dto.getAbstimmbezirk(), dto.getStadtteil(),
				dto.getPostzustellbezirk(), dto.getAdNummer(), dto.getStimmbezirkStadtteil(),
				dto.getKommunalwahlbezirk(), dto.getLandtagswahlkreis(), dto.getBundestagswahlkreis(), dto.getGeom() };
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
