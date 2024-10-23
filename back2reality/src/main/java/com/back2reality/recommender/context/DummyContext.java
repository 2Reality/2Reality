package com.back2reality.recommender.context;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author FLIGHT
 */

@Component
public class DummyContext implements RecommenderContext {

  @Value("${config.longitude}")
  private double longitude;

  @Value("${config.latitude}")
  private double latitude;

  public static DummyContext INSTANCE = new DummyContext();

  @Override
  public RecommenderUser getUser() {
    return new RecommenderUser();
  }

  @Override
  public Point location() {
    GeometryFactory geometryFactory = new GeometryFactory();
    return geometryFactory.createPoint(new Coordinate(longitude, latitude));
  }

  @Override
  public int limit() {
    return 32;
  }
}
