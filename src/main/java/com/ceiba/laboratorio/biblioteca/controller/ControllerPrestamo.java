package com.ceiba.laboratorio.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ceiba.laboratorio.biblioteca.service.IPrestamoService;

@RestController
@RequestMapping("/prestamo")
public class ControllerPrestamo {

	@Autowired
	private IPrestamoService prestamoEJB;
	
	@GetMapping("/{isbn}/{usuario}")
	public String findIsbn(@PathVariable String isbn,@PathVariable String usuario) {
		try { 
		prestamoEJB.agregarPrestamo(isbn, usuario);
		return "OK";
		}catch (Exception e) {
		 return e.getMessage();
		}
		
	}
}
