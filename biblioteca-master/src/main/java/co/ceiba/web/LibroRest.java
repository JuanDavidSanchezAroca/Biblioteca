package co.ceiba.web;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.ceiba.entidades.Libro;
import co.ceiba.negocio.NegocioEJB;

@Path("/libro")
public class LibroRest {
	
	@Inject
	private NegocioEJB negocioEJB;

	
	@POST
	@Path("/insertar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public String ordenar(Libro libro) {
			negocioEJB.agregarLibro(libro);
			return "OK";		
	}
}
