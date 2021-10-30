package com.mvcapp.andrea.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AplicacionControlador {

	//http://localhost:8080/bienvenida
	@GetMapping("/bienvenida")
	public String mostrarBienvenida(Model modelo) {
		System.out.println("Ejecutando bienvenida");
		
		
		//Consulta a la base de datos
		String nombreUsuario="Homero Simpson";
		modelo.addAttribute("nombre",nombreUsuario);
		return "inicio";
	}
	
	@GetMapping("/calculadora")
	public String muestraCalculadora() {
		
		return "calculadora";
	}
	
	@GetMapping("/imc")
	public String calculaIMC(double peso, double altura, Model modelo) {
	
		double imc =peso/(altura*altura);
		modelo.addAttribute("imc",imc);
		return "resultado";
	}
}

