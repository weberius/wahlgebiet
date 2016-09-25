package de.illilli.opendata.service.wahlgebiet.stimmbezirk.jdbc;

import java.util.ArrayList;
import java.util.List;

import org.postgis.LinearRing;
import org.postgis.MultiPolygon;
import org.postgis.Point;
import org.postgis.Polygon;

public class Stimmbezirk2Multipolygon {

	private MultiPolygon geometry = new MultiPolygon();

	public Stimmbezirk2Multipolygon() {

		List<Point> elements = new ArrayList<Point>();

		// for loop

		Point[] points = elements.toArray(new Point[elements.size()]);
		LinearRing linearRing = new LinearRing(points);
		LinearRing[] linearRings = new LinearRing[] { linearRing };
		Polygon polygon = new Polygon(linearRings);
		Polygon[] polygons = new Polygon[] { polygon };

		geometry = new MultiPolygon(polygons);

	}

	public MultiPolygon getGeometry() {
		return geometry;
	}
}
