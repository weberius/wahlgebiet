package de.illilli.opendata.service.wahlgebiet;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import de.illilli.jdbc.ConnectionEnvironment;
import de.illilli.opendata.service.Facade;

public class GeoJsonStimmbezirkFacadeTest {

	public static void main(String[] args) throws SQLException, NamingException, IOException {
		ConnectionEnvironment.setUpConnectionForJndi();

		Facade facade = new GeoJsonStimmbezirkeFacade();
		System.out.println(facade.getJson());
	}

}
