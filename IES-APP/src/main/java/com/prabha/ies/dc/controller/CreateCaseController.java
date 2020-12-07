package com.prabha.ies.dc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prabha.ies.admin.domain.Plan;
import com.prabha.ies.admin.service.PlanService;
import com.prabha.ies.ar.domain.Citizen;
import com.prabha.ies.ar.service.CitizenService;
import com.prabha.ies.dc.domain.DcCase;
import com.prabha.ies.dc.domain.DcPlan;
import com.prabha.ies.dc.service.DataCollectionService;

@Controller
public class CreateCaseController {
	@Autowired
	private DataCollectionService dcService;
	@Autowired
	private CitizenService citizenService;
	@Autowired
	PlanService planService;

	@GetMapping("/createCase")
	public String handleSearchBtn(@RequestParam("arNo") String arNo, RedirectAttributes rd, Model m) {
		// boolean arNoisValid = dcService.isArNoisValid(arNo);
		Citizen citizenByArNo = citizenService.getCitizenByArNo(arNo);
		if (citizenByArNo != null) {
			m.addAttribute("citizen", citizenByArNo);

			return "createCase";
		} else {
			rd.addFlashAttribute("errorMsg", "Application Number is Not Valid");
			return "redirect:/search";
		}

	}
	
	
	
	@PostMapping("/createCase")
	public String handleCreateCaseBtn(@ModelAttribute("citizen") DcCase dcCase,Model m) {
		 DcCase saveDcCase = dcService.saveDcCase(dcCase);
		 if(saveDcCase!=null) {
			 DcPlan dcplan = new DcPlan();
			 dcplan.setCaseId(saveDcCase.getCaseId());
			 dcplan.setFirstName(saveDcCase.getFirstName());
			 dcplan.setLastName(saveDcCase.getLastName());
			 m.addAttribute("dcplanObj", dcplan);
			 List<String> plans = new ArrayList<String>();
			 List<Plan> allPlans = planService.getAllPlans();
			 allPlans.forEach(plan->{
				 if(plan.getPlanStatus().equals("ACTIVE")) {
				 plans.add (plan.getPlanName());
				 }
			 });
			 m.addAttribute("plans", plans);
			 
			 return"selectPlan";
		 }else {
			 m.addAttribute("errorMsg", "Case creation Failed");
			 return"createCase";
		 }
		  
	}
}
