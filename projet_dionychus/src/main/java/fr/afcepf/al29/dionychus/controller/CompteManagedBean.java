package fr.afcepf.al29.dionychus.controller;

import java.sql.Date;
import java.util.ArrayList;
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

	private Adresse adresseLivraison = new Adresse();

	private Adresse adresseFacturation = new Adresse();

	private List<Adresse> adresses = new ArrayList<>();

	private Ville villeLivraison = new Ville();

	private Ville villeFacturation = new Ville();

	private Pays paysLivraison = new Pays();

	private Pays paysFacturation = new Pays();

	private List<Pays> listePays = new ArrayList<>();

	private TypeAcces typeAcces = new TypeAcces();

	private Integer idTypeAccesClientParDefaut = 2;

	public Utilisateur registerUser() {

		// PAYS

		// paysLivraison = new Pays();
		paysLivraison.setLibelle(paysLivraison.getLibelle());

		// paysFacturation = new Pays();
		paysFacturation.setLibelle(paysFacturation.getLibelle());

		// VILLE

		// villeLivraison = new Ville();
		villeLivraison.setLibelle(villeLivraison.getLibelle());
		villeLivraison.setCodePostal(villeLivraison.getCodePostal());
		villeLivraison.setPays(paysLivraison);

		createVille(villeLivraison);

		// villeFacturation = new Ville();
		villeFacturation.setLibelle(villeFacturation.getLibelle());
		villeFacturation.setCodePostal(villeFacturation.getCodePostal());
		villeFacturation.setPays(paysFacturation);

		createVille(villeFacturation);

		// ADRESSE

		// adresseLivraison = new Adresse();
		adresseLivraison.setLibelle(adresseLivraison.getLibelle());
		adresseLivraison.setComplementAdresse(adresseLivraison.getComplementAdresse());
		adresseLivraison.setAdresseLivraison(adresseLivraison.getAdresseLivraison());
		adresseLivraison.setVille(villeLivraison);

		// adresseFacturation = new Adresse();
		adresseFacturation.setLibelle(adresseFacturation.getLibelle());
		adresseFacturation.setComplementAdresse(adresseFacturation.getComplementAdresse());
		adresseFacturation.setAdresseFacturation(adresseFacturation.getAdresseFacturation());
		adresseFacturation.setVille(villeFacturation);

		// adresses = new ArrayList<>();
		adresses.add(adresseLivraison);
		adresses.add(adresseFacturation);

		// TYPE ACCES

		// typeAcces = new TypeAcces();
		typeAcces.setIdTypeAcces(idTypeAccesClientParDefaut);

		// UTILISATEUR

		// utilisateur = new Utilisateur();
		utilisateur.setNom(utilisateur.getNom());
		utilisateur.setPrenom(utilisateur.getPrenom());
		utilisateur.setCivilite(utilisateur.getCivilite());
		utilisateur.setAdresseMail(utilisateur.getAdresseMail());
		utilisateur.setNumeroTelephone(utilisateur.getNumeroTelephone());
		System.out.println(utilisateur.getDateNaissance());
		Date sqlDate = Date.valueOf((utilisateur.getDateNaissance()).toString());
		utilisateur.setDateNaissance(sqlDate);
		System.out.println(sqlDate);
		utilisateur.setProfession(utilisateur.getProfession());
		utilisateur.setOptin(utilisateur.getOptin());
		utilisateur.setOrigine(utilisateur.getOrigine());
		utilisateur.setLogin(utilisateur.getLogin());
		utilisateur.setPassword(utilisateur.getPassword());
		utilisateur.setTypeAcces(typeAcces);
		utilisateur.setAdresses(adresses);

		proxy.addUtilisateur(utilisateur);

		createAdresse(adresseLivraison, utilisateur.getIdActeur());
		createAdresse(adresseFacturation, utilisateur.getIdActeur());

		System.out.println(utilisateur.getNom());

		System.out.println(utilisateur.getPrenom());

		return null;
	}

	public void createVille(Ville paramVille) {
		proxy.addVille(paramVille);
	}

	public void createAdresse(Adresse paramAdresse, Integer paramIdActeur) {
		proxy.addAdresse(paramAdresse, paramIdActeur);
	}

	public Utilisateur connectUser() {

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

}
