/**
 * 
 */
package com.ceiba.laboratorio.biblioteca.dominio;

import java.util.Date;

/**
 * @author	Jeison Julián Barbosa Serna<br>
 * 			Email: jjbarser@gmail.com<br>
 * 
 * @date	5/10/2019
 * @version 1.0
 *
 */
public class Prestamo {

	private Date fechaSolicitud;
	private Libro libro;
	private Date fechaEntregaMaxima;
	private String nombreUsuario;
	/**
	 * Método constructor de la clase en cuestión.
	 * 
	 * @author	Jeison Julián Barbosa Serna<br>
	 * 			Email: jjbarser@gmail.com<br>
	 *
	 * @date	5/10/2019
	 * @version 1.0
	 * 
	 * @param fechaSolicitud
	 * @param libro
	 * @param fechaEntregaMaxima
	 * @param nombreUsuario
	 */
	public Prestamo(Date fechaSolicitud, Libro libro, Date fechaEntregaMaxima, String nombreUsuario) {
		super();
		this.fechaSolicitud = fechaSolicitud;
		this.libro = libro;
		this.fechaEntregaMaxima = fechaEntregaMaxima;
		this.nombreUsuario = nombreUsuario;
	}
	
	/**
	 * Método que retorna el valor del atributo fechaSolicitud
	 * 
	 * @author	Jeison Julián Barbosa Serna<br>
	 * 			Email: jjbarser@gmail.com<br>
	 *
	 * @date	5/10/2019
	 * @version 1.0
	 * 
	 * @return 	fechaSolicitud
	 */
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}
	
	/**
	 * Método que permite almacenar el valor fechaSolicitud en el atributo fechaSolicitud
	 * 
	 * @author	Jeison Julián Barbosa Serna<br>
	 * 			Email: jjbarser@gmail.com<br>
	 *
	 * @date	5/10/2019
	 * @version 1.0
	 * 
	 * @param fechaSolicitud el valor a asignar al atributo fechaSolicitud
	 */
	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	
	/**
	 * Método que retorna el valor del atributo libro
	 * 
	 * @author	Jeison Julián Barbosa Serna<br>
	 * 			Email: jjbarser@gmail.com<br>
	 *
	 * @date	5/10/2019
	 * @version 1.0
	 * 
	 * @return 	libro
	 */
	public Libro getLibro() {
		return libro;
	}
	
	/**
	 * Método que permite almacenar el valor libro en el atributo libro
	 * 
	 * @author	Jeison Julián Barbosa Serna<br>
	 * 			Email: jjbarser@gmail.com<br>
	 *
	 * @date	5/10/2019
	 * @version 1.0
	 * 
	 * @param libro el valor a asignar al atributo libro
	 */
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	/**
	 * Método que retorna el valor del atributo fechaEntregaMaxima
	 * 
	 * @author	Jeison Julián Barbosa Serna<br>
	 * 			Email: jjbarser@gmail.com<br>
	 *
	 * @date	5/10/2019
	 * @version 1.0
	 * 
	 * @return 	fechaEntregaMaxima
	 */
	public Date getFechaEntregaMaxima() {
		return fechaEntregaMaxima;
	}
	
	/**
	 * Método que permite almacenar el valor fechaEntregaMaxima en el atributo fechaEntregaMaxima
	 * 
	 * @author	Jeison Julián Barbosa Serna<br>
	 * 			Email: jjbarser@gmail.com<br>
	 *
	 * @date	5/10/2019
	 * @version 1.0
	 * 
	 * @param fechaEntregaMaxima el valor a asignar al atributo fechaEntregaMaxima
	 */
	public void setFechaEntregaMaxima(Date fechaEntregaMaxima) {
		this.fechaEntregaMaxima = fechaEntregaMaxima;
	}
	
	/**
	 * Método que retorna el valor del atributo nombreUsuario
	 * 
	 * @author	Jeison Julián Barbosa Serna<br>
	 * 			Email: jjbarser@gmail.com<br>
	 *
	 * @date	5/10/2019
	 * @version 1.0
	 * 
	 * @return 	nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	
	/**
	 * Método que permite almacenar el valor nombreUsuario en el atributo nombreUsuario
	 * 
	 * @author	Jeison Julián Barbosa Serna<br>
	 * 			Email: jjbarser@gmail.com<br>
	 *
	 * @date	5/10/2019
	 * @version 1.0
	 * 
	 * @param nombreUsuario el valor a asignar al atributo nombreUsuario
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	
	
}
