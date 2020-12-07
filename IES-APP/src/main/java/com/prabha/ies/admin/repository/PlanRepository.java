package com.prabha.ies.admin.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prabha.ies.admin.entity.PlanEntity;

public interface PlanRepository extends JpaRepository<PlanEntity, Serializable>{

}
