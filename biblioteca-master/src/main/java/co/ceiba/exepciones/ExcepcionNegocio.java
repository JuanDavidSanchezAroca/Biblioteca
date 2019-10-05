package co.ceiba.exepciones;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class ExcepcionNegocio extends RuntimeException {
	
	public ExcepcionNegocio(String mensaje) {
		// TODO Auto-generated constructor stub
		super(mensaje);
	}
}
