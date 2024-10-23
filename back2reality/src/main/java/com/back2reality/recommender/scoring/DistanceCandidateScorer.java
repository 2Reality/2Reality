package com.back2reality.recommender.scoring;

import com.back2reality.recommender.context.RecommenderContext;
import com.back2reality.recommender.item.ItemFactory;
import com.back2reality.recommender.item.WithDistance;
import com.back2reality.utils.MathUtils;

import java.util.List;

/**
 * @author FLIGHT
 */
public class DistanceCandidateScorer<TItem extends WithDistance> implements CandidateScorer<TItem> {

    private final ItemFactory<TItem> itemFactory;

    public DistanceCandidateScorer(ItemFactory<TItem> itemFactory) {
        this.itemFactory = itemFactory;
    }

    @Override
    public List<TItem> score(List<TItem> candidates, RecommenderContext recommenderContext) {
        return candidates.stream()
                .map(candidate -> itemFactory.createWithScore(
                        candidate,
                        MathUtils.round(candidate.distance(), 2))
                )
                .toList();
    }
}
