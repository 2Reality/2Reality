package com.back2reality.storage.dao;

import com.back2reality.event.EventForm;
import com.back2reality.event.TREvent;
import com.back2reality.storage.mapper.EventMapper;
import com.back2reality.storage.repository.EventRepository;
import com.back2reality.utils.StreamUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author FLIGHT
 */
public class EventStorage implements CandidateStorage<TREvent> {

  private final Logger logger = LoggerFactory.getLogger(EventStorage.class);

  private final EventRepository eventRepository;

  private final EventMapper eventMapper;

  public EventStorage(EventRepository eventRepository, EventMapper eventMapper) {
    this.eventRepository = eventRepository;
    this.eventMapper = eventMapper;
  }

  @Override
  public List<TREvent> getAllCandidates() {
    return StreamUtils.toStream(eventRepository.findAll())
      .map(eventMapper::toEvent)
      .toList();
  }

  public void create(EventForm eventForm) {
    eventRepository.save(eventMapper.toEvent(eventForm));
    logger.info("event {} saved", eventForm);
  }

  public void delete(long id) {
    eventRepository.deleteById(id);
    logger.info("event {} deleted", id);
  }
}
