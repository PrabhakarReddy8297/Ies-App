package com.prabha.ies.co.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data
public class CoTriggerEntity {
	@Id
	private Integer triggerId;
	private Integer caseNumber;
	private Date createdDate;
	private Date updatedDate;
	private String triggerStatus;

}
