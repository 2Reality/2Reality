package com.back2reality.storage.dao;

import com.back2reality.recommender.context.RecommenderContext;

import java.util.List;

/**
 * @author FLIGHT
 */
public interface CandidateStorage<TItem> {

  List<TItem> getCandidates(RecommenderContext recommenderContext);
}
