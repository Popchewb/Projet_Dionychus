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

@Controller("panierManagedBean")
@Scope("request")
public class PanierManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private IBusinessCommandeClient proxyBusinessCommandeClient;

	private Integer idPanier = ((CommandeClient) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
			.get("panier")).getIdCommande();
	private List<LigneCommande> lignesCommande;
	private Double totalCommande;
	private Integer quantiteArticle;

	public PanierManagedBean() {
		super();
	}

	@PostConstruct
	public void init() {
		lignesCommande = proxyBusinessCommandeClient.getAllLigneCommandeByIdCommande(idPanier);
		totalCommande = 0d;
		quantiteArticle = 0;
		for (LigneCommande ligneCommande : lignesCommande) {
			totalCommande += ligneCommande.getArticle().getPrix() * ligneCommande.getQuantite();
			quantiteArticle += ligneCommande.getQuantite();
		}
	}

	public String deleteLigne(LigneCommande lc) {
		proxyBusinessCommandeClient.deleteLigneCommande(lc.getIdLigneCommande());
		init();
		String url = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/panier.jsf";
		return url;
	}

	public String retourAccueil() {
		return "http://localhost:8080/Projet_Dionychus/accueil.jsf";
	}

	public String updatePanier() {

		for (LigneCommande ligneCommande : lignesCommande) {
			System.out.println(ligneCommande.getQuantite());
			proxyBusinessCommandeClient.updateLigneCommande(ligneCommande);
		}
		init();
		String url = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/panier.jsf";
		return url;
	}

	public Integer getIdPanier() {
		return idPanier;
	}

	public void setIdPanier(Integer idPanier) {
		this.idPanier = idPanier;
	}

	public List<LigneCommande> getLignesCommande() {
		return lignesCommande;
	}

	public void setLignesCommande(List<LigneCommande> lignesCommande) {
		this.lignesCommande = lignesCommande;
	}

	public Double getTotalCommande() {
		return totalCommande;
	}

	public void setTotalCommande(Double totalCommande) {
		this.totalCommande = totalCommande;
	}

	public Integer getQuantiteArticle() {
		return quantiteArticle;
	}

	public void setQuantiteArticle(Integer quantiteArticle) {
		this.quantiteArticle = quantiteArticle;
	}

}
