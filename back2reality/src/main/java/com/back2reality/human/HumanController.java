package com.back2reality.human;

import com.back2reality.network.TRResponse;
import com.back2reality.recommender.context.ContextExtractionFactory;
import com.back2reality.recommender.context.RecommenderContext;
import com.back2reality.storage.dao.HumanStorage;
import com.back2reality.storage.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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

  private final ContextExtractionFactory contextExtractionFactory;

  public HumanController(
          HumanRecommender humanRecommender,
          HumanStorage humanStorage,
          ContextExtractionFactory contextExtractionFactory)
  {
    this.humanRecommender = humanRecommender;
    this.humanStorage = humanStorage;
    this.contextExtractionFactory = contextExtractionFactory;
  }

  @GetMapping("/recommend")
  public List<HumanItem> getHumans(@AuthenticationPrincipal User user) {
    RecommenderContext recommenderContext = contextExtractionFactory.extract(user);
    return humanRecommender.recommend(recommenderContext);
  }

  @GetMapping("/{nickname}")
  public HumanItem getHuman(@PathVariable String nickname, @AuthenticationPrincipal User user) {
    RecommenderContext recommenderContext = contextExtractionFactory.extract(user);
    return humanStorage.getHuman(nickname, recommenderContext);
  }

  @PostMapping("/create")
  public HumanForm create(@RequestBody HumanForm humanForm) {
    humanStorage.create(humanForm);
    return humanForm;
  }

  @PostMapping("/update")
  public HumanForm update(@RequestBody HumanForm humanForm) {
    humanStorage.update(humanForm);
    return humanForm;
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<TRResponse> delete(@PathVariable long id) {
    humanStorage.delete(id);
    return ResponseEntity.ok(TRResponse.of("ok"));
  }
}
