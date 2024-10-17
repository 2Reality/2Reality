package com.back2reality.storage.dao;

import java.util.List;

/**
 * @author FLIGHT
 */
public interface CandidateStorage<TItem> {

  List<TItem> getCandidates();
}
