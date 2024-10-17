package com.back2reality.recommender.selection;

import com.back2reality.recommender.context.RecommenderContext;
import com.back2reality.storage.dao.CandidateStorage;

import java.util.List;

/**
 * @author FLIGHT
 */
public class StorageCandidateSelector<TItem> implements CandidateSelector<TItem> {

  private final CandidateStorage<TItem> storage;

  public StorageCandidateSelector(CandidateStorage<TItem> storage) {
    this.storage = storage;
  }

  @Override
  public List<TItem> getCandidates(RecommenderContext recommenderContext) {
    return storage.getCandidates();
  }
}
