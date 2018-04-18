package it.dario.dao;

import java.io.Serializable;
import java.util.List;

import it.dario.bean.Utente;

public interface IDaoUtente extends Serializable {

	public int salvaUtente(Utente utente);
	public int aggiornaUtente(Utente utente);
	public List<Utente> getUtenti();
	public Utente getUtente(Utente utente);
	void deleteUtente(Utente utente);
}
