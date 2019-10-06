package com.ceiba.laboratorio.biblioteca.service;

import java.util.Date;

import com.ceiba.laboratorio.biblioteca.entity.Usuario_x_Libro;

public interface IPrestamoService {

	public void agregarPrestamo(String isbn, String usuario);
	
	public boolean validarFecha(Date fechaActual, Date fechaEntrega);
	
	public int diferenciaDias(Date fechaActual, Date fechaEntrega);
	
	public  Date sumarDiasAFecha(Date fecha, int dias);
	
	public boolean isSuma(String numero);
	
	public boolean isPalindorme(String numero);
	
	public String getDiaSemana(Date fechaActual);
	
	public Date generarFechaEntrega(int dias, Date fechaSolicitud);
	
	
	
	
}
