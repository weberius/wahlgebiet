package de.illilli.opendata.service.wahlgebiet.stimmbezirk.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import org.apache.commons.io.IOUtils;
import org.geojson.GeoJsonObject;
import org.junit.After;
import org.junit.Before;
import org.postgis.LinearRing;
import org.postgis.MultiPolygon;
import org.postgis.PGgeometry;
import org.postgis.Point;
import org.postgis.Polygon;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.illilli.jdbc.ConnectionEnvironment;
import de.illilli.jdbc.ConnectionFactory;

public class InsertStimmbezirkTest {

	private Connection conn;

	@Before
	public void setUp() throws Exception {
		ConnectionEnvironment.setUpConnectionForJndi();
		conn = ConnectionFactory.getConnection();
	}

	@After
	public void tearDown() throws SQLException {
		conn.rollback();
		conn.close();
	}

	// @Test
	// public void test() {
	// fail("Not yet implemented");
	// }

	public static void main(String[] args) throws SQLException, NamingException, IOException {
		ConnectionEnvironment.setUpConnectionForJndi();
		Connection conn = ConnectionFactory.getConnection();
		StimmbezirkDTO stimmbezirk = InsertStimmbezirkTest.getStimmbezirkForTest();
		InsertStimmbezirk insert = new InsertStimmbezirk(stimmbezirk, conn);
		insert.closeConnection();
	}

	public static StimmbezirkDTO getStimmbezirkForTest() throws JsonParseException, JsonMappingException, IOException {
		StimmbezirkDTO s = new StimmbezirkDTO();
		s.setbWahl(123);
		s.setId("id");
		s.setkWahl(123);
		s.setlWahl(123);
		s.setNrStb(123);
		s.setNrStt(123);
		s.setNummer(123);
		s.setShapeArea(123456789.0123);
		s.setShapeLen(123456789.0123);
		s.setStb("stadtbezirk");
		s.setStt("stadtteil");
		// s.setGeom(InsertStimmbezirkTest.getMultipolygon());
		s.setGeom(InsertStimmbezirkTest.getMultipolygonFromGeoJson());
		return s;
	}

	public static PGgeometry getMultipolygon() {

		Polygon polygon = new Polygon( //
				new LinearRing[] { //
						new LinearRing( //
								new Point[] { //
										new Point(-1.0d, -1.0d), //
										new Point(1.0d, -1.0d), //
										new Point(1.0d, 1.0d), //
										new Point(-1.0d, 1.0d), //
										new Point(-1.0d, -1.0d) }) });
		Polygon[] polygonArray = new Polygon[] { polygon };
		MultiPolygon geom = new MultiPolygon(polygonArray);
		// ACHTUNG: Srid muss auf 4326 gesetzt werden, wie in der DB-Definition
		geom.setSrid(4326);

		return new PGgeometry(geom);
	}

	public static PGgeometry getMultipolygonFromGeoJson() throws JsonParseException, JsonMappingException, IOException {
		GeoJsonObject object = new ObjectMapper().readValue(IOUtils.toInputStream(getMultipolygonAsGeojson()),
				GeoJsonObject.class);
		MultiPolygon geom = new GeoJson2PostgisMultipolygon(object).getGeometry();
		return new PGgeometry(geom);
	}

	public static String getMultipolygonAsGeojson() {
		StringBuffer geojson = new StringBuffer();
		geojson.append(
				"{\"type\": \"MultiPolygon\", \"coordinates\": [ [ [ [100.0, 0.0], [101.0, 0.0], [101.0, 1.0], [100.0, 1.0], [100.0, 0.0] ] ] ] }, \"crs\" : {\"type\":\"name\",\"properties\":{\"name\":\"EPSG:4326\"}}");
		return geojson.toString();
	}

}
