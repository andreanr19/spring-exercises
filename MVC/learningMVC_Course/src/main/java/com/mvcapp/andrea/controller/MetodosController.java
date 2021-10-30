package com.mvcapp.andrea.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mvcapp.andrea.model.Persona;

@Controller
@RequestMapping("/")
public class MetodosController {

	//metodo 1
	@GetMapping("/metodo1")
	public String Metodo1(Model model) {
		model.addAttribute("p", getPersonas());
		return "resultados";
	}
	
	//metodo 2
	@GetMapping("/metodo2")
	public ModelAndView Metodo2() {
		ModelAndView mav = new ModelAndView("resultados");
		mav.addObject("p", getPersonas());
		return mav;
	}
	
	private List<Persona> getPersonas(){
		List<Persona> p = new ArrayList<>();
		p.add(new Persona("Andrea", 2434322));
		p.add(new Persona("Isabel", 389892));
		p.add(new Persona("Sandra", 32112322));
		p.add(new Persona("Pinina", 244434322));

		return p;
	}
}
