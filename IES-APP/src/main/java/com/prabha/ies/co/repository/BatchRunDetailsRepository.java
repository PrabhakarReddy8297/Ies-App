package com.prabha.ies.co.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prabha.ies.co.entity.BatchRunDetailsEntity;

public interface BatchRunDetailsRepository extends JpaRepository<BatchRunDetailsEntity, Serializable> {

}
