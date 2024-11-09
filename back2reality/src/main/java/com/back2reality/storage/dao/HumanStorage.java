package com.back2reality.storage.dao;

import com.back2reality.human.HumanForm;
import com.back2reality.human.HumanItem;
import com.back2reality.recommender.context.RecommenderContext;
import com.back2reality.storage.entities.Human;
import com.back2reality.storage.entities.Image;
import com.back2reality.storage.mapper.HumanMapper;
import com.back2reality.storage.repository.HumanRepository;
import com.back2reality.utils.StreamUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

/**
 * @author FLIGHT
 */
public class HumanStorage implements CandidateStorage<HumanItem>, EntityStorage<HumanForm> {

  private final Logger logger = LoggerFactory.getLogger(HumanStorage.class);

  private final HumanRepository humanRepository;

  private final HumanMapper humanMapper;

  public HumanStorage(HumanRepository humanRepository, HumanMapper humanMapper) {
    this.humanRepository = humanRepository;
    this.humanMapper = humanMapper;
  }

  @Override
  public List<HumanItem> getCandidates(RecommenderContext recommenderContext) {
    return StreamUtils.toStream(humanRepository.findAllWithImages())
      .map(human -> humanMapper.toHumanItem(human, recommenderContext))
      .toList();
  }

  @Override
  public void create(HumanForm humanForm) {
    humanRepository.save(humanMapper.toHuman(humanForm));
    logger.info("event {} saved", humanForm);
  }

  @Override
  public void update(HumanForm humanForm) {
    Optional<Human> humanO = humanRepository.findById(humanForm.id());
    if (humanO.isPresent()) {
      Human human = humanMapper.update(humanO.get(), humanForm);
      humanRepository.save(human);
    }
  }

  @Override
  public void delete(long id) {
    humanRepository.deleteById(id);
    logger.info("event {} deleted", id);
  }

  public HumanItem getHuman(String nickname, RecommenderContext context) {
    return humanRepository.findHumanByNickname(nickname)
      .map(human -> humanMapper.toHumanItem(human, context))
      .orElseThrow(IllegalArgumentException::new);
  }
}
