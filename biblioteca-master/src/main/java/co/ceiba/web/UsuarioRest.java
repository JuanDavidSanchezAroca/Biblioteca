package co.ceiba.web;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import co.ceiba.entidades.Usuario;
import co.ceiba.negocio.NegocioEJB;

@Path("/usuario")
public class UsuarioRest {

	@Inject
	private NegocioEJB negocioEJB;
	
	@POST
	@Path("/insertar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_HTML)
	public String registrarUsuario(Usuario usuario) {		
		negocioEJB.agregarUsuario(usuario);
		return "OK";
	}
}
