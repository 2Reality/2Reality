package com.back2reality.storage.repository;

import com.back2reality.storage.entities.Event;
import org.springframework.data.repository.CrudRepository;

/**
 * @author FLIGHT
 */
public interface EventRepository extends CrudRepository<Event, Long> {
}
