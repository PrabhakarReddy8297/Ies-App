package com.prabha.ies.dc.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prabha.ies.dc.entity.DcPlanEntity;

public interface DcPlanRepository extends JpaRepository<DcPlanEntity, Serializable> {

}
