package com.back2reality.place;

import com.back2reality.recommender.item.ItemFactory;

/**
 * @author FLIGHT
 */
public class PlaceItemFactory implements ItemFactory<PlaceItem> {
  @Override
  public PlaceItem createWithScore(PlaceItem placeItem, double score) {
    return new PlaceItem(
      placeItem.id(),
      placeItem.title(),
      placeItem.description(),
      placeItem.geo(),
      score
    );
  }
}
