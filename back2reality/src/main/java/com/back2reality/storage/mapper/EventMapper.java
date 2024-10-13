package com.back2reality.storage.mapper;

import com.back2reality.event.EventForm;
import com.back2reality.event.TREvent;
import com.back2reality.storage.entities.Event;

/**
 * @author FLIGHT
 */
public class EventMapper {

  public TREvent toEvent(Event event) {
    return new TREvent(
      event.getId(),
      event.getTitle(),
      event.getDescription(),
      event.getStart(),
      event.getFinish(),
      event.getGeo(),
      TREvent.DEFAULT_SCORE
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
