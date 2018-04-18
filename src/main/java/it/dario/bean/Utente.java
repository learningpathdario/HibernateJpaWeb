package it.dario.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Utente
 *
 */
@Entity
@SequenceGenerator(sequenceName = "SEQ_UTENTE",initialValue=1, allocationSize=1, name = "SEQ_UTENTE")
public class Utente implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Utente() {
//		listaLibri = new ArrayList<Libro>();
	}
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_UTENTE")
	  private Long id;
	  
	  private String username;
	  private String email;
//	  @OneToMany(mappedBy="libro")
//	  private List<Libro> listaLibri;
	  
	  

//	public List<Libro> getListaLibri() {
//		return listaLibri;
//	}
//	public void setListaLibri(List<Libro> listaLibri) {
//		this.listaLibri = listaLibri;
//	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Utente [id=" + id + ", username=" + username + ", email=" + email + "]";
	}
  
}
