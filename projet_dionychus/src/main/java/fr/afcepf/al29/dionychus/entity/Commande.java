package fr.afcepf.al29.dionychus.entity;

import java.sql.Date;
import java.util.List;

public class Commande {
	private Integer idCommande;
	private Date dateValidation;
	private String numeroReference;
	private StatutCommande statutCommande;
	private List<LigneCommande> lignesCommande;
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Commande(Integer idCommande, Date dateValidation, String numeroReference, StatutCommande statutCommande,
			List<LigneCommande> lignesCommande) {
		super();
		this.idCommande = idCommande;
		this.dateValidation = dateValidation;
		this.numeroReference = numeroReference;
		this.statutCommande = statutCommande;
		this.lignesCommande = lignesCommande;
	}
	public Integer getIdCommande() {
		return idCommande;
	}
	public void setIdCommande(Integer idCommande) {
		this.idCommande = idCommande;
	}
	public Date getDateValidation() {
		return dateValidation;
	}
	public void setDateValidation(Date dateValidation) {
		this.dateValidation = dateValidation;
	}
	public String getNumeroReference() {
		return numeroReference;
	}
	public void setNumeroReference(String numeroReference) {
		this.numeroReference = numeroReference;
	}
	public StatutCommande getStatutCommande() {
		return statutCommande;
	}
	public void setStatutCommande(StatutCommande statutCommande) {
		this.statutCommande = statutCommande;
	}
	public List<LigneCommande> getLignesCommande() {
		return lignesCommande;
	}
	public void setLignesCommande(List<LigneCommande> lignesCommande) {
		this.lignesCommande = lignesCommande;
	}
	@Override
	public String toString() {
		return "Commande [idCommande=" + idCommande + ", dateValidation=" + dateValidation + ", numeroReference="
				+ numeroReference + ", statutCommande=" + statutCommande + ", lignesCommande=" + lignesCommande + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateValidation == null) ? 0 : dateValidation.hashCode());
		result = prime * result + ((idCommande == null) ? 0 : idCommande.hashCode());
		result = prime * result + ((lignesCommande == null) ? 0 : lignesCommande.hashCode());
		result = prime * result + ((numeroReference == null) ? 0 : numeroReference.hashCode());
		result = prime * result + ((statutCommande == null) ? 0 : statutCommande.hashCode());
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
		Commande other = (Commande) obj;
		if (dateValidation == null) {
			if (other.dateValidation != null)
				return false;
		} else if (!dateValidation.equals(other.dateValidation))
			return false;
		if (idCommande == null) {
			if (other.idCommande != null)
				return false;
		} else if (!idCommande.equals(other.idCommande))
			return false;
		if (lignesCommande == null) {
			if (other.lignesCommande != null)
				return false;
		} else if (!lignesCommande.equals(other.lignesCommande))
			return false;
		if (numeroReference == null) {
			if (other.numeroReference != null)
				return false;
		} else if (!numeroReference.equals(other.numeroReference))
			return false;
		if (statutCommande == null) {
			if (other.statutCommande != null)
				return false;
		} else if (!statutCommande.equals(other.statutCommande))
			return false;
		return true;
	}
	
	
}
