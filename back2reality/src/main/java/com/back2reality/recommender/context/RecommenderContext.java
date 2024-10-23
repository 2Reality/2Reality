package com.back2reality.recommender.context;

import org.locationtech.jts.geom.Point;

/**
 * @author FLIGHT
 */
public interface RecommenderContext {

  RecommenderUser getUser();
  Point location();
  int limit();
}
