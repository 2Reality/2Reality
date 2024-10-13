package com.back2reality.recommender.item;

import java.time.LocalDateTime;

/**
 * @author FLIGHT
 */
public interface ItemFactory<TItem> {

  TItem create(
    long id,
    String title,
    String description,
    LocalDateTime start,
    LocalDateTime end,
    String geo
  );

  TItem create(TItem item, double score);
}
