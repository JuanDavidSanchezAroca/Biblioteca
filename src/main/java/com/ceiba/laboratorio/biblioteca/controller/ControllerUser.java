/**
 * 
 */
package com.ceiba.laboratorio.biblioteca.controller;



import org.springframework.beans.factory.annotation.Autowired;

import com.ceiba.laboratorio.biblioteca.entity.Usuario;
import com.ceiba.laboratorio.biblioteca.service.IUsuarioService;

/**
 * @author	Jeison Julián Barbosa Serna<br>
 * 			Email: jjbarser@gmail.com<br>
 * 
 * @date	6/10/2019
 * @version 1.0
 *
 */
@RestController
@RequestMapping("/usuario")
public class ControllerUser {

	@Autowired
	private IUsuarioService usuarioServices;
	
	@PostMapping
	public Usuario crear(@RequestBody Usuario user){
		return usuarioServices.addUser(user);
	}
}
