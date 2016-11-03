package de.illilli.opendata.service.wahlgebiet;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
	public void testGetFacade() throws IOException, SQLException, NamingException {
		Facade facade = LoadWahlgebietFacadeFactory.getFacade("xyz");
		String expected = IOUtils.toString(this.getClass().getResourceAsStream("/loadfacade.result.default.json"));
		String actual = facade.getJson();
		Assert.assertEquals(expected, actual);

	}

}
