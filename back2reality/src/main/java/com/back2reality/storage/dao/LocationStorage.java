package com.back2reality.storage.dao;

import com.back2reality.location.LocationItem;
import com.back2reality.location.LocationMapper;
import com.back2reality.storage.entities.Location;
import com.back2reality.storage.repository.LocationRepository;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author FLIGHT
 */
public class LocationStorage {

  private static final Logger logger = LoggerFactory.getLogger(LocationStorage.class);

  private final LocationRepository locationRepository;

  private final LocationMapper locationMapper;

  public LocationStorage(LocationRepository locationRepository, LocationMapper locationMapper) {
    this.locationRepository = locationRepository;
    this.locationMapper = locationMapper;
  }

  public List<LocationItem> getLocationsNear(double longitude, double latitude, double distance) {
    List<Location> nearestLocations = locationRepository.findWithinDistance(longitude, latitude, distance);

    logger.info("found {} nearest locations", nearestLocations.size());
    return nearestLocations.stream()
            .map(locationMapper::toLocationItem)
            .toList();
  }

  public void saveLocation(LocationItem locationForm) {
    GeometryFactory geometryFactory = new GeometryFactory();
    Point point = geometryFactory.createPoint(new Coordinate(locationForm.longitude(), locationForm.latitude()));
    Location savedLocation = locationRepository.save(new Location(locationForm.title(), point));
    logger.info("Saved {} location", savedLocation);
  }
}
