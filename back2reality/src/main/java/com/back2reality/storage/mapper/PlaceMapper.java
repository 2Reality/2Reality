package com.back2reality.storage.mapper;

import com.back2reality.place.PlaceForm;
import com.back2reality.place.PlaceItem;
import com.back2reality.storage.entities.Place;

/**
 * @author FLIGHT
 */
public class PlaceMapper {

  public PlaceItem toPlaceItem(Place place) {
    return new PlaceItem(
      place.getId(),
      place.getTitle(),
      place.getDescription(),
      place.getGeo(),
      PlaceItem.DEFAULT_SCORE
    );
  }


  public Place toPlace(PlaceForm placeForm) {
    return new Place(
      placeForm.title(),
      placeForm.description(),
      placeForm.geo()
    );
  }
}
