package it.dario.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "SUPERMARKET", catalog = "DARIO_DB", uniqueConstraints = {
		@UniqueConstraint(columnNames = "CODE_SUPERMARKET"),
		@UniqueConstraint(columnNames = "NAME_SUPERMARKET") })
@SequenceGenerator(sequenceName = "SUPERMARKET_SEQ",initialValue=1, allocationSize=1, name = "SUPERMARKET_SEQ")
public class Supermarket implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Supermarket() {
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SUPERMARKET_SEQ")
	@Column(name = "SUPERMARKET_ID", unique = true, nullable = false)
	private Long supermarketId;
	
	@Column(name = "CODE_SUPERMARKET")
	private String codeSupermarket;
	
	@Column(name = "NAME_SUPERMARKET")
	private String nameSupermarket;
	

//	private List<Prodotto> prodotti = new ArrayList<Prodotto>(); 
//	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//	@JoinTable(name = "SUPERMARKET_PRODOTTO", catalog = "DARIO_DB", joinColumns = { 
//			@JoinColumn(name = "SUPERMARKET_ID", nullable = false, updatable = false) }, 
//			inverseJoinColumns = { @JoinColumn(name = "PRODOTTO_ID", 
//					nullable = false, updatable = false) })
	@ManyToMany(mappedBy = "supermarkets", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Prodotto> prodotti = new ArrayList<>();

	public Long getSupermarketId() {
		return supermarketId;
	}
	public void setSupermarketId(Long supermarketId) {
		this.supermarketId = supermarketId;
	}
	public String getCodeSupermarket() {
		return codeSupermarket;
	}
	public void setCodeSupermarket(String codeSupermarket) {
		this.codeSupermarket = codeSupermarket;
	}
	public String getNameSupermarket() {
		return nameSupermarket;
	}
	public void setNameSupermarket(String nameSupermarket) {
		this.nameSupermarket = nameSupermarket;
	}

	@Override
	public String toString() {
		return "Supermarket [supermarketId=" + supermarketId + ", codeSupermarket=" + codeSupermarket
				+ ", nameSupermarket=" + nameSupermarket + ", prodotti=" + prodotti + "]";
	}
	
	
	public List<Prodotto> getProdotti() {
		return prodotti;
	}
	public void setProdotti(List<Prodotto> prodotti) {
		this.prodotti = prodotti;
	}
	
	
}