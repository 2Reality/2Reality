package com.back2reality.location;

import com.back2reality.storage.dao.LocationStorage;
import com.back2reality.storage.repository.LocationRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author FLIGHT
 */

@Configuration
public class LocationContextConfiguration {

  @Bean
  public LocationMapper locationMapper() {
    return new LocationMapper();
  }
  @Bean
  public LocationStorage locationStorage(
          LocationRepository locationRepository,
          LocationMapper locationMapper) {
    return new LocationStorage(locationRepository, locationMapper);
  }
}
