package com.prabha.ies.ar.domain;

import java.util.Date;

import lombok.Data;
@Data
public class Citizen {
	private String arNo;
	private String firstName;
	private String lastName;
	private Date dob;
	private String gender;
	private Long ssn;
	private Long phoneNumber;
	private String email;
	private String citizenStatus;
	private Date createdDate;
	private Date updatedDate;

}
