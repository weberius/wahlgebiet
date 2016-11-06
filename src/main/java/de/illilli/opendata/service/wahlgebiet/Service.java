package de.illilli.opendata.service.wahlgebiet;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	 * Get information about stimmbezirke. At the moment it returns an geojson.
	 * If Example:
	 * <p>
	 * <a href="http://localhost:8080/wahlgebiet/service/stimmbezirke?geojson">
	 * /wahlgebiet/service/stimmbezirke?geojson</a>
	 * </p>
	 * 
	 * @return all stimmbezirke geojson formatted
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

		logger.info("/stimmbezirke called");
		request.setCharacterEncoding(Config.getProperty("encoding"));
		response.setCharacterEncoding(Config.getProperty("encoding"));
		boolean isGeojson = request.getParameter("geojson") != null;

		if (isGeojson) {
			return new GeoJsonStimmbezirkeFacade().getJson();
		} else {
			return "not implemented; use '/wahlgebiet/service/stimmbezirke?geojson' instead";
		}
	}

	/**
	 * <p>
	 * Get the stimmbezirk by lat-lng geo Information.
	 * </p>
	 * 
	 * <p>
	 * Example: <a href=
	 * "http://localhost:8080/wahlgebiet/service/stimmbezirk/6.958307/50.941357">
	 * /wahlgebiet/service/stimmbezirk/{lng}/{lat}</a>
	 * </p>
	 * 
	 * @return the stimmbezirk information json formatted.
	 * @throws MismatchedDimensionException
	 * @throws JsonProcessingException
	 * @throws NoSuchAuthorityCodeException
	 * @throws IOException
	 * @throws FactoryException
	 * @throws TransformException
	 * @throws NamingException
	 * @throws SQLException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/stimmbezirk/{lng}/{lat}")
	public String getStimmbezirkByLatLng(@PathParam("lng") double lng, @PathParam("lat") double lat)
			throws MismatchedDimensionException, JsonProcessingException, NoSuchAuthorityCodeException, IOException,
			FactoryException, TransformException, SQLException, NamingException {

		logger.info("/stimmbezirk/" + lng + "/" + lat + " called");

		request.setCharacterEncoding(Config.getProperty("encoding"));
		response.setCharacterEncoding(Config.getProperty("encoding"));

		return new StimmbezirkFacade(lng, lat).getJson();
	}

	/**
	 * <p>
	 * Dieser Service holt die Daten von nextbike-live und schreibt die
	 * aktuellen Positionen der Fahrräder in die Datenbank.
	 * </p>
	 * <p>
	 * Beispiel:
	 * <code>curl -X PUT http://localhost:8080/wahlgebiet/service/load/stimmbezirke</code>
	 * </p>
	 * 
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws SQLException
	 * @throws NamingException
	 * @throws URISyntaxException
	 * @throws TransformException
	 * @throws FactoryException
	 * @throws NoSuchAuthorityCodeException
	 * @throws MismatchedDimensionException
	 */
	@PUT
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/load/{wahlgebiet}")
	public String load(@PathParam("wahlgebiet") String wahlgebiet) throws JsonParseException, JsonMappingException,
			IOException, SQLException, NamingException, URISyntaxException, MismatchedDimensionException,
			NoSuchAuthorityCodeException, FactoryException, TransformException {

		logger.info("/load/" + wahlgebiet + " called");
		Facade facade = LoadWahlgebietFacadeFactory.getFacade(wahlgebiet);
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

		logger.info("/wahllokale called");

		request.setCharacterEncoding(Config.getProperty("encoding"));
		response.setCharacterEncoding(Config.getProperty("encoding"));

		boolean isGeojson = request.getParameter("geojson") != null;
		if (isGeojson) {
			return new GeoJsonWahllokalFacade().getJson();
		} else {
			return "not implemented; use '/wahlgebiet/service/wahllokale?geojson' instead";
		}
	}

}
