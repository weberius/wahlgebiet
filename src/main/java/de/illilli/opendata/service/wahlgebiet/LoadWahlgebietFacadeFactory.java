package de.illilli.opendata.service.wahlgebiet;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;

import de.illilli.opendata.service.Facade;

public class LoadWahlgebietFacadeFactory {

	public static Facade getFacade(String wahlgebiet) throws IOException, SQLException, NamingException {
		Facade facade = null;

		if ("stimmbezirk".equalsIgnoreCase(wahlgebiet)) {
			facade = new LoadStimmbezirkFacade();
		} else {
			facade = new LoadFacade("no facade for " + wahlgebiet + " found. No data loaded.");
		}
		return facade;
	}
}
