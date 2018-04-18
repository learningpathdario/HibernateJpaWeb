package it.dario.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table( name = "STUDENTI" )
@SequenceGenerator(sequenceName = "STUDENTE_SEQ",initialValue=1, allocationSize=1, name = "STUDENTE_SEQ")
public class Studente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Studente() {
		// TODO Auto-generated constructor stub
	}
	@Id
    private String matricola;
    private String nome;
    private String cognome;
    private Indirizzo indirizzo;
    
    public String getMatricola() {
        return matricola;
    }

    public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

//	@OneToOne( fetch= FetchType.EAGER )
//  @JoinColumn( name="INDIRIZZO" )
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
    public Indirizzo getIndirizzo() {
        return indirizzo;
    }
    public void setIndirizzo(Indirizzo indirizzo) {
        this.indirizzo = indirizzo;
    }

	@Override
	public String toString() {
		return "Studente [matricola=" + matricola + ", nome=" + nome + ", cognome=" + cognome + ", indirizzo="
				+ indirizzo + "]";
	}
    
}