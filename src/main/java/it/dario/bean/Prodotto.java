package it.dario.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "PRODOTTO", catalog = "DARIO_DB")
@SequenceGenerator(sequenceName = "PRODOTTO_SEQ",initialValue=1, allocationSize=1, name = "PRODOTTO_SEQ")
public class Prodotto implements Serializable {

	private static final long serialVersionUID = 1L;

	public Prodotto() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODOTTO_SEQ")
	@Column(name = "PRODOTTO_ID")
	private Long prodottoID;
	

	@Column(name = "PRODOTTO_NOME")
	private String prodottoNome;
	@Column(name = "PRODOTTO_DESC")
	private String prodottoDesc;
	@Column(name = "PRODOTTO_PREZZO")
	private float prodottoPrezzo;
	
	//@ManyToMany(fetch = FetchType.LAZY, mappedBy = "prodotti")
//	private Set<Supermarket> supermarkets = new HashSet<Supermarket>(0);
//	@ManyToMany(mappedBy = "prodotti")
//	@JoinTable(name = "SUPERMARKET_PRODOTTO", catalog = "DARIO_DB", joinColumns = { 
//			@JoinColumn(name = "PRODOTTO_ID", nullable = false, updatable = false) }, 
//			inverseJoinColumns = { @JoinColumn(name = "SUPERMARKET_ID", 
//					nullable = false, updatable = false) })
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
@JoinTable(name = "SUPERMARKET_PRODOTTO",joinColumns = {
		@JoinColumn(name = "PRODOTTO_ID", referencedColumnName = "PRODOTTO_ID")},
inverseJoinColumns = {
    @JoinColumn(name = "SUPERMARKET_ID", referencedColumnName = "SUPERMARKET_ID")})
	private List<Supermarket> supermarkets = new ArrayList<>();

	public Long getProdottoID() {
		return prodottoID;
	}
	public void setProdottoID(Long prodottoID) {
		this.prodottoID = prodottoID;
	}
	public String getProdottoNome() {
		return prodottoNome;
	}
	public void setProdottoNome(String prodottoNome) {
		this.prodottoNome = prodottoNome;
	}
	public String getProdottoDesc() {
		return prodottoDesc;
	}
	public void setProdottoDesc(String prodottoDesc) {
		this.prodottoDesc = prodottoDesc;
	}
	public float getProdottoPrezzo() {
		return prodottoPrezzo;
	}
	public void setProdottoPrezzo(float prodottoPrezzo) {
		this.prodottoPrezzo = prodottoPrezzo;
	}
	
	@Override
	public String toString() {
		return "Prodotto [prodottoID=" + prodottoID + ", prodottoNome=" + prodottoNome + ", prodottoDesc="
				+ prodottoDesc + ", prodottoPrezzo=" + prodottoPrezzo + "]";
	}
	public List<Supermarket> getSupermarkets() {
		return supermarkets;
	}
	public void setSupermarkets(List<Supermarket> supermarkets) {
		this.supermarkets = supermarkets;
	}
	
}