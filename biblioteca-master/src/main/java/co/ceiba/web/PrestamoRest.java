package co.ceiba.web;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.ceiba.entidades.Usuario_x_Libro;
import co.ceiba.negocio.NegocioEJB;

@Path("/prestamo")
public class PrestamoRest {

	@Inject
	private NegocioEJB negocioEJB;
	
	@POST
	@Path("/insertar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public String agregarPrestamo(Usuario_x_Libro prestamo) {		
		negocioEJB.agregarPrestamo(prestamo);
		return "OK";	
	}
	
	@GET
	@Path("/consulta")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario_x_Libro> consultaPrestamo(){
		return negocioEJB.listaPrestamo(); 
	}
}
