package com.prabha.ies.dc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class DcIncomeEntity {
	@Id
	private Long caseId;
	private String name;
	private Boolean isWorkingEmployee;
	private String income;

}
