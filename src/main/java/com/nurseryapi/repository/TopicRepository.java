package com.nurseryapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nurseryapi.entity.TopicEntity;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Repository
public interface TopicRepository extends JpaRepository<TopicEntity, Long> {
}