/**
 * 
 */
package com.ceiba.laboratorio.biblioteca.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceiba.laboratorio.biblioteca.entity.Libro;
import com.ceiba.laboratorio.biblioteca.entity.Usuario;

/**
 * @author	Jeison Julián Barbosa Serna<br>
 * 			Email: jjbarser@gmail.com<br>
 * 
 * @date	5/10/2019
 * @version 1.0
 *
 */
public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{

}
