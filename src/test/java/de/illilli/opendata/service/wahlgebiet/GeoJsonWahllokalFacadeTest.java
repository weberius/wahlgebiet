package de.illilli.opendata.service.wahlgebiet;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.commons.io.IOUtils;
import org.geotools.feature.SchemaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.opengis.geometry.MismatchedDimensionException;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.opengis.referencing.operation.TransformException;

import de.illilli.jdbc.ConnectionEnvironment;
import de.illilli.opendata.service.Facade;

public class GeoJsonWahllokalFacadeTest {

	@Before
	public void setUp() throws Exception {
	}

	public static void main(String[] args) throws URISyntaxException, IOException, SchemaException,
			NoSuchAuthorityCodeException, FactoryException, MismatchedDimensionException, TransformException, SQLException, NamingException {
		ConnectionEnvironment.setUpConnectionForJndi();

		Facade facade = new GeoJsonWahllokalFacade();
		System.out.println(facade.getJson());
	}

}
