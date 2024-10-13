package com.back2reality.event;

import com.back2reality.recommender.limitation.BaseCandidateLimiter;
import com.back2reality.recommender.logging.RecommenderLogger;
import com.back2reality.recommender.logging.RecommenderStageLogger;
import com.back2reality.recommender.ranking.ScoreCandidateRanker;
import com.back2reality.recommender.scoring.RandomCandidateScorer;
import com.back2reality.recommender.selection.StorageCandidateSelector;
import com.back2reality.storage.dao.EventStorage;
import com.back2reality.storage.mapper.EventMapper;
import com.back2reality.storage.repository.EventRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author FLIGHT
 */

@Configuration
public class EventRecommenderContextConfiguration {

  @Bean
  public EventItemFactory eventItemFactory() {
    return new EventItemFactory();
  }

  @Bean
  public EventMapper eventMapper() {
    return new EventMapper();
  }

  @Bean
  public EventStorage eventStorage(EventRepository eventRepository, EventMapper eventMapper) {
    return new EventStorage(eventRepository, eventMapper);
  }

  @Bean
  public StorageCandidateSelector<EventItem> storageCandidateSelector(EventStorage eventStorage) {
    return new StorageCandidateSelector<>(eventStorage);
  }

  @Bean
  public RandomCandidateScorer<EventItem> randomEventCandidateScorer(EventItemFactory eventItemFactory) {
    return new RandomCandidateScorer<>(eventItemFactory);
  }

  @Bean
  public ScoreCandidateRanker<EventItem> scoreEventCandidateRanker() {
    return new ScoreCandidateRanker<>();
  }

  @Bean
  public BaseCandidateLimiter<EventItem> baseEventCandidateLimiter() {
    return new BaseCandidateLimiter<>();
  }

  @Bean
  public RecommenderLogger<EventItem> eventRecommenderLogger() {
    return new RecommenderStageLogger<>();
  }

  @Bean
  public EventRecommender eventRecommender(
    StorageCandidateSelector<EventItem> storageCandidateSelector,
    RandomCandidateScorer<EventItem> randomEventCandidateScorer,
    ScoreCandidateRanker<EventItem> scoreEventCandidateRanker,
    BaseCandidateLimiter<EventItem> baseEventCandidateLimiter,
    RecommenderLogger<EventItem> eventRecommenderLogger)
  {
    return new EventRecommender(
      storageCandidateSelector,
      randomEventCandidateScorer,
      scoreEventCandidateRanker,
      baseEventCandidateLimiter,
      eventRecommenderLogger
    );
  }
}
