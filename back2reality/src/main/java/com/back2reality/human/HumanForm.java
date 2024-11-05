package com.back2reality.human;

import java.time.LocalDate;

/**
 * @author FLIGHT
 */
public record HumanForm(
  long id,
  String fullname,
  String nickname,
  String description,
  Sex sex,
  LocalDate birthDate,
  String geo,
  double longitude,
  double latitude
) {
}
