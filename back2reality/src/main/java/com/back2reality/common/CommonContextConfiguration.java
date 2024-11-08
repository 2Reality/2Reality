package com.back2reality.common;

import com.back2reality.recommender.context.ContextExtractionFactory;
import com.back2reality.recommender.context.SimpleRecommenderContext;
import com.back2reality.storage.entities.Human;
import org.locationtech.jts.geom.Point;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author FLIGHT
 */

@Configuration
public class CommonContextConfiguration {

  @Bean
  public ContextExtractionFactory contextExtractionFactory() {
    return user -> {
      Human human = user.getHuman();
      Point location = human.getLocation();
      return new SimpleRecommenderContext(location, 32);
    };
  }
}
