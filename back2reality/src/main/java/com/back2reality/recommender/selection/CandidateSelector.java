package com.back2reality.recommender.selection;

import com.back2reality.recommender.context.RecommenderContext;

import java.util.List;

/**
 * @author FLIGHT
 */
public interface CandidateSelector<TItem> {

  List<TItem> getCandidates(RecommenderContext recommenderContext);
}
