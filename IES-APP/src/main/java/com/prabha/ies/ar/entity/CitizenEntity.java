package com.prabha.ies.ar.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
@Data
@Entity
@Table(name = "CITIZEN_DTLS")
public class CitizenEntity {
	@Id
	@GeneratedValue(generator ="arNo_gen")
	@GenericGenerator(name = "arNo_gen",strategy = "com.prabha.ies.ar.generators.ARGenerator")
	@Column(name = "AR_NO")
	private String arNo;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Temporal(TemporalType.DATE)
	@Column(name = "DOB")
	private Date dob;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "SSN")
	private Long ssn;
	@Column(name = "PHONE_NUMBER")
	private Long phoneNumber;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "CITIZEN_STATUS")
	private String citizenStatus;
	@Column(name = "CREATED_DATE")
	@CreationTimestamp
	private Date createdDate;
	@UpdateTimestamp
	@Column(name = "UPDATED_DATE")
	private Date updatedDate;

}
