package com.back2reality.recommender.ranking;

import com.back2reality.recommender.context.RecommenderContext;

import java.util.List;

/**
 * @author FLIGHT
 */
public interface CandidateRanker<TItem> {

  List<TItem> rank(List<TItem> candidates, RecommenderContext recommenderContext);
}
