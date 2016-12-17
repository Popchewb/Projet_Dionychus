package fr.afcepf.al29.dionychus.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fr.afcepf.al29.dionychus.business.itf.IBusinessCommandeClient;
import fr.afcepf.al29.dionychus.entity.CommandeClient;

@Controller("confirmationManagedBean")
@Scope("request")
public class ConfirmationCommandeManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	IBusinessCommandeClient proxyBusinessCommandeClient;
	
	private Integer idCommande = ((CommandeClient) FacesContext.getCurrentInstance().getExternalContext()
			.getSessionMap().get("panier")).getIdCommande();
	private CommandeClient commandeClient;
	
	@PostConstruct
	public void init(){
		commandeClient = proxyBusinessCommandeClient.getCommandeById(idCommande);
	}

	public Integer getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(Integer idCommande) {
		this.idCommande = idCommande;
	}

	public CommandeClient getCommandeClient() {
		return commandeClient;
	}

	public void setCommandeClient(CommandeClient commandeClient) {
		this.commandeClient = commandeClient;
	}

}
