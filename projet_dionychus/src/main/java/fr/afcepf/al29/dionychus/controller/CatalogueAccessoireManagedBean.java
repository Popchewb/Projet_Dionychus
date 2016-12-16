package fr.afcepf.al29.dionychus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fr.afcepf.al29.dionychus.business.itf.IBusinessInventaire;
import fr.afcepf.al29.dionychus.entity.Accessoire;

@Controller("catalogueAccessoireManagedBean")
@Scope("request")
public class CatalogueAccessoireManagedBean {

	@Autowired
	private IBusinessInventaire proxyBusinessInventaire;
	List<Accessoire> accessoires;

	public List<Accessoire> getAccessoires() {
		return proxyBusinessInventaire.getAllAccessoire();
	}

	public void setAccessoires(List<Accessoire> accessoires) {
		this.accessoires = accessoires;
	}

}
