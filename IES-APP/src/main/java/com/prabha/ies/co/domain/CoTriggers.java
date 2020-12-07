package com.prabha.ies.co.domain;

import java.util.Date;

import lombok.Data;
@Data
public class CoTriggers {
	private Integer triggerId;
	private Integer caseNumber;
	private Date createdDate;
	private Date updatedDate;
	private String triggerStatus;

}
