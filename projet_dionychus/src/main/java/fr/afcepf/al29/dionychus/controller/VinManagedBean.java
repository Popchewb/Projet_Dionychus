package fr.afcepf.al29.dionychus.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fr.afcepf.al29.dionychus.business.itf.IBusinessInventaire;
import fr.afcepf.al29.dionychus.entity.Arome;
import fr.afcepf.al29.dionychus.entity.Cepage;
import fr.afcepf.al29.dionychus.entity.TypeVin;

@Controller("vinManagedBean")
@Scope("request")
public class VinManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IBusinessInventaire proxyInventaire;
	
	private List<TypeVin> typeVins = null;

	private TypeVin typeVin;
	
	private Double prix;
	
	private List<Arome> aromes;
	
	private List<Cepage> cepages;
	
	public String rechercher() {
		return null;
	}
	
	public List<TypeVin> getTypeVins() {
		return proxyInventaire.getAllTypeVins();
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

	public List<Arome> getAromes() {
		return proxyInventaire.getAllAromes();
	}

	public void setAromes(List<Arome> aromes) {
		this.aromes = aromes;
	}

	public List<Cepage> getCepages() {
		return proxyInventaire.getAllCepages();
	}

	public void setCepages(List<Cepage> cepages) {
		this.cepages = cepages;
	}
	
	

}
