package fr.afcepf.al29.dionychus.entity;

public class Appelation {
	private Integer idArome;
	private String libelle;
	public Appelation(Integer idArome, String libelle) {
		super();
		this.idArome = idArome;
		this.libelle = libelle;
	}
	public Appelation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getIdArome() {
		return idArome;
	}
	public void setIdArome(Integer idArome) {
		this.idArome = idArome;
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
		result = prime * result + ((idArome == null) ? 0 : idArome.hashCode());
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
		if (idArome == null) {
			if (other.idArome != null)
				return false;
		} else if (!idArome.equals(other.idArome))
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
		return "Appelation [idArome=" + idArome + ", libelle=" + libelle + "]";
	}
	
	
}
