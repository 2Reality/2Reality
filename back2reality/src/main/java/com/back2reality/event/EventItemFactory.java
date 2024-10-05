package com.back2reality.event;

import com.back2reality.recommender.item.ItemFactory;

/**
 * @author FLIGHT
 */
public class EventItemFactory implements ItemFactory<TREvent> {

  @Override
  public TREvent create(
    long id,
    String title,
    String description) {
    return new TREvent(id, title, description);
  }

  @Override
  public TREvent create(TREvent event, double score) {
    return new TREvent(
      event.id(),
      event.title(),
      event.description(),
      event.start(),
      event.finish(),
      score);
  }
}
