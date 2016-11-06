package de.illilli.opendata.service.wahlgebiet.askFor;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.AskForCsv;
import de.illilli.opendata.service.Config;
import de.illilli.opendata.service.wahlgebiet.wahllokal.WahllokalCSV;

/**
 * Mit dieser Klasse werden die Wahllokalen von
 * <a href="https://www.offenedaten-koeln.de/dataset/wahllokale">Offene Daten
 * Köln - Wahllokale</a> ausgelesen und in eine List von WahllokalCSV - Objekten
 * überführt.
 * 
 * @See WahllokalCSV
 */
public class AskForWahllokale extends AskForCsv<WahllokalCSV> implements AskFor<List<WahllokalCSV>> {

	String url = Config.getProperty("odk.wahllokal.csv.url");

	private final CsvSchema simpleSchema = CsvSchema.builder() //
			.addColumn("OBJECTID") //
			.addColumn("NR_STIMMBEZIRK800") //
			.addColumn("WLK_NAME") //
			.addColumn("WLK_ADRESSE") //
			.addColumn("ROLLSTUHLGERECHT") //
			.addColumn("WLK_BEMERKUNG") //
			.addColumn("ABSTIMMBEZIRK") //
			.addColumn("WLK_STADTTEIL") //
			.addColumn("POSTZUSTELLBEZIRK") //
			.addColumn("AD_NUMMER") //
			.addColumn("KOORX") //
			.addColumn("KOORY") //
			.addColumn("STIMMBEZIRK_STADTTEIL") //
			.addColumn("KOMMUNALWAHLBEZIRK") //
			.addColumn("LANDTAGSWAHLKREIS") //
			.addColumn("BUNDESTAGSWAHLKREIS") //
			.build().withHeader();

	public AskForWahllokale() throws MalformedURLException, IOException {
		mapData(this.getUrl(), getObjectReader(simpleSchema, WahllokalCSV.class));
	}

	AskForWahllokale(URL url) throws MalformedURLException, IOException {
		mapData(url, getObjectReader(simpleSchema, WahllokalCSV.class));
	}

	@Override
	protected URL getUrl() throws MalformedURLException {
		return new URL(url);
	}

}
