package de.illilli.opendata.service.wahlgebiet;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.illilli.opendata.service.Facade;
import de.illilli.opendata.service.wahlgebiet.stimmbezirk.Stimmbezirk;

public class StimmbezirkFacadeTest {

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test for interface; uses a default "Stimmbezirk" and check wether all
	 * fields are set.
	 * 
	 * @throws IOException
	 */
	@Test
	public void testGetJson() throws IOException {
		Facade facade = new StimmbezirkFacade(getDefaultStimmbezirk());
		InputStream inputStream = this.getClass().getResourceAsStream("/stimmbezirk.default.json");
		String expected = IOUtils.toString(inputStream);
		String actual = facade.getJson();
		Assert.assertEquals(expected, actual);
	}

	public static Stimmbezirk getDefaultStimmbezirk() {
		Stimmbezirk stimmbezirk = new Stimmbezirk();
		stimmbezirk.setFlaeche(0.0);
		stimmbezirk.setId("id");
		stimmbezirk.setNummer(0);
		stimmbezirk.setNummerBundestagswahl(0);
		stimmbezirk.setNummerKommunalwahl(0);
		stimmbezirk.setNummerLandtagswahl(0);
		stimmbezirk.setNummerStadtbezirk(0);
		stimmbezirk.setNummerStadtteil(0);
		stimmbezirk.setStadtbezirk("stadtbezirk");
		stimmbezirk.setStadtteil("stadtteil");
		stimmbezirk.setUmfang(0.0);
		return stimmbezirk;
	}

}
