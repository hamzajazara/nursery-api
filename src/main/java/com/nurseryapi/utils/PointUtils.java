package com.nurseryapi.utils;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

public class PointUtils {

	private static GeometryFactory geometryFactory;

	private PointUtils() {
	}

	/**
	 * 
	 * @param source
	 * @param target
	 * @return
	 */
	public static Point create(com.nurseryapi.model.Point point) {
		if (point == null)
			return null;

		if (geometryFactory == null) {
			geometryFactory = new GeometryFactory();
		}

		return geometryFactory.createPoint(new Coordinate(point.getLat(), point.getLng()));
	}
}