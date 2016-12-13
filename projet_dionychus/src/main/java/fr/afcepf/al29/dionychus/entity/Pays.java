package fr.afcepf.al29.dionychus.entity;

public class Pays {
	private Integer idPays;
	private String libelle;
	public Pays() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pays(Integer idPays, String libelle) {
		super();
		this.idPays = idPays;
		this.libelle = libelle;
	}
	public Integer getIdPays() {
		return idPays;
	}
	public void setIdPays(Integer idPays) {
		this.idPays = idPays;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	@Override
	public String toString() {
		return "Pays [idPays=" + idPays + ", libelle=" + libelle + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPays == null) ? 0 : idPays.hashCode());
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
		Pays other = (Pays) obj;
		if (idPays == null) {
			if (other.idPays != null)
				return false;
		} else if (!idPays.equals(other.idPays))
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		return true;
	}
	
	
}
