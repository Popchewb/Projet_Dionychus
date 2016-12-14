package fr.afcepf.al29.dionychus.entity;

import java.util.List;

public abstract class Acteur {
	private Integer idActeur;
	private String nom;
	private String prenom;
	private String numeroTelephone;
	private String adresseMail;
	private String civilite;
	private List<Adresse> adresses;
	public Acteur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Acteur(Integer idActeur, String nom, String prenom, String numeroTelephone, String adresseMail,
			String civilite, List<Adresse> adresses) {
		super();
		this.idActeur = idActeur;
		this.nom = nom;
		this.prenom = prenom;
		this.numeroTelephone = numeroTelephone;
		this.adresseMail = adresseMail;
		this.civilite = civilite;
		this.adresses = adresses;
	}
	public Integer getIdActeur() {
		return idActeur;
	}
	public void setIdActeur(Integer idActeur) {
		this.idActeur = idActeur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNumeroTelephone() {
		return numeroTelephone;
	}
	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}
	public String getAdresseMail() {
		return adresseMail;
	}
	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}
	public String getCivilite() {
		return civilite;
	}
	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}
	public List<Adresse> getAdresses() {
		return adresses;
	}
	public void setAdresses(List<Adresse> adresses) {
		this.adresses = adresses;
	}
	@Override
	public String toString() {
		return "Acteur [idActeur=" + idActeur + ", nom=" + nom + ", prenom=" + prenom + ", numeroTelephone="
				+ numeroTelephone + ", adresseMail=" + adresseMail + ", civilite=" + civilite + ", adresses=" + adresses
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresseMail == null) ? 0 : adresseMail.hashCode());
		result = prime * result + ((adresses == null) ? 0 : adresses.hashCode());
		result = prime * result + ((civilite == null) ? 0 : civilite.hashCode());
		result = prime * result + ((idActeur == null) ? 0 : idActeur.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((numeroTelephone == null) ? 0 : numeroTelephone.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
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
		Acteur other = (Acteur) obj;
		if (adresseMail == null) {
			if (other.adresseMail != null)
				return false;
		} else if (!adresseMail.equals(other.adresseMail))
			return false;
		if (adresses == null) {
			if (other.adresses != null)
				return false;
		} else if (!adresses.equals(other.adresses))
			return false;
		if (civilite == null) {
			if (other.civilite != null)
				return false;
		} else if (!civilite.equals(other.civilite))
			return false;
		if (idActeur == null) {
			if (other.idActeur != null)
				return false;
		} else if (!idActeur.equals(other.idActeur))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (numeroTelephone == null) {
			if (other.numeroTelephone != null)
				return false;
		} else if (!numeroTelephone.equals(other.numeroTelephone))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		return true;
	}
	
}
