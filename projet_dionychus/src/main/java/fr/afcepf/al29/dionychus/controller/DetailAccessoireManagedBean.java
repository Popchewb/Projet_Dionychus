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
import fr.afcepf.al29.dionychus.business.itf.IBusinessInventaire;
import fr.afcepf.al29.dionychus.entity.Article;
import fr.afcepf.al29.dionychus.entity.CommandeClient;
import fr.afcepf.al29.dionychus.entity.LigneCommande;

@Controller("detailAccessoireManagedBean")
@Scope("request")
public class DetailAccessoireManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IBusinessInventaire proxyBusinessInventaire;
	@Autowired
	private IBusinessCommandeClient proxyCommandeClient;
	
	HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
			.getRequest();

	private Integer idArticle = Integer.parseInt(request.getParameter("id"));
	private Article article;
	private Integer quantite = 1;
	private Integer idCommande = ((CommandeClient) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("panier")).getIdCommande();
	private List<Article> articlesAssocies;
	
	@PostConstruct
	public void init() {
		article = proxyBusinessInventaire.getAccessoireById(idArticle);
		article.setCommentaires(proxyBusinessInventaire.getAllByAccessoire(idArticle));
		articlesAssocies = proxyBusinessInventaire.getArticlesAssocies(idArticle);
	}
	
	public String ajouterPanier() {
		Boolean estDeja = false;
		List<LigneCommande> lignesCommande = proxyCommandeClient.getAllLigneCommandeByIdCommande(idCommande);
		LigneCommande ligneDejaCree = null;
		for (LigneCommande ligneCommande : lignesCommande) {
			if(ligneCommande.getArticle().getIdArticle() == idArticle){
				estDeja = true;
				ligneDejaCree = ligneCommande;
			}
		}
		if(estDeja){
			ligneDejaCree.setQuantite(ligneDejaCree.getQuantite()+quantite);
			proxyCommandeClient.updateLigneCommande(ligneDejaCree);
		} else {
		LigneCommande lc = new LigneCommande(null, quantite, article);
		proxyCommandeClient.addLigneCommande(lc, idCommande);
		}
		String url = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/panier.jsf";
		quantite = 1;
		return url;
	}

	public Integer getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(Integer idArticle) {
		this.idArticle = idArticle;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public Integer getQuantite() {
		return quantite;
	}
	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public Integer getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(Integer idCommande) {
		this.idCommande = idCommande;
	}

	public List<Article> getArticlesAssocies() {
		return articlesAssocies;
	}

	public void setArticlesAssocies(List<Article> articlesAssocies) {
		this.articlesAssocies = articlesAssocies;
	}
	
	

}
