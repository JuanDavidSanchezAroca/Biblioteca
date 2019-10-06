package co.ceiba.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="usuarioxlibro")
@NamedQueries({@NamedQuery(name=Usuario_x_Libro.PRESTAMOS,query="select p from Usuario_x_Libro p ")
})
public class Usuario_x_Libro implements Serializable{

	
	public static final String PRESTAMOS="prestamos";
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idUsuarioLibro;
	
	@Column(name="libro")
	private String libro;
	
	@Column(name="nombre")
	private String usuario;
	
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

	/**
	 * @return the libro
	 */
	public String getLibro() {
		return libro;
	}

	/**
	 * @param libro the libro to set
	 */
	public void setLibro(String libro) {
		this.libro = libro;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	
}
