package fr.afcepf.al29.dionychus.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fr.afcepf.al29.dionychus.business.itf.IBusinessInventaire;
import fr.afcepf.al29.dionychus.entity.Accessoire;
import fr.afcepf.al29.dionychus.entity.Appelation;
import fr.afcepf.al29.dionychus.entity.Arome;
import fr.afcepf.al29.dionychus.entity.Cepage;
import fr.afcepf.al29.dionychus.entity.Region;
import fr.afcepf.al29.dionychus.entity.TypeVin;
import fr.afcepf.al29.dionychus.entity.Vin;

@Controller("inventaireManagedBean")
@Scope("request")
public class InventaireManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IBusinessInventaire proxyInventaire;
	
	private List<Accessoire> accessoires;

	private List<Vin> vins;
	
	private String reference;
	
	private List<TypeVin> typeVins;
	
	private Integer typeVin;
	
	private List<Appelation> appellations;
	
	private Integer appellation;
	
	private String libelle;
	
	private List<Region> regions;
	
	private Integer region;
	
	private String annee;
	
	private List<Cepage> cepages;
	
	private String cepage;
	
	private String vigneron;
	
	private String prix;
	
	private List<Arome> aromes;
	
	private String arome;
	
	private String stock;
	
	private String alerte;
	
	private String description;
	
	private String urlImage;
	
	public List<Accessoire> getAccessoires() {
		return proxyInventaire.getAllAccessoires();
	}

	public void setAccessoires(List<Accessoire> accessoires) {
		this.accessoires = accessoires;
	}

	public List<Vin> getVins() {
		return proxyInventaire.getAllVins();
	}

	public void setVins(List<Vin> vins) {
		this.vins = vins;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public List<TypeVin> getTypeVins() {
		return proxyInventaire.getAllTypeVins();
	}

	public void setTypeVins(List<TypeVin> typeVins) {
		this.typeVins = typeVins;
	}

	public List<Appelation> getAppellations() {
		return proxyInventaire.getAllAppellation();
	}

	public void setAppellations(List<Appelation> appellations) {
		this.appellations = appellations;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Region> getRegions() {
		return proxyInventaire.getAllRegions();
	}

	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public List<Cepage> getCepages() {
		return proxyInventaire.getAllCepages();
	}

	public void setCepages(List<Cepage> cepages) {
		this.cepages = cepages;
	}

	public String getVigneron() {
		return vigneron;
	}

	public void setVigneron(String vigneron) {
		this.vigneron = vigneron;
	}

	public String getPrix() {
		return prix;
	}

	public void setPrix(String prix) {
		this.prix = prix;
	}

	public List<Arome> getAromes() {
		return proxyInventaire.getAllAromes();
	}

	public void setAromes(List<Arome> aromes) {
		this.aromes = aromes;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getAlerte() {
		return alerte;
	}

	public void setAlerte(String alerte) {
		this.alerte = alerte;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	public Integer getAppellation() {
		return appellation;
	}

	public void setAppellation(Integer appellation) {
		this.appellation = appellation;
	}

	public Integer getRegion() {
		return region;
	}

	public void setRegion(Integer region) {
		this.region = region;
	}

	public void setTypeVin(Integer typeVin) {
		this.typeVin = typeVin;
	}
	
	public Integer getTypeVin() {
		return typeVin;
	}

	public String getCepage() {
		return cepage;
	}

	public void setCepage(String cepage) {
		this.cepage = cepage;
	}

	public String getArome() {
		return arome;
	}

	public void setArome(String arome) {
		this.arome = arome;
	}

	public String ajouterArticle() {
		Vin vin = new Vin();
		vin.setReference(reference);
		vin.setLibelle(libelle);
		vin.setDescription(description);
		vin.setPrix(Double.parseDouble(prix));
		vin.setQuantite(Integer.parseInt(stock));
		vin.setSeuilAlerte(Integer.parseInt(alerte));
		vin.setUrlImage(urlImage);
		vin.setAnnee(Integer.parseInt(annee));
		Region regionById = proxyInventaire.getRegionById(region);
		Appelation appellationById = proxyInventaire.getAppellationById(appellation);
		TypeVin typeVinById = proxyInventaire.getTypeVinById(typeVin);
		vin.setRegion(regionById);
		vin.setAppelation(appellationById);
		vin.setTypeVin(typeVinById);
		String[] chaineAromes = arome.split(",");
		String[] chaineCepages = cepage.split(",");
		List<Arome> aromeSelect = new ArrayList<>();
		for (String aromeId : chaineAromes) {
			Arome arome = proxyInventaire.getAromeById(Integer.parseInt(aromeId));
			aromeSelect.add(arome);
		}
		List<Cepage> cepageSelect = new ArrayList<>();
		for (String cepageId : chaineCepages) {
			Cepage cepage = proxyInventaire.getCepageById(Integer.parseInt(cepageId));
			cepageSelect.add(cepage);
		}
		vin.setAromes(aromeSelect);
		vin.setCepages(cepageSelect);
		vin.setTypeArticle("Vin");
		
		proxyInventaire.ajouterVin(vin);
		
		return null;
	}
	
}
