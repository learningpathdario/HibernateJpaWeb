package it.dario.dao;

import java.io.Serializable;
import java.util.List;

import it.dario.bean.Studente;
import it.dario.bean.Utente;

public interface IDaoStudente extends Serializable {

	public int salva(Studente studente);
	public int aggiorna(Studente studente);
	public List<Studente> getLista();
	public Utente getSingolo(Studente studente);
	void delete(Studente studente);
}
