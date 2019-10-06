package co.ceiba.web;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	public String agregarLibro(Libro libro) {
			negocioEJB.agregarLibro(libro);
			return "OK";		
	}
	
	@POST
	@Path("/eliminar/{isbn}")
	@Produces(MediaType.TEXT_HTML)
	public String eliminarLibro(@PathParam("isbn") String isbn) {		
		negocioEJB.eliminar(isbn);		
		return "OK";
	}
	
	
	@GET
	@Path("/consultar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Libro> listaLibros(){
		return negocioEJB.listaLibros();
	}
	
	
}
