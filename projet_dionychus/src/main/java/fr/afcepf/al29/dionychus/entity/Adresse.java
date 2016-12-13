package fr.afcepf.al29.dionychus.entity;

public class Adresse {
	private Integer idAdresse;
	private String libelle;
	private String complementAdresse;
	private Ville ville;
	private Boolean adresseFacturation;
	private Boolean adresseLivraison;
	public Adresse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Boolean getAdresseFacturation() {
		return adresseFacturation;
	}

	public void setAdresseFacturation(Boolean adresseFacturation) {
		this.adresseFacturation = adresseFacturation;
	}

	public Boolean getAdresseLivraison() {
		return adresseLivraison;
	}

	public void setAdresseLivraison(Boolean adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}

	
	public Adresse(Integer idAdresse, String libelle, String complementAdresse, Ville ville, Boolean adresseFacturation,
			Boolean adresseLivraison) {
		super();
		this.idAdresse = idAdresse;
		this.libelle = libelle;
		this.complementAdresse = complementAdresse;
		this.ville = ville;
		this.adresseFacturation = adresseFacturation;
		this.adresseLivraison = adresseLivraison;
	}

	public Integer getIdAdresse() {
		return idAdresse;
	}
	public void setIdAdresse(Integer idAdresse) {
		this.idAdresse = idAdresse;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getComplementAdresse() {
		return complementAdresse;
	}
	public void setComplementAdresse(String complementAdresse) {
		this.complementAdresse = complementAdresse;
	}
	public Ville getVille() {
		return ville;
	}
	public void setVille(Ville ville) {
		this.ville = ville;
	}
	@Override
	public String toString() {
		return "Adresse [idAdresse=" + idAdresse + ", libelle=" + libelle + ", complementAdresse=" + complementAdresse
				+ ", ville=" + ville + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((complementAdresse == null) ? 0 : complementAdresse.hashCode());
		result = prime * result + ((idAdresse == null) ? 0 : idAdresse.hashCode());
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		result = prime * result + ((ville == null) ? 0 : ville.hashCode());
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
		Adresse other = (Adresse) obj;
		if (complementAdresse == null) {
			if (other.complementAdresse != null)
				return false;
		} else if (!complementAdresse.equals(other.complementAdresse))
			return false;
		if (idAdresse == null) {
			if (other.idAdresse != null)
				return false;
		} else if (!idAdresse.equals(other.idAdresse))
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equals(other.ville))
			return false;
		return true;
	}
	
	
}
