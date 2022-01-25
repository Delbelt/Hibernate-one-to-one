package negocio;

import dao.ContactoDao;
import datos.Cliente;
import datos.Contacto;

public class ContactoABM {
	
	ContactoDao dao = new ContactoDao();
	
	public int agregar(String email, String movil, String fijo, Cliente cliente) throws Exception
	{		
		if(dao.traer(cliente.getIdCliente()) != null)
		throw new Exception("No se puede agregar el contacto al cliente, ya se encuentra en la bd");
		
		//Comparten la misma ID (Cliente y Contacto) por ende, si no es null el Contacto que trae ese ID no puede guardarse el Contacto
		
		return dao.agregar(new Contacto(email, movil, fijo, cliente));		
	}
	
	public void modificar(Contacto contacto) throws Exception
	{		
		//if(dao.traer(contacto.getIdContacto()) != null) 
		//throw new Exception("No se puede actualizar el contacto, ya se encuentra en la bd");	
		
		dao.actualizar(contacto);
	}
	
	public void eliminar(long idContacto) throws Exception
	{		
		if(dao.traer(idContacto) == null) 
		throw new Exception("No se puede borrar el contacto, no existe");
		
		dao.eliminar(dao.traer(idContacto));		
	}
	
	public Contacto traer(long idContacto)
	{		
		return dao.traer(idContacto);
	}
}
