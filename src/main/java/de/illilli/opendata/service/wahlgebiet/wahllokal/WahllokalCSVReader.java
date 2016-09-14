package de.illilli.opendata.service.wahlgebiet.wahllokal;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;

public class WahllokalCSVReader {

	private List<WahllokalCSV> wahllokalList = new ArrayList<WahllokalCSV>();

	public WahllokalCSVReader(URL url) throws URISyntaxException, IOException {
		File file = new File(url.toURI());
		CsvReader csvReader = new CsvReader(new FileReader(file));
		csvReader.readHeaders();
		while (csvReader.readRecord()) {
			WahllokalCSV wahllokal = new WahllokalCSV();
			wahllokal.objectid = csvReader.get("OBJECTID");
			wahllokal.nr_stimmbezirk800 = csvReader.get("WLK_NAME");
			wahllokal.wlk_name = csvReader.get("NR_STIMMBEZIRK800");
			wahllokal.wlk_adresse = csvReader.get("WLK_ADRESSE");
			wahllokal.rollstuhlgerecht = csvReader.get("ROLLSTUHLGERECHT");
			wahllokal.wlk_bemerkung = csvReader.get("WLK_BEMERKUNG");
			wahllokal.abstimmbezirk = csvReader.get("ABSTIMMBEZIRK");
			wahllokal.wlk_stadtteil = csvReader.get("WLK_STADTTEIL");
			wahllokal.postzustellbezirk = csvReader.get("POSTZUSTELLBEZIRK");
			wahllokal.ad_nummer = csvReader.get("AD_NUMMER");
			wahllokal.koorx = csvReader.get("KOORX");
			wahllokal.koory = csvReader.get("KOORY");
			wahllokal.stimmbezirk_stadtteil = csvReader.get("STIMMBEZIRK_STADTTEIL");
			wahllokal.kommunalwahlbezirk = csvReader.get("KOMMUNALWAHLBEZIRK");
			wahllokal.landtagswahlkreis = csvReader.get("LANDTAGSWAHLKREIS");
			wahllokal.bundestagswahlkreis = csvReader.get("BUNDESTAGSWAHLKREIS");
			wahllokalList.add(wahllokal);
		}
	}

	public List<WahllokalCSV> getList() {
		return wahllokalList;
	}

}
