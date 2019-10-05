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
public class Usuario {
private int id;
private String Nombre;
/**
 * Método constructor de la clase en cuestión.
 * 
 * @author	Jeison Julián Barbosa Serna<br>
 * 			Email: jjbarser@gmail.com<br>
 *
 * @date	5/10/2019
 * @version 1.0
 * 
 * @param id
 * @param nombre
 */
public Usuario(int id, String nombre) {
	super();
	this.id = id;
	Nombre = nombre;
}

/**
 * Método que retorna el valor del atributo id
 * 
 * @author	Jeison Julián Barbosa Serna<br>
 * 			Email: jjbarser@gmail.com<br>
 *
 * @date	5/10/2019
 * @version 1.0
 * 
 * @return 	id
 */
public int getId() {
	return id;
}

/**
 * Método que permite almacenar el valor id en el atributo id
 * 
 * @author	Jeison Julián Barbosa Serna<br>
 * 			Email: jjbarser@gmail.com<br>
 *
 * @date	5/10/2019
 * @version 1.0
 * 
 * @param id el valor a asignar al atributo id
 */
public void setId(int id) {
	this.id = id;
}

/**
 * Método que retorna el valor del atributo nombre
 * 
 * @author	Jeison Julián Barbosa Serna<br>
 * 			Email: jjbarser@gmail.com<br>
 *
 * @date	5/10/2019
 * @version 1.0
 * 
 * @return 	nombre
 */
public String getNombre() {
	return Nombre;
}

/**
 * Método que permite almacenar el valor nombre en el atributo nombre
 * 
 * @author	Jeison Julián Barbosa Serna<br>
 * 			Email: jjbarser@gmail.com<br>
 *
 * @date	5/10/2019
 * @version 1.0
 * 
 * @param nombre el valor a asignar al atributo nombre
 */
public void setNombre(String nombre) {
	Nombre = nombre;
}


}
