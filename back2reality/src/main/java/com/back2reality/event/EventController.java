package com.back2reality.event;

import com.back2reality.recommender.context.DummyContext;
import com.back2reality.recommender.context.RecommenderContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author FLIGHT
 */

@RestController
public class EventController {

  private final EventRecommender eventRecommender;


  public EventController(EventRecommender eventRecommender, RecommenderContext recommenderContext) {
    this.eventRecommender = eventRecommender;
  }

  @GetMapping("/events")
  public List<Event> getEvents() {
    RecommenderContext recommenderContext = DummyContext.INSTANCE;
    return eventRecommender.recommend(recommenderContext);
  }
}
