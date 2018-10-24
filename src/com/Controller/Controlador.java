package com.Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Hibernate.hibernateUtil;

public class Controlador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.close();

	}

}
