package com.everis.spring.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;


import com.everis.spring.repository.EverisCustomer;
import com.everis.spring.services.EverisCustomerManagementServiceI;

@RestController
@RequestMapping("/home/customer/")
public class CustomerController {
	
	@Autowired
	public EverisCustomerManagementServiceI customerService;
	
	@GetMapping("customerList")
	public @ResponseBody String cookSpaguettis(Model modelAndView) {

		
		List<EverisCustomer> customerList = customerService.getAllCustomers();
		
		
		// Se retorna el menú a la vista y modelo.
		modelAndView.addAttribute("customerList", customerList);
		
		return "showCustomers";
	}
	
	@PostMapping("/addCustomer")
	public @ResponseBody String addCustomer(@ModelAttribute EverisCustomer newCustomer, Model model) {
		
		// Se establece referencia de matriculación.
		final String customerName = StringUtils.substring(newCustomer.getName(), 0, 1);
		final String customerSurName1 = StringUtils.substring(newCustomer.getSurName1(), 0, 1);
		final String customerSurName2 = StringUtils.substring(newCustomer.getSurName2(), 0, 1);
		final String customerIdentifyDocNumber = StringUtils.substring(newCustomer.getIdentityDocNumber(), 0, 1);
		
		customerService.insertNewCustomer(newCustomer);
		
		
		// Se retorna actualizado al modelo.
		model.addAttribute("newCustomer", newCustomer);
		
		return "/showCustomers";
	}
	
	@GetMapping(value = "/findCustomer",params={"name","surName1","surName2"})
	public @ResponseBody String findCustomer(String name,String surName1,String surName2,Model modelAndView) {
		
		List<EverisCustomer> response = customerService.findByFullName(name, surName1, surName2);
		
		modelAndView.addAttribute("customerList", response);
		
		return "showCustomer";
		
		
	}

}
