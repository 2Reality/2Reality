package com.back2reality.place;

import com.back2reality.network.TRResponse;
import com.back2reality.recommender.context.DummyContext;
import com.back2reality.recommender.context.RecommenderContext;
import com.back2reality.storage.dao.PlaceStorage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author FLIGHT
 */

@RestController
@RequestMapping("/place")
public class PlaceController {

  private final PlaceRecommender placeRecommender;

  private final PlaceStorage placeStorage;

  public PlaceController(PlaceRecommender placeRecommender, PlaceStorage placeStorage) {
    this.placeRecommender = placeRecommender;
    this.placeStorage = placeStorage;
  }

  @GetMapping("/recommend")
  public List<PlaceItem> getEvents() {
    RecommenderContext recommenderContext = DummyContext.INSTANCE;
    return placeRecommender.recommend(recommenderContext);
  }

  @PostMapping( "/create")
  public PlaceForm create(@RequestBody PlaceForm placeForm) {
    placeStorage.create(placeForm);
    return placeForm;
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<TRResponse> delete(@PathVariable long id) {
    placeStorage.delete(id);
    return ResponseEntity.ok(TRResponse.of("ok"));
  }
}
