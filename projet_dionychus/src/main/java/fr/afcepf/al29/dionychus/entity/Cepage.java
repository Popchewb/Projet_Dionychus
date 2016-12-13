package fr.afcepf.al29.dionychus.entity;

public class Cepage {
	private Integer idCepage;
	private String libelle;
	public Cepage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cepage(Integer idCepage, String libelle) {
		super();
		this.idCepage = idCepage;
		this.libelle = libelle;
	}
	public Integer getIdCepage() {
		return idCepage;
	}
	public void setIdCepage(Integer idCepage) {
		this.idCepage = idCepage;
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
		result = prime * result + ((idCepage == null) ? 0 : idCepage.hashCode());
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
		Cepage other = (Cepage) obj;
		if (idCepage == null) {
			if (other.idCepage != null)
				return false;
		} else if (!idCepage.equals(other.idCepage))
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
		return "Cepage [idCepage=" + idCepage + ", libelle=" + libelle + "]";
	}
	
}
