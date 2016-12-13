package fr.afcepf.al29.dionychus.entity;

public class Livraison {
	private Integer idLivraison;
	private String libelle;
	private Double tarification;
	private TypeLivraison typeLivraison;
	public Livraison(Integer idLivraison, String libelle, Double tarification, TypeLivraison typeLivraison) {
		super();
		this.idLivraison = idLivraison;
		this.libelle = libelle;
		this.tarification = tarification;
		this.typeLivraison = typeLivraison;
	}
	public Livraison() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getIdLivraison() {
		return idLivraison;
	}
	public void setIdLivraison(Integer idLivraison) {
		this.idLivraison = idLivraison;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Double getTarification() {
		return tarification;
	}
	public void setTarification(Double tarification) {
		this.tarification = tarification;
	}
	public TypeLivraison getTypeLivraison() {
		return typeLivraison;
	}
	public void setTypeLivraison(TypeLivraison typeLivraison) {
		this.typeLivraison = typeLivraison;
	}
	@Override
	public String toString() {
		return "Livraison [idLivraison=" + idLivraison + ", libelle=" + libelle + ", tarification=" + tarification
				+ ", typeLivraison=" + typeLivraison + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idLivraison == null) ? 0 : idLivraison.hashCode());
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		result = prime * result + ((tarification == null) ? 0 : tarification.hashCode());
		result = prime * result + ((typeLivraison == null) ? 0 : typeLivraison.hashCode());
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
		Livraison other = (Livraison) obj;
		if (idLivraison == null) {
			if (other.idLivraison != null)
				return false;
		} else if (!idLivraison.equals(other.idLivraison))
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		if (tarification == null) {
			if (other.tarification != null)
				return false;
		} else if (!tarification.equals(other.tarification))
			return false;
		if (typeLivraison == null) {
			if (other.typeLivraison != null)
				return false;
		} else if (!typeLivraison.equals(other.typeLivraison))
			return false;
		return true;
	}
	
	
}
