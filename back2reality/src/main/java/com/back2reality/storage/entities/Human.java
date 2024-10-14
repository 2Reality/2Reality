package com.back2reality.storage.entities;

import com.back2reality.human.Sex;
import jakarta.persistence.*;

/**
 * @author FLIGHT
 */


@Entity
public class Human {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "human")
  @SequenceGenerator(name = "human", sequenceName = "s_human", allocationSize = 1)
  private long id;

  private String fullname;

  private String nickname;

  private String description;

  private Sex sex;

  private int age;

  private String geo;

  public Human() {
  }

  public Human(String fullname, String nickname, String description, Sex sex, int age, String geo) {
    this.fullname = fullname;
    this.nickname = nickname;
    this.description = description;
    this.sex = sex;
    this.age = age;
    this.geo = geo;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Sex getSex() {
    return sex;
  }

  public void setSex(Sex sex) {
    this.sex = sex;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getGeo() {
    return geo;
  }

  public void setGeo(String geo) {
    this.geo = geo;
  }
}
