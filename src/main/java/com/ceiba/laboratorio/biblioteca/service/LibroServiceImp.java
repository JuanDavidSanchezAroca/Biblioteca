/**
 * 
 */
package com.ceiba.laboratorio.biblioteca.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.laboratorio.biblioteca.entity.Libro;
import com.ceiba.laboratorio.biblioteca.repository.ILibroRepo;

/**
 * @author Jeison Julián Barbosa Serna<br>
 *         Email: jjbarser@gmail.com<br>
 * 
 * @date 5/10/2019
 * @version 1.0
 *
 */
@Service
public class LibroServiceImp implements ILibroService {

	@Autowired
	private ILibroRepo libroDao;

	@Override
	public List<Libro> findAll() {
		return (List<Libro>) libroDao.findAll();
	}

	@Override
	@Transactional
	public Libro addLibro(Libro libro) {
		Libro libroOut = findByIsbn(libro.getIsbn());
		if (libroOut != null) {
			libroOut.setTotal(libroOut.getTotal() + 1);
			libroDao.save(libroOut);
		} else {
			libroOut = libroDao.save(libro);

		}
		return libroOut;
	}

	@Override
	public Libro findByIsbn(String isbn) {

		return libroDao.findByIsbn(isbn);
	}

	@Override
	@Transactional
	public boolean delete(String isbn) {
		Libro libro = findByIsbn(isbn);
		if (libro != null) {
			if (libro.getTotal() > 1) {
				libro.setTotal(libro.getTotal() - 1);
				libroDao.save(libro);
				return true;
			} else {
				libroDao.deleteById(libro.getIdLibro());
			}
		}
		return false;

	}

	@Override
	public boolean disponibilidad(String isbn) {
		Libro libro= libroDao.findByIsbn(isbn);
		if(libro!= null){
			if(libro.getTotal()>libro.getCantidad()){
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Libro> listAllActivate() {
		List<Libro> libros = libroDao.findAll();
		ArrayList<Libro> listActivate = new ArrayList<Libro>(); 
		
		for (int i = 0; i < libros.size(); i++) {
			if(libros.get(i).getCantidad()<libros.get(i).getTotal()){
				listActivate.add(libros.get(i));
			}
		}
		return listActivate;
	}
	
	
	
	

}
