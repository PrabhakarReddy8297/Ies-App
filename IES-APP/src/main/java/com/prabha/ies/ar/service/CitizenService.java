package com.prabha.ies.ar.service;

import java.util.List;

import com.prabha.ies.ar.domain.Citizen;


public interface CitizenService {
	public String saveCitizen(Citizen citizen);
	public Citizen getCitizenByArNo(String arNo);
	public List<Citizen> getAllCitizens();
	public boolean deactivateCitizen(String arNo);
	public boolean activateCitizen(String arNo);
	public boolean checkCitizenState(Long ssn);
	public String verifySSN(Long ssn);

}
