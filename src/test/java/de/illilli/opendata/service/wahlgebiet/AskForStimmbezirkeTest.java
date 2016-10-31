package de.illilli.opendata.service.wahlgebiet;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import de.illilli.opendata.koeln.arcgis.StimmbezirkeArcgis;
import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.wahlgebiet.askFor.AskForStimmbezirke;

public class AskForStimmbezirkeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	@Ignore
	public void testGetData() throws JsonParseException, JsonMappingException, IOException {

		AskFor<StimmbezirkeArcgis> askFor = new AskForStimmbezirke(
				this.getClass().getResourceAsStream("/stimmbezirke.stadt-koeln.json"));
		StimmbezirkeArcgis data = askFor.getData();
		String actual = data.toString();
		String expected = IOUtils.toString(this.getClass().getResourceAsStream("/stimmbezirk.arcgis.json"));
		Assert.assertEquals(expected, actual);
	}

}
