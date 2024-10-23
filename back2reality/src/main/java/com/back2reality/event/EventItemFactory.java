package com.back2reality.event;

import com.back2reality.recommender.item.ItemFactory;

import java.time.LocalDateTime;

/**
 * @author FLIGHT
 */
public class EventItemFactory implements ItemFactory<EventItem> {

  @Override
  public EventItem createWithScore(EventItem event, double score) {
    return new EventItem(
      event.id(),
      event.title(),
      event.description(),
      event.start(),
      event.finish(),
      event.geo(),
      event.distance(),
      score);
  }
}
