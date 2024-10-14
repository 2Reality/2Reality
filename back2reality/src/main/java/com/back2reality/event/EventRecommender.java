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
public class EventRecommender extends Recommender<EventItem> {

  public EventRecommender(
    CandidateSelector<EventItem> candidateSelector,
    CandidateScorer<EventItem> candidateScorer,
    CandidateRanker<EventItem> candidateRanker,
    CandidateLimiter<EventItem> candidateLimiter,
    RecommenderLogger<EventItem> recommenderLogger)
  {
    super(candidateSelector, candidateScorer, candidateRanker, candidateLimiter, recommenderLogger);
  }
}
