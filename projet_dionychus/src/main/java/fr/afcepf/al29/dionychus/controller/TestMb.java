package fr.afcepf.al29.dionychus.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fr.afcepf.al29.dionychus.business.itf.IBusinessCompte;
import fr.afcepf.al29.dionychus.entity.Adresse;
import fr.afcepf.al29.dionychus.entity.Commentaire;

@Controller
@Scope("request")
public class TestMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private IBusinessCompte proxyCompte;

	private Adresse adresse;

	private List<Adresse> adresses;

	private Integer paramIdAdresse;

	private Integer paramIdActeur;

	private Integer paramIdUtilisateur;

	private Commentaire commentaire;

	private List<Commentaire> commentaires;

	public String getAdresseById() {
		adresse = proxyCompte.getAdresseById(paramIdAdresse);
		return null;
	}

	public String getAdresseIdByActeur() {
		adresses = proxyCompte.getAdresseByIdActeur(2);
		return null;
	}

	public String delete() {
		proxyCompte.deleteAdresse(paramIdAdresse);
		return null;
	}

	public IBusinessCompte getProxyCompte() {
		return proxyCompte;
	}

	public void setProxyCompte(IBusinessCompte proxyCompte) {
		this.proxyCompte = proxyCompte;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Adresse> getAdresses() {
		return proxyCompte.getAllAdresse();
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}

	public Integer getParamIdAdresse() {
		return paramIdAdresse;
	}

	public void setParamIdAdresse(Integer paramIdAdresse) {
		this.paramIdAdresse = paramIdAdresse;
	}

	public Integer getParamIdActeur() {
		return paramIdActeur;
	}

	public void setParamIdActeur(Integer paramIdActeur) {
		this.paramIdActeur = paramIdActeur;
	}

	public Integer getParamIdUtilisateur() {
		return paramIdUtilisateur;
	}

	public void setParamIdUtilisateur(Integer paramIdUtilisateur) {
		this.paramIdUtilisateur = paramIdUtilisateur;
	}

	public Commentaire getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(Commentaire commentaire) {
		this.commentaire = commentaire;
	}

	public List<Commentaire> getCommentaires() {
		System.out.println("je passe dans TestMB getCommentaires()");
		System.out.println(paramIdUtilisateur);
		return proxyCompte.getAllCommentaireByUtilisateur(3);
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

}