package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.EmployeeDto;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@RequestMapping("/getemployee")
	public String getEmployee(Model model){
		EmployeeDto emp = new EmployeeDto();
		emp.setName("Raj");
		model.addAttribute("emp", emp);
		return "employeedetail";
	}

}
