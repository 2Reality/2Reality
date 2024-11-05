package com.back2reality.storage.dao;

import com.back2reality.place.PlaceForm;
import com.back2reality.place.PlaceItem;
import com.back2reality.recommender.context.RecommenderContext;
import com.back2reality.storage.mapper.PlaceMapper;
import com.back2reality.storage.repository.PlaceRepository;
import com.back2reality.utils.StreamUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author FLIGHT
 */
public class PlaceStorage implements CandidateStorage<PlaceItem>, EntityStorage<PlaceForm> {

  private final Logger logger = LoggerFactory.getLogger(PlaceStorage.class);

  private final PlaceRepository placeRepository;

  private final PlaceMapper placeMapper;


  public PlaceStorage(PlaceRepository placeRepository, PlaceMapper placeMapper) {
    this.placeRepository = placeRepository;
    this.placeMapper = placeMapper;
  }


  @Override
  public List<PlaceItem> getCandidates(RecommenderContext recommenderContext) {
    return StreamUtils.toStream(placeRepository.findAll())
      .map(place -> placeMapper.toPlaceItem(place, recommenderContext))
      .toList();
  }

  @Override
  public void create(PlaceForm placeForm) {
    placeRepository.save(placeMapper.toPlace(placeForm));
    logger.info("event {} saved", placeForm);
  }

  @Override
  public void update(PlaceForm placeForm) {

  }

  @Override
  public void delete(long id) {
    placeRepository.deleteById(id);
    logger.info("event {} deleted", id);
  }
}
