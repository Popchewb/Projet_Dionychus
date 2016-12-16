package fr.afcepf.al29.dionychus.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import fr.afcepf.al29.dionychus.business.itf.IBusinessInventaire;
import fr.afcepf.al29.dionychus.entity.Arome;
import fr.afcepf.al29.dionychus.entity.Cepage;
import fr.afcepf.al29.dionychus.entity.Region;
import fr.afcepf.al29.dionychus.entity.TypeVin;
import fr.afcepf.al29.dionychus.entity.Vin;

@Controller("vinManagedBean")
@Scope("request")
public class VinManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private IBusinessInventaire proxyInventaire;

	private String vigneron;

	private String millesime;

	private List<TypeVin> typeVins;

	private Integer typeVin;

	private Double prix;

	private List<Arome> aromes;

	private String arome;

	private String cepage;

	private Integer region;
	
	private List<Region> regions;

	private Map<String, String> cepageMap = new HashMap<String, String>();
	
	private Map<String, String> aromeMap = new HashMap<String, String>();
	
	public String rechercher() {
		System.out.println(cepage);
//		System.out.println("region " + region);
//		System.out.println("arome " + arome + " cepage " + cepage);
		List<Vin> vins = proxyInventaire.getAllVin();
		List<Vin> selectVin = new ArrayList<>();

		if(typeVin != 0) {
			System.out.println("plop1");
			for (Vin vin : vins) {
				if(vin.getTypeVin().getIdTypeVin() != typeVin) {
					selectVin.add(vin);
				}
			}
			vins.removeAll(selectVin);
			selectVin.clear();
		}

		if(!millesime.equals("")){
			System.out.println("plop2");
			for (Vin vin : vins) {
				if(vin.getAnnee() != Integer.parseInt(millesime)){
					selectVin.add(vin);
				}
			}
			vins.removeAll(selectVin);
			selectVin.clear();
		}

//		if(prix != 0) {
//			for (Vin vin : vins) {
//				if(vin.getPrix() < prix) {
//					System.out.println("boucle if prix " + vin.getPrix() + " " + prix);
//					selectVin.add(vin);
//				}
//			}
//			vins.removeAll(selectVin);
//			selectVin.clear();
//		}

		if(region != 0) {
			for (Vin vin : vins) {
				if(vin.getRegion().getIdRegion() != region) {
					selectVin.add(vin);
				}
			}
			vins.removeAll(selectVin);
			selectVin.clear();
		}
		
		System.out.println("debut methode");
		System.out.println("arome " + arome);
		System.out.println("cepage " + cepage);
		System.out.println(vins.size());

		if(!arome.equals("")){
			boolean estPresent = false;
			String[] chaineAromes = arome.split(",");
			for (Vin vin : vins) {
				System.out.println("vin " + vin);
				for (String str : chaineAromes) {
					System.out.println("str " + str);
					System.out.println(vin.getCepages());
					System.out.println(vin.getAromes());
					try{
						for (Arome aro : vin.getAromes()) {
							System.out.println("arome " + aro.getLibelle());
							if(aro.getLibelle().equals(str)){
								System.out.println("est Present");
								estPresent = true;
							}
						}
					} catch (Exception e){
						
					}
					if(!estPresent){
						System.out.println("ajout vin");
						selectVin.add(vin);
					}
				}
			}
			System.out.println("taille " + vins.size() + " " + selectVin.size());
			vins.removeAll(selectVin);
			selectVin.clear();
		}
		
		for (Vin vin : vins) {
			System.out.println(vin);	
		}

		return null;
	}

	public List<TypeVin> getTypeVins() {
		return proxyInventaire.getAllTypeVin();
	}

	public void setTypeVins(List<TypeVin> typeVins) {
		this.typeVins = typeVins;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public List<Arome> getAromes() {
		List<Arome> test = proxyInventaire.getAllArome();
		for (Arome arome : test) {
			System.out.println(arome.getIdArome() + " " + arome.getLibelle());
		}	
		return test;
	}

	public void setAromes(List<Arome> aromes) {
		this.aromes = aromes;
	}

	public Integer getTypeVin() {
		return typeVin;
	}

	public void setTypeVin(Integer typeVin) {
		this.typeVin = typeVin;
	}

	public String getArome() {
		return arome;
	}

	public void setArome(String arome) {
		this.arome = arome;
	}

	public String getCepage() {
		return cepage;
	}

	public void setCepage(String cepage) {
		this.cepage = cepage;
	}

	public Integer getRegion() {
		return region;
	}

	public void setRegion(Integer region) {
		this.region = region;
	}

	public String getVigneron() {
		return vigneron;
	}

	public void setVigneron(String vigneron) {
		this.vigneron = vigneron;
	}

	public String getMillesime() {
		return millesime;
	}

	public void setMillesime(String millesime) {
		this.millesime = millesime;
	}

	public Map<String, String> getCepageMap() {
		List<Cepage> testCepage = proxyInventaire.getAllCepage();
		
		for (Cepage cepage : testCepage) {
			cepageMap.put(cepage.getLibelle(), cepage.getIdCepage().toString());
		}
		return cepageMap;
	}

	public void setCepageMap(Map<String, String> cepageMap) {
		this.cepageMap = cepageMap;
	}

	public Map<String, String> getAromeMap() {
		List<Arome> testArome = proxyInventaire.getAllArome();
		
		for (Arome arome : testArome) {
			aromeMap.put(arome.getLibelle(), arome.getIdArome().toString());
		}
		return aromeMap;
	}

	public void setAromeMap(Map<String, String> aromeMap) {
		this.aromeMap = aromeMap;
	}

	public List<Region> getRegions() {
		return proxyInventaire.getAllRegion();
	}

	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

}
