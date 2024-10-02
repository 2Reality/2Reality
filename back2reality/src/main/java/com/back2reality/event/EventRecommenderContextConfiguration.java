package com.back2reality.event;

import com.back2reality.recommender.limitation.BaseCandidateLimiter;
import com.back2reality.recommender.logging.RecommenderLogger;
import com.back2reality.recommender.logging.RecommenderStageLogger;
import com.back2reality.recommender.ranking.ScoreCandidateRanker;
import com.back2reality.recommender.scoring.RandomCandidateScorer;
import com.back2reality.recommender.selection.RandomCandidateSelector;
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
  public RandomCandidateSelector<Event> randomEventCandidateSelector(EventItemFactory eventItemFactory) {
    return new RandomCandidateSelector<>(eventItemFactory);
  }

  @Bean
  public RandomCandidateScorer<Event> randomEventCandidateScorer(EventItemFactory eventItemFactory) {
    return new RandomCandidateScorer<>(eventItemFactory);
  }

  @Bean
  public ScoreCandidateRanker<Event> scoreEventCandidateRanker() {
    return new ScoreCandidateRanker<>();
  }

  @Bean
  public BaseCandidateLimiter<Event> baseEventCandidateLimiter() {
    return new BaseCandidateLimiter<>();
  }

  @Bean
  public RecommenderLogger<Event> eventRecommenderLogger() {
    return new RecommenderStageLogger<>();
  }

  @Bean
  public EventRecommender eventRecommender(
    RandomCandidateSelector<Event> randomEventCandidateSelector,
    RandomCandidateScorer<Event> randomEventCandidateScorer,
    ScoreCandidateRanker<Event> scoreEventCandidateRanker,
    BaseCandidateLimiter<Event> baseEventCandidateLimiter,
    RecommenderLogger<Event> eventRecommenderLogger)
  {
    return new EventRecommender(
      randomEventCandidateSelector,
      randomEventCandidateScorer,
      scoreEventCandidateRanker,
      baseEventCandidateLimiter,
      eventRecommenderLogger
    );
  }
}
