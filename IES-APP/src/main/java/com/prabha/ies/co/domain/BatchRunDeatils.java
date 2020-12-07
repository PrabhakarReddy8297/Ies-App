package com.prabha.ies.co.domain;

import java.util.Date;

import lombok.Data;
@Data
public class BatchRunDeatils {
	private Integer batchRunSeq;
	private String batchName;
	private String batchRunStatus;
	private Date startDate;
	private Date endtDate;

}
