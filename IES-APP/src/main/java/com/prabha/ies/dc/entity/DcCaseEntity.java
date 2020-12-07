package com.prabha.ies.dc.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
@Data
@Entity
public class DcCaseEntity {
	@Id
	@GeneratedValue
	private Long caseId;
	private String firstName;
	private String lastName;
	private Date dob;
	private String gender;
	private Long ssn;
	private Long phoneNumber;
	private String email;
	@CreationTimestamp
	private Date createdDate;
	@UpdateTimestamp
	private Date updatedDate;
	

}
