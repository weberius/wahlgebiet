package de.illilli.opendata.service.wahlgebiet;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.geotools.feature.SchemaException;
import org.opengis.geometry.MismatchedDimensionException;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.opengis.referencing.operation.TransformException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import de.illilli.opendata.service.Config;
import de.illilli.opendata.service.Facade;

@Path("/")
public class Service {

	private final static Logger logger = Logger.getLogger(Service.class);
	public static final String ENCODING = Config.getProperty("encoding");

	@Context
	private HttpServletRequest request;
	@Context
	private HttpServletResponse response;

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/empty")
	public String getEmpty() {
		return "{empty}";
	}

	/**
	 * Example:
	 * <p>
	 * <a href="http://localhost:8080/wahlgebiet/service/stimmbezirke?geojson">
	 * /wahlgebiet/service/stimmbezirke?geojson</a>
	 * </p>
	 * 
	 * @return
	 * @throws MismatchedDimensionException
	 * @throws JsonProcessingException
	 * @throws NoSuchAuthorityCodeException
	 * @throws IOException
	 * @throws FactoryException
	 * @throws TransformException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/stimmbezirke")
	public String getStimmbezirke() throws MismatchedDimensionException, JsonProcessingException,
			NoSuchAuthorityCodeException, IOException, FactoryException, TransformException {

		request.setCharacterEncoding(Config.getProperty("encoding"));
		response.setCharacterEncoding(Config.getProperty("encoding"));

		URL url = GeoJsonWahllokalFacade.class.getResource("/stimmbezirk/Stimmbezirk.shp");
		return new GeoJsonStimmbezirkeFacade(url).getJson();
	}

	/**
	 * <p>
	 * Dieser Service holt die Daten von nextbike-live und schreibt die
	 * aktuellen Positionen der Fahrräder in die Datenbank.
	 * </p>
	 * <p>
	 * Beispiel:
	 * <code>curl -X PUT http://localhost:8080/wahlgebiet/service/stimmbezirke/put</code>
	 * </p>
	 * 
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws SQLException
	 * @throws NamingException
	 */
	@PUT
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/stimmbezirke/put")
	public String putStimmbezirke()
			throws JsonParseException, JsonMappingException, IOException, SQLException, NamingException {
		Facade facade = new LoadStimmbezirkFacade();
		return facade.getJson();
	}

	/**
	 * Example:
	 * <p>
	 * <a href="http://localhost:8080/wahlgebiet/service/wahllokale?geojson">
	 * /wahlgebiet/service/wahllokale?geojson</a>
	 * </p>
	 * 
	 * 
	 * @return
	 * @throws URISyntaxException
	 * @throws IOException
	 * @throws SchemaException
	 * @throws FactoryException
	 * @throws NoSuchAuthorityCodeException
	 * @throws TransformException
	 * @throws MismatchedDimensionException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/wahllokale")
	public String getWahllokale() throws URISyntaxException, IOException, SchemaException, NoSuchAuthorityCodeException,
			FactoryException, MismatchedDimensionException, TransformException {

		request.setCharacterEncoding(Config.getProperty("encoding"));
		response.setCharacterEncoding(Config.getProperty("encoding"));

		Facade facade = new GeoJsonWahllokalFacade();
		return facade.getJson();
	}

}
