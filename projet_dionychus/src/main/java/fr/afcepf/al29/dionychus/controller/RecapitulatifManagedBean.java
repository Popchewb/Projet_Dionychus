package fr.afcepf.al29.dionychus.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fr.afcepf.al29.dionychus.business.itf.IBusinessCommandeClient;
import fr.afcepf.al29.dionychus.entity.CommandeClient;
import fr.afcepf.al29.dionychus.entity.LigneCommande;

@Controller("recapManagedBean")
@Scope("request")
public class RecapitulatifManagedBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Autowired
	IBusinessCommandeClient proxyBusinessCommandeClient;
	
	private Integer idCommande = ((CommandeClient) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
			.get("panier")).getIdCommande();
	private List<LigneCommande> lignesCommande;
	private Double totalCommande = 0d;
	private Double tarifLivraison = 0d;
	
	@PostConstruct
	public void init(){
		System.out.println("dans recap idCommande =" + idCommande);
		lignesCommande = proxyBusinessCommandeClient.getAllLigneCommandeByIdCommande(idCommande);
		for (LigneCommande ligneCommande : lignesCommande) {
			totalCommande += ligneCommande.getArticle().getPrix() * ligneCommande.getQuantite();
			System.out.println("Totalcommande = "+totalCommande);
		}
	}
	
	public Integer getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(Integer idCommande) {
		this.idCommande = idCommande;
	}
	public Double getTotalCommande() {
		return totalCommande;
	}
	public void setTotalCommande(Double totalCommande) {
		this.totalCommande = totalCommande;
	}

	public List<LigneCommande> getLignesCommande() {
		return lignesCommande;
	}

	public void setLignesCommande(List<LigneCommande> lignesCommande) {
		this.lignesCommande = lignesCommande;
	}

	public Double getTarifLivraison() {
		tarifLivraison = proxyBusinessCommandeClient.getTarifLivraisonByIdCommande(idCommande);
		return tarifLivraison;
	}

	public void setTarifLivraison(Double tarifLivraison) {
		this.tarifLivraison = tarifLivraison;
	}
	
	
	
	
}
