package de.illilli.opendata.service.wahlgebiet.askFor;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.wahlgebiet.wahllokal.WahllokalCSV;

public class AskForWahllokaleTest {

	private URL url;

	@Before
	public void setUp() throws Exception {
		this.url = AskForWahllokaleTest.class.getResource("/20140513_Wahllokale_geo.csv");
	}

	@Test
	public void testForNumberOfRows() throws MalformedURLException, IOException {
		AskFor<List<WahllokalCSV>> askFor = new AskForWahllokale(this.url);
		int expected = 800;
		int actual = askFor.getData().size();
		Assert.assertEquals(expected, actual);
	}

}
