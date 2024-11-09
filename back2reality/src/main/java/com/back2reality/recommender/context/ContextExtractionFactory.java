package com.back2reality.recommender.context;

import com.back2reality.storage.entities.User;

/**
 * @author FLIGHT
 */
public interface ContextExtractionFactory {

    RecommenderContext extract(User user);
}
