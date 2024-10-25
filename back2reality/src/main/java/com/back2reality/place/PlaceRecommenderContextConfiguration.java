package com.back2reality.place;

import com.back2reality.common.CommonContextConfiguration;
import com.back2reality.location.LocationFactory;
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
import com.back2reality.storage.dao.PlaceStorage;
import com.back2reality.storage.mapper.PlaceMapper;
import com.back2reality.storage.repository.PlaceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author FLIGHT
 */

@Configuration
@Import({CommonContextConfiguration.class})
public class PlaceRecommenderContextConfiguration {

  @Bean
  public PlaceMapper placeMapper(LocationFactory locationFactory) {
    return new PlaceMapper(locationFactory);
  }

  @Bean
  public PlaceStorage placeItemCandidateStorage(
    PlaceRepository placeRepository,
    PlaceMapper placeMapper)
  {
    return new PlaceStorage(placeRepository, placeMapper);
  }

  @Bean
  public CandidateSelector<PlaceItem> placeItemStorageCandidateSelector(CandidateStorage<PlaceItem> placeItemCandidateStorage)
  {
    return new StorageCandidateSelector<>(placeItemCandidateStorage);
  }

  @Bean
  public ItemFactory<PlaceItem> placeItemItemFactory() {
    return new PlaceItemFactory();
  }

  @Bean
  public CandidateScorer<PlaceItem> placeItemCandidateScorer(ItemFactory<PlaceItem> placeItemFactory) {
    return new RandomCandidateScorer<>(placeItemFactory);
  }

  @Bean
  public CandidateRanker<PlaceItem> placeItemCandidateRanker() {
    return new ScoreCandidateRanker<>();
  }

  @Bean
  public CandidateLimiter<PlaceItem> placeItemCandidateLimiter() {
    return new BaseCandidateLimiter<>();
  }

  @Bean
  public RecommenderLogger<PlaceItem> placeItemRecommenderLogger() {
    return new RecommenderStageLogger<>();
  }

  @Bean
  public PlaceRecommender placeRecommender(
    CandidateSelector<PlaceItem> placeItemCandidateSelector,
    CandidateScorer<PlaceItem> placeItemCandidateScorer,
    CandidateRanker<PlaceItem> placeItemCandidateRanker,
    CandidateLimiter<PlaceItem> placeItemCandidateLimiter,
    RecommenderLogger<PlaceItem> placeItemRecommenderLogger
  ) {
    return new PlaceRecommender(
      placeItemCandidateSelector,
      placeItemCandidateScorer,
      placeItemCandidateRanker,
      placeItemCandidateLimiter,
      placeItemRecommenderLogger
    );
  }
}
