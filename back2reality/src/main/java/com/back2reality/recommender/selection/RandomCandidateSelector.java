package com.back2reality.recommender.selection;

import com.back2reality.recommender.context.RecommenderContext;
import com.back2reality.recommender.item.ItemFactory;
import com.back2reality.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author FLIGHT
 */
public class RandomCandidateSelector<TItem> implements CandidateSelector<TItem> {

  private final ItemFactory<TItem> itemFactory;

  public RandomCandidateSelector(ItemFactory<TItem> itemFactory) {
    this.itemFactory = itemFactory;
  }

  @Override
  public List<TItem> getCandidates(RecommenderContext recommenderContext) {
    List<TItem> candidates = new ArrayList<>();
    for (int index = 0; index < RandomUtils.generateInteger(1000); ++index) {
      candidates.add(generateRandomCandidate());
    }
    return candidates;
  }

  private TItem generateRandomCandidate() {
    return itemFactory.create(
      RandomUtils.generateInteger(1_000_000),
      RandomUtils.generatePrettyRandomString(16),
      RandomUtils.generatePrettyRandomString(16)
    );
  }
}
