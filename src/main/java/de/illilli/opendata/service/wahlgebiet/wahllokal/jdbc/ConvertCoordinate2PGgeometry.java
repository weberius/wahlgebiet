package de.illilli.opendata.service.wahlgebiet.wahllokal.jdbc;

import org.apache.commons.lang3.math.NumberUtils;
import org.geotools.geometry.jts.JTS;
import org.geotools.referencing.CRS;
import org.opengis.geometry.MismatchedDimensionException;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.MathTransform;
import org.opengis.referencing.operation.TransformException;
import org.postgis.PGgeometry;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;

public class ConvertCoordinate2PGgeometry {

	private PGgeometry geom;

	public ConvertCoordinate2PGgeometry(String koordx, String koordy)
			throws NoSuchAuthorityCodeException, FactoryException, MismatchedDimensionException, TransformException {

		CoordinateReferenceSystem sourceCRS = CRS.decode("EPSG:3857");
		CoordinateReferenceSystem targetCRS = CRS.decode("EPSG:4326");

		double x = NumberUtils.toDouble(koordx);
		double y = NumberUtils.toDouble(koordy);

		GeometryFactory gf = new GeometryFactory();
		com.vividsolutions.jts.geom.Coordinate coord = new Coordinate(x, y);
		com.vividsolutions.jts.geom.Point sourceGeometry = gf.createPoint(coord);

		MathTransform transform = CRS.findMathTransform(sourceCRS, targetCRS, false);
		com.vividsolutions.jts.geom.Geometry targetGeometry = JTS.transform(sourceGeometry, transform);

		org.postgis.Geometry postGisPoint = new org.postgis.Point(targetGeometry.getCoordinate().x,
				targetGeometry.getCoordinate().y);
		postGisPoint.setSrid(4326);

		geom = new PGgeometry(postGisPoint);
	}

	public PGgeometry getGeom() {
		return geom;
	}
}
