package com.prabha.ies.ed.domain;

import java.util.Date;

import lombok.Data;
@Data
public class EligibilityDetails {
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
