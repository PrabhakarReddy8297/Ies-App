package com.prabha.ies.admin.service;

import java.util.List;

import com.prabha.ies.admin.domain.Plan;

public interface PlanService {
	public boolean savePlan(Plan plan);
	public Plan getPlanById(Integer id);
	public List<Plan> getAllPlans();
	public boolean inActivePlan(Integer id);
	public boolean ActivePlan(Integer planId);

}
