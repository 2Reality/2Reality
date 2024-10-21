package com.back2reality.storage.repository;

import com.back2reality.storage.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author FLIGHT
 */
public interface LocationRepository extends JpaRepository<Location, Long> {
  @Query(value = "SELECT * FROM Location WHERE ST_DWithin(location, ST_SetSRID(ST_MakePoint(?1, ?2), 4326), ?3)", nativeQuery = true)
  List<Location> findWithinDistance(double longitude, double latitude, double distance);
}
