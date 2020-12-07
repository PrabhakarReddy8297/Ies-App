package com.prabha.ies.ar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prabha.ies.ar.domain.Citizen;
import com.prabha.ies.ar.service.CitizenService;
import com.prabha.ies.constants.IesConstants;

@Controller
public class CitizenViewController {
	@Autowired
	private CitizenService citizenService;
	@GetMapping("/editCitizen")
	public String editBtnHandling(@RequestParam("arNo") String arNo,Model model)
	{
		 Citizen citizen = citizenService.getCitizenByArNo(arNo);
		model.addAttribute("citizenObj", citizen);
		return IesConstants.CITIZEN_REGISTRATION_VIEW_NAME;
		
	}
	@GetMapping("/deactivateCitizen")
	public String deactivateBtnHandling(@RequestParam("arNo") String arNo,RedirectAttributes rd) {
		boolean deactivate = citizenService.deactivateCitizen(arNo);
		if(deactivate)
		rd.addFlashAttribute("succMsg", "Citizen DeActivated Successfully");
		else
			rd.addFlashAttribute("failMsg", "Citizen DeActivation Failed");
		return IesConstants.REDIRECT_CITIZENS_PAGE;
	}
	@GetMapping("/activateCitizen")
	public String ActiveBtnHandling(@RequestParam("arNo") String arNo,RedirectAttributes rd) {
		boolean activate = citizenService.activateCitizen(arNo);
		if(activate)
			rd.addFlashAttribute("succMsg", "Citizen Activated Successfully");
		else
			rd.addFlashAttribute("failMsg", "Citizen Activation Failed");
			
		return IesConstants.REDIRECT_CITIZENS_PAGE;
	}

}
