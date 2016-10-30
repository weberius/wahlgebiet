package de.illilli.opendata.service.wahlgebiet.stimmbezirk.jdbc;

import java.util.ArrayList;
import java.util.List;

import org.geojson.LngLatAlt;
import org.postgis.LinearRing;
import org.postgis.MultiPolygon;
import org.postgis.Point;
import org.postgis.Polygon;

/**
 * Diese Hilfklasse wandelt ein GeoJson - Objekt in ein Postgis - Multipolygon
 * um. Voraussetzung ist dass das übergebende Feature ein MultiPolygon besitzt.
 * Das zurückgegebene Postgis-MultiPolygon kann in die Postgis Datenbank
 * eingelesen werden.
 */
public class GeoJson2PostgisMultipolygon {

	private MultiPolygon geometry;

	public GeoJson2PostgisMultipolygon(org.geojson.GeoJsonObject geoJsonObject) {

		if (geoJsonObject instanceof org.geojson.MultiPolygon) {
			setMultiPolygon((org.geojson.MultiPolygon) geoJsonObject);
		} else if (geoJsonObject instanceof org.geojson.Polygon) {
			setMultiPolygon((org.geojson.Polygon) geoJsonObject);
		}
	}

	/**
	 * 
	 * @param feature
	 *            feature mit einer Multipolygon Geometry.
	 */
	public void setMultiPolygon(org.geojson.MultiPolygon geoJsonMultiPolygon) {

		List<List<List<LngLatAlt>>> listListListLngLatAlt = geoJsonMultiPolygon.getCoordinates();

		List<Polygon> polygonList = new ArrayList<Polygon>();
		for (List<List<LngLatAlt>> listListLngLatAlt : listListListLngLatAlt) {
			List<LinearRing> linearRingList = new ArrayList<LinearRing>();
			for (List<LngLatAlt> listLngLatAlt : listListLngLatAlt) {
				List<Point> pointList = new ArrayList<Point>();
				for (LngLatAlt lngLatAlt : listLngLatAlt) {
					Point point = new Point(lngLatAlt.getLongitude(), lngLatAlt.getLatitude());
					pointList.add(point);
				}
				Point[] points = pointList.toArray(new Point[pointList.size()]);
				LinearRing linearRing = new LinearRing(points);
				linearRingList.add(linearRing);
			}
			LinearRing[] linearRings = linearRingList.toArray(new LinearRing[linearRingList.size()]);
			Polygon polygon = new Polygon(linearRings);
			polygonList.add(polygon);
		}

		Polygon[] polygons = polygonList.toArray(new Polygon[polygonList.size()]);
		geometry = new MultiPolygon(polygons);
		this.geometry.setSrid(4326);
	}

	public void setMultiPolygon(org.geojson.Polygon geoJsonPolygon) {

		geometry = new MultiPolygon();

		List<List<LngLatAlt>> listListLngLatAlt = geoJsonPolygon.getCoordinates();

		List<LinearRing> linearRingList = new ArrayList<LinearRing>();
		for (List<LngLatAlt> listLngLatAlt : listListLngLatAlt) {
			List<Point> pointList = new ArrayList<Point>();
			for (LngLatAlt lngLatAlt : listLngLatAlt) {
				Point point = new Point(lngLatAlt.getLongitude(), lngLatAlt.getLatitude());
				pointList.add(point);
			}
			Point[] points = pointList.toArray(new Point[pointList.size()]);
			LinearRing linearRing = new LinearRing(points);
			linearRingList.add(linearRing);
		}
		LinearRing[] linearRings = linearRingList.toArray(new LinearRing[linearRingList.size()]);

		Polygon[] polygons = new Polygon[] { new Polygon(linearRings) };
		geometry = new MultiPolygon(polygons);
		this.geometry.setSrid(4326);
	}

	/**
	 * 
	 * @return
	 */
	public MultiPolygon getGeometry() {
		return geometry;
	}

}
