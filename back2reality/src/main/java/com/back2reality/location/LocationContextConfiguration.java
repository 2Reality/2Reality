package com.back2reality.location;

import com.back2reality.storage.dao.LocationStorage;
import com.back2reality.storage.repository.LocationRepository;
import org.locationtech.jts.geom.GeometryFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author FLIGHT
 */

@Configuration
public class LocationContextConfiguration {

  @Bean
  public GeometryFactory geometryFactory() {
    return new GeometryFactory();
  }
  @Bean
  public LocationFactory locationMapper(GeometryFactory geometryFactory) {
    return new LocationFactory(geometryFactory);
  }
  @Bean
  public LocationStorage locationStorage(
          LocationRepository locationRepository,
          LocationFactory locationFactory) {
    return new LocationStorage(locationRepository, locationFactory);
  }
}
