package com.back2reality.event;

import com.back2reality.recommender.*;
import com.back2reality.recommender.limitation.CandidateLimiter;
import com.back2reality.recommender.logging.RecommenderLogger;
import com.back2reality.recommender.ranking.CandidateRanker;
import com.back2reality.recommender.scoring.CandidateScorer;
import com.back2reality.recommender.selection.CandidateSelector;

/**
 * @author FLIGHT
 */
public class EventRecommender extends Recommender<TREvent> {

  public EventRecommender(
    CandidateSelector<TREvent> candidateSelector,
    CandidateScorer<TREvent> candidateScorer,
    CandidateRanker<TREvent> candidateRanker,
    CandidateLimiter<TREvent> candidateLimiter,
    RecommenderLogger<TREvent> recommenderLogger)
  {
    super(candidateSelector, candidateScorer, candidateRanker, candidateLimiter, recommenderLogger);
  }
}
