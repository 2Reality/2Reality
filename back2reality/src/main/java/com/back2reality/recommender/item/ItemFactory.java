package com.back2reality.recommender.item;

/**
 * @author FLIGHT
 */
public interface ItemFactory<TItem> {

  TItem create(long id, String title);

  TItem create(long id, String title, double score);

  TItem create(TItem item, double score);
}
