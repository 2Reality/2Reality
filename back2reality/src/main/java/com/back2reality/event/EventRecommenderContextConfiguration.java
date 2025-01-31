package com.back2reality.event;

import com.back2reality.common.CommonContextConfiguration;
import com.back2reality.location.LocationFactory;
import com.back2reality.recommender.item.ItemFactory;
import com.back2reality.recommender.limitation.BaseCandidateLimiter;
import com.back2reality.recommender.limitation.CandidateLimiter;
import com.back2reality.recommender.logging.RecommenderLogger;
import com.back2reality.recommender.logging.RecommenderStageLogger;
import com.back2reality.recommender.ranking.CandidateRanker;
import com.back2reality.recommender.ranking.ReverseCandidateRanker;
import com.back2reality.recommender.scoring.CandidateScorer;
import com.back2reality.recommender.scoring.DistanceCandidateScorer;
import com.back2reality.recommender.selection.CandidateSelector;
import com.back2reality.recommender.selection.StorageCandidateSelector;
import com.back2reality.storage.dao.CandidateStorage;
import com.back2reality.storage.dao.EventStorage;
import com.back2reality.storage.mapper.EventMapper;
import com.back2reality.storage.repository.EventRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author FLIGHT
 */

@Configuration
@Import({CommonContextConfiguration.class})
public class EventRecommenderContextConfiguration {

  @Bean
  public ItemFactory<EventItem> eventItemFactory() {
    return new EventItemFactory();
  }

  @Bean
  public EventMapper eventMapper(LocationFactory locationFactory) {
    return new EventMapper(locationFactory);
  }

  @Bean
  public EventStorage eventStorage(EventRepository eventRepository, EventMapper eventMapper) {
    return new EventStorage(eventRepository, eventMapper);
  }

  @Bean
  public CandidateSelector<EventItem> eventItemCandidateSelector(CandidateStorage<EventItem> eventItemCandidateStorage) {
    return new StorageCandidateSelector<>(eventItemCandidateStorage);
  }

  @Bean
  public CandidateScorer<EventItem> eventItemCandidateScorer(ItemFactory<EventItem> eventItemFactory) {
    return new DistanceCandidateScorer<>(eventItemFactory);
//    return new RandomCandidateScorer<>(eventItemFactory);
  }

  @Bean
  public CandidateRanker<EventItem> eventItemCandidateRanker() {
    return new ReverseCandidateRanker<>();
//    return new ScoreCandidateRanker<>();
  }

  @Bean
  public CandidateLimiter<EventItem> eventItemCandidateLimiter() {
    return new BaseCandidateLimiter<>();
  }

  @Bean
  public RecommenderLogger<EventItem> eventItemRecommenderLogger() {
    return new RecommenderStageLogger<>();
  }

  @Bean
  public EventRecommender eventRecommender(
    CandidateSelector<EventItem> eventItemCandidateSelector,
    CandidateScorer<EventItem> eventItemCandidateScorer,
    CandidateRanker<EventItem> eventItemCandidateRanker,
    CandidateLimiter<EventItem> eventItemCandidateLimiter,
    RecommenderLogger<EventItem> eventItemRecommenderLogger)
  {
    return new EventRecommender(
      eventItemCandidateSelector,
      eventItemCandidateScorer,
      eventItemCandidateRanker,
      eventItemCandidateLimiter,
      eventItemRecommenderLogger
    );
  }
}
