package com.prabha.ies.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prabha.ies.admin.domain.Account;
import com.prabha.ies.admin.service.AccountService;
import com.prabha.ies.constants.IesConstants;

@Controller
public class AccountsViewController {
    @Autowired
    private AccountService accountService;
	@GetMapping("/editAccount")
	public String editBtnHandling(@RequestParam("accountId") Integer id,Model model)
	{
		Account account = accountService.getAccountById(id);
		model.addAttribute("accountObj", account);
		return IesConstants.ACCOUNT_REGISTRATION_VIEW_NAME;
		
	}
	@GetMapping("/deactivateAccount")
	public String deactivateBtnHandling(@RequestParam("accountId") Integer id,RedirectAttributes rd) {
		boolean deactivateAccountById = accountService.deactivateAccountById(id);
		if(deactivateAccountById)
		rd.addFlashAttribute("succMsg", "Account Deactivated Successfully");
		else
			rd.addFlashAttribute("errorMsg", "Account Deactivation failed");
		return IesConstants.REDIRECT_ACCOUNTS_PAGE;
	}
	@GetMapping("/activateAccount")
	public String activateBtnHandling(@RequestParam("accountId") Integer id,RedirectAttributes rd) {
		 boolean activateAccountById = accountService.activateAccountById(id);
		 if(activateAccountById )
		 rd.addFlashAttribute("succMsg", "Account Activated Successfully");
		 else 
			 rd.addFlashAttribute("errorMsg", "Account Activation failed");
		 
		return IesConstants.REDIRECT_ACCOUNTS_PAGE;
	}

}
