package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.model.Person;
import com.service.PersonService;

@Controller
@SessionAttributes("p123")
public class PersonController {
	
	@Autowired
	Person p;

	@Autowired
	PersonService personService;
	
	@RequestMapping("/personform/{id}")
	public String personForm(Model model, @PathVariable("id") int id){
		BeanUtils.copyProperties(personService.getPerson(id), p);
		//p=personService.getPerson(id);
		//Person p1 = personService.getPerson(id);
		model.addAttribute("p123", p);
		return "persondetail";
	}
	
	
	@RequestMapping(value="/personSave",method=RequestMethod.POST)
	public String personFormSave(Model model,@ModelAttribute("p123") Person person){
		
		model.addAttribute("p123", person);
		return "personShow";
	}


	public PersonService getPersonService() {
		return personService;
	}


	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	
	
	@RequestMapping(value="/show")
	public String Show(Model model){
		
		model.addAttribute("p123", p);
		return "personShow";
	}
	
	@RequestMapping("/form")
	public String personForm1(Model model, @ModelAttribute("p123") Person p){
		//BeanUtils.copyProperties(personService.getPerson(id), p);
		
		p.setName("Atif");
		
		model.addAttribute("person", p);
		System.out.println(getPersonService());
		System.out.println(new PersonController().getPersonService());
		return "persondetail";
	}
	
	
	@ModelAttribute("person")
	public Person getPerson(){
		return new Person();
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}
	
	
}
