package fr.afcepf.al29.dionychus.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fr.afcepf.al29.dionychus.business.itf.IBusinessInventaire;
import fr.afcepf.al29.dionychus.entity.Article;

@Controller("accueilManagedBean")
@Scope("request")
public class AccueilManagedBean {
	
	@Autowired
	private IBusinessInventaire proxyBusinessInventaire;
	private List<Article> top4Accessoires;
	private List<Article> top4Vins;
	
	@PostConstruct
	public void init(){
		top4Accessoires = proxyBusinessInventaire.getBestSellerAccessoire();
		top4Vins = proxyBusinessInventaire.getBestSellerVin();
	}

	public IBusinessInventaire getProxyBusinessInventaire() {
		return proxyBusinessInventaire;
	}

	public void setProxyBusinessInventaire(IBusinessInventaire proxyBusinessInventaire) {
		this.proxyBusinessInventaire = proxyBusinessInventaire;
	}

	public List<Article> getTop4Accessoires() {
		return top4Accessoires;
	}

	public void setTop4Accessoires(List<Article> top4Accessoires) {
		this.top4Accessoires = top4Accessoires;
	}

	public List<Article> getTop4Vins() {
		return top4Vins;
	}

	public void setTop4Vins(List<Article> top4Vins) {
		this.top4Vins = top4Vins;
	}

	
	
}

