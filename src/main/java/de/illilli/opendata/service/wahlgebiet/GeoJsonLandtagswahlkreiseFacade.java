package de.illilli.opendata.service.wahlgebiet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;

import org.geojson.Feature;
import org.geojson.FeatureCollection;
import org.geojson.GeoJsonObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.illilli.jdbc.Select;
import de.illilli.opendata.service.Facade;
import de.illilli.opendata.service.wahlgebiet.landtagswahkreis.jdbc.LandtagswahlkreisDTO;
import de.illilli.opendata.service.wahlgebiet.landtagswahkreis.jdbc.SelectLandtagswahlkreiseGeojson;

/**
 * Diese Klasse 'kümmert' sich darum, dass die Landtagswahlkreise aus der
 * Datenbank gelesen werden und geojson formatiert zur Verfügung gestellt
 * werden.
 *
 */
public class GeoJsonLandtagswahlkreiseFacade implements Facade {

	private FeatureCollection featureCollection;

	public GeoJsonLandtagswahlkreiseFacade()
			throws JsonParseException, JsonMappingException, IOException, SQLException, NamingException {
		List<Feature> featureList = new ArrayList<>();

		// lese aus Datenbank
		Select<LandtagswahlkreisDTO> select = new SelectLandtagswahlkreiseGeojson();
		List<LandtagswahlkreisDTO> wahlkreiseList = select.getDbObjectList();
		for (LandtagswahlkreisDTO dto : wahlkreiseList) {
			Feature feature = new Feature();
			feature.setId(dto.getId() + "");
			Map<String, Object> properties = new HashMap<>();
			properties.put("nummer", dto.getNummer());
			properties.put("bezeichnung", dto.getBezeichnung());
			feature.setProperties(properties);

			GeoJsonObject geomertry = new ObjectMapper().readValue(dto.getGeojson(), GeoJsonObject.class);

			feature.setGeometry(geomertry);
			featureList.add(feature);
		}

		// erstelle featureCollection-Object

		featureCollection = new FeatureCollection();
		featureCollection.addAll(featureList);
	}

	@Override
	public String getJson() throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(featureCollection);
	}

}
