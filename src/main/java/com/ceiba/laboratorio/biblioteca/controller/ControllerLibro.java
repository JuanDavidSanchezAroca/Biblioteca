/**
 * 
 */
package com.ceiba.laboratorio.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.laboratorio.biblioteca.entity.Libro;
import com.ceiba.laboratorio.biblioteca.service.ILibroService;

/**
 * @author Jeison Julián Barbosa Serna<br>
 *         Email: jjbarser@gmail.com<br>
 * 
 * @date 5/10/2019
 * @version 1.0
 *
 */
@RestController
@RequestMapping("/libros")
public class ControllerLibro {

	@Autowired
	private ILibroService libroService;

	@GetMapping
	public List<Libro> index() {
		return libroService.findAll();
	}

	@PostMapping
	public Libro create(@RequestBody Libro libro) {
		return libroService.addLibro(libro);
	}

	@GetMapping("/{isbn}")
	public Libro findIsbn(@PathVariable String isbn) {
		return libroService.findByIsbn(isbn);
	}

	@DeleteMapping("/{isbn}")
	public boolean deleteByIsbn(@PathVariable String isbn) {
		return libroService.delete(isbn);
	}

	@GetMapping("/ds/{isbn}")
	public boolean getDisponibilidad(@PathVariable String isbn) {
		return libroService.disponibilidad(isbn);
	}
	
	@GetMapping("/list_disponibles")
	public List<Libro> listarDisponibles() {
		return libroService.listAllActivate();
	}
	

}
