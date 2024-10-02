package com.back2reality.recommender.limitation;

import com.back2reality.recommender.context.RecommenderContext;

import java.util.List;

/**
 * @author FLIGHT
 */
public class BaseCandidateLimiter<TItem> implements CandidatesLimiter<TItem> {

  @Override
  public List<TItem> limit(List<TItem> candidates, RecommenderContext recommenderContext) {
    return candidates.stream()
      .limit(recommenderContext.limit())
      .toList();
  }
}
