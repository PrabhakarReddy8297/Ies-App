package com.prabha.ies.co.domain;

import lombok.Data;

@Data
public class CoPdfs {
	private Integer coPdfId;
	private String planStatus;
	private Integer caseNumber;
	private Byte [] pdfDocument;
	private String planName;
}
