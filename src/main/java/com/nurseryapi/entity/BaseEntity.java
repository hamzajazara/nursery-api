package com.nurseryapi.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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

	@Size(max = 20)
	@Column(name = "created_by", updatable = false)
	private String createdBy;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@Size(max = 20)
	@Column(name = "updated_by")
	private String updatedBy;

	/**
	 * Sets createdAt before insert
	 * 
	 * TODO: add listener before insert record to store createdby field.
	 */
	@PrePersist
	public void setCreationDate() {
		this.createdAt = this.updatedAt = LocalDateTime.now().atOffset(ZoneOffset.UTC).toLocalDateTime();
	}

	/**
	 * Sets updatedAt before update
	 * 
	 * TODO: add listener before insert record to store updatedby field.
	 */
	@PreUpdate
	public void setChangeDate() {
		this.updatedAt = LocalDateTime.now().atOffset(ZoneOffset.UTC).toLocalDateTime();
	}
}
