package co.ceiba.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity(name="libro")
@NamedQueries({@NamedQuery(name="hola",query="select l from libro l"),
		@NamedQuery(name=Libro.BUSCAR_LIBRO, query="select l from libro l where l.isbn = ?1"),
		@NamedQuery(name=Libro.ACTUALIZAR_LIBRO, query = "update libro l set l.total= ?1 where l.isbn = ?2 and l.titulo = ?3"),
		@NamedQuery(name=Libro.DISPONIBLES_LIBRO, query = "select l  from libro l where  l.cantidad < l.total")
})
public class Libro implements Serializable{

	
	public static final String BUSCAR_LIBRO="buscarLibro";
	public static final String ACTUALIZAR_LIBRO="actualizarLibro";
	public static final String DISPONIBLES_LIBRO="librosDisponibles";
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLibro;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="isbn")
	private String isbn;
	
	@Column(name="total")
	private int total;
	
	@Column(name="cantidad")
	private int cantidad;
	
	@Column(name="fecha")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}
	/**
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	/**
	 * @return the idLibro
	 */
	public int getIdLibro() {
		return idLibro;
	}
	/**
	 * @param idLibro the idLibro to set
	 */
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
		
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}
	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
}
