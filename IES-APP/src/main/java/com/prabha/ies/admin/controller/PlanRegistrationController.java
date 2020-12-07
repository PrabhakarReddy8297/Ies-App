package com.prabha.ies.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prabha.ies.admin.domain.Plan;
import com.prabha.ies.admin.service.PlanService;
import com.prabha.ies.constants.IesConstants;

@Controller
public class PlanRegistrationController {
	@Autowired
	private PlanService planService; 
	@PostMapping("/savePlan")
	public String handleCreatePlanLink(@ModelAttribute("planObj")Plan plan,RedirectAttributes rd) {
		boolean savePlan = planService.savePlan(plan);
		if(savePlan) {
			if(plan.getPlanId()==null)
			rd.addFlashAttribute("succMsg", "Plan Registration Successfull");
			else
				rd.addFlashAttribute("succMsg", "Plan Updated Successfully");
		}
		else {
			if(plan.getPlanId()==null)
			rd.addFlashAttribute("failMsg", "Plan Registration Failed");
			else
				rd.addFlashAttribute("succMsg", "Plan Updation Failed");
		}
		return IesConstants.REDIRECT_PLAN_REGISTRATION_PAGE;
		
	}

}
