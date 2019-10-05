/**
 * 
 */
package com.ceiba.laboratorio.biblioteca.dominio;

import java.util.Calendar;
import java.util.Date;

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
	
	/**
	 * 
	 * Permite validar si el isbn cumple con una cantidad máxima en la suma de sus digitos como restricción de fecha de entrega
	 *
	 * @author Jeison Julián Barbosa Serna<br>
	 *         Email: jjbarser@gmail.com<br>
	 * 
	 * @date 31/08/2019
	 * @version 1.0
	 *
	 * @param isbn, código que identifica el libro
	 * @param limit, Valor máximo que puede sumar los digitos númericos del códgio isbn @return, verdadero si supera el valor limite
	 */
	public boolean esSumaISBNMayorA(String isbn, int limit) {
		int sum = 0;
		for (int i = 0; i < isbn.length(); i++) {
			char caracter = isbn.charAt(i);
			if (Character.isDigit(caracter)) {
				int b = Integer.parseInt(String.valueOf(caracter));
				sum = sum + b;

				if (sum > limit) {
					return true;
				}
			}
		}
		return false;

	}
	
	/**
	 * 
	 * Genera fecha de entrega de acuerdo a una cantidad de días posterior a el día de solicitud sin contar domingos
	 *
	 * @author Jeison Julián Barbosa Serna<br>
	 *         Email: jjbarser@gmail.com<br>
	 * 
	 * @date 31/08/2019
	 * @version 1.0
	 *
	 * @param dias
	 * @param fechaSolicitud
	 * @return la fecha en tipo date que se obtiene del proceso
	 */
	public Date generarFechaEntrega(int dias, Date fechaSolicitud) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(fechaSolicitud);
		int i = 1;
		while (i < dias) {

			if (cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
				i++;
				cal.get(Calendar.DAY_OF_WEEK);
			}
			cal.add(Calendar.DATE, 1);

		}
		if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			cal.add(Calendar.DATE, 1);
		}

		return cal.getTime();
	}


}
