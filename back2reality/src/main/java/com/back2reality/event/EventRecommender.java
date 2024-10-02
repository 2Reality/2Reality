package com.back2reality.event;

import com.back2reality.recommender.*;
import com.back2reality.recommender.limitation.CandidatesLimiter;
import com.back2reality.recommender.logging.RecommenderLogger;
import com.back2reality.recommender.ranking.CandidateRanker;
import com.back2reality.recommender.scoring.CandidateScorer;
import com.back2reality.recommender.selection.CandidateSelector;

/**
 * @author FLIGHT
 */
public class EventRecommender extends Recommender<Event> {

  public EventRecommender(
    CandidateSelector<Event> candidateSelector,
    CandidateScorer<Event> candidateScorer,
    CandidateRanker<Event> candidateRanker,
    CandidatesLimiter<Event> candidatesLimiter,
    RecommenderLogger<Event> recommenderLogger)
  {
    super(candidateSelector, candidateScorer, candidateRanker, candidatesLimiter, recommenderLogger);
  }
}
