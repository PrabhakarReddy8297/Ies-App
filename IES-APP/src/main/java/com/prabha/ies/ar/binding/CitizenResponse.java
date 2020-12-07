package com.prabha.ies.ar.binding;

import java.util.Date;

import lombok.Data;

@Data
public class CitizenResponse {
	private Long ssnId;
	private String firstName;
	private String lastName;
	private String gender;
	private Date dob;
	private String stateName;

}
