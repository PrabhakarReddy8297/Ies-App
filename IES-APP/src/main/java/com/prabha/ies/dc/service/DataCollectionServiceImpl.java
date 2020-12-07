package com.prabha.ies.dc.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prabha.ies.dc.domain.DcCase;
import com.prabha.ies.dc.entity.DcCaseEntity;
import com.prabha.ies.dc.repository.DcCaseRepository;
@Service
public class DataCollectionServiceImpl implements DataCollectionService {
	
	@Autowired
	private DcCaseRepository dcCaseRepo;
	
	
	@Override
	public DcCase saveDcCase(DcCase dcCase) {
		DcCaseEntity entity = new DcCaseEntity();
	    BeanUtils.copyProperties(dcCase, entity);
	    DcCaseEntity save = dcCaseRepo.save(entity);
	    BeanUtils.copyProperties(save, dcCase);	 
		return dcCase;
	}

	

}
