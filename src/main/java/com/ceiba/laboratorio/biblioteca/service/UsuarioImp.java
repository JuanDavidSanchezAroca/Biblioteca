/**
 * 
 */
package com.ceiba.laboratorio.biblioteca.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.laboratorio.biblioteca.entity.Usuario;
import com.ceiba.laboratorio.biblioteca.repository.IUsuarioRepo;

/**
 * @author	Jeison Julián Barbosa Serna<br>
 * 			Email: jjbarser@gmail.com<br>
 * 
 * @date	6/10/2019
 * @version 1.0
 *
 */
public class UsuarioImp implements IUsuarioService{
	
	@Autowired
	private IUsuarioRepo usuarioDao;	
	
	@Override
	@Transactional
	public Usuario addUser(Usuario user) {
		if(user!=null){
			return usuarioDao.save(user);
		}
		return null;
	}

	@Override
	public boolean findUser(int id) {
		if( usuarioDao.findById(id)!= null){
			return true;
		}
		return false;
	}
	
	
	
	

}
