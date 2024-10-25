package com.back2reality.place;

import com.back2reality.recommender.item.WithDistance;
import com.back2reality.recommender.item.WithScore;

import java.time.LocalDateTime;

/**
 * @author FLIGHT
 */
public record PlaceItem(
  long id,
  String title,
  String description,
  String geo,
  double distance,
  double score)
  implements WithScore, WithDistance {

}
