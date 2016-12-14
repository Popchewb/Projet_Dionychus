package fr.afcepf.al29.dionychus.entity;

public class TypeAcces {
	private Integer idTypeAcces;
	private String libelle;
	public TypeAcces() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypeAcces(Integer idTypeAcces, String libelle) {
		super();
		this.idTypeAcces = idTypeAcces;
		this.libelle = libelle;
	}
	public Integer getIdTypeAcces() {
		return idTypeAcces;
	}
	public void setIdTypeAcces(Integer idTypeAcces) {
		this.idTypeAcces = idTypeAcces;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	@Override
	public String toString() {
		return "TypeAcces [idTypeAcces=" + idTypeAcces + ", libelle=" + this.libelle + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTypeAcces == null) ? 0 : idTypeAcces.hashCode());
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
		TypeAcces other = (TypeAcces) obj;
		if (idTypeAcces == null) {
			if (other.idTypeAcces != null)
				return false;
		} else if (!idTypeAcces.equals(other.idTypeAcces))
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		return true;
	}
	
	
}
