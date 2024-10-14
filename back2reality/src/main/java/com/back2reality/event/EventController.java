package com.back2reality.event;

import com.back2reality.network.TRResponse;
import com.back2reality.recommender.context.DummyContext;
import com.back2reality.recommender.context.RecommenderContext;
import com.back2reality.storage.dao.EventStorage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author FLIGHT
 */

@RestController
@RequestMapping("/event")
public class EventController {

  private final EventRecommender eventRecommender;

  private final EventStorage eventStorage;

  public EventController(EventRecommender eventRecommender, EventStorage eventStorage) {
    this.eventRecommender = eventRecommender;
    this.eventStorage = eventStorage;
  }

  @GetMapping("/recommend")
  public List<EventItem> getEvents() {
    RecommenderContext recommenderContext = DummyContext.INSTANCE;
    return eventRecommender.recommend(recommenderContext);
  }

  @PostMapping( "/create")
  public EventForm create(@RequestBody EventForm eventForm) {
    eventStorage.create(eventForm);
    return eventForm;
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<TRResponse> delete(@PathVariable long id) {
    eventStorage.delete(id);
    return ResponseEntity.ok(TRResponse.of("ok"));
  }
}
