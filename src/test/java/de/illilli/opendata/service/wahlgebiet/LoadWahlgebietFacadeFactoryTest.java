package de.illilli.opendata.service.wahlgebiet;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.opengis.geometry.MismatchedDimensionException;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.opengis.referencing.operation.TransformException;

import de.illilli.opendata.service.Facade;

/**
 * Dieser Test prüft, ob bei ungültiger Übergabe die Default Facade vewerwendet
 * wird.
 *
 */
public class LoadWahlgebietFacadeFactoryTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetFacade() throws IOException, SQLException, NamingException, URISyntaxException,
			MismatchedDimensionException, NoSuchAuthorityCodeException, FactoryException, TransformException {
		Facade facade = LoadWahlgebietFacadeFactory.getFacade("xyz");
		String expected = IOUtils.toString(this.getClass().getResourceAsStream("/loadfacade.result.default.json"));
		String actual = facade.getJson();
		Assert.assertEquals(expected, actual);

	}

}
