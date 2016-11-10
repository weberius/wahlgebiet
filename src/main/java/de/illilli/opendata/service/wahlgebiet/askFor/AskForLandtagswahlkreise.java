package de.illilli.opendata.service.wahlgebiet.askFor;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.Config;
import de.illilli.opendata.service.wahlgebiet.landtagswahlkreis.LandtagswahlkreiseArcgis;

public class AskForLandtagswahlkreise implements AskFor<LandtagswahlkreiseArcgis> {

	private static final Logger logger = Logger.getLogger(AskForLandtagswahlkreise.class);
	public static final String URL = Config.getProperty("odk.landtagswahlkreis.json.url");

	private LandtagswahlkreiseArcgis data;

	public AskForLandtagswahlkreise() throws MalformedURLException, IOException {
		this(new URL(URL).openStream());
	}

	public AskForLandtagswahlkreise(InputStream inputStream)
			throws JsonParseException, JsonMappingException, IOException {
		logger.info("ask for landtagswahlkreise");
		ObjectMapper mapper = new ObjectMapper();
		data = mapper.readValue(inputStream, LandtagswahlkreiseArcgis.class);
	}

	@Override
	public LandtagswahlkreiseArcgis getData() {
		return data;
	}

}
