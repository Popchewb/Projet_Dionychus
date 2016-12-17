package fr.afcepf.al29.dionychus.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
@Scope("session")
public class CookieManagedBean {

	@Autowired
	private IBusinessCommandeClient proxyCommandeClient;

	@Autowired
	private IBusinessCompte proxyCompte;

	private Utilisateur user = new Utilisateur();

	private String bienvenue;

	private String connection_deco;

	private String email;

	private String password;

	private String deco;

	public void init() throws UnsupportedEncodingException {

		String id = null;
		CommandeClient panier;

		Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		CommandeClient panierSession = (CommandeClient)session.get("panier");
		
		if(panierSession == null){
			System.out.println("panier session null");
			Map<String, Object> cookies = FacesContext.getCurrentInstance().getExternalContext().getRequestCookieMap();
			Cookie cookie = (Cookie) cookies.get("idPanier");
			if(cookie != null){
				System.out.println("cookie non null");
				id = cookie.getValue();
				panier = proxyCommandeClient.getCommandeById(Integer.parseInt(id));
			} else {
				System.out.println("cooki null");
				panier = new CommandeClient();
				Calendar c = Calendar.getInstance();
				java.sql.Date date = new java.sql.Date(c.getTimeInMillis());
				panier.setDateCreation(date);
				panier = proxyCommandeClient.addPanier(panier);
				System.out.println("panier" + panier);
				Map<String, Object> cookiesResponse = new HashMap<>();
				cookiesResponse.put("maxAge", 31536000);
				cookiesResponse.put("path", "/");
				FacesContext.getCurrentInstance().getExternalContext().addResponseCookie("idPanier", URLEncoder.encode(panier.getIdCommande().toString(), "UTF-8"), cookiesResponse);
			}
			session.put("panier", panier);
		}

	}

	public String getBienvenue() {
		String id = null;
		Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		Utilisateur user = (Utilisateur)session.get("user");
		if(user!=null){
//			System.out.println("user non null");
			id = user.getPrenom();
		}
		if(id == null){
//			System.out.println("id null");
			return "SE CONNECTER";
		} else {
//			System.out.println("id non null");
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
//			System.out.println("seconnecter");
			return "SeConnecter.jsf";
		} else {
//			System.out.println("se déconnecter");
			return "accueil.jsf";
		}
	}

	public void setConnection_deco(String connection_deco) {
		this.connection_deco = connection_deco;
	}

	public String validationPanier() throws UnsupportedEncodingException{
		System.out.println("panier validation");
		CommandeClient panier = new CommandeClient();
		Calendar c = Calendar.getInstance();
		java.sql.Date date = new java.sql.Date(c.getTimeInMillis());
		panier.setDateCreation(date);
		panier = proxyCommandeClient.addPanier(panier);
		Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		System.out.println("récupération données");
		CommandeClient panierValide = (CommandeClient)session.get("panier");
		System.out.println("panierValide" + panierValide);
		Utilisateur userConnecte = (Utilisateur)session.get("user");
		System.out.println("user" + userConnecte + userConnecte.getIdActeur());
		StatutCommande statutPreparation = proxyCommandeClient.getStatutCommandeById(2);
		System.out.println("get statut commande" + statutPreparation);
		panierValide.setUtilisateur(userConnecte);
		System.out.println("set user");
		panierValide.setStatutCommande(statutPreparation);
		System.out.println("set statut");
		System.out.println("panier valide " + panierValide.getStatutCommande().getIdStatutCommande() + panierValide.getUtilisateur().getIdActeur());
		proxyCommandeClient.updatePanierValider(panierValide);
		
		session.put("panier", panier);

		Map<String, Object> cookiesResponse = new HashMap<>();
		cookiesResponse.put("maxAge", 31536000);
		cookiesResponse.put("path", "/");
		FacesContext.getCurrentInstance().getExternalContext().addResponseCookie("idPanier", URLEncoder.encode(panier.getIdCommande().toString(), "UTF-8"), cookiesResponse);
		return null;
	}

	public String connecter(){
		Utilisateur user_connecte = null;
		try {
//			System.out.println("email " + email);
			user_connecte = proxyCompte.getUserByEmail(email);
//			System.out.println("user récupéré");
		} catch (Exception e){
//			System.out.println("pas de user avec cet mail");
		}
		if(user_connecte != null){
			if(user_connecte.getPassword().equals(password)){
				Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
				session.put("user", user_connecte);
//				System.out.println("user en session");
			} else {
//				System.out.println("mauvais mot de passe message erreur");
			}
		} else {
//			System.out.println("mauvais login");
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

	public String deco() {
		System.out.println("déco");
		//		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return deco;
	}
	
	public String getDeco() {
		System.out.println("déco");
		//		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return deco;
	}

	public void setDeco(String deco) {
		this.deco = deco;
	}

}