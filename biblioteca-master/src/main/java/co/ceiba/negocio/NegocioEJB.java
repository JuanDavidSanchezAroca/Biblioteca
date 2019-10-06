package co.ceiba.negocio;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.client.Client;

import co.ceiba.entidades.Libro;
import co.ceiba.entidades.Usuario;
import co.ceiba.entidades.Usuario_x_Libro;

@Stateless
public class NegocioEJB {

	@PersistenceContext(unitName = "persistencia")
	protected transient EntityManager em;

	/**
	 * Metodo que permite validar si existe un libro
	 * 
	 * @param isbn
	 * @param titulo
	 * @return true si existe, false si no
	 */
	private boolean buscarLibro(String isbn, String titulo) {

		Query query = em.createNamedQuery(Libro.BUSCAR_LIBRO);
		query.setParameter(1, isbn);

		List<Libro> res = query.getResultList();

		return res.size() > 0 ? true : false;
	}

	/**
	 * Metodo que permite agregar un libro
	 * 
	 * @param libro
	 */
	public void agregarLibro(Libro libro) {
		if (!buscarLibro(libro.getIsbn(), libro.getTitulo())) {
			em.persist(libro);
		} else {
			Libro l = consultarLibro(libro.getIsbn());
			if (l != null) {
				l.setTotal(l.getTotal() + libro.getTotal());
				em.merge(l);
			}
		}
	}

	/**
	 * Metodo que consulta un libro
	 * 
	 * @param isbn
	 * @param titulo
	 * @return
	 */
	private Libro consultarLibro(String isbn) {

		Query query = em.createNamedQuery(Libro.BUSCAR_LIBRO);
		query.setParameter(1, isbn);

		List<Libro> res = query.getResultList();

		return res.size() == 1 ? res.get(0) : null;
	}

	/**
	 * Metodo que elimina un libro
	 * 
	 * @param isbn
	 * @param titulo
	 * @return true si es eliminado, false si no
	 */
	public boolean eliminar(String isbn) {
		Libro l = consultarLibro(isbn);
		if (l != null) {
			if (l.getTotal() > 1) {
				l.setTotal(l.getTotal() - 1);
				em.merge(l);
				return true;
			} else {
				em.remove(l);
				return true;
			}
		}
		return false;
	}

	/**
	 * Metodo que agrega un nuevo usuario
	 * 
	 * @param usuario
	 */
	public void agregarUsuario(Usuario usuario) {
		if (buscarUsuario(usuario) == null) {
			em.persist(usuario);
		}
	}

	/**
	 * Metodo que verifica si un usuario existe
	 * 
	 * @param usuario
	 * @return usuario
	 */
	public Usuario buscarUsuario(Usuario usuario) {
		Query query = em.createNamedQuery(Usuario.BUSCAR_USUARIO);
		query.setParameter(1, usuario.getCedula());

		List<Usuario> users = query.getResultList();
		return users.size() == 1 ? users.get(0) : null;
	}

	/**
	 * Metodo que permite agregar prestamo
	 * 
	 * @param prestamo
	 */
	public void agregarPrestamo(Usuario_x_Libro prestamo) {

		prestamo.setFechaSolicitud(sumarDiasAFecha(new Date(), 1));
		prestamo.setFechaMaxima(sumarDiasAFecha(new Date(), 1));
		if (!isPalindorme(String.valueOf(prestamo.getLibro()))) {
			if (isSuma(prestamo.getLibro())) {
				prestamo.setFechaMaxima(sumarDiasAFecha(new Date(), 15));
			}else {
				prestamo.setFechaMaxima(null);
			}
			Libro l = consultarLibro(prestamo.getLibro());
			if (l.getCantidad() + 1 <= l.getTotal()) {
				if (getDiaSemana(prestamo.getFechaMaxima()).equals("Domingo")) {
					prestamo.setFechaMaxima(sumarDiasAFecha(prestamo.getFechaMaxima(), 1));
				}
				l.setCantidad(l.getCantidad() + 1);
				em.merge(l);
				em.persist(prestamo);
			}

			System.out.println("error 15 dias");

		}
		System.out.println("error palindromo");
	}



	/**
	 * Metodo que calcula la diferencia de dias
	 * 
	 * @param fechaActual
	 * @param fechaEntrega
	 * @return
	 */
	public int diferenciaDias(Date fechaActual, Date fechaEntrega) {
		long diferenciaEn_ms = fechaEntrega.getTime() - fechaActual.getTime();
		long dias = diferenciaEn_ms / (1000 * 60 * 60 * 24);
		return (int) dias + 2;
	}

	public static Date sumarDiasAFecha(Date fecha, int dias) {
		if (dias == 0)
			return fecha;
		int cantidadDomingos= dias / 7;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(Calendar.DAY_OF_YEAR, dias+cantidadDomingos);
		return calendar.getTime();
	}

	/**
	 * Metodo que permite validar si la suma de isbn es 30
	 * 
	 * @param numero
	 * @return
	 */
	public boolean isSuma(String numero) {
		int suma = 0;
		int numeroAux = Integer.parseInt(numero);
		while (numeroAux > 0) {
			suma += numeroAux % 10;
			numeroAux = numeroAux / 10;
		}

		return suma > 30 ? true : false;
	}

	public boolean isPalindorme(String numero) {
		for (int i = 0; i < numero.length() / 2; i++) {
			if (numero.charAt(i) != numero.charAt(numero.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	public String getDiaSemana(Date fechaActual) {
		String Valor_dia = null;
		GregorianCalendar fechaCalendario = new GregorianCalendar();
		fechaCalendario.setTime(fechaActual);
		int diaSemana = fechaCalendario.get(Calendar.DAY_OF_WEEK);
		if (diaSemana == 1) {
			Valor_dia = "Domingo";
		} else if (diaSemana == 2) {
			Valor_dia = "Lunes";
		} else if (diaSemana == 3) {
			Valor_dia = "Martes";
		} else if (diaSemana == 4) {
			Valor_dia = "Miercoles";
		} else if (diaSemana == 5) {
			Valor_dia = "Jueves";
		} else if (diaSemana == 6) {
			Valor_dia = "Viernes";
		} else if (diaSemana == 7) {
			Valor_dia = "Sabado";
		}
		return Valor_dia;
	}

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

	public List<Libro> listaLibros() {
		Query query = em.createNamedQuery(Libro.DISPONIBLES_LIBRO);
		List<Libro> res = query.getResultList();
		return res;
	}

	public List<Usuario_x_Libro> listaPrestamo() {
		Query query = em.createNamedQuery(Usuario_x_Libro.PRESTAMOS);
		List<Usuario_x_Libro> res = query.getResultList();
		return res;

	}
}
