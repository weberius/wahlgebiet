package de.illilli.opendata.service.wahlgebiet;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.opengis.geometry.MismatchedDimensionException;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.opengis.referencing.operation.TransformException;

import de.illilli.jdbc.UpdateData;
import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.wahlgebiet.askFor.AskForLandtagswahlkreise;
import de.illilli.opendata.service.wahlgebiet.landtagswahkreis.jdbc.DeleteLandtagswahlkreise;
import de.illilli.opendata.service.wahlgebiet.landtagswahkreis.jdbc.InsertLandtagswahlkreis;
import de.illilli.opendata.service.wahlgebiet.landtagswahkreis.jdbc.LandtagswahlkreisDTO;
import de.illilli.opendata.service.wahlgebiet.landtagswahkreis.jdbc.LandtagswahlkreisFeature2DTO;
import de.illilli.opendata.service.wahlgebiet.landtagswahlkreis.Feature;
import de.illilli.opendata.service.wahlgebiet.landtagswahlkreis.LandtagswahlkreiseArcgis;

public class LoadLandtagswahlkreiseFacade extends LoadFacade {

	private int dataInserted = 0;
	private int dataNotInserted = 0;

	public LoadLandtagswahlkreiseFacade() throws MalformedURLException, IOException, SQLException, NamingException,
			MismatchedDimensionException, NoSuchAuthorityCodeException, FactoryException, TransformException {

		// hole die Daten
		AskFor<LandtagswahlkreiseArcgis> askFor = new AskForLandtagswahlkreise();
		// lösche vorher alle Datensätze
		UpdateData delete = new DeleteLandtagswahlkreise();

		for (Feature feature : askFor.getData().features) {
			// erstelle das DTO-Objekt
			LandtagswahlkreisDTO dto = new LandtagswahlkreisFeature2DTO(feature).getDto();
			// füge den Datensatz ein
			UpdateData insert = new InsertLandtagswahlkreis(dto);
			dataInserted = dataInserted + insert.getRowsUpdated();

		}
		// beschreibe das Ergebnis
		result.dataNotInserted = dataNotInserted;
		result.dataInserted = dataInserted;
		result.msg = "Data loaded";

	}

}
