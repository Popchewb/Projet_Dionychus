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
	
	public void init() throws UnsupportedEncodingException {
		
		boolean start = false;
		
		if(start){
			return;
		}
		start = true;
		Map<String, Object> cookies = FacesContext.getCurrentInstance().getExternalContext().getRequestCookieMap();
		Cookie cookie = (Cookie) cookies.get("idPanier");
		String id = cookie.getValue();
		Map<String, Object> cookiesResponse = new HashMap<>();
		cookiesResponse.put("maxAge", 31536000);
		cookiesResponse.put("path", "/");
		FacesContext.getCurrentInstance().getExternalContext().addResponseCookie("idPanier", URLEncoder.encode("1", "UTF-8"), cookiesResponse);
		CommandeClient panier;
		
		if(id == null) {
			panier = new CommandeClient();
			Calendar c = Calendar.getInstance();
			java.sql.Date date = new java.sql.Date(c.getTimeInMillis());
			panier.setDateCreation(date);
			panier = proxyCommandeClient.addPanier(panier);
		} else {
			panier = proxyCommandeClient.getCommandeById(Integer.parseInt(id));
		}
		Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		session.put("user", user);
		session.put("panier", panier);
		
	}
}
