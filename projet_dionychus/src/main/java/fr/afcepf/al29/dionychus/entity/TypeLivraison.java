package fr.afcepf.al29.dionychus.entity;

public class TypeLivraison {
	private Integer idTypeLivraison;
	private String libelle;
	public TypeLivraison() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypeLivraison(Integer idTypeLivraison, String libelle) {
		super();
		this.idTypeLivraison = idTypeLivraison;
		this.libelle = libelle;
	}
	public Integer getIdTypeLivraison() {
		return idTypeLivraison;
	}
	public void setIdTypeLivraison(Integer idTypeLivraison) {
		this.idTypeLivraison = idTypeLivraison;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	@Override
	public String toString() {
		return "TypeLivraison [idTypeLivraison=" + idTypeLivraison + ", libelle=" + libelle + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTypeLivraison == null) ? 0 : idTypeLivraison.hashCode());
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
		TypeLivraison other = (TypeLivraison) obj;
		if (idTypeLivraison == null) {
			if (other.idTypeLivraison != null)
				return false;
		} else if (!idTypeLivraison.equals(other.idTypeLivraison))
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		return true;
	}
	
	
}
