package de.illilli.opendata.service.wahlgebiet;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.opengis.geometry.MismatchedDimensionException;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.opengis.referencing.operation.TransformException;

public class GeoJsonStimmbezirkFacadeTest {

	private URL url;

	@Before
	public void setUp() throws Exception {
		url = new File("./src/main/resources/stimmbezirk/Stimmbezirk.shp").toURI().toURL();
	}

	@Test
	public void testForFeatureCollection() throws MismatchedDimensionException, NoSuchAuthorityCodeException,
			IOException, FactoryException, TransformException {
		GeoJsonStimmbezirkeFacade facade = new GeoJsonStimmbezirkeFacade(url);
		String json = facade.getJson();
		Assert.assertTrue(json.contains("FeatureCollection"));
	}

}
