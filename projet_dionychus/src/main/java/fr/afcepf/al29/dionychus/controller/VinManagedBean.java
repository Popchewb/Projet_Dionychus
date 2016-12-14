package fr.afcepf.al29.dionychus.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.stereotype.Controller;

import fr.afcepf.al29.dionychus.entity.Arome;
import fr.afcepf.al29.dionychus.entity.Cepage;
import fr.afcepf.al29.dionychus.entity.TypeVin;

@RequestScoped
@ManagedBean
@Controller
public class VinManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<TypeVin> typeVins = null;

	private TypeVin typeVin;
	
	private Double prix;
	
	private Arome arome;
	
	private List<Arome> aromes;
	
	private Cepage cepage;
	
	private List<Cepage> cepages;
	
	public String rechercher() {
		return null;
	}
	
	public List<TypeVin> getTypeVins() {
		return typeVins;
	}

	public void setTypeVins(List<TypeVin> typeVins) {
		this.typeVins = typeVins;
	}

	public TypeVin getTypeVin() {
		return typeVin;
	}

	public void setTypeVin(TypeVin typeVin) {
		this.typeVin = typeVin;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Arome getArome() {
		return arome;
	}

	public void setArome(Arome arome) {
		this.arome = arome;
	}

	public List<Arome> getAromes() {
		return aromes;
	}

	public void setAromes(List<Arome> aromes) {
		this.aromes = aromes;
	}

	public Cepage getCepage() {
		return cepage;
	}

	public void setCepage(Cepage cepage) {
		this.cepage = cepage;
	}

	public List<Cepage> getCepages() {
		return cepages;
	}

	public void setCepages(List<Cepage> cepages) {
		this.cepages = cepages;
	}
	
	

}
