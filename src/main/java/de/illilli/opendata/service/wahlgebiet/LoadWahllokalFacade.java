package de.illilli.opendata.service.wahlgebiet;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.opengis.geometry.MismatchedDimensionException;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.opengis.referencing.operation.TransformException;

import de.illilli.jdbc.UpdateData;
import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.wahlgebiet.askFor.AskForWahllokale;
import de.illilli.opendata.service.wahlgebiet.wahllokal.WahllokalCSV;
import de.illilli.opendata.service.wahlgebiet.wahllokal.jdbc.DeleteWahllokale;
import de.illilli.opendata.service.wahlgebiet.wahllokal.jdbc.InsertWahllokal;
import de.illilli.opendata.service.wahlgebiet.wahllokal.jdbc.WahllokalCSV2DTO;
import de.illilli.opendata.service.wahlgebiet.wahllokal.jdbc.WahllokalDTO;

public class LoadWahllokalFacade extends LoadFacade {

	private int dataInserted = 0;
	private int dataNotInserted = 0;

	public LoadWahllokalFacade() throws URISyntaxException, IOException, MismatchedDimensionException,
			NoSuchAuthorityCodeException, FactoryException, TransformException, SQLException, NamingException {

		// hole die Daten
		AskFor<List<WahllokalCSV>> askFor = new AskForWahllokale();
		// lösche vorher alle Datensätze
		UpdateData delete = new DeleteWahllokale();

		for (WahllokalCSV csv : askFor.getData()) {
			// erstelle das DTO-Objekt
			WahllokalDTO dto = new WahllokalCSV2DTO(csv).getDto();
			// füge den Datensatz ein try
			UpdateData insert = new InsertWahllokal(dto);
			dataInserted = dataInserted + insert.getRowsUpdated();

		}
		// beschreibe das Ergebnis
		result.dataNotInserted = dataNotInserted;
		result.dataInserted = dataInserted;
		result.msg = "Data loaded";
	}

}
