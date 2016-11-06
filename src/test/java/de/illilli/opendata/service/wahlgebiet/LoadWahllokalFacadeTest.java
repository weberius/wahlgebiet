package de.illilli.opendata.service.wahlgebiet;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.junit.Before;
import org.opengis.geometry.MismatchedDimensionException;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.opengis.referencing.operation.TransformException;

import de.illilli.jdbc.ConnectionEnvironment;
import de.illilli.opendata.service.Facade;

public class LoadWahllokalFacadeTest {

	@Before
	public void setUp() throws Exception {
	}

	public static void main(String[] args) throws URISyntaxException, IOException, MismatchedDimensionException,
			NoSuchAuthorityCodeException, FactoryException, TransformException, SQLException, NamingException {
		ConnectionEnvironment.setUpConnectionForJndi();
		Facade facade = new LoadWahllokalFacade();
		System.out.println(facade.getJson());
	}

}
