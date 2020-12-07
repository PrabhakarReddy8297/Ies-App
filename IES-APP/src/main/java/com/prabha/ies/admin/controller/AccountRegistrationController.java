package com.prabha.ies.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prabha.ies.admin.domain.Account;
import com.prabha.ies.admin.service.AccountService;
import com.prabha.ies.constants.IesConstants;

@Controller
public class AccountRegistrationController {
	@Autowired
	private AccountService accountService;

	@PostMapping("/saveAccount")
	public String handleCreateAccountLink(@ModelAttribute("accountObj") Account account, RedirectAttributes rd) {
		
			boolean saveAccount = accountService.saveAccount(account);
			if (saveAccount) {
				if(account.getAccountId() != null)
				rd.addFlashAttribute("succMsg", "Account Updated Successfully");
				else
					rd.addFlashAttribute("succMsg","Account Registration  Successfull Dtailes Send to Account Holder Mialid ");
						
			} else {
				if(account.getAccountId() != null)
				rd.addFlashAttribute("failMsg", "Account Updation Failed");
				else
					rd.addFlashAttribute("failMsg", "Account Registration Failed");
			}
		
						
		return IesConstants.REDIRECT_ACCOUNT_REGISTRATION_PAGE;
	}

	@GetMapping("/uniqueMailCheck")
	@ResponseBody
	public String isUniqueEmail(@RequestParam("email") String email) {
		return accountService.isUniqueEmail(email) ? "UNIQUE" : "DUPLICATE";
	}

}
