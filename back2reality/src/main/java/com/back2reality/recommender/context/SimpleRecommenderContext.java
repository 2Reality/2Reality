package com.back2reality.recommender.context;

import org.locationtech.jts.geom.Point;

/**
 * @author FLIGHT
 */
public record SimpleRecommenderContext(Point location, int limit) implements RecommenderContext {

}
