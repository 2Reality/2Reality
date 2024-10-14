package com.back2reality.human;

import com.back2reality.network.TRResponse;
import com.back2reality.recommender.context.DummyContext;
import com.back2reality.recommender.context.RecommenderContext;
import com.back2reality.storage.dao.HumanStorage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author FLIGHT
 */

@RestController
@RequestMapping("/human")
public class HumanController {

  private final HumanRecommender humanRecommender;

  private final HumanStorage humanStorage;

  public HumanController(HumanRecommender humanRecommender, HumanStorage humanStorage) {
    this.humanRecommender = humanRecommender;
    this.humanStorage = humanStorage;
  }

  @GetMapping("/recommend")
  public List<HumanItem> getHumans() {
    RecommenderContext recommenderContext = DummyContext.INSTANCE;
    return humanRecommender.recommend(recommenderContext);
  }

  @PostMapping( "/create")
  public HumanForm create(@RequestBody HumanForm humanForm) {
    humanStorage.create(humanForm);
    return humanForm;
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<TRResponse> delete(@PathVariable long id) {
    humanStorage.delete(id);
    return ResponseEntity.ok(TRResponse.of("ok"));
  }
}
