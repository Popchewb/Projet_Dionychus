package fr.afcepf.al29.dionychus.entity;

import java.util.List;

public class Fournisseur extends Acteur {
	private String nomDomaine;

	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fournisseur(Integer idActeur, String nom, String prenom, String numeroTelephone, String adresseMail,
			String civilite, List<Adresse> adresses) {
		super(idActeur, nom, prenom, numeroTelephone, adresseMail, civilite, adresses);
		// TODO Auto-generated constructor stub
	}

	public Fournisseur(Integer idActeur, String nom, String prenom, String numeroTelephone, String adresseMail,
			String civilite, List<Adresse> adresses, String nomDomaine) {
		super(idActeur, nom, prenom, numeroTelephone, adresseMail, civilite, adresses);
		this.nomDomaine = nomDomaine;
	}

	public String getNomDomaine() {
		return nomDomaine;
	}

	public void setNomDomaine(String nomDomaine) {
		this.nomDomaine = nomDomaine;
	}

	@Override
	public String toString() {
		return "Fournisseur [nomDomaine=" + nomDomaine + ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nomDomaine == null) ? 0 : nomDomaine.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fournisseur other = (Fournisseur) obj;
		if (nomDomaine == null) {
			if (other.nomDomaine != null)
				return false;
		} else if (!nomDomaine.equals(other.nomDomaine))
			return false;
		return true;
	}
	
	

	

}
