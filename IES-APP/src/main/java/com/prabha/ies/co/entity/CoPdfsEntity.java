package com.prabha.ies.co.entity;

import javax.persistence.Id;

import lombok.Data;

@Data
public class CoPdfsEntity {
	@Id
	private Integer coPdfId;
	private String planStatus;
	private Integer caseNumber;
	private Byte [] pdfDocument;
	private String planName;

}
