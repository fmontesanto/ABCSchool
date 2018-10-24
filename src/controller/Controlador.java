package controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import hibernate.hibernateUtil;

public class Controlador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//this is a comment lolololol
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.close();
		System.exit(0);

	}

}
