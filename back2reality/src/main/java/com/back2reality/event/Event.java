package com.back2reality.event;

import com.back2reality.recommender.item.WithScore;

/**
 * @author FLIGHT
 */
public record Event(long id, String title, double score) implements WithScore {

  @Override
  public String toString() {
    return "Event{" +
      "id=" + id +
      ", title='" + title + '\'' +
      ", score=" + score +
      '}';
  }
}
