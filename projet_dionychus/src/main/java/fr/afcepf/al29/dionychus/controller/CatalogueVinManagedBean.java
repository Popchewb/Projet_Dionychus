package fr.afcepf.al29.dionychus.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fr.afcepf.al29.dionychus.business.itf.IBusinessInventaire;
import fr.afcepf.al29.dionychus.entity.Vin;

@Controller("catalogueVinManagedBean")
@Scope("request")
public class CatalogueVinManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private IBusinessInventaire proxyBusinessInventaire;
	List<Vin> vins;
	String typeArticle;

	public String getTypeArticle() {
		return typeArticle;
	}

	public void setTypeArticle(String typeArticle) {
		this.typeArticle = typeArticle;
	}

	public List<Vin> getVins() {
		return proxyBusinessInventaire.getAllVin();
	}

	public void setVins(List<Vin> vins) {
		this.vins = vins;
	}

}
