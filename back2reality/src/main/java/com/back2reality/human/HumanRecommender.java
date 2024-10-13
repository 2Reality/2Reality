package com.back2reality.human;

import com.back2reality.recommender.*;
import com.back2reality.recommender.limitation.CandidateLimiter;
import com.back2reality.recommender.logging.RecommenderLogger;
import com.back2reality.recommender.ranking.CandidateRanker;
import com.back2reality.recommender.scoring.CandidateScorer;
import com.back2reality.recommender.selection.CandidateSelector;

/**
 * @author FLIGHT
 */
public class HumanRecommender extends Recommender<HumanItem> {

  public HumanRecommender(
    CandidateSelector<HumanItem> candidateSelector,
    CandidateScorer<HumanItem> candidateScorer,
    CandidateRanker<HumanItem> candidateRanker,
    CandidateLimiter<HumanItem> candidateLimiter,
    RecommenderLogger<HumanItem> recommenderLogger)
  {
    super(candidateSelector, candidateScorer, candidateRanker, candidateLimiter, recommenderLogger);
  }
}
