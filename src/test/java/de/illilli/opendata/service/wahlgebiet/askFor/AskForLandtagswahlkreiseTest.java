package de.illilli.opendata.service.wahlgebiet.askFor;

import java.io.IOException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.wahlgebiet.landtagswahlkreis.LandtagswahlkreiseArcgis;

public class AskForLandtagswahlkreiseTest {

	private URL url;

	@Before
	public void setUp() throws Exception {
		this.url = AskForLandtagswahlkreiseTest.class.getResource("/landtagswahlkreis.arcgis.json");
	}

	@Test
	public void testNumberOfRecords() throws IOException {
		AskFor<LandtagswahlkreiseArcgis> askFor = new AskForLandtagswahlkreise(this.url.openStream());
		LandtagswahlkreiseArcgis data = askFor.getData();
		int expected = 7;
		int actual = data.features.size();
		Assert.assertEquals(expected, actual);
	}

}
