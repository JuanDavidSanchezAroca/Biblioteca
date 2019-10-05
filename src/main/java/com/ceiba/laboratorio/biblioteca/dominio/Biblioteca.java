/**
 * 
 */
package com.ceiba.laboratorio.biblioteca.dominio;


/**
 * @author	Jeison Julián Barbosa Serna<br>
 * 			Email: jjbarser@gmail.com<br>
 * 
 * @date	5/10/2019
 * @version 1.0
 *
 */
public class Biblioteca {




	/**
	 * 	
	 * Método que permite validar si un isbn es palindromo
	 *
	 * @author	Jeison Julián Barbosa Serna<br>
	 * 			Email: jjbarser@gmail.com<br>
	 * 
	 * @date	5/10/2019
	 * @version 1.0
	 *
	 * @param isbn
	 * @return
	 */
	public boolean esPalindromo(String isbn) {
			return isbn.equals(new StringBuilder(isbn).reverse().toString());
	}

}
