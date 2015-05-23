package com.om.hibDelete.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.om.hibDelete.dto.PersonDTO;

public class PersonDAO {
	public static void main(String[] args){
		Configuration configuration=new Configuration();
		configuration.configure();
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		try{
			transaction.begin();
		PersonDTO personDTO=(PersonDTO) session.load(PersonDTO.class, 1);
		session.delete(personDTO);
		transaction.commit();
	}catch(HibernateException e){
		transaction.rollback();
		e.printStackTrace();
	}session.close();

}}
