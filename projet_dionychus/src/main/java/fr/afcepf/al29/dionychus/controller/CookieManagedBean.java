package fr.afcepf.al29.dionychus.controller;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fr.afcepf.al29.dionychus.business.itf.IBusinessCommandeClient;
import fr.afcepf.al29.dionychus.business.itf.IBusinessCompte;
import fr.afcepf.al29.dionychus.entity.CommandeClient;
import fr.afcepf.al29.dionychus.entity.StatutCommande;
import fr.afcepf.al29.dionychus.entity.Utilisateur;

@Controller("cookieManagedBean")
@Scope("request")
public class CookieManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Autowired
	private IBusinessCommandeClient proxyCommandeClient;

	@Autowired
	private IBusinessCompte proxyCompte;

	private Utilisateur user = new Utilisateur();

	private String bienvenue;

	private String connection_deco;

	private String email;

	private String password;

	private String validationPanier;

	private String onglet_Admin;

	public void init() throws UnsupportedEncodingException {

		String id = null;
		CommandeClient panier;

		Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		CommandeClient panierSession = (CommandeClient)session.get("panier");

		if(panierSession == null){
			Map<String, Object> cookies = FacesContext.getCurrentInstance().getExternalContext().getRequestCookieMap();
			Cookie cookie = (Cookie) cookies.get("idPanier");
			if(cookie != null){
				id = cookie.getValue();
				panier = proxyCommandeClient.getCommandeById(Integer.parseInt(id));
			} else {
				panier = new CommandeClient();
				Calendar c = Calendar.getInstance();
				java.sql.Date date = new java.sql.Date(c.getTimeInMillis());
				panier.setDateCreation(date);
				panier.setNumeroReference(newReference());
				panier = proxyCommandeClient.addPanier(panier);
				Map<String, Object> cookiesResponse = new HashMap<>();
				cookiesResponse.put("maxAge", 31536000);
				cookiesResponse.put("path", "/");
				FacesContext.getCurrentInstance().getExternalContext().addResponseCookie("idPanier", URLEncoder.encode(panier.getIdCommande().toString(), "UTF-8"), cookiesResponse);
			}
			session.put("panier", panier);
		}

	}

	private static SecureRandom random = new SecureRandom();

	public static String newReference() {
		return new BigInteger(48, random).toString(36).toUpperCase();
	}

	public String getBienvenue() {
		String id = null;
		Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		Utilisateur user = (Utilisateur)session.get("user");
		if(user!=null){
			id = user.getPrenom();
		}
		if(id == null){
			return "SE CONNECTER";
		} else {
			String accueil = "Bienvenue " + id;
			return accueil;
		}
	}

	public void setBienvenue(String bienvenue) {
		this.bienvenue = bienvenue;
	}

	public String getConnection_deco() {
		Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		Utilisateur user = (Utilisateur)session.get("user");
		if(user == null){
			return "SeConnecter.jsf";
		} else {
			return "accueil.jsf";
		}
	}

	public void setConnection_deco(String connection_deco) {
		this.connection_deco = connection_deco;
	}

	public String validationPanier() throws UnsupportedEncodingException{
		CommandeClient panier = new CommandeClient();
		Calendar c = Calendar.getInstance();
		java.sql.Date date = new java.sql.Date(c.getTimeInMillis());
		panier.setDateCreation(date);
		panier.setNumeroReference(newReference());
		panier = proxyCommandeClient.addPanier(panier);
		Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		CommandeClient panierValide = (CommandeClient)session.get("panier");
		StatutCommande statutPreparation = proxyCommandeClient.getStatutCommandeById(2);
		panierValide.setStatutCommande(statutPreparation);
		proxyCommandeClient.updatePanierValider(panierValide);

		session.put("panier", panier);

		Map<String, Object> cookiesResponse = new HashMap<>();
		cookiesResponse.put("maxAge", 31536000);
		cookiesResponse.put("path", "/");
		FacesContext.getCurrentInstance().getExternalContext().addResponseCookie("idPanier", URLEncoder.encode(panier.getIdCommande().toString(), "UTF-8"), cookiesResponse);
		return "confirmation_commande.jsf";
	}

	public String connecter(){
		Utilisateur user_connecte = null;
		try {
			user_connecte = proxyCompte.getUserByEmail(email);
		} catch (Exception e){
		}
		if(user_connecte != null){
			if(user_connecte.getPassword().equals(password)){
				Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
				CommandeClient panierUtilisateur = (CommandeClient)session.get("panier");
				session.put("user", user_connecte);
				panierUtilisateur.setUtilisateur(user_connecte);
				proxyCommandeClient.updatePanierRefUtilisateur(panierUtilisateur);
				return "accueil.jsf";
			}
		}
		return null;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getValidationPanier() throws UnsupportedEncodingException {
		CommandeClient panier = new CommandeClient();
		Calendar c = Calendar.getInstance();
		java.sql.Date date = new java.sql.Date(c.getTimeInMillis());
		Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		Utilisateur userConnecte = (Utilisateur)session.get("user");
		panier.setUtilisateur(userConnecte);
		panier.setDateCreation(date);
		panier.setNumeroReference(newReference());
		panier = proxyCommandeClient.addPanierPostCommande(panier);
		CommandeClient panierValide = (CommandeClient)session.get("panier");
		StatutCommande statutPreparation = proxyCommandeClient.getStatutCommandeById(2);
		panierValide.setStatutCommande(statutPreparation);
		proxyCommandeClient.updatePanierValider(panierValide);

		session.put("panier", panier);

		Map<String, Object> cookiesResponse = new HashMap<>();
		cookiesResponse.put("maxAge", 31536000);
		cookiesResponse.put("path", "/");
		FacesContext.getCurrentInstance().getExternalContext().addResponseCookie("idPanier", URLEncoder.encode(panier.getIdCommande().toString(), "UTF-8"), cookiesResponse);
		return "confirmation_commande.jsf";
	}

	public void setValidationPanier(String validationPanier) {
		this.validationPanier = validationPanier;
	}

	public String getOnglet_Admin() {
		Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		Utilisateur userConnecte = (Utilisateur)session.get("user");
		if(userConnecte != null){
			if(userConnecte.getTypeAcces().getLibelle().equals("Administrateur")){
				return "1";
			} else {
				return "2";
			}
		} else {
			return "2";
		}
	}

	public void setOnglet_Admin(String onglet_Admin) {
		this.onglet_Admin = onglet_Admin;
	}
	
	public String verifConnecte() {
		Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		Utilisateur userConnecte = (Utilisateur)session.get("user");
		if(userConnecte != null){
			return "livraison.jsf";
		} else{
			return "SeConnecter.jsf";
		}
	}
	
	public String deconnection() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "accueil.jsf";
	}

}