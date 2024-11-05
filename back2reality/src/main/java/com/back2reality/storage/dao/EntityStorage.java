package com.back2reality.storage.dao;

/**
 * @author FLIGHT
 */
public interface EntityStorage<EntityForm> {

  void create(EntityForm entityForm);

  void update(EntityForm entityForm);

  void delete(long id);
}
