package com.back2reality.recommender.context;

import org.springframework.stereotype.Component;

/**
 * @author FLIGHT
 */

@Component
public class DummyContext implements RecommenderContext {

  public static DummyContext INSTANCE = new DummyContext();

  @Override
  public RecommenderUser getUser() {
    return new RecommenderUser();
  }

  @Override
  public int limit() {
    return 32;
  }
}
