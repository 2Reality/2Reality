package com.back2reality.recommender.scoring;

import com.back2reality.recommender.context.RecommenderContext;

import java.util.List;

/**
 * @author FLIGHT
 */
public interface CandidateScorer<TItem> {

  List<TItem> score(List<TItem> candidates, RecommenderContext recommenderContext);
}
