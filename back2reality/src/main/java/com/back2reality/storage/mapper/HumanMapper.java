package com.back2reality.storage.mapper;

import com.back2reality.human.HumanForm;
import com.back2reality.human.HumanItem;
import com.back2reality.storage.entities.Human;

/**
 * @author FLIGHT
 */
public class HumanMapper {

  public HumanItem toHumanItem(Human human) {
    return new HumanItem(
      human.getId(),
      human.getFullname(),
      human.getNickname(),
      human.getDescription(),
      human.getSex(),
      human.getAge(),
      human.getGeo(),
      HumanItem.DEFAULT_SCORE
    );
  }

  public Human toHuman(HumanForm humanForm) {
    return new Human(
      humanForm.fullname(),
      humanForm.nickname(),
      humanForm.description(),
      humanForm.sex(),
      humanForm.age(),
      humanForm.geo()
    );
  }
}
