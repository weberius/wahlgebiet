package de.illilli.opendata.service.wahlgebiet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;

import de.illilli.opendata.service.Config;
import de.illilli.opendata.service.DefaultFacade;
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
	@Path("/ping")
	public String getEmpty() throws JsonProcessingException {
		logger.info("/ping called");
		Facade facade = new DefaultFacade(DefaultFacade.INFO, "alive");
		return facade.getJson();
	}

}
