package de.illilli.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import de.illilli.opendata.service.Config;

/**
 */
public class ConnectionFactory {

	public static Connection getConnection() throws SQLException, NamingException {
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup(Config.getProperty("ConnectionFactory.initContext.lookup"));
		DataSource ds = (DataSource) envContext.lookup(Config.getProperty("ConnectionFactory.envContext.lookup"));
		Connection conn = ds.getConnection();
		return conn;
	}
}
