package test;

import org.hibernate.Session;

import dao.HibernateUtil;

public class TestHBM {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession(); //Crea la Session
		session.beginTransaction();//Crea una nueva transacci�n
		session.close(); //Una vez finalizado se deber� cerrar la sesi�n con el m�todo
		System.out.println("OK");
	}
}
