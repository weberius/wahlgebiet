package de.illilli.opendata.service.wahlgebiet.askFor;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.wahlgebiet.stimmbezirk.StimmbezirkeArcgis;

public class AskForStimmbezirkeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetNumber() throws JsonParseException, JsonMappingException, IOException {

		AskFor<StimmbezirkeArcgis> askFor = new AskForStimmbezirke(
				this.getClass().getResourceAsStream("/stimmbezirk.arcgis.json"));
		StimmbezirkeArcgis data = askFor.getData();
		int expected = 800;
		int actual = data.getFeatures().size();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testGetFirstGlobalid() throws JsonParseException, JsonMappingException, IOException {
		AskFor<StimmbezirkeArcgis> askFor = new AskForStimmbezirke(
				this.getClass().getResourceAsStream("/stimmbezirk.arcgis.json"));
		StimmbezirkeArcgis data = askFor.getData();
		String expected = data.getFeatures().get(0).getAttributes().getGlobalid();
		String actual = "{01E4261A-6BFD-498E-BACF-E1815BF27B70}";
		Assert.assertEquals(expected, actual);

	}
}
