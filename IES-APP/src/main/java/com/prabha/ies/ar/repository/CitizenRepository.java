package com.prabha.ies.ar.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prabha.ies.ar.entity.CitizenEntity;

public interface CitizenRepository extends JpaRepository<CitizenEntity, Serializable>{
public CitizenEntity findByArNo(String arNo);
}
