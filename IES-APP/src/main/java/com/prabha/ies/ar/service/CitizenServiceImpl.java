package com.prabha.ies.ar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prabha.ies.ar.binding.CitizenResponse;
import com.prabha.ies.ar.domain.Citizen;
import com.prabha.ies.ar.entity.CitizenEntity;
import com.prabha.ies.ar.repository.CitizenRepository;
@Service
public class CitizenServiceImpl implements CitizenService {
	@Autowired
    private CitizenRepository citizenRepo;
	@Override
	public String saveCitizen(Citizen citizen) {
		String status = null;
		CitizenEntity citizenEntity=null;
		boolean isCitizenState = checkCitizenState(citizen.getSsn());
		
		
		if(isCitizenState) {
		 citizenEntity = new CitizenEntity();
		BeanUtils.copyProperties(citizen, citizenEntity);
		citizenEntity.setCitizenStatus("ACTIVE");
		citizenEntity = citizenRepo.save(citizenEntity);
		 status = citizenEntity.getArNo();
		}
	
		return status;
	}

	@Override
	public Citizen getCitizenByArNo(String arNo) {
		Citizen citizen = null;
		CitizenEntity citizenEntity = citizenRepo.findByArNo(arNo);
		if(citizenEntity!=null) {
		 citizen = new Citizen();
		BeanUtils.copyProperties(citizenEntity, citizen);
		}
		return citizen;
	}

	@Override
	public List<Citizen> getAllCitizens() {
		List<Citizen> citizens = new ArrayList<>();
		List<CitizenEntity> citizenEntities = citizenRepo.findAll();
		citizenEntities.forEach(entity-> {
			Citizen c = new Citizen();
			BeanUtils.copyProperties(entity, c);
			 citizens.add(c);
		});
		return citizens;
	}

	@Override
	public boolean deactivateCitizen(String arNo) {
		Citizen citizen = getCitizenByArNo(arNo);
		citizen.setCitizenStatus("INACTIVE");
		CitizenEntity entity = new CitizenEntity();
		BeanUtils.copyProperties(citizen, entity);
		return citizenRepo.save(entity)!=null ? true : false;
		
		 
	}

	@Override
	public boolean activateCitizen(String arNo) {
		Citizen citizen = getCitizenByArNo(arNo);
		citizen.setCitizenStatus("ACTIVE");
		CitizenEntity entity = new CitizenEntity();
		BeanUtils.copyProperties(citizen, entity);
		
		return citizenRepo.save(entity)!=null ? true : false;
	}
	@Override
	public boolean checkCitizenState(Long ssn) {
		boolean flag=false;
		String endPointUrl="http://localhost:7070/verify?ssn="+ssn;
		RestTemplate rt = new RestTemplate();
		  ResponseEntity<CitizenResponse> responseEntity = rt.getForEntity(endPointUrl, CitizenResponse.class);

			int statusCodeValue = responseEntity.getStatusCodeValue();
		
			if(statusCodeValue==200)
			{
				
				CitizenResponse citizenResponse = responseEntity.getBody();
				
				if(citizenResponse.getStateName().equals("KENTUCKEY")) {
					flag=true;
				   System.out.println(citizenResponse);
				}
			}
			
			
		return flag;
		
	}

	@Override
	public String verifySSN(Long ssn) {
		String status ="";
		String endPointUrl="http://localhost:7070/verify?ssn="+ssn;
		RestTemplate rt = new RestTemplate();
		try {
		  ResponseEntity<CitizenResponse> responseEntity = rt.getForEntity(endPointUrl, CitizenResponse.class);
		  int statusCodeValue = responseEntity.getStatusCodeValue();
		 System.out.println(statusCodeValue);
		  
		  if(statusCodeValue==200){
			  status = "VALID";
		  }
		}catch (Exception e) {
			status="INVALID";
		}	  
		return status;
	}

}
