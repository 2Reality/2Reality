package com.back2reality.event;

import com.back2reality.recommender.item.ItemFactory;

/**
 * @author FLIGHT
 */
public class EventItemFactory implements ItemFactory<Event> {

  @Override
  public Event create(long id, String title) {
    return new Event(id, title, 0.0);
  }

  @Override
  public Event create(long id, String title, double score) {
    return new Event(id, title, score);
  }

  @Override
  public Event create(Event event, double score) {
    return new Event(event.id(), event.title(), score);
  }


}
