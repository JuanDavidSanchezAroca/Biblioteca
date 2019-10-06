/**
 * 
 */
package com.ceiba.laboratorio.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.laboratorio.biblioteca.entity.Libro;
import com.ceiba.laboratorio.biblioteca.repository.ILibroRepo;

/**
 * @author	Jeison Julián Barbosa Serna<br>
 * 			Email: jjbarser@gmail.com<br>
 * 
 * @date	5/10/2019
 * @version 1.0
 *
 */
@Service
public class LibroServiceImp implements ILibroService{

	@Autowired
	private ILibroRepo libroDao;
	
	@Override
	public List<Libro> findAll() {
		return (List<Libro>) libroDao.findAll();
	}

	@Override
	@Transactional
	public Libro addLibro(Libro libro) {

		return libro;
	}

	@Override
	public Libro findByIsbn(String isbn) {
		
		return libroDao.findByIsbn(isbn);
	}

	@Override
	@Transactional
	public void delete(String isbn) {
		
	}
	
	
	
	
}
