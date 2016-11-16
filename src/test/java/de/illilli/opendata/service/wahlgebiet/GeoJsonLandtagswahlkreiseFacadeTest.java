package de.illilli.opendata.service.wahlgebiet;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.junit.Before;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import de.illilli.jdbc.ConnectionEnvironment;
import de.illilli.opendata.service.Facade;

public class GeoJsonLandtagswahlkreiseFacadeTest {

	@Before
	public void setUp() throws Exception {
	}

	public static void main(String[] args)
			throws JsonParseException, JsonMappingException, IOException, SQLException, NamingException {
		ConnectionEnvironment.setUpConnectionForJndi();
		Facade facade = new GeoJsonLandtagswahlkreiseFacade();
		System.out.println(facade.getJson());
	}

}
