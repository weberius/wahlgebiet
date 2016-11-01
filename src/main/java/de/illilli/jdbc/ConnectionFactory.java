package de.illilli.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

/**
 * <p>
 * Die ConnectionFactory unterstellt, dass im Tomcat die Verbindung zur
 * Datenbank definiert wurde.
 * </p>
 * <p>
 * Beispiel:
 * </p>
 * 
 * context.xml
 * 
 * <pre>
    &lt;Context&gt;
        &lt;ResourceLink 
             name="jdbc/wahlgebiet" 
             global="jdbc/wahlgebiet"
             type="javax.sql.DataSource" /&gt;
    &lt;/Context&gt;
 * </pre>
 * 
 * server.xml
 * 
 * <pre>
    &lt;GlobalNamingResources&gt;
        &lt;Resource 
            name="jdbc/wahlgebiet"
            auth="Container"
            driverClassName="org.postgresql.Driver"
            maxTotal="25" 
            maxIdle="10"
            username="username"
            password="password"
            type="javax.sql.DataSource"
            url="jdbc:postgresql://localhost:5432/wahlgebiet"
            validationQuery="select 1"/&gt;
 * </pre>
 * 
 */
public class ConnectionFactory {

	private static final Logger logger = Logger.getLogger(ConnectionFactory.class);

	public static Connection getConnection() throws SQLException, NamingException {
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/wahlgebiet");
		Connection conn = ds.getConnection();
		logger.info("got connection for '" + conn.getCatalog() + "'");
		return conn;
	}
}
