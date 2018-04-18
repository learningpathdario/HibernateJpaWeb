package it.dario.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import it.dario.bean.Prodotto;
import it.dario.bean.Supermarket;
import it.dario.hibernate.HibernateUtil;


public class MainManytoManySemplice {

	public MainManytoManySemplice() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		MainManytoManySemplice many = new MainManytoManySemplice();
		many.insertSupermercato();
//		Supermarket supermercato = new Supermarket();
//		supermercato.setCodeSupermarket("0002");
//		many.cercaSupermercato(supermercato);
		
		
//		many.cercaSupermercati();
	}
	private void insertSupermercato(){
	       System.out.println("Hibernate many to many (Annotation)");
	   	Session session = HibernateUtil.getSessionFactory().openSession();

	   	session.beginTransaction();

	   	Supermarket supermarket1 = new Supermarket();
	   	supermarket1.setCodeSupermarket("0001");
	   	supermarket1.setNameSupermarket("Carrefour");
//	   	supermarket1.setSupermarketId(new Long(17));
//	   	Supermarket supermarket2 = new Supermarket();
//	   	supermarket2 = cercaSupermercato(supermarket1);
	   	
	    Prodotto prodotto1 = new Prodotto();
	    prodotto1.setProdottoDesc("ttt");
	    prodotto1.setProdottoNome("tttttt");
	    prodotto1.setProdottoPrezzo(800);
	    prodotto1.setProdottoID(new Long(47));

	    List<Prodotto> prodotti = new ArrayList<>();
	    prodotti.add(prodotto1);
	    
	    supermarket1.setProdotti(prodotti);
	    List<Supermarket> supermarkets = new ArrayList<>();
	    supermarkets.add(supermarket1);
	    prodotto1.setSupermarkets(supermarkets);

	    session.merge(supermarket1);
	       
	   	session.getTransaction().commit();
	   	session.close();
	   	System.out.println("Done");
	}
	private void insertProdotto() {
	       System.out.println("Hibernate many to many (Annotation)");
	   	Session session = HibernateUtil.getSessionFactory().openSession();

	   	session.beginTransaction();

	   	Supermarket supermarket1 = new Supermarket();
	   	supermarket1.setCodeSupermarket("0001");
	   	supermarket1.setNameSupermarket("Carrefour");
	   	supermarket1.setSupermarketId(new Long(17));
//	   	Supermarket supermarket2 = new Supermarket();
//	   	supermarket2 = cercaSupermercato(supermarket1);
	   	
	    Prodotto prodotto1 = new Prodotto();
	    prodotto1.setProdottoDesc("ttt");
	    prodotto1.setProdottoNome("tttttt");
	    prodotto1.setProdottoPrezzo(800);
	    
//	    Prodotto prodotto2 = new Prodotto();
//	    prodotto2.setProdottoDesc("biscotti mulino bianco");
//	    prodotto2.setProdottoNome("biscotti");
//	    prodotto2.setProdottoPrezzo(5);
	    
//	    Set<Prodotto> prodotti = new HashSet<Prodotto>();
	    List<Prodotto> prodotti = new ArrayList<>();
	    prodotti.add(prodotto1);
//	    prodotti.add(prodotto2);
	    
	    supermarket1.setProdotti(prodotti);
	    List<Supermarket> supermarkets = new ArrayList<>();
	    supermarkets.add(supermarket1);
	    prodotto1.setSupermarkets(supermarkets);
//	    session.persist(supermarket1);
//	    session.save(supermarket1);
//	    session.save(prodotto1);
//	    session.merge(supermarket1);
	    session.merge(supermarket1);
//	    session.save(prodotto1);
	  
	    
//	    session.flush();
//	    session.update(supermarket1);
//	    session.merge(supermarket1);
	       
	   	session.getTransaction().commit();
	   	session.close();
	   	System.out.println("Done");
	}
	
	private Supermarket cercaSupermercato(Supermarket supermercato) {
		Session session = HibernateUtil.getSessionFactory().openSession();
	    session.beginTransaction();
 
	    @SuppressWarnings("unchecked")
		Query<Supermarket> query = session.createQuery(" from Supermarket where SUPERMARKET_ID=:CODE");
        query.setParameter("CODE", supermercato.getSupermarketId());
        Supermarket singoloSupermarket = (Supermarket) query.uniqueResult();
        System.out.println("singoloSupermarket = " + singoloSupermarket.toString() );
 
        session.close();
        return singoloSupermarket;
		
	}
	private void cercaSupermercati() {
		Session session = HibernateUtil.getSessionFactory().openSession();
	    session.beginTransaction();
 
	    @SuppressWarnings("unchecked")
		Query<Supermarket> query = session.createQuery(" from Supermarket ");
       
        List<Supermarket> listaSupermercati = (List<Supermarket>) query.getResultList();
        
    	for(Supermarket supermercato : listaSupermercati) {
    		System.out.println("mio supermercato:"+supermercato.toString());
    	}
 
        session.close();

		
	}
}
