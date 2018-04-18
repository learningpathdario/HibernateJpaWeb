package it.dario.main;

import java.util.ArrayList;
import java.util.List;

import it.dario.bean.Indirizzo;
import it.dario.bean.Libro;
import it.dario.bean.Studente;
import it.dario.bean.Utente;
import it.dario.dao.DaoStudente;
import it.dario.dao.DaoUtente;

public class Start {

	public Start() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Start start = new Start();
//		start.salvaUtente();
//		start.cercaUtente();
//		start.eliminaUtente();
//		start.aggiornaUtente();
		start.salvaStudente();
	}
	
	public void salvaUtente() {
		DaoUtente dao = new DaoUtente();
		Utente utente = new Utente();
//		utente.setId(new Long(100));
		utente.setUsername("superman");
		utente.setEmail("dario@io.com");
//		Libro libro = new Libro();
//		libro.setAutore("io");
//		libro.setTitolo("mio titolo");
//		List<Libro> listaLibri = new ArrayList<>();
//		utente.setListaLibri(listaLibri);
		dao.salvaUtente(utente);
	}
	public void cercaUtente() {
		DaoUtente dao = new DaoUtente();
		Utente utente = new Utente();
//		utente.setId(new Long(100));
//		utente.setUsername("superman");
		utente.setEmail("dario@io.com");
		Utente u = dao.getUtente(utente);
		System.out.println("utente cercato: "+u.toString());
	}
	public void eliminaUtente() {
		DaoUtente dao = new DaoUtente();
		Utente utente = new Utente();
//		utente.setId(new Long(100));
//		utente.setUsername("superman");
		utente.setUsername("superman");
		dao.deleteUtente(utente);
		System.out.println("utente cancellato: "+utente.toString());
	}
	public void aggiornaUtente() {
		DaoUtente dao = new DaoUtente();
		Utente utente = new Utente();
		utente.setId(new Long(67));
		utente.setUsername("sonoio");
		utente.setEmail("sonoio@gmail.com");
		dao.aggiornaUtente(utente);
		System.out.println("utente aggiornato: "+utente.toString());
	}
	
	public void salvaStudente() {
		DaoStudente dao = new DaoStudente();
		Studente studente = new Studente();
		studente.setMatricola("1");
		studente.setCognome("aita");
		studente.setNome("dario");
		Indirizzo indirizzo = new Indirizzo();
		indirizzo.setCap("1234");
		indirizzo.setCitta("rivoli");
		indirizzo.setCivico("5");
		indirizzo.setStrada("via iopiiu");
		indirizzo.setStudente(studente);
		studente.setIndirizzo(indirizzo);

		dao.salva(studente);
	}
}
