package com.back2reality.recommender.logging;

import com.back2reality.recommender.RecommenderStage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author FLIGHT
 */
public class RecommenderStageLogger<TItem> implements RecommenderLogger<TItem> {

  private final Logger logger = LoggerFactory.getLogger(RecommenderStageLogger.class);

  @Override
  public void logRecommenderStage(List<TItem> result, RecommenderStage recommenderStage) {
    logger.info("after the {} stage there are {} candidates", recommenderStage, result.size());
  }

  @Override
  public void logRecommenderResult(List<TItem> result) {
    logger.info("recommendation result:");
    String resultPrettyString = result.stream()
      .map(TItem::toString)
      .collect(Collectors.joining(","));
    logger.info(resultPrettyString);
  }
}
