package de.illilli.opendata.service.wahlgebiet;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.junit.Before;
import org.opengis.geometry.MismatchedDimensionException;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.opengis.referencing.operation.TransformException;

import de.illilli.jdbc.ConnectionEnvironment;
import de.illilli.opendata.service.Facade;

public class LoadLandtagswahlkreiseFacadeTest {

	@Before
	public void setUp() throws Exception {
	}

	public static void main(String[] args)
			throws MismatchedDimensionException, MalformedURLException, NoSuchAuthorityCodeException, IOException,
			SQLException, NamingException, FactoryException, TransformException {

		ConnectionEnvironment.setUpConnectionForJndi();

		Facade facade = new LoadLandtagswahlkreiseFacade();
		System.out.println(facade.getJson());
	}

}
