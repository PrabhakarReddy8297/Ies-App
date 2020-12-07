package com.prabha.ies.dc.domain;

import lombok.Data;

@Data
public class DcIncome {
	
	private Long caseId;
	private String name;
	private Boolean isWorkingEmployee;
	private String income;

}
