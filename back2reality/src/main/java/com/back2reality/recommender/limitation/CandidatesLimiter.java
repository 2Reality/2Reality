package com.back2reality.recommender.limitation;

import com.back2reality.recommender.context.RecommenderContext;

import java.util.List;

/**
 * @author FLIGHT
 */
public interface CandidatesLimiter<TItem> {

  List<TItem> limit(List<TItem> candidates, RecommenderContext recommenderContext);
}
