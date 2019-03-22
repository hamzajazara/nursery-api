package com.nurseryapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nurseryapi.entity.TopicEntity;
import com.nurseryapi.exception.NoSuchElementFoundException;
import com.nurseryapi.repository.TopicRepository;
import com.nurseryapi.service.TopicService;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Service
public class TopicServiceImpl implements TopicService {

	@Autowired
	private TopicRepository topicRepository;

	/*
	 * @see com.nurseryapi.service.TopicService#save(com.nurseryapi.repository.
	 * TopicRepository)
	 */
	@Override
	public TopicEntity save(TopicEntity topicEntity) {
		return topicRepository.save(topicEntity);
	}

	/*
	 * @see com.nurseryapi.service.TopicService#getTopic(long)
	 */
	@Override
	public TopicEntity getTopic(long topicId) {
		return topicRepository.findById(topicId).orElseThrow(NoSuchElementFoundException::new);
	}

	/*
	 * @see com.nurseryapi.service.TopicService#getTopic(java.util.List)
	 */
	@Override
	public List<TopicEntity> getTopic(List<Long> topicIds) {
		return topicRepository.findAllById(topicIds);
	}
}