package fr.afcepf.al29.dionychus.controller;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fr.afcepf.al29.dionychus.business.itf.IBusinessCommandeClient;
import fr.afcepf.al29.dionychus.business.itf.IBusinessInventaire;
import fr.afcepf.al29.dionychus.entity.Article;


@Controller("detailProduitManagedBean")
@Scope("request")
public class DetailProduitManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private IBusinessInventaire proxyBusinessInventaire;
	@Autowired
	private IBusinessCommandeClient proxyCommandeClient;
	
	HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
	        .getRequest();

	Integer idArticle = Integer.parseInt(request.getParameter("id"));
	String typeArticle = request.getParameter("typeArticle");
	Article article;


	public IBusinessInventaire getProxyInventaire() {
		return proxyBusinessInventaire;
	}

	public void setProxyInventaire(IBusinessInventaire proxyInventaire) {
		this.proxyBusinessInventaire = proxyInventaire;
	}

	public IBusinessCommandeClient getProxyCommandeClient() {
		return proxyCommandeClient;
	}

	public void setProxyCommandeClient(IBusinessCommandeClient proxyCommandeClient) {
		this.proxyCommandeClient = proxyCommandeClient;
	}

	public Integer getIdArticle() {
		
		return idArticle;
	}

	public void setIdArticle(Integer idArticle) {
		this.idArticle = idArticle;
	}

	public String getTypeArticle() {
		return typeArticle;
	}

	public void setTypeArticle(String typeArticle) {
		this.typeArticle = typeArticle;
	}

	public Article getArticle() {
		if (typeArticle.equals("Accessoire")) {
			article = proxyBusinessInventaire.getAccessoireById(idArticle);
			article.setCommentaires(proxyBusinessInventaire.getAllByAccessoire(idArticle));
		} else if (typeArticle.equals("Vin")) {
			System.out.println("vin");
			article = proxyBusinessInventaire.getVinById(idArticle);
			System.out.println(article);
			article.setCommentaires(proxyBusinessInventaire.getAllByVin(idArticle));
		}
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

}
