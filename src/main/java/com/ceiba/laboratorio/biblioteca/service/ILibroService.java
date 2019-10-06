/**
 * 
 */
package com.ceiba.laboratorio.biblioteca.service;

import java.util.List;

import com.ceiba.laboratorio.biblioteca.entity.Libro;

/**
 * @author	Jeison Julián Barbosa Serna<br>
 * 			Email: jjbarser@gmail.com<br>
 * 
 * @date	5/10/2019
 * @version 1.0
 *
 */
public interface ILibroService {

	 public List<Libro> findAll();
	 public Libro addLibro(Libro libro);
	 public Libro findByIsbn(String isbn);
	 public boolean delete (String isbn);
	 
	 
	 
}
