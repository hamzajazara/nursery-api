package com.nurseryapi.service;

import java.util.List;

import com.nurseryapi.entity.TopicEntity;

/**
 * 
 * @author Hamza Aljazara
 *
 */
public interface TopicService {

	/**
	 * 
	 * @param TopicEntity
	 * @return
	 */
	TopicEntity save(TopicEntity TopicEntity);

	/**
	 * 
	 * @param topicId
	 * @return
	 */
	TopicEntity getTopic(long topicId);

	/**
	 * 
	 * @param topicIds
	 * @return
	 */
	List<TopicEntity> getTopic(List<Long> topicIds);
}