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
public class Libro {

	private String isbn;
	private String titulo;
	private int anio;
	private int cantidadPrestamo;
	private int total;
	
	/**
	 * Método constructor de la clase en cuestión.
	 * 
	 * @author	Jeison Julián Barbosa Serna<br>
	 * 			Email: jjbarser@gmail.com<br>
	 *
	 * @date	5/10/2019
	 * @version 1.0
	 * 
	 * @param isbn
	 * @param titulo
	 * @param anio
	 */
	public Libro(String isbn, String titulo, int anio) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.anio = anio;
	}
	
	
	/**
	 * Método que retorna el valor del atributo cantidad
	 * 
	 * @author	Jeison Julián Barbosa Serna<br>
	 * 			Email: jjbarser@gmail.com<br>
	 *
	 * @date	5/10/2019
	 * @version 1.0
	 * 
	 * @return 	cantidad
	 */
	public int getCantidad() {
		return cantidadPrestamo;
	}

	
	/**
	 * Método que permite almacenar el valor cantidad en el atributo cantidad
	 * 
	 * @author	Jeison Julián Barbosa Serna<br>
	 * 			Email: jjbarser@gmail.com<br>
	 *
	 * @date	5/10/2019
	 * @version 1.0
	 * 
	 * @param cantidad el valor a asignar al atributo cantidad
	 */
	public void setCantidad(int cantidad) {
		this.cantidadPrestamo = cantidad;
	}


	
	/**
	 * Método que retorna el valor del atributo isbn
	 * 
	 * @author	Jeison Julián Barbosa Serna<br>
	 * 			Email: jjbarser@gmail.com<br>
	 *
	 * @date	5/10/2019
	 * @version 1.0
	 * 
	 * @return 	isbn
	 */
	public String getIsbn() {
		return isbn;
	}
	
	/**
	 * Método que permite almacenar el valor isbn en el atributo isbn
	 * 
	 * @author	Jeison Julián Barbosa Serna<br>
	 * 			Email: jjbarser@gmail.com<br>
	 *
	 * @date	5/10/2019
	 * @version 1.0
	 * 
	 * @param isbn el valor a asignar al atributo isbn
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	/**
	 * Método que retorna el valor del atributo titulo
	 * 
	 * @author	Jeison Julián Barbosa Serna<br>
	 * 			Email: jjbarser@gmail.com<br>
	 *
	 * @date	5/10/2019
	 * @version 1.0
	 * 
	 * @return 	titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	
	/**
	 * Método que permite almacenar el valor titulo en el atributo titulo
	 * 
	 * @author	Jeison Julián Barbosa Serna<br>
	 * 			Email: jjbarser@gmail.com<br>
	 *
	 * @date	5/10/2019
	 * @version 1.0
	 * 
	 * @param titulo el valor a asignar al atributo titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	/**
	 * Método que retorna el valor del atributo anio
	 * 
	 * @author	Jeison Julián Barbosa Serna<br>
	 * 			Email: jjbarser@gmail.com<br>
	 *
	 * @date	5/10/2019
	 * @version 1.0
	 * 
	 * @return 	anio
	 */
	public int getAnio() {
		return anio;
	}
	
	/**
	 * Método que permite almacenar el valor anio en el atributo anio
	 * 
	 * @author	Jeison Julián Barbosa Serna<br>
	 * 			Email: jjbarser@gmail.com<br>
	 *
	 * @date	5/10/2019
	 * @version 1.0
	 * 
	 * @param anio el valor a asignar al atributo anio
	 */
	public void setAnio(int anio) {
		this.anio = anio;
	}
	
	
}
