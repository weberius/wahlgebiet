package de.illilli.opendata.service.wahlgebiet;

import java.io.File;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;

public class GeoJsonWahllokalFacade {

	public GeoJsonWahllokalFacade() throws URISyntaxException {
		List<String> cities = new ArrayList<String>();
		URL url = GeoJsonWahllokalFacade.class.getResource("/wahllokal/20140513_Wahllokale_geo.csv");
		File file = new File(url.toURI());
		try {
			CsvReader locations = new CsvReader(new FileReader(file));
			locations.readHeaders();
			while (locations.readRecord()) {
				cities.add(locations.get("OBJECTID"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(cities.toString());
	}
}
