package com.back2reality.recommender.item;

/**
 * @author FLIGHT
 */
public interface ItemFactory<TItem> {

  TItem createWithScore(TItem item, double score);
}
