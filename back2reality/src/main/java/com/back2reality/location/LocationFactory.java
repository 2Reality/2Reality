package com.back2reality.location;

import com.back2reality.storage.entities.Location;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

/**
 * @author FLIGHT
 */
public class LocationFactory {

    private final GeometryFactory geometryFactory;

    public LocationFactory(GeometryFactory geometryFactory) {
        this.geometryFactory = geometryFactory;
    }

    public LocationItem toLocationItem(Location location) {
        return new LocationItem(
                location.getTitle(),
                location.getLocation().getX(),
                location.getLocation().getY()
        );
    }

    public Point toPoint(double longitude, double latitude) {
       return geometryFactory.createPoint(new Coordinate(longitude, latitude));
    }

    public static Point defaultLocation() {
        return new GeometryFactory().createPoint(new Coordinate(0, 0));
    }
}
