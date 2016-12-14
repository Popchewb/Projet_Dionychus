package fr.afcepf.al29.dionychus.entity;

import java.sql.Date;
import java.util.List;

public class CommandeStock extends Commande {
	private Date dateReception;
	private Fournisseur fournisseur;
	public CommandeStock() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommandeStock(Integer idCommande, Date dateValidation, String numeroReference, StatutCommande statutCommande,
			List<LigneCommande> lignesCommande) {
		super(idCommande, dateValidation, numeroReference, statutCommande, lignesCommande);
		// TODO Auto-generated constructor stub
	}
	
	public CommandeStock(Integer idCommande, Date dateValidation, String numeroReference, StatutCommande statutCommande,
			List<LigneCommande> lignesCommande, Date dateReception, Fournisseur fournisseur) {
		super(idCommande, dateValidation, numeroReference, statutCommande, lignesCommande);
		this.dateReception = dateReception;
		this.fournisseur = fournisseur;
	}
	public CommandeStock(Date dateReception, Fournisseur fournisseur) {
		super();
		this.dateReception = dateReception;
		this.fournisseur = fournisseur;
	}
	public Date getDateReception() {
		return dateReception;
	}
	public void setDateReception(Date dateReception) {
		this.dateReception = dateReception;
	}
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	@Override
	public String toString() {
		return "CommandeStock [dateReception=" + dateReception + ", fournisseur=" + fournisseur + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dateReception == null) ? 0 : dateReception.hashCode());
		result = prime * result + ((fournisseur == null) ? 0 : fournisseur.hashCode());
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
		CommandeStock other = (CommandeStock) obj;
		if (dateReception == null) {
			if (other.dateReception != null)
				return false;
		} else if (!dateReception.equals(other.dateReception))
			return false;
		if (fournisseur == null) {
			if (other.fournisseur != null)
				return false;
		} else if (!fournisseur.equals(other.fournisseur))
			return false;
		return true;
	}
	
	
}
