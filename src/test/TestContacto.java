package test;

import negocio.ClienteABM;
import negocio.ContactoABM;

public class TestContacto {

	public static void main(String[] args) {
		
		ClienteABM cABM = new ClienteABM();
		ContactoABM sistema = new ContactoABM();
		
		//Test  *******************************
		
				try {
					
					System.out.println("");
					
					System.out.println("Test 1: Agregar un contacto a un cliente");	
					sistema.agregar("mail@gmail.com", "1520","4214" ,cABM.traerId(1));
					//Cambiar Id cada vez que se agrega o salta la excepcion
					System.out.println("OK");	
					
					}
				
					catch(Exception e) 
					{
						System.out.println("Exception: "+e.getMessage());
					}
				
				//Test  *******************************
				
				try {
					
					System.out.println("");	
					
					System.out.println("Test 2: Mostrar Contacto agregado CU 1");	
					System.out.println(sistema.traer(1));
					System.out.println("OK");
					
					}
				
					catch(Exception e) 
					{
						System.out.println("Exception: "+e.getMessage());
					}				
	
	}

}
