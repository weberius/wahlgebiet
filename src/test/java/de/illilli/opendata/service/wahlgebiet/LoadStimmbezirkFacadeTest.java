package de.illilli.opendata.service.wahlgebiet;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.junit.Before;

import de.illilli.jdbc.ConnectionEnvironment;
import de.illilli.opendata.service.Facade;

public class LoadStimmbezirkFacadeTest {

	private static URL url;

	@Before
	public void setUp() throws Exception {
		url = new File("./src/main/resources/stimmbezirk/Stimmbezirk.shp").toURI().toURL();
	}

	public static void main(String[] args) throws IOException, SQLException, NamingException {
		url = new File("./src/main/resources/stimmbezirk/Stimmbezirk.shp").toURI().toURL();
		ConnectionEnvironment.setUpConnectionForJndi();
		Facade facade = new LoadStimmbezirkFacade(url);
		System.out.println(facade.getJson());
	}

}
