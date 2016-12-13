package fr.afcepf.al29.dionychus.entity;

public class StatutCommande {
	private Integer idStatutCommande;
	private String libelle;
	public StatutCommande(Integer idStatutCommande, String libelle) {
		super();
		this.idStatutCommande = idStatutCommande;
		this.libelle = libelle;
	}
	public StatutCommande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getIdStatutCommande() {
		return idStatutCommande;
	}
	public void setIdStatutCommande(Integer idStatutCommande) {
		this.idStatutCommande = idStatutCommande;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	@Override
	public String toString() {
		return "StatutCommande [idStatutCommande=" + idStatutCommande + ", libelle=" + libelle + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idStatutCommande == null) ? 0 : idStatutCommande.hashCode());
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
		StatutCommande other = (StatutCommande) obj;
		if (idStatutCommande == null) {
			if (other.idStatutCommande != null)
				return false;
		} else if (!idStatutCommande.equals(other.idStatutCommande))
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		return true;
	}
	
}
