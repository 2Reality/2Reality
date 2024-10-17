package com.back2reality.storage.dao;

/**
 * @author FLIGHT
 */
public interface EntityStorage<EntityForm> {

  void create(EntityForm entityForm);

  void delete(long id);
}
