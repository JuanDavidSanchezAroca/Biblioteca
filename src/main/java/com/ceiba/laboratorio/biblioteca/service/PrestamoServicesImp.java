package com.ceiba.laboratorio.biblioteca.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.laboratorio.biblioteca.entity.Libro;
import com.ceiba.laboratorio.biblioteca.entity.Usuario;
import com.ceiba.laboratorio.biblioteca.entity.Usuario_x_Libro;
import com.ceiba.laboratorio.biblioteca.excepcion.PrestamoException;
import com.ceiba.laboratorio.biblioteca.repository.ILibroRepo;
import com.ceiba.laboratorio.biblioteca.repository.IPrestamoRepo;

@Service
public class PrestamoServicesImp implements IPrestamoService {

	public static final String EL_LIBRO_NO_SE_ENCUENTRA_DISPONIBLE = "El libro no se encuentra disponible";

	public static final String MENSAJE_PALINDROMO = "los libros palindromos solo se pueden utilizar en la biblioteca";

	public static final String ISBN_NO_ENTREGADO = "El ISBN no fue entregado para el prestamo del libro";

	public static final String USUARIO_NO_ENVIADO = "El usuario no fue entregado para el prestamo del libro";

	public static final String LIBRO_NO_EXISTE = "El libro no existe";

	public static final int LIMITE_SUMA_ISBN = 30;

	public static final int DIAS_PRESTAMO_RESTRICCION = 15;

	@Autowired
	private ILibroRepo libroDao;

	@Autowired
	private IPrestamoRepo prestamoDao;

	@Override
	public void agregarPrestamo(String isbn, String usuario) {

		Usuario_x_Libro p = new Usuario_x_Libro();
		p.setFechaMaxima(sumarDiasAFecha(new Date(), 1));
		p.setFechaMaxima(sumarDiasAFecha(new Date(), 1));
		Usuario u = new Usuario();
		u.setNombre("mario");
		u.setIdUsuario(Integer.parseInt(usuario));
		p.setUsuario(u);

		if (isbn == null || isbn.trim().equals("")) {
			throw new PrestamoException(ISBN_NO_ENTREGADO);
		}
		if (usuario == null || usuario.trim().equals("")) {
			throw new PrestamoException(USUARIO_NO_ENVIADO);
		}

		if (!isPalindorme(String.valueOf(isbn))) {
			if (isSuma(isbn)) {
				p.setFechaMaxima(sumarDiasAFecha(new Date(), DIAS_PRESTAMO_RESTRICCION));
			} else {
				p.setFechaMaxima(null);
			}
			Libro l = libroDao.findByIsbn(isbn);
			if (l == null) {
				throw new PrestamoException(LIBRO_NO_EXISTE);
			}

			if (l.getCantidad() + 1 <= l.getTotal()) {

				if (p.getFechaMaxima()!= null && getDiaSemana(p.getFechaMaxima()).equals("Domingo")) {

					p.setFechaMaxima(sumarDiasAFecha(p.getFechaMaxima(), 1));
				}

				
				l.setCantidad(l.getCantidad() + 1);
				libroDao.save(l);
				p.setLibro(l);
				prestamoDao.save(p);
			} else {
				throw new PrestamoException(EL_LIBRO_NO_SE_ENCUENTRA_DISPONIBLE);
			}
		}
		throw new PrestamoException(MENSAJE_PALINDROMO);

	}

	@Override
	public boolean validarFecha(Date fechaActual, Date fechaEntrega) {
		int dias = diferenciaDias(fechaActual, fechaEntrega);
		int cantDomingos = dias / 7;
		dias = dias - cantDomingos;
		System.out.println("cantidad de dias" + dias);
		return dias > 15 ? true : false;
	}

	@Override
	public int diferenciaDias(Date fechaActual, Date fechaEntrega) {
		long diferenciaEnms = fechaEntrega.getTime() - fechaActual.getTime();
		long dias = diferenciaEnms / (1000 * 60 * 60 * 24);
		return (int) dias + 2;
	}

	@Override
	public Date sumarDiasAFecha(Date fecha, int dias) {
		if (dias == 0)
			return fecha;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(Calendar.DAY_OF_YEAR, dias);
		return calendar.getTime();
	}

	@Override
	public boolean isSuma(String numero) {
		int suma = 0;
		int numeroAux = Integer.parseInt(numero);
		while (numeroAux > 0) {
			suma += numeroAux % 10;
			numeroAux = numeroAux / 10;
		}

		return suma > 30 ? true : false;
	}

	@Override
	public boolean isPalindorme(String numero) {
		for (int i = 0; i < numero.length() / 2; i++) {
			if (numero.charAt(i) != numero.charAt(numero.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}

	@Override
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

		System.out.println("valor dia" + Valor_dia);
		return Valor_dia;
	}

	@Override
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
