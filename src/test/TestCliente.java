package test;

import datos.Cliente;
import negocio.ClienteABM;

public class TestCliente {

	public static void main(String[] args) {
		
		ClienteABM sistema = new ClienteABM();
		
		//Test  *******************************
		
		try {
			
			System.out.println("");
			
			System.out.println("Test 1: Traer un cliente");	
			System.out.println(sistema.traerId(1));
			System.out.println("OK");	
			
			}
		
			catch(Exception e) 
			{
				System.out.println("Exception: "+e.getMessage());
			}
		
		//Test  *******************************
		
		try {
			
			System.out.println("");	
			
			System.out.println("Test 2: Traer un cliente y su contacto");
			Cliente objeto = sistema.traerClienteYContacto(1);
			
			System.out.println("Cliente: " + objeto);
			System.out.println("Contacto: " + objeto.getContacto());
			
			System.out.println("OK");
			
			}
		
			catch(Exception e) 
			{
				System.out.println("Exception: "+e.getMessage());
			}
		
	}

}
