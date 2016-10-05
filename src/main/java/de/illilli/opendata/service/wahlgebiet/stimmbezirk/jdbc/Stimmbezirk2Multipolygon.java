package de.illilli.opendata.service.wahlgebiet.stimmbezirk.jdbc;

import java.util.ArrayList;
import java.util.List;

import org.postgis.LinearRing;
import org.postgis.MultiPolygon;
import org.postgis.Point;
import org.postgis.Polygon;

import com.vividsolutions.jts.geom.Coordinate;

public class Stimmbezirk2Multipolygon {

	public static final int SRID = 4326;
	private MultiPolygon geometry = new MultiPolygon();

	public Stimmbezirk2Multipolygon(com.vividsolutions.jts.geom.MultiPolygon multiPolygon) {

		List<Point> elements = new ArrayList<Point>();

		for (Coordinate coordinate : multiPolygon.getCoordinates()) {
			Point point = new Point(coordinate.x, coordinate.y);
			elements.add(point);
		}

		Point[] points = elements.toArray(new Point[elements.size()]);
		LinearRing linearRing = new LinearRing(points);
		LinearRing[] linearRings = new LinearRing[] { linearRing };
		Polygon polygon = new Polygon(linearRings);
		Polygon[] polygons = new Polygon[] { polygon };

		geometry = new MultiPolygon(polygons);
		geometry.setSrid(SRID);
	}

	public MultiPolygon getGeometry() {
		return geometry;
	}
}
