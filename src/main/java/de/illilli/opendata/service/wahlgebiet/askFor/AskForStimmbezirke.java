package de.illilli.opendata.service.wahlgebiet.askFor;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.illilli.opendata.koeln.arcgis.StimmbezirkeArcgis;
import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.Config;

public class AskForStimmbezirke implements AskFor<StimmbezirkeArcgis> {

	private static final Logger logger = Logger.getLogger(AskForStimmbezirke.class);

	public static final String URL = Config.getProperty("odk.stimmbezirk.json.url");
	private StimmbezirkeArcgis data;

	public AskForStimmbezirke() throws MalformedURLException, IOException {
		this(new URL(URL).openStream());
	}

	public AskForStimmbezirke(InputStream inputStream) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();
		data = mapper.readValue(inputStream, StimmbezirkeArcgis.class);
		logger.debug(URL);

	}

	@Override
	public StimmbezirkeArcgis getData() {
		return data;
	}

}
