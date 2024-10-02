package com.back2reality.recommender.logging;

import com.back2reality.recommender.RecommenderStage;

import java.util.List;

/**
 * @author FLIGHT
 */
public interface RecommenderLogger<TItem> {

  void logRecommenderStage(List<TItem> result, RecommenderStage recommenderStage);

  void logRecommenderResult(List<TItem> result);
}
