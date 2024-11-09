package com.back2reality.storage.mapper;

import com.back2reality.human.HumanForm;
import com.back2reality.human.HumanItem;
import com.back2reality.image.ImageCompressor;
import com.back2reality.image.ImageItem;
import com.back2reality.location.LocationFactory;
import com.back2reality.recommender.context.RecommenderContext;
import com.back2reality.storage.entities.Human;
import com.back2reality.storage.entities.Image;
import com.back2reality.utils.MathUtils;
import com.back2reality.utils.RandomUtils;
import org.locationtech.jts.geom.Point;

import java.util.List;

/**
 * @author FLIGHT
 */
public class HumanMapper {

  private final LocationFactory locationFactory;

  private final ImageCompressor imageCompressor;

  public HumanMapper(LocationFactory locationFactory, ImageCompressor imageCompressor) {
    this.locationFactory = locationFactory;
    this.imageCompressor = imageCompressor;
  }

  public HumanItem toHumanItem(Human human, RecommenderContext recommenderContext) {
    double distance = toDistance(human.getLocation(), recommenderContext.location());
    ImageItem image = toImage(human.getImages());

    return new HumanItem(
      human.getId(),
      human.getFullname(),
      human.getNickname(),
      human.getDescription(),
      human.getSex(),
      human.getBirthDate(),
      image,
      human.getGeo(),
      human.getLocation().getX(),
      human.getLocation().getY(),
      distance,
      HumanItem.DEFAULT_SCORE
    );
  }

  public Human update(Human human, HumanForm humanForm) {
    Point location = locationFactory.toPoint(
      humanForm.longitude(),
      humanForm.latitude()
    );

    human.setFullname(humanForm.fullname());
    human.setNickname(humanForm.nickname());
    human.setGeo(humanForm.geo());
    human.setDescription(humanForm.description());
    human.setSex(humanForm.sex());
    human.setLocation(location);
    human.setBirthDate(humanForm.birthDate());

    return human;
  }

  public Human toHuman(HumanForm humanForm) {
    Point location = locationFactory.toPoint(
      humanForm.longitude(),
      humanForm.latitude()
    );
    return new Human(
      humanForm.fullname(),
      humanForm.nickname(),
      humanForm.description(),
      humanForm.sex(),
      humanForm.birthDate(),
      humanForm.geo(),
      location
    );
  }

  private ImageItem toImage(List<Image> images) {
    if (images == null || images.isEmpty())
      return ImageItem.empty;

    int imageIndex = RandomUtils.generateInteger(images.size());
    Image image = images.get(imageIndex);
    return new ImageItem(
      image.getId(),
      imageCompressor.decompressBytes(image.getContent())
    );
  }

  private double toDistance(Point itemLocation, Point contextLocation) {
    return MathUtils.round(
      itemLocation.distance(contextLocation) * 100, 2
    );
  }
}
