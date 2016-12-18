package fr.afcepf.al29.dionychus.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fr.afcepf.al29.dionychus.business.itf.IBusinessCommandeClient;
import fr.afcepf.al29.dionychus.entity.Adresse;
import fr.afcepf.al29.dionychus.entity.CommandeClient;
import fr.afcepf.al29.dionychus.entity.TypeLivraison;
import fr.afcepf.al29.dionychus.entity.Utilisateur;

@Controller("livraisonManagedBean")
@Scope("request")
public class LivraisonManagedBean implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private IBusinessCommandeClient proxyBusinessCommandeClient;
	
	private Integer idCommande = ((CommandeClient) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("panier")).getIdCommande();
	private List<TypeLivraison> typesLivraison;
	private Integer idTypeLivraison;
	private List<Adresse> adressesLivraison;
	private Integer idClient = ((Utilisateur)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user")).getIdActeur();
	// Pour faire un test de rendu, commenter la ligne au dessus et décommenter celle en dessous.
	// private Integer idClient = 2;
	public String majCommande(Integer paramIdTypeLivraison){
		CommandeClient commandeClient = proxyBusinessCommandeClient.getCommandeById(idCommande);
		proxyBusinessCommandeClient.updateTypeLivraison(commandeClient, paramIdTypeLivraison);
		return "/recapitulatif.jsf?faces-redirect=true";
	}
	
	@PostConstruct
	public void init(){
	typesLivraison = proxyBusinessCommandeClient.getAll();
	adressesLivraison = proxyBusinessCommandeClient.getAdresseByIdActeur(idClient);
	}

	public Integer getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(Integer idCommande) {
		this.idCommande = idCommande;
	}

	public List<TypeLivraison> getTypesLivraison() {
		return typesLivraison;
	}

	public void setTypesLivraison(List<TypeLivraison> typesLivraison) {
		this.typesLivraison = typesLivraison;
	}

	public Integer getIdTypeLivraison() {
		return idTypeLivraison;
	}

	public void setIdTypeLivraison(Integer idTypeLivraison) {
		this.idTypeLivraison = idTypeLivraison;
	}


	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public List<Adresse> getAdressesLivraison() {
		return adressesLivraison;
	}

	public void setAdressesLivraison(List<Adresse> adressesLivraison) {
		this.adressesLivraison = adressesLivraison;
	}
	
	
}
