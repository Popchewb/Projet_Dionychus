package fr.afcepf.al29.dionychus.entity;

public class Region {
	private Integer idRegion;
	private String libelle;
	public Region() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Region(Integer idRegion, String libelle) {
		super();
		this.idRegion = idRegion;
		this.libelle = libelle;
	}
	public Integer getIdRegion() {
		return idRegion;
	}
	public void setIdRegion(Integer idRegion) {
		this.idRegion = idRegion;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	@Override
	public String toString() {
		return "Region [idRegion=" + idRegion + ", libelle=" + libelle + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idRegion == null) ? 0 : idRegion.hashCode());
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
		Region other = (Region) obj;
		if (idRegion == null) {
			if (other.idRegion != null)
				return false;
		} else if (!idRegion.equals(other.idRegion))
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		return true;
	}
	
	
}
