package fr.afcepf.al29.dionychus.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

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
	
	private HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
			.getRequest();
	private Integer idPanier = Integer.parseInt(request.getParameter("id"));
	private CommandeClient commandeClient;
	private List<LigneCommande> lignesCommande;
	private Double totalCommande = 0.00;
	private Integer quantiteArticle = 0;
	
	
	
	public PanierManagedBean() {
		super();		
	}
	
	@PostConstruct
	public void init(){
		lignesCommande = proxyBusinessCommandeClient.getAllLigneCommandeByIdCommande(idPanier);
		for (LigneCommande ligneCommande : lignesCommande) {
			totalCommande += ligneCommande.getArticle().getPrix() * ligneCommande.getQuantite();
			quantiteArticle += ligneCommande.getQuantite();
		}
	}
	
	public String deleteLigne(LigneCommande lc){
		proxyBusinessCommandeClient.deleteLigneCommande(lc.getIdLigneCommande());
		init();
		return null;
	}
	
	public Integer getIdPanier() {
		return idPanier;
	}
	public void setIdPanier(Integer idPanier) {
		this.idPanier = idPanier;
	}
	public CommandeClient getCommandeClient() {
		return (CommandeClient) proxyBusinessCommandeClient.getCommandeById(idPanier);
	}
	public void setCommandeClient(CommandeClient commandeClient) {
		this.commandeClient = commandeClient;
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
