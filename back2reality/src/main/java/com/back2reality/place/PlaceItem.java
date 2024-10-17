package com.back2reality.place;

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
  double score)
  implements WithScore {

}
