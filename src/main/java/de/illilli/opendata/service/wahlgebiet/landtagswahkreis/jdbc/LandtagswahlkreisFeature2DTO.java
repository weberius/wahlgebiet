package de.illilli.opendata.service.wahlgebiet.landtagswahkreis.jdbc;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.math.NumberUtils;
import org.postgis.LinearRing;
import org.postgis.MultiPolygon;
import org.postgis.PGgeometry;
import org.postgis.Point;
import org.postgis.Polygon;

import de.illilli.opendata.service.wahlgebiet.landtagswahlkreis.Feature;

public class LandtagswahlkreisFeature2DTO {

	private LandtagswahlkreisDTO dto;

	public LandtagswahlkreisFeature2DTO(Feature feature) {

		this.dto = new LandtagswahlkreisDTO();
		this.dto.setId(NumberUtils.toInt(feature.attributes.objectid));
		this.dto.setNummer(NumberUtils.toInt(feature.attributes.nummer));
		this.dto.setBezeichnung(feature.attributes.bezeichnung);
		this.dto.setGeom(getGeom(feature));
	}

	public LandtagswahlkreisDTO getDto() {
		return dto;
	}

	PGgeometry getGeom(Feature feature) {

		de.illilli.opendata.koeln.arcgis.Geometry geometry = feature.geometry;
		double[][][] rings = geometry.getRings();

		List<Polygon> polygonList = new ArrayList<Polygon>();
		for (double[][] ring1 : rings) {
			List<LinearRing> linearRingList = new ArrayList<LinearRing>();
			List<Point> pointList = new ArrayList<Point>();
			for (double[] ring2 : ring1) {
				Point point = new Point(ring2[0], ring2[1]);
				pointList.add(point);
			}
			Point[] points = pointList.toArray(new Point[pointList.size()]);
			LinearRing linearRing = new LinearRing(points);
			linearRingList.add(linearRing);

			LinearRing[] linearRings = linearRingList.toArray(new LinearRing[linearRingList.size()]);
			Polygon polygon = new Polygon(linearRings);
			polygonList.add(polygon);
		}

		Polygon[] polygons = polygonList.toArray(new Polygon[polygonList.size()]);
		MultiPolygon geom = new MultiPolygon(polygons);
		geom.setSrid(4326);
		return new PGgeometry(geom);
	}

}
