package de.illilli.jdbc;

import java.sql.SQLException;

public interface UpdateData {

	/**
	 * Get Number of updated Rows
	 * 
	 * @return number of inserts.
	 */
	int getRowsUpdated();

	/**
	 * Please don't forget to return the connection.
	 * 
	 * @throws SQLException
	 */
	void closeConnection() throws SQLException;
}
