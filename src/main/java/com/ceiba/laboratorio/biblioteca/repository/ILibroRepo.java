/**
 * 
 */
package com.ceiba.laboratorio.biblioteca.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.ceiba.laboratorio.biblioteca.entity.Libro;

/**
 * @author	Jeison Julián Barbosa Serna<br>
 * 			Email: jjbarser@gmail.com<br>
 * 
 * @date	5/10/2019
 * @version 1.0
 *
 */
public interface ILibroRepo extends JpaRepository<Libro, Integer>{
	
	Libro findByIsbn(String isbn);
	
	
}
