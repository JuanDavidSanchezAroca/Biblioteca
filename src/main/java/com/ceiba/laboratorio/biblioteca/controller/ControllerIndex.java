/**
 * 
 */
package com.ceiba.laboratorio.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author	Jeison Julián Barbosa Serna<br>
 * 			Email: jjbarser@gmail.com<br>
 * 
 * @date	5/10/2019
 * @version 1.0
 *
 */
@Controller
public class ControllerIndex {
	

	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String index(){
		return "bilioteca";
	}
	
}
