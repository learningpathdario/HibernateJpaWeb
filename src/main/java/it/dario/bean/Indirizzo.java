package it.dario.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table( name = "INDIRIZZI" )
@SequenceGenerator(sequenceName = "INDIRIZZO_SEQ",initialValue=1, allocationSize=1, name = "INDIRIZZO_SEQ")
public class Indirizzo implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
    private String strada;
    private String civico;
    private String cap;
    private String citta;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="INDIRIZZO")
    private Studente studente;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INDIRIZZO_SEQ")
    public Integer getId() {
        return id;
    }

    public String getStrada() {
		return strada;
	}

	public void setStrada(String strada) {
		this.strada = strada;
	}

	public String getCivico() {
		return civico;
	}

	public void setCivico(String civico) {
		this.civico = civico;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	@OneToOne( mappedBy = "indirizzo" )
//	@OneToOne(fetch = FetchType.LAZY, mappedBy = "indirizzo", cascade = CascadeType.ALL)

    public Studente getStudente() {
        return studente;
    }
    public void setStudente(Studente studente) {
        this.studente = studente;
    }

	@Override
	public String toString() {
		return "Indirizzo [id=" + id + ", strada=" + strada + ", civico=" + civico + ", cap=" + cap + ", citta=" + citta
				+ ", studente=" + studente + "]";
	}
    
}