package com.prabha.ies.ed.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prabha.ies.ed.entity.EligibilityDetailsEntity;

public interface EligibilityDetailsRepogitory extends JpaRepository<EligibilityDetailsEntity, Serializable> {

}
