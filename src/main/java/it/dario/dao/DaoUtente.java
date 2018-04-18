package it.dario.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import it.dario.bean.Utente;
import it.dario.hibernate.HibernateUtil;

public class DaoUtente implements IDaoUtente {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DaoUtente() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int salvaUtente(Utente utente) {
		System.out.println("Maven + Hibernate + Oracle");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		session.save(utente);
		session.getTransaction().commit();
		session.close();
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int aggiornaUtente(Utente utente) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query<Utente> query=session.createQuery("update Utente set email=:email, username=:username where id=:id");  
		query.setParameter("email", utente.getEmail());
		query.setParameter("id", utente.getId());
		query.setParameter("username", utente.getUsername());
		//specifying class name (Emp) not tablename  
		query.executeUpdate(); 
	    session.getTransaction().commit();
	    session.close();
		return 0;
	}

	@Override
	public List<Utente> getUtenti() {
		Session session = HibernateUtil.getSessionFactory().openSession();
	    session.beginTransaction();
	 
	    @SuppressWarnings("unchecked")
	    List<Utente> listaUtenti = (List<Utente>) session.createQuery("FROM UTENTE u ORDER BY u.id ASC").list();
	 
	    session.getTransaction().commit();
	    
	    session.close();
		return listaUtenti;
	}

	@Override
	public Utente getUtente(Utente utente) {
	    
		Session session = HibernateUtil.getSessionFactory().openSession();
	    session.beginTransaction();
 
	    @SuppressWarnings("unchecked")
		Query<Utente> query = session.createQuery(" from Utente where username=:username");
        query.setParameter("username", "dario");
        Utente singoloUtente = (Utente) query.uniqueResult();
        System.out.println("singoloUtente = " + singoloUtente.toString() );
 
        session.close();

		return singoloUtente;
	}

	@Override
	public void deleteUtente(Utente utente) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query=session.createQuery("delete from Utente where username=:username");  
		query.setParameter("username", utente.getUsername());
		//specifying class name (Emp) not tablename  
		query.executeUpdate(); 
	    session.getTransaction().commit();
	    session.close();

	}

}
