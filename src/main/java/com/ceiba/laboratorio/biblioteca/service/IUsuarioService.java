/**
 * 
 */
package com.ceiba.laboratorio.biblioteca.service;

import com.ceiba.laboratorio.biblioteca.entity.Usuario;

/**
 * @author	Jeison Julián Barbosa Serna<br>
 * 			Email: jjbarser@gmail.com<br>
 * 
 * @date	6/10/2019
 * @version 1.0
 *
 */
public interface IUsuarioService {

	public Usuario addUser(Usuario user);
	
	public boolean findUser(int id );
}
