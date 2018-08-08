
package com.luv2code.springdemo.controller;

import org.springframework.ui.Model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//inject customer Service
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/list")
	public String listCustomer (Model theModel) {
		
		//get customer from dao
		List <Customer> theCustomers = customerService.getCustomer();
		
		//add the customer to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
		
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model TheModel) {
			
		Customer thecustomer = new Customer();
		TheModel.addAttribute("customer", thecustomer);
			
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
		
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		
		Customer theCustomer =customerService.getCustomer(theId);
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
		
		
	}
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
		
	}
		
	}


