package com.prabha.ies.dc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class DcPlanEntity {
	@Id
	private Long caseId;
	private String firstName;
	private String lastName;
	private String plan;

}
