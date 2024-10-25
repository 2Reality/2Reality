package com.back2reality.human;

import com.back2reality.recommender.item.ItemFactory;

/**
 * @author FLIGHT
 */
public class HumanItemFactory implements ItemFactory<HumanItem> {
    @Override
    public HumanItem createWithScore(HumanItem humanItem, double score) {
        return new HumanItem(
                humanItem.id(),
                humanItem.fullname(),
                humanItem.nickname(),
                humanItem.description(),
                humanItem.sex(),
                humanItem.age(),
                humanItem.geo(),
                humanItem.distance(),
                score
        );
    }
}
