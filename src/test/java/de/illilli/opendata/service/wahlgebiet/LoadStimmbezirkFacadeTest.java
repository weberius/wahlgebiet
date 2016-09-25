package de.illilli.opendata.service.wahlgebiet;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import de.illilli.opendata.service.Facade;

public class LoadStimmbezirkFacadeTest {

	private URL url;

	@Before
	public void setUp() throws Exception {
		url = new File("./src/main/resources/stimmbezirk/Stimmbezirk.shp").toURI().toURL();
	}

	@Test
	public void test() throws IOException, SQLException, NamingException {
		Facade facade = new LoadStimmbezirkFacade(url);
	}

}
