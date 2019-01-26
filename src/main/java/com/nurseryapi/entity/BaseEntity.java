package com.nurseryapi.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Hamza Aljazara
 *
 */
@MappedSuperclass
@Setter
@Getter
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 4866523849800709094L;

	@Column(name = "created_at", nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@Size(max = 20)
	@Column(name = "created_by", nullable = false, updatable = false)
	private String createdBy;

	@Column(name = "updated_at", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	@Size(max = 20)
	@Column(name = "updated_by", nullable = false)
	private String updatedBy;

	/**
	 * Sets createdAt before insert
	 * 
	 * TODO: add listener before insert record to store createdby field.
	 */
	@PrePersist
	public void setCreationDate() {
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}

	/**
	 * Sets updatedAt before update
	 * 
	 * TODO: add listener before insert record to store updatedby field.
	 */
	@PreUpdate
	public void setChangeDate() {
		this.updatedAt = new Date();
	}
}
