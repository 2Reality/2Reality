package com.back2reality.human;

import com.back2reality.recommender.limitation.BaseCandidateLimiter;
import com.back2reality.recommender.logging.RecommenderStageLogger;
import com.back2reality.recommender.ranking.ScoreCandidateRanker;
import com.back2reality.recommender.scoring.RandomCandidateScorer;
import com.back2reality.recommender.selection.StorageCandidateSelector;
import com.back2reality.storage.dao.HumanStorage;
import com.back2reality.storage.mapper.HumanMapper;
import com.back2reality.storage.repository.HumanRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author FLIGHT
 */

@Configuration
public class HumanRecommenderContextConfiguration {

  @Bean
  public HumanMapper humanMapper() {
    return new HumanMapper();
  }

  @Bean
  public HumanStorage humanStorage(HumanRepository humanRepository, HumanMapper humanMapper) {
    return new HumanStorage(humanRepository, humanMapper);
  }

  @Bean
  public StorageCandidateSelector<HumanItem> humanItemStorageCandidateSelector(HumanStorage humanStorage) {
    return new StorageCandidateSelector<>(humanStorage);
  }

  @Bean
  public HumanItemFactory humanItemFactory() {
    return new HumanItemFactory();
  }

  @Bean
  public RandomCandidateScorer<HumanItem> humanItemRandomCandidateScorer(HumanItemFactory humanItemFactory) {
    return new RandomCandidateScorer<>(humanItemFactory);
  }

  @Bean
  public ScoreCandidateRanker<HumanItem> humanItemScoreCandidateRanker() {
    return new ScoreCandidateRanker<>();
  }

  @Bean
  public BaseCandidateLimiter<HumanItem> humanItemBaseCandidateLimiter() {
    return new BaseCandidateLimiter<>();
  }

  @Bean
  public RecommenderStageLogger<HumanItem> humanItemRecommenderStageLogger() {
    return new RecommenderStageLogger<>();
  }

  @Bean
  public HumanRecommender humanRecommender(
    StorageCandidateSelector<HumanItem> humanItemStorageCandidateSelector,
    RandomCandidateScorer<HumanItem> humanItemRandomCandidateScorer,
    ScoreCandidateRanker<HumanItem> humanItemScoreCandidateRanker,
    BaseCandidateLimiter<HumanItem> humanItemBaseCandidateLimiter,
    RecommenderStageLogger<HumanItem> humanItemRecommenderStageLogger) {
    return new HumanRecommender(
      humanItemStorageCandidateSelector,
      humanItemRandomCandidateScorer,
      humanItemScoreCandidateRanker,
      humanItemBaseCandidateLimiter,
      humanItemRecommenderStageLogger
    );
  }
}
