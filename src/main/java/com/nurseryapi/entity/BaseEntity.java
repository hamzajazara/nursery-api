package com.nurseryapi.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Positive;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.context.SecurityContextHolder;

import com.nurseryapi.entity.user.UserEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 4866523849800709094L;

	@Column(name = "created_at", updatable = false)
	@CreatedDate
	private LocalDateTime createdAt;

	@Positive
	@Column(name = "created_by", updatable = false)
	private long createdBy;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@Positive
	@Column(name = "updated_by")
	private long updatedBy;

	/**
	 * Sets createdAt before insert
	 */
	@PrePersist
	public void setCreationDate() {
		UserEntity userEntity = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		this.createdBy = this.updatedBy = userEntity.getId();
		this.createdAt = this.updatedAt = LocalDateTime.now().atOffset(ZoneOffset.UTC).toLocalDateTime();
	}

	/**
	 * Sets updatedAt before update
	 */
	@PreUpdate
	public void setChangeDate() {
		UserEntity userEntity = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		this.updatedBy = userEntity.getId();
		this.updatedAt = LocalDateTime.now().atOffset(ZoneOffset.UTC).toLocalDateTime();
	}
}
