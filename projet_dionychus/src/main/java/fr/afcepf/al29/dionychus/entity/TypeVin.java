package fr.afcepf.al29.dionychus.entity;

public class TypeVin {
	private Integer idTypeVin;
	private String libelle;
	public TypeVin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypeVin(Integer idTypeVin, String libelle) {
		super();
		this.idTypeVin = idTypeVin;
		this.libelle = libelle;
	}
	public Integer getIdTypeVin() {
		return idTypeVin;
	}
	public void setIdTypeVin(Integer idTypeVin) {
		this.idTypeVin = idTypeVin;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	@Override
	public String toString() {
		return "TypeVin [idTypeVin=" + idTypeVin + ", libelle=" + libelle + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTypeVin == null) ? 0 : idTypeVin.hashCode());
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
		TypeVin other = (TypeVin) obj;
		if (idTypeVin == null) {
			if (other.idTypeVin != null)
				return false;
		} else if (!idTypeVin.equals(other.idTypeVin))
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		return true;
	}
	
	
}
