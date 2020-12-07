package com.prabha.ies.dc.domain;

import java.util.Date;

import javax.persistence.Id;

import lombok.Data;
@Data
public class DcCase {
	@Id
	private Long caseId;
	private String firstName;
	private String lastName;
	private Date dob;
	private String gender;
	private Long ssn;
	private Long phoneNumber;
	private String email;
	private Date createdDate;
	private Date updatedDate;
	

}
