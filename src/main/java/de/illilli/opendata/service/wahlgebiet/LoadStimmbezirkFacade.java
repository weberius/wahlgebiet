package de.illilli.opendata.service.wahlgebiet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.geojson.FeatureCollection;
import org.geotools.data.simple.SimpleFeatureSource;

import com.fasterxml.jackson.core.JsonProcessingException;

import de.illilli.jdbc.UpdateData;
import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.Facade;
import de.illilli.opendata.service.wahlgebiet.askFor.AskForStimmbezirke;
import de.illilli.opendata.service.wahlgebiet.stimmbezirk.Feature;
import de.illilli.opendata.service.wahlgebiet.stimmbezirk.StimmbezirkeArcgis;
import de.illilli.opendata.service.wahlgebiet.stimmbezirk.jdbc.DeleteStimmbezirk;
import de.illilli.opendata.service.wahlgebiet.stimmbezirk.jdbc.GeojsonFeatureStimmbezirk2DTO;
import de.illilli.opendata.service.wahlgebiet.stimmbezirk.jdbc.InsertStimmbezirk;
import de.illilli.opendata.service.wahlgebiet.stimmbezirk.jdbc.StimmbezirkDTO;

public class LoadStimmbezirkFacade implements Facade {

	private static final Logger logger = Logger.getLogger(LoadStimmbezirkFacade.class);
	SimpleFeatureSource featureSource;
	private int dataInserted = 0;
	private int dataNotInserted = 0;

	/**
	 * Anhand der Shape Daten werden die Stimmbezirke in die Datenbank
	 * eingeladen.
	 * 
	 * @param url
	 *            Wo die einzulesenden Daten zu finden sind.
	 * @throws IOException
	 * @throws SQLException
	 * @throws NamingException
	 */
	public LoadStimmbezirkFacade() throws IOException, SQLException, NamingException {

		FeatureCollection featureCollection = new FeatureCollection();

		AskFor<StimmbezirkeArcgis> askFor = new AskForStimmbezirke();
		StimmbezirkeArcgis stimmbezirkeFromArcgis = askFor.getData();
		List<Feature> featureList = stimmbezirkeFromArcgis.getFeatures();

		featureCollection = new ArcgisFeatureList2GeojsonFeatureCollection(featureList).getFeatureCollection();

		// delete stimmbezirke from database
		UpdateData delete = new DeleteStimmbezirk();
		logger.info(delete.getRowsUpdated() + "rows deleted");

		for (org.geojson.Feature geojsonFeature : featureCollection.getFeatures()) {

			StimmbezirkDTO dto = new GeojsonFeatureStimmbezirk2DTO(geojsonFeature).getDto();

			try {
				UpdateData insert = new InsertStimmbezirk(dto);
				dataInserted = dataInserted + insert.getRowsUpdated();
			} catch (SQLException e) {
				dataNotInserted++;
				logger.error("Unable to load data for " + dto.toString() + "; " + e.toString());
			} catch (ClassNotFoundException e) {
				logger.error(e);
			}

		}

	}

	@Override
	public String getJson() throws JsonProcessingException {
		StringBuffer sb = new StringBuffer();
		sb.append("{\"dataInserted\": ");
		sb.append(dataInserted);
		sb.append(",");
		sb.append("\"dataNotInserted\":");
		sb.append(dataNotInserted);
		sb.append("}");
		return sb.toString();
	}

}
