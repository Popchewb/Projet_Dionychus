package fr.afcepf.al29.dionychus.entity;

import java.util.List;

public class Vin extends Article {
	private Integer annee;
	private Appelation appelation;
	private Region region;
	private TypeVin typeVin;
	private List<Arome> aromes;
	private List<Cepage> cepages;
	public Vin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vin(Integer idArticle, String reference, String libelle, String description, Double prix, Integer quantite,
			Integer seuilAlerte, String urlImage) {
		super(idArticle, reference, libelle, description, prix, quantite, seuilAlerte, urlImage);
		// TODO Auto-generated constructor stub
	}
	public Vin(Integer annee, Appelation appelation, Region region, TypeVin typeVin, List<Arome> aromes,
			List<Cepage> cepages) {
		super();
		this.annee = annee;
		this.appelation = appelation;
		this.region = region;
		this.typeVin = typeVin;
		this.aromes = aromes;
		this.cepages = cepages;
	}
	public Integer getAnnee() {
		return annee;
	}
	public void setAnnee(Integer annee) {
		this.annee = annee;
	}
	public Appelation getAppelation() {
		return appelation;
	}
	public void setAppelation(Appelation appelation) {
		this.appelation = appelation;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public TypeVin getTypeVin() {
		return typeVin;
	}
	public void setTypeVin(TypeVin typeVin) {
		this.typeVin = typeVin;
	}
	public List<Arome> getAromes() {
		return aromes;
	}
	public void setAromes(List<Arome> aromes) {
		this.aromes = aromes;
	}
	public List<Cepage> getCepages() {
		return cepages;
	}
	public void setCepages(List<Cepage> cepages) {
		this.cepages = cepages;
	}
	@Override
	public String toString() {
		return "Vin [annee=" + annee + ", appelation=" + appelation + ", region=" + region + ", typeVin=" + typeVin
				+ ", aromes=" + aromes + ", cepages=" + cepages + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((annee == null) ? 0 : annee.hashCode());
		result = prime * result + ((appelation == null) ? 0 : appelation.hashCode());
		result = prime * result + ((aromes == null) ? 0 : aromes.hashCode());
		result = prime * result + ((cepages == null) ? 0 : cepages.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		result = prime * result + ((typeVin == null) ? 0 : typeVin.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vin other = (Vin) obj;
		if (annee == null) {
			if (other.annee != null)
				return false;
		} else if (!annee.equals(other.annee))
			return false;
		if (appelation == null) {
			if (other.appelation != null)
				return false;
		} else if (!appelation.equals(other.appelation))
			return false;
		if (aromes == null) {
			if (other.aromes != null)
				return false;
		} else if (!aromes.equals(other.aromes))
			return false;
		if (cepages == null) {
			if (other.cepages != null)
				return false;
		} else if (!cepages.equals(other.cepages))
			return false;
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		if (typeVin == null) {
			if (other.typeVin != null)
				return false;
		} else if (!typeVin.equals(other.typeVin))
			return false;
		return true;
	}
	
	
	
}
