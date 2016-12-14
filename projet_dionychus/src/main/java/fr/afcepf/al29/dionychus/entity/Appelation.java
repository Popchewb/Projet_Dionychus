package fr.afcepf.al29.dionychus.entity;

public class Appelation {
	private Integer idAppelation;
	private String libelle;
	public Appelation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Appelation(Integer idAppelation, String libelle) {
		super();
		this.idAppelation = idAppelation;
		this.libelle = libelle;
	}
	public Integer getIdAppelation() {
		return idAppelation;
	}
	public void setIdAppelation(Integer idAppelation) {
		this.idAppelation = idAppelation;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAppelation == null) ? 0 : idAppelation.hashCode());
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appelation other = (Appelation) obj;
		if (idAppelation == null) {
			if (other.idAppelation != null)
				return false;
		} else if (!idAppelation.equals(other.idAppelation))
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Appelation [idAppelation=" + idAppelation + ", libelle=" + libelle + "]";
	}
	
	
	
	
}
