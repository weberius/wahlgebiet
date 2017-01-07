package de.illilli.opendata.service.wahlgebiet;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;

import de.illilli.opendata.service.Facade;

public class CachedGeoJsonWahllokalFacade implements Facade {

	private static final Logger logger = Logger.getLogger(CachedGeoJsonWahllokalFacade.class);

	private String json = "{empty}";

	/**
	 * 
	 * @param gkz
	 *            die Gemeindekennziffer
	 * @throws IOException
	 */
	public CachedGeoJsonWahllokalFacade(String gkz) throws IOException {
		logger.info("use CachedGeoJsonWahllokalFacade");
		InputStream inputStream = this.getClass().getResourceAsStream("/wahllokale." + gkz + ".geojson");
		json = IOUtils.toString(inputStream);
	}

	@Override
	public String getJson() throws JsonProcessingException {
		return json;
	}

}
