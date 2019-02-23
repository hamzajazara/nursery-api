package com.nurseryapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nurseryapi.entity.AddressEntity;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}