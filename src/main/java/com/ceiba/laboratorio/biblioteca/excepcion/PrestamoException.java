/**
 * 
 */
package com.ceiba.laboratorio.biblioteca.excepcion;


/**
 * @author	Jeison Julián Barbosa Serna<br>
 * 			Email: jjbarser@gmail.com<br>
 * 
 * @date	6/10/2019
 * @version 1.0
 *
 */
public class PrestamoException extends RuntimeException {

		private static final long serialVersionUID = 1L;
		
		public PrestamoException(String message) {
			super(message);
		}
}
