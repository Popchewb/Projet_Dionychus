package fr.afcepf.al29.dionychus.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fr.afcepf.al29.dionychus.business.itf.IBusinessCompte;
import fr.afcepf.al29.dionychus.entity.Adresse;
import fr.afcepf.al29.dionychus.entity.Pays;
import fr.afcepf.al29.dionychus.entity.TypeAcces;
import fr.afcepf.al29.dionychus.entity.Utilisateur;
import fr.afcepf.al29.dionychus.entity.Ville;

@Controller
@Scope("request")
public class CompteManagedBean {

	@Autowired
	private IBusinessCompte proxy;

	private Utilisateur utilisateur = new Utilisateur();

	private Date dateNaissance = new Date();

	private Adresse adresseLivraison = new Adresse();

	private Adresse adresseFacturation = new Adresse();

	private List<Adresse> adresses = new ArrayList<>();

	private Ville villeLivraison = new Ville();

	private List<Ville> villesLivraison = new ArrayList<>();

	private Ville villeFacturation = new Ville();

	private List<Ville> villesFacturation = new ArrayList<>();

	private Pays paysLivraison = new Pays();

	private Pays paysFacturation = new Pays();

	private List<Pays> listePays = new ArrayList<>();

	private TypeAcces typeAcces = new TypeAcces();

	private Integer idTypeAccesClientParDefaut = 2;

	public Utilisateur registerUser() {

		villeLivraison.setIdVille(villeLivraison.getIdVille());
		adresseLivraison.setLibelle(adresseLivraison.getLibelle());
		adresseLivraison.setComplementAdresse(adresseLivraison.getComplementAdresse());
		adresseLivraison.setAdresseLivraison(adresseLivraison.getAdresseLivraison().booleanValue());
		adresseLivraison.setAdresseFacturation(false);
		adresseLivraison.setVille(villeLivraison);

		villeFacturation.setIdVille(villeFacturation.getIdVille());
		adresseFacturation.setLibelle(adresseFacturation.getLibelle());
		adresseFacturation.setComplementAdresse(adresseFacturation.getComplementAdresse());
		adresseFacturation.setAdresseLivraison(false);
		adresseFacturation.setAdresseFacturation(adresseFacturation.getAdresseFacturation().booleanValue());
		adresseFacturation.setVille(villeFacturation);

		adresses.add(adresseLivraison);
		adresses.add(adresseFacturation);

		typeAcces.setIdTypeAcces(idTypeAccesClientParDefaut);

		utilisateur.setNom(utilisateur.getNom());
		utilisateur.setPrenom(utilisateur.getPrenom());
		utilisateur.setCivilite(utilisateur.getCivilite());
		utilisateur.setAdresseMail(utilisateur.getAdresseMail());
		utilisateur.setNumeroTelephone(utilisateur.getNumeroTelephone());
		java.sql.Date sqlDate = new java.sql.Date(dateNaissance.getTime());
		utilisateur.setDateNaissance(sqlDate);
		utilisateur.setProfession(utilisateur.getProfession());
		utilisateur.setOptin(utilisateur.getOptin());
		utilisateur.setOrigine(utilisateur.getOrigine());
		utilisateur.setLogin(utilisateur.getLogin());
		utilisateur.setPassword(utilisateur.getPassword());
		utilisateur.setTypeAcces(typeAcces);
		utilisateur.setAdresses(adresses);

		proxy.addUtilisateur(utilisateur);

		proxy.addAdresse(adresseLivraison, utilisateur.getIdActeur());
		proxy.addAdresse(adresseFacturation, utilisateur.getIdActeur());

		utilisateur = new Utilisateur();

		return null;
	}

	public Utilisateur connectUser() {

		proxy.getUserByEmail();

		return null;
	}

	public List<Pays> getListePays() {
		return proxy.getAllPays();
	}

	public void setListePays(List<Pays> listePays) {
		this.listePays = listePays;
	}

	public IBusinessCompte getProxy() {
		return proxy;
	}

	public void setProxy(IBusinessCompte proxy) {
		this.proxy = proxy;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Adresse getAdresseLivraison() {
		return adresseLivraison;
	}

	public void setAdresseLivraison(Adresse adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}

	public Adresse getAdresseFacturation() {
		return adresseFacturation;
	}

	public void setAdresseFacturation(Adresse adresseFacturation) {
		this.adresseFacturation = adresseFacturation;
	}

	public List<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}

	public Ville getVilleLivraison() {
		return villeLivraison;
	}

	public void setVilleLivraison(Ville villeLivraison) {
		this.villeLivraison = villeLivraison;
	}

	public Ville getVilleFacturation() {
		return villeFacturation;
	}

	public void setVilleFacturation(Ville villeFacturation) {
		this.villeFacturation = villeFacturation;
	}

	public Pays getPaysLivraison() {
		return paysLivraison;
	}

	public void setPaysLivraison(Pays paysLivraison) {
		this.paysLivraison = paysLivraison;
	}

	public Pays getPaysFacturation() {
		return paysFacturation;
	}

	public void setPaysFacturation(Pays paysFacturation) {
		this.paysFacturation = paysFacturation;
	}

	public TypeAcces getTypeAcces() {
		return typeAcces;
	}

	public void setTypeAcces(TypeAcces typeAcces) {
		this.typeAcces = typeAcces;
	}

	public Integer getIdTypeAccesClientParDefaut() {
		return idTypeAccesClientParDefaut;
	}

	public void setIdTypeAccesClientParDefaut(Integer idTypeAccesClientParDefaut) {
		this.idTypeAccesClientParDefaut = idTypeAccesClientParDefaut;
	}

	public List<Ville> getVillesLivraison() {
		return proxy.getAllVille();
	}

	public void setVillesLivraison(List<Ville> villesLivraison) {
		this.villesLivraison = villesLivraison;
	}

	public List<Ville> getVillesFacturation() {
		return proxy.getAllVille();
	}

	public void setVillesFacturation(List<Ville> villesFacturation) {
		this.villesFacturation = villesFacturation;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

}
