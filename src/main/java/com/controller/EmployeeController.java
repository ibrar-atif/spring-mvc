package com.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.EmployeeDto;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@RequestMapping("/getemployee/{age1}/{name1}/{t}")
	public String getEmployee(Model model, @PathVariable("age1") int age,@PathVariable("name1") String name,@PathVariable("t") String name1){
		EmployeeDto emp = new EmployeeDto();
		emp.setName(name);
		emp.setAge(age);
		model.addAttribute("emp", emp);
		model.addAttribute("name", name1);
		return "employeedetail";
		
	}
	
	@RequestMapping(value="/saveEmp",method=RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("emp") EmployeeDto emp ,BindingResult result,Model model){

		model.addAttribute("emp", emp);
		return "employeedetail";
	}
	
	@RequestMapping("/getemployeemvc")
	public ModelAndView getEmployeemvc(Model model){
		ModelAndView mvc = new ModelAndView("employeedetail");
		EmployeeDto emp = new EmployeeDto();
		emp.setName("Raj");
		mvc.addObject("emp", emp);
		//model.addAttribute("emp", emp);
		return mvc;
	}
	
	public EmployeeController(){
		System.out.println("controller");
	}
	
	@RequestMapping("/getemployee")
	public String getEmployee1(Model model){
		EmployeeDto emp = new EmployeeDto();
		emp.setName("Srini");
		emp.setAge(40);
		model.addAttribute("emp", emp);
		model.addAttribute("name", "my name is srini");
		return "employeedetail";
		
	}

}
