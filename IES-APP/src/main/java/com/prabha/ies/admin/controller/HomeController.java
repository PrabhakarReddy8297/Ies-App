package com.prabha.ies.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.prabha.ies.admin.domain.Account;
import com.prabha.ies.admin.domain.Plan;
import com.prabha.ies.admin.service.AccountService;
import com.prabha.ies.admin.service.PlanService;
import com.prabha.ies.ar.domain.Citizen;
import com.prabha.ies.ar.service.CitizenService;
import com.prabha.ies.constants.IesConstants;


@Controller
public class HomeController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private PlanService planService;
	@Autowired
	private CitizenService citizenService;
	@GetMapping({"/","/home"})
	public String loadHomePage() {
		return IesConstants.HOME_VIEW_NAME;		
	}
	@GetMapping("/accountReg")
	public String handleCreatingAccLink(Model model) {
		Account account = new Account();
		model.addAttribute("accountObj", account);
		return IesConstants.ACCOUNT_REGISTRATION_VIEW_NAME;
	}
	@GetMapping("/accounts")
	public String handleViewAccountsLInk(@RequestParam("role") String role,Model m){
		List<Account> allAccountsByRole = accountService.getAllAccountsByRole(role);
		 m.addAttribute("accounts", allAccountsByRole);
		
		return IesConstants.ACCOUNTS_VIEW_NAME;
		
	}
	@GetMapping("/planReg")
	public String handleCreatingplanLink(Model model) {
		Plan plan = new Plan();
		model.addAttribute("planObj", plan);
		return IesConstants.PLAN_REGISTRATION_VIEW_NAME;
	}
	@GetMapping("/plans")
	public String handleViewPlansLink(Model m){
		List<Plan> allPlans = planService.getAllPlans();
		 m.addAttribute("plans", allPlans);
		
		return IesConstants.PLANS_VIEW_NAME;
		
	}
	@GetMapping("/citizenReg")
	public String handleCitizenAccLink(Model model) {
		Citizen citizen = new Citizen();
		model.addAttribute("citizenObj", citizen);
		return IesConstants.CITIZEN_REGISTRATION_VIEW_NAME;
	}
	@GetMapping("/citizens")
	public String handleViewCitizensLink(Model m){
		 List<Citizen> allCitizens = citizenService.getAllCitizens();
		 m.addAttribute("citizens", allCitizens);
		
		return IesConstants.CITIZENS_VIEW_NAME;
		
	}
	@GetMapping("/search")
	public String handlecreatingCaseLink() {
		return"arNoSearch";
	}

}
