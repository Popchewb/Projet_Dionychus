package fr.afcepf.al29.dionychus.controller;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fr.afcepf.al29.dionychus.business.itf.IBusinessInventaire;
import fr.afcepf.al29.dionychus.entity.Article;

@Controller("detailAccessoireManagedBean")
@Scope("request")
public class DetailAccessoireManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IBusinessInventaire proxyBusinessInventaire;
	
	HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
			.getRequest();

	Integer idArticle = Integer.parseInt(request.getParameter("id"));
	Article article;
	Integer quantite;
	
	public String ajouterPanier() {
		return null;
	}

	public Integer getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(Integer idArticle) {
		this.idArticle = idArticle;
	}
	public Article getArticle() {
		article = proxyBusinessInventaire.getAccessoireById(idArticle);
		article.setCommentaires(proxyBusinessInventaire.getAllByAccessoire(idArticle));
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
	
	

}
