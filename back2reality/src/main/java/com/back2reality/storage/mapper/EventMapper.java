package com.back2reality.storage.mapper;

import com.back2reality.event.EventForm;
import com.back2reality.event.EventItem;
import com.back2reality.storage.entities.Event;

/**
 * @author FLIGHT
 */
public class EventMapper {

  public EventItem toEventItem(Event event) {
    return new EventItem(
      event.getId(),
      event.getTitle(),
      event.getDescription(),
      event.getStart(),
      event.getFinish(),
      event.getGeo(),
      EventItem.DEFAULT_SCORE
    );
  }

  public Event toEvent(EventForm eventForm) {
    return new Event(
      eventForm.title(),
      eventForm.description(),
      eventForm.start(),
      eventForm.finish(),
      eventForm.geo()
    );
  }
}
