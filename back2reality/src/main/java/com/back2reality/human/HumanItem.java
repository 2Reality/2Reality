package com.back2reality.human;

import com.back2reality.recommender.item.WithScore;

/**
 * @author FLIGHT
 */
public record HumanItem(
  long id,
  String fullname,
  String nickname,
  String description,
  Sex sex,
  int age,
  String geo,
  double score) implements WithScore {


}
