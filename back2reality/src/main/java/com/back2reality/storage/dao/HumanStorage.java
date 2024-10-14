package com.back2reality.storage.dao;

import com.back2reality.human.HumanForm;
import com.back2reality.human.HumanItem;
import com.back2reality.storage.mapper.HumanMapper;
import com.back2reality.storage.repository.HumanRepository;
import com.back2reality.utils.StreamUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author FLIGHT
 */
public class HumanStorage implements CandidateStorage<HumanItem> {

  private final Logger logger = LoggerFactory.getLogger(HumanStorage.class);

  private final HumanRepository humanRepository;

  private final HumanMapper humanMapper;

  public HumanStorage(HumanRepository humanRepository, HumanMapper humanMapper) {
    this.humanRepository = humanRepository;
    this.humanMapper = humanMapper;
  }

  @Override
  public List<HumanItem> getAllCandidates() {
    return StreamUtils.toStream(humanRepository.findAll())
      .map(humanMapper::toHumanItem)
      .toList();
  }

  public void create(HumanForm humanForm) {
    humanRepository.save(humanMapper.toHuman(humanForm));
    logger.info("event {} saved", humanForm);
  }

  public void delete(long id) {
    humanRepository.deleteById(id);
    logger.info("event {} deleted", id);
  }
}
