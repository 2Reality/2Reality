package com.back2reality.storage.repository;

import com.back2reality.storage.entities.Human;
import org.springframework.data.repository.CrudRepository;

/**
 * @author FLIGHT
 */
public interface HumanRepository extends CrudRepository<Human, Long> {
}
