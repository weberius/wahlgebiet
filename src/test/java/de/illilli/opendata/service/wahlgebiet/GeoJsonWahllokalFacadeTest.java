package de.illilli.opendata.service.wahlgebiet;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

import org.apache.commons.io.IOUtils;
import org.geotools.feature.SchemaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.opengis.geometry.MismatchedDimensionException;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.opengis.referencing.operation.TransformException;

import de.illilli.opendata.service.Facade;

public class GeoJsonWahllokalFacadeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGeoJsonWahllokalFacade() throws URISyntaxException, IOException, SchemaException,
			NoSuchAuthorityCodeException, FactoryException, MismatchedDimensionException, TransformException {
		Facade facade = new GeoJsonWahllokalFacade();
		InputStream inputStream = this.getClass().getResourceAsStream("/wahllokale.json");
		String expected = IOUtils.toString(inputStream);
		String actual = facade.getJson();
		Assert.assertEquals(expected, actual);
	}

}
