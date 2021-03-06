package com.prabha.ies.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prabha.ies.admin.domain.Plan;
import com.prabha.ies.admin.service.PlanService;
import com.prabha.ies.constants.IesConstants;
@Controller
public class PlansViewController {
	@Autowired
	private PlanService planService;
	@GetMapping("/editPlan")
	public String editBtnHandling(@RequestParam("planId") Integer planId,Model model)
	{
		Plan plan = planService.getPlanById(planId);
		model.addAttribute("planObj", plan);
		return IesConstants.PLAN_REGISTRATION_VIEW_NAME;
		
	}
	@GetMapping("/deactivatePlan")
	public String inActiveBtnHandling(@RequestParam("planId") Integer planId,RedirectAttributes rd) {
		boolean inActive = planService.inActivePlan(planId);
		if(inActive)
		rd.addFlashAttribute("succMsg", "Plan DeActivated Successfully");
		else
			rd.addFlashAttribute("failMsg", "Plan DeActivation Failed");
		return IesConstants.REDIRECT_PLANS_PAGE;
	}
	@GetMapping("/activePlan")
	public String ActiveBtnHandling(@RequestParam("planId") Integer planId,RedirectAttributes rd) {
		boolean inActive = planService.ActivePlan(planId);
		if(inActive)
			rd.addFlashAttribute("succMsg", "Plan Activated Successfully");
		else
			rd.addFlashAttribute("failMsg", "Plan Activation Failed");
			
		return IesConstants.REDIRECT_PLANS_PAGE;
	}
}
