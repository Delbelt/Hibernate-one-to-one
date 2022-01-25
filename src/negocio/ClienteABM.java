package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {
	
	ClienteDao dao = new ClienteDao();
	
	public int agregar(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento) throws Exception
	{		
		if(dao.traer(dni) != null)
		throw new Exception("No se puede agregar el cliente, el dni "+ dni +" ya se encuentra registrado");	
		
		return dao.agregar(new Cliente(apellido, nombre, dni, fechaDeNacimiento));
	}

	public void modificar(Cliente cliente) throws Exception
	{		
		Cliente objeto = dao.traerId(cliente.getIdCliente()); //Traigo el cliente por id
		
		if(objeto != null && objeto.getIdCliente() != dao.traer(cliente.getDni()).getIdCliente())
		//Si el objeto que traemos por Id es el MISMO que traerlo por Documento, significa que son la MISMA persona
		//Y que no se manipulo el DNI, por ende, cambio algo mas, pero no el DNI, si esto no es asi, no se puede actualizar
		//Porque consideraria que si el DNI en la BD existe, no se puede actualizar, cosa que es un ERROR!
		//Porque si tipeamos mal el nombre, y solo queremos cambiar el NOMBRE, no podriamos...porque el DNI ya existe registrado...
		throw new Exception("No se puede actualizar el cliente debido a que ese dni " + cliente.getDni() + " ya se encuentra registrado");	
		
		dao.actualizar(cliente);
	}

	public void eliminar(long idCliente) throws Exception
	{
		if(dao.traerId(idCliente) == null) 
		throw new Exception("No se puede borrar el cliente, no existe en la bd");
		
		//Opcion 1:
		//if(dao.traerId(idCliente).getContacto() != null)
		//throw new Exception("No se puede borrar el cliente, se debe eliminar primero su contacto");
		
		//Opcion 2:
		//A traves de un ContactoDao eliminar el contacto ¿Se puede hacer en el mapeo con el cascade? Seguramente.
		//Ver mas adelante

		dao.eliminar(dao.traerId(idCliente));
	}
	
	public Cliente traerId(long idCliente)
	{
		return dao.traerId(idCliente);
	}

	public Cliente traer(int dni)
	{
		return dao.traer(dni);
	}

	public List<Cliente> traer()
	{		
		return dao.traer();
	}
	
	public Cliente traerClienteYContacto(long idCliente)
	{		
		return dao.traerClienteYContacto(idCliente);		
	}
}
