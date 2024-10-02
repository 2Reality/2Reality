package com.back2reality.recommender.ranking;


import com.back2reality.recommender.context.RecommenderContext;
import com.back2reality.recommender.item.WithScore;

import java.util.Comparator;
import java.util.List;

/**
 * @author FLIGHT
 */
public class ScoreCandidateRanker<TItem extends WithScore> implements CandidateRanker<TItem> {

  @Override
  public List<TItem> rank(List<TItem> candidates, RecommenderContext recommenderContext) {
    return candidates.stream()
      .sorted(Comparator.comparing(TItem::score).reversed())
      .toList();
  }
}
