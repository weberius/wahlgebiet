package de.illilli.opendata.service.wahlgebiet;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.opengis.geometry.MismatchedDimensionException;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.opengis.referencing.operation.TransformException;

import de.illilli.opendata.service.Facade;

public class LoadWahlgebietFacadeFactory {

	public static Facade getFacade(String wahlgebiet)
			throws IOException, SQLException, NamingException, URISyntaxException, MismatchedDimensionException,
			NoSuchAuthorityCodeException, FactoryException, TransformException {
		Facade facade = null;

		if ("stimmbezirk".equalsIgnoreCase(wahlgebiet)) {
			facade = new LoadStimmbezirkFacade();
		} else if ("wahllokal".equalsIgnoreCase(wahlgebiet)) {
			facade = new LoadWahllokalFacade();
		} else {
			facade = new LoadFacade("no facade for " + wahlgebiet + " found. No data loaded.");
		}
		return facade;
	}
}
