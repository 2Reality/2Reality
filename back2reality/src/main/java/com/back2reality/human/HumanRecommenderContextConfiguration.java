package com.back2reality.human;

import com.back2reality.recommender.item.ItemFactory;
import com.back2reality.recommender.limitation.BaseCandidateLimiter;
import com.back2reality.recommender.limitation.CandidateLimiter;
import com.back2reality.recommender.logging.RecommenderLogger;
import com.back2reality.recommender.logging.RecommenderStageLogger;
import com.back2reality.recommender.ranking.CandidateRanker;
import com.back2reality.recommender.ranking.ScoreCandidateRanker;
import com.back2reality.recommender.scoring.CandidateScorer;
import com.back2reality.recommender.scoring.RandomCandidateScorer;
import com.back2reality.recommender.selection.CandidateSelector;
import com.back2reality.recommender.selection.StorageCandidateSelector;
import com.back2reality.storage.dao.CandidateStorage;
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
  public HumanStorage humanItemStorage(HumanRepository humanRepository, HumanMapper humanMapper) {
    return new HumanStorage(humanRepository, humanMapper);
  }

  @Bean
  public CandidateSelector<HumanItem> humanItemCandidateSelector(CandidateStorage<HumanItem> humanItemCandidateStorage) {
    return new StorageCandidateSelector<>(humanItemCandidateStorage);
  }

  @Bean
  public ItemFactory<HumanItem> humanItemFactory() {
    return new HumanItemFactory();
  }

  @Bean
  public CandidateScorer<HumanItem> humanItemCandidateScorer(ItemFactory<HumanItem> humanItemFactory) {
    return new RandomCandidateScorer<>(humanItemFactory);
  }

  @Bean
  public CandidateRanker<HumanItem> humanItemCandidateRanker() {
    return new ScoreCandidateRanker<>();
  }

  @Bean
  public CandidateLimiter<HumanItem> humanItemCandidateLimiter() {
    return new BaseCandidateLimiter<>();
  }

  @Bean
  public RecommenderLogger<HumanItem> humanItemRecommenderLogger() {
    return new RecommenderStageLogger<>();
  }

  @Bean
  public HumanRecommender humanRecommender(
    CandidateSelector<HumanItem> humanItemCandidateSelector,
    CandidateScorer<HumanItem> humanItemCandidateScorer,
    CandidateRanker<HumanItem> humanItemCandidateRanker,
    CandidateLimiter<HumanItem> humanItemCandidateLimiter,
    RecommenderLogger<HumanItem> humanItemRecommenderLogger)
  {
    return new HumanRecommender(
      humanItemCandidateSelector,
      humanItemCandidateScorer,
      humanItemCandidateRanker,
      humanItemCandidateLimiter,
      humanItemRecommenderLogger
    );
  }
}
