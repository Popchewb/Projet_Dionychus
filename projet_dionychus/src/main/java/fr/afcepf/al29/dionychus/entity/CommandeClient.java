package fr.afcepf.al29.dionychus.entity;

import java.sql.Date;
import java.util.List;

public class CommandeClient extends Commande {
	private Date dateCreation;
	private Utilisateur utilisateur;
	private Promotion promotion;
	public CommandeClient() {
		super();
	}
	public CommandeClient(Date dateCreation, Utilisateur utilisateur, Promotion promotion) {
		super();
		this.dateCreation = dateCreation;
		this.utilisateur = utilisateur;
		this.promotion = promotion;
	}
	
	public CommandeClient(Integer idCommande, Date dateValidation, String numeroReference,
			StatutCommande statutCommande, List<LigneCommande> lignesCommande, Date dateCreation,
			Utilisateur utilisateur, Promotion promotion) {
		super(idCommande, dateValidation, numeroReference, statutCommande, lignesCommande);
		this.dateCreation = dateCreation;
		this.utilisateur = utilisateur;
		this.promotion = promotion;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public Promotion getPromotion() {
		return promotion;
	}
	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
	@Override
	public String toString() {
		return "CommandeClient [dateCreation=" + dateCreation + ", utilisateur=" + utilisateur + ", promotion="
				+ promotion + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dateCreation == null) ? 0 : dateCreation.hashCode());
		result = prime * result + ((promotion == null) ? 0 : promotion.hashCode());
		result = prime * result + ((utilisateur == null) ? 0 : utilisateur.hashCode());
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
		CommandeClient other = (CommandeClient) obj;
		if (dateCreation == null) {
			if (other.dateCreation != null)
				return false;
		} else if (!dateCreation.equals(other.dateCreation))
			return false;
		if (promotion == null) {
			if (other.promotion != null)
				return false;
		} else if (!promotion.equals(other.promotion))
			return false;
		if (utilisateur == null) {
			if (other.utilisateur != null)
				return false;
		} else if (!utilisateur.equals(other.utilisateur))
			return false;
		return true;
	}
	
	
}
