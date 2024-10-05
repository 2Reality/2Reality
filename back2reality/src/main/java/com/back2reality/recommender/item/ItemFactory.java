package com.back2reality.recommender.item;

/**
 * @author FLIGHT
 */
public interface ItemFactory<TItem> {

  TItem create(long id, String title, String description);

  TItem create(TItem item, double score);
}
