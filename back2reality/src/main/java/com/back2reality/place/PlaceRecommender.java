package com.back2reality.place;

import com.back2reality.recommender.*;
import com.back2reality.recommender.limitation.CandidatesLimiter;
import com.back2reality.recommender.logging.RecommenderLogger;
import com.back2reality.recommender.ranking.CandidateRanker;
import com.back2reality.recommender.scoring.CandidateScorer;
import com.back2reality.recommender.selection.CandidateSelector;

/**
 * @author FLIGHT
 */
public class PlaceRecommender extends Recommender<Place> {

  public PlaceRecommender(
    CandidateSelector<Place> candidateSelector,
    CandidateScorer<Place> candidateScorer,
    CandidateRanker<Place> candidateRanker,
    CandidatesLimiter<Place> candidatesLimiter,
    RecommenderLogger<Place> recommenderLogger)
  {
    super(candidateSelector, candidateScorer, candidateRanker, candidatesLimiter, recommenderLogger);
  }
}
