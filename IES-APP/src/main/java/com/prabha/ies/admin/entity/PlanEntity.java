package com.prabha.ies.admin.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
@Data
@Entity
@Table(name = "PLAN_DTLS")
public class PlanEntity {
	@Id
	@GeneratedValue( generator ="planSEQ" ,strategy = GenerationType.SEQUENCE )
	@SequenceGenerator(sequenceName = "PLAN_SEQUENCE", name = "planSEQ", allocationSize = 1,initialValue = 6)
	@Column(name = "PLAN_ID")
	private Integer planId;
	@Column(name = "PLAN_NAME")
	private String planName;
	@Column(name = "PLAN_DESCRIPTION")
	private String planDescription;
	@Column(name = "PLAN_START_DATE")
	private Date planStartDate;
	@Column(name = "PLAN_END_DATE")
	private Date planEndDate;
	@Column(name = "PLAN_STATUS")
	private String planStatus;
	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	@Column(name = "CREATED_DATE")
	private Date createdDate;
	@Temporal(TemporalType.DATE)
	@UpdateTimestamp
	@Column(name = "UPDATED_DATE")
	private Date updateddDate;

}
