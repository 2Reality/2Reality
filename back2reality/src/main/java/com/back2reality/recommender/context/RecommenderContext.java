package com.back2reality.recommender.context;

/**
 * @author FLIGHT
 */
public interface RecommenderContext {

  RecommenderUser getUser();

  int limit();
}
