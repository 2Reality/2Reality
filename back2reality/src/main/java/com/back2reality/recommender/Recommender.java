package com.back2reality.recommender;

import com.back2reality.recommender.context.RecommenderContext;
import com.back2reality.recommender.limitation.CandidateLimiter;
import com.back2reality.recommender.logging.RecommenderLogger;
import com.back2reality.recommender.ranking.CandidateRanker;
import com.back2reality.recommender.scoring.CandidateScorer;
import com.back2reality.recommender.selection.CandidateSelector;

import java.util.List;

/**
 * @author FLIGHT
 */
public abstract class Recommender<TItem> {

  private final CandidateSelector<TItem> candidateSelector;

  private final CandidateScorer<TItem> candidateScorer;

  private final CandidateRanker<TItem> candidateRanker;

  private final CandidateLimiter<TItem> candidateLimiter;

  private final RecommenderLogger<TItem> recommenderLogger;

  public Recommender(
    CandidateSelector<TItem> candidateSelector,
    CandidateScorer<TItem> candidateScorer,
    CandidateRanker<TItem> candidateRanker,
    CandidateLimiter<TItem> candidateLimiter,
    RecommenderLogger<TItem> recommenderLogger)
  {
    this.candidateSelector = candidateSelector;
    this.candidateScorer = candidateScorer;
    this.candidateRanker = candidateRanker;
    this.candidateLimiter = candidateLimiter;
    this.recommenderLogger = recommenderLogger;
  }

  public List<TItem> recommend(RecommenderContext recommenderContext) {
    List<TItem> selectedCandidates = getCandidates(recommenderContext);
    List<TItem> scoredCandidates = score(selectedCandidates, recommenderContext);
    List<TItem> rankedCandidates = rank(scoredCandidates, recommenderContext);
    List<TItem> limitedCandidates = limit(rankedCandidates, recommenderContext);

    recommenderLogger.logRecommenderResult(limitedCandidates);
    return limitedCandidates;
  }

  private List<TItem> getCandidates(RecommenderContext recommenderContext) {
    List<TItem> candidates = candidateSelector.getCandidates(recommenderContext);
    recommenderLogger.logRecommenderStage(candidates, RecommenderStage.CANDIDATE_SELECTION);

    return candidates;
  }

  private List<TItem> score(List<TItem> candidates, RecommenderContext recommenderContext) {
    List<TItem> scoredCandidates = candidateScorer.score(candidates, recommenderContext);
    recommenderLogger.logRecommenderStage(scoredCandidates, RecommenderStage.CANDIDATE_SCORING);

    return scoredCandidates;
  }

  private List<TItem> rank(List<TItem> candidates, RecommenderContext recommenderContext) {
    List<TItem> rankedCandidates = candidateRanker.rank(candidates, recommenderContext);
    recommenderLogger.logRecommenderStage(rankedCandidates, RecommenderStage.CANDIDATE_RANKING);

    return rankedCandidates;
  }

  private List<TItem> limit(List<TItem> candidates, RecommenderContext recommenderContext) {
    List<TItem> limitedCandidates = candidateLimiter.limit(candidates, recommenderContext);
    recommenderLogger.logRecommenderStage(limitedCandidates, RecommenderStage.CANDIDATE_LIMITATION);

    return limitedCandidates;
  }
}
