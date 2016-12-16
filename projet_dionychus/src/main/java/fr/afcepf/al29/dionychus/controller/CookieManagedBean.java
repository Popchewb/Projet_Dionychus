package fr.afcepf.al29.dionychus.controller;

import java.util.Map;

import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fr.afcepf.al29.dionychus.business.itf.IBusinessCommandeClient;
import fr.afcepf.al29.dionychus.entity.Acteur;
import fr.afcepf.al29.dionychus.entity.Commande;

@Controller("cookieManagedBean")
@Scope("request")
public class CookieManagedBean {

	@Autowired
	private IBusinessCommandeClient proxyCommandeClient;
	
	private Acteur acteur;
	
	public void init() {
		
		boolean start = false;
		
		if(start){
			return;
		}
		start = true;
		Map<String, Object> cookies = FacesContext.getCurrentInstance().getExternalContext().getRequestCookieMap();
		String id = (String)cookies.get("idPanier");
		Commande panier;
		
		if(id == null) {
			panier = new Commande();
			//panier = proxyCommandeClient.
		} else {
			panier = proxyCommandeClient.getCommandeById(Integer.parseInt(id));
		}
		
		Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		session.put("user", acteur);
		session.put("panier", panier);
		
//		<f:event type="preRenderView" listener="#{surveyWebBean.init}" />
		
	}
}
