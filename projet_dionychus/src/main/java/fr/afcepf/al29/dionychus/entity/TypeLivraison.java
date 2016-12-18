package fr.afcepf.al29.dionychus.entity;

public class TypeLivraison {
	private Integer idTypeLivraison;
	private String libelle;
	private String description;
	private String urlImage;
	private Double tarification;
	public TypeLivraison() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypeLivraison(Integer idTypeLivraison, String libelle, String description, String urlImage,
			Double tarification) {
		super();
		this.idTypeLivraison = idTypeLivraison;
		this.libelle = libelle;
		this.description = description;
		this.urlImage = urlImage;
		this.tarification = tarification;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	public Double getTarification() {
		return tarification;
	}
	public void setTarification(Double tarification) {
		this.tarification = tarification;
	}
	@Override
	public String toString() {
		return "TypeLivraison [idTypeLivraison=" + idTypeLivraison + ", libelle=" + libelle + ", description="
				+ description + ", urlImage=" + urlImage + ", tarification=" + tarification + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((idTypeLivraison == null) ? 0 : idTypeLivraison.hashCode());
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		result = prime * result + ((tarification == null) ? 0 : tarification.hashCode());
		result = prime * result + ((urlImage == null) ? 0 : urlImage.hashCode());
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
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
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
		if (tarification == null) {
			if (other.tarification != null)
				return false;
		} else if (!tarification.equals(other.tarification))
			return false;
		if (urlImage == null) {
			if (other.urlImage != null)
				return false;
		} else if (!urlImage.equals(other.urlImage))
			return false;
		return true;
	}
	
	
	
	
}
