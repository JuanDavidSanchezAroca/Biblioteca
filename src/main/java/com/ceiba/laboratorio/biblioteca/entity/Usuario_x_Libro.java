/**
 * 
 */
package com.ceiba.laboratorio.biblioteca.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * @author	Jeison Julián Barbosa Serna<br>
 * 			Email: jjbarser@gmail.com<br>
 * 
 * @date	5/10/2019
 * @version 1.0
 *
 */
@Entity
@Table(name="usuarioxlibro")
public class Usuario_x_Libro implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idUsuarioLibro;
	
    @ManyToOne
    @JoinColumn(name="idLibro")
	private Libro libro;
	
    @ManyToOne
    @JoinColumn(name="idUsuario")
	private Usuario usuario;
	
	@Temporal(TemporalType.DATE)
	private Date fechaSolicitud;
	
	@Temporal(TemporalType.DATE)
	private Date fechaMaxima;

	/**
	 * @return the idUsuarioLibro
	 */
	public int getIdUsuarioLibro() {
		return idUsuarioLibro;
	}

	/**
	 * @param idUsuarioLibro the idUsuarioLibro to set
	 */
	public void setIdUsuarioLibro(int idUsuarioLibro) {
		this.idUsuarioLibro = idUsuarioLibro;
	}

	

	/**
	 * @return the libro
	 */
	public Libro getLibro() {
		return libro;
	}

	/**
	 * @param libro the libro to set
	 */
	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the fechaSolicitud
	 */
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	/**
	 * @param fechaSolicitud the fechaSolicitud to set
	 */
	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	/**
	 * @return the fechaMaxima
	 */
	public Date getFechaMaxima() {
		return fechaMaxima;
	}

	/**
	 * @param fechaMaxima the fechaMaxima to set
	 */
	public void setFechaMaxima(Date fechaMaxima) {
		this.fechaMaxima = fechaMaxima;
	}		
}
