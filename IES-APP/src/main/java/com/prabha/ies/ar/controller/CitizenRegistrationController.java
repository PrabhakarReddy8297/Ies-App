package com.prabha.ies.ar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prabha.ies.ar.domain.Citizen;
import com.prabha.ies.ar.service.CitizenService;
import com.prabha.ies.constants.IesConstants;

@Controller
public class CitizenRegistrationController {
	@Autowired
	private CitizenService citizenSrvice;

	@PostMapping("/saveCitizen")
	public String handleCreatePlanLink(@ModelAttribute("citizenObj") Citizen citizen, RedirectAttributes rd) {
		String saveCitizen = citizenSrvice.saveCitizen(citizen);
		System.out.println(citizen.getArNo());
		if (saveCitizen != null) {
			if (citizen.getArNo() == "") {
				rd.addFlashAttribute("succMsg",
						"Citizen Registration Successfull with application no is : " + saveCitizen);
			} else {
				rd.addFlashAttribute("succMsg", "Citizen Updated Successfully");
			}

		} else {
			if (citizen.getArNo() == "") {
				rd.addFlashAttribute("failMsg", " Registration Failed Citizen is Not Belongs to a Kentuckey State");
			} else {
				rd.addFlashAttribute("failMsg", "Citizen Updation Failed");
			}
		}
		return IesConstants.REDIRECT_CITIZEN_REGISTRATION_PAGE;

	}

	@ResponseBody
	@GetMapping("/ssnCheck")
	public String isValidSSN(@RequestParam("ssn") Long ssn) {

		return citizenSrvice.verifySSN(ssn);
	}

}
