package fr.afcepf.al29.dionychus.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fr.afcepf.al29.dionychus.business.itf.IBusinessInventaire;
import fr.afcepf.al29.dionychus.entity.Accessoire;
import fr.afcepf.al29.dionychus.entity.Vin;

@Controller("inventaireManagedBean")
@Scope("request")
public class InventaireManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IBusinessInventaire proxyInventaire;
	
	private List<Accessoire> accessoires;

	private List<Vin> vins;
	
	public List<Accessoire> getAccessoires() {
		return proxyInventaire.getAllAccessoires();
	}

	public void setAccessoires(List<Accessoire> accessoires) {
		this.accessoires = accessoires;
	}

	public List<Vin> getVins() {
		return proxyInventaire.getAllVins();
	}

	public void setVins(List<Vin> vins) {
		this.vins = vins;
	}
	
}
