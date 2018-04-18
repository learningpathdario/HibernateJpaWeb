package it.dario.dao;

import java.util.List;

import org.hibernate.Session;

import it.dario.bean.Studente;
import it.dario.bean.Utente;
import it.dario.hibernate.HibernateUtil;

public class DaoStudente implements IDaoStudente {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int salva(Studente studente) {
		System.out.println("salva studente");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		session.save(studente);
		session.getTransaction().commit();
		session.close();
		return 0;
	}

	@Override
	public int aggiorna(Studente studente) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Studente> getLista() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utente getSingolo(Studente studente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Studente studente) {
		// TODO Auto-generated method stub
		
	}

}
