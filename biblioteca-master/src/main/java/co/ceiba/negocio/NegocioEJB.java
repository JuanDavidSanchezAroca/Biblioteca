package co.ceiba.negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.ceiba.entidades.Libro;

@Stateless
public class NegocioEJB {
	
	@PersistenceContext(unitName = "persistencia")
	protected transient EntityManager em;
	
	
	/**
	 * Metodo que permite validar si existe un libro
	 * @param isbn
	 * @param titulo
	 * @return true si existe, false si no 
	 */
	private boolean buscarLibro(String isbn, String titulo) {
		
		Query query = em.createNamedQuery(Libro.BUSCAR_LIBRO);
		query.setParameter(1, isbn);
		query.setParameter(2, titulo);
		
		List<Libro> res = query.getResultList();
		
		return res.size() > 0 ? true:false;
	}
	
	/**
	 * Metodo que permite agregar un libro
	 * @param libro
	 */
	public void agregarLibro(Libro libro) {
		if(!buscarLibro(libro.getIsbn(), libro.getTitulo())) {
			em.persist(libro);
		}else {
			Libro l = consultarLibro(libro.getIsbn(), libro.getTitulo());
			if(l!=null) {
			l.setTotal(l.getCantidad()+l.getIdLibro()+1);
			em.merge(libro);
			/*Query query = em.createNamedQuery(Libro.ACTUALIZAR_LIBRO);
			query.setParameter(1, l.getTotal());
			query.setParameter(2, l.getIsbn());
			query.setParameter(3, l.getTitulo());
			query.getResultList();
			*/
			}
		}
	}
	
	
	/**
	 * Metodo que consulta un libro 
	 * @param isbn
	 * @param titulo
	 * @return
	 */
	private Libro consultarLibro(String isbn,String titulo) {
		
		Query query = em.createNamedQuery(Libro.BUSCAR_LIBRO);
		query.setParameter(1, isbn);
		query.setParameter(2, titulo);
		
		List<Libro> res = query.getResultList();
		
		return res.size() ==1 ? res.get(0):null;
	}
	
	/**
	 * Metodo que elimina un libro
	 * @param isbn
	 * @param titulo
	 * @return true si es eliminado, false si no 
	 */
	public boolean eliminar(String isbn,String titulo) {
		Libro l = consultarLibro(isbn, titulo);
		if(l!=null) {
			if(l.getCantidad()>1) {
				l.setCantidad(l.getCantidad()-1);
				em.merge(l);
				return true;
			}else {
				em.remove(l);
				return true;
			}
		}
		return false;
	}
	
}
