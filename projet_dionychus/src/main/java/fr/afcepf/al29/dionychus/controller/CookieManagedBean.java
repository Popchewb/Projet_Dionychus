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
import fr.afcepf.al29.dionychus.entity.CommandeClient;
import fr.afcepf.al29.dionychus.entity.Utilisateur;

@Controller("cookieManagedBean")
@Scope("request")
public class CookieManagedBean {

	@Autowired
	private IBusinessCommandeClient proxyCommandeClient;

	private Utilisateur user = new Utilisateur();
	boolean start = false;
	String idPanier = null;
	CommandeClient panier;

	public void init() throws UnsupportedEncodingException {
		if (FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("panier") != null) {
			idPanier = ((CommandeClient) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
					.get("panier")).getIdCommande().toString();
		}

		if (start) {
			return;
		}
		start = true;
		Map<String, Object> cookies = FacesContext.getCurrentInstance().getExternalContext().getRequestCookieMap();
		Cookie cookie = (Cookie) cookies.get("idPanier");
		if (cookie != null) {
			idPanier = cookie.getValue();
			Map<String, Object> cookiesResponse = new HashMap<>();
			cookiesResponse.put("maxAge", 31536000);
			cookiesResponse.put("path", "/");
			FacesContext.getCurrentInstance().getExternalContext().addResponseCookie("idPanier",
					URLEncoder.encode(idPanier, "UTF-8"), cookiesResponse);
		}
		if (idPanier == null) {
			panier = new CommandeClient();
			Calendar c = Calendar.getInstance();
			java.sql.Date date = new java.sql.Date(c.getTimeInMillis());
			panier.setDateCreation(date);
			panier = proxyCommandeClient.addPanier(panier);
			idPanier = panier.getIdCommande().toString();
		} else {
			panier = proxyCommandeClient.getCommandeById(Integer.parseInt(idPanier));
		}
		Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		session.put("user", user);
		session.put("panier", panier);

	}
}