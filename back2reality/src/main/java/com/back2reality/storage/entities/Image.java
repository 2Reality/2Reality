package com.back2reality.storage.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * @author FLIGHT
 */
@Entity
public class Image {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image")
  @SequenceGenerator(name = "image", sequenceName = "s_image", allocationSize = 1)
  private long id;
  private String name;

  @Lob
  @Column(columnDefinition="bytea")
  private byte[] content;

  private LocalDateTime uploadDate;

  @ManyToOne
  @JoinColumn(name = "human_id")
  private Human human;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public byte[] getContent() {
    return content;
  }

  public void setContent(byte[] content) {
    this.content = content;
  }

  public LocalDateTime getUploadDate() {
    return uploadDate;
  }

  public void setUploadDate(LocalDateTime uploadDate) {
    this.uploadDate = uploadDate;
  }

  public Human getHuman() {
    return human;
  }

  public void setHuman(Human human) {
    this.human = human;
  }
}
