package com.prabha.ies.ed.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class EligibilityDetailsEntity {
	@Id
	private Integer edTraceIdNumber;
	private String benefitAmt;
	private Integer caseNumber;
	private Date createdDate;
	private Date updatedDate;
	private String denialReason;
	private String planName;
	private Date planEndDate;
	private Date planStartDate;
	private String planStatus;

}
