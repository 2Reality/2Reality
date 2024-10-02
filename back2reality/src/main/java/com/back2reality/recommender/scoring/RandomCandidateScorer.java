package com.back2reality.recommender.scoring;

import com.back2reality.recommender.context.RecommenderContext;
import com.back2reality.recommender.item.ItemFactory;
import com.back2reality.utils.RandomUtils;

import java.util.List;

/**
 * @author FLIGHT
 */
public class RandomCandidateScorer<TItem> implements CandidateScorer<TItem> {

  private final ItemFactory<TItem> itemFactory;

  public RandomCandidateScorer(ItemFactory<TItem> itemFactory) {
    this.itemFactory = itemFactory;
  }

  @Override
  public List<TItem> score(List<TItem> candidates, RecommenderContext recommenderContext) {
    return candidates.stream()
      .map(candidate -> itemFactory.create(candidate, RandomUtils.generatePrettyDouble(1.00)))
      .toList();
  }
}
