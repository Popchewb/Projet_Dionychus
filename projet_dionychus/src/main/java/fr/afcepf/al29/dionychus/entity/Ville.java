package fr.afcepf.al29.dionychus.entity;

public class Ville {
	private Integer idVille;
	private String libelle;
	private String codePostal;
	private Pays pays;
	public Ville() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ville(Integer idVille, String libelle, String codePostal, Pays pays) {
		super();
		this.idVille = idVille;
		this.libelle = libelle;
		this.codePostal = codePostal;
		this.pays = pays;
	}
	public Integer getIdVille() {
		return idVille;
	}
	public void setIdVille(Integer idVille) {
		this.idVille = idVille;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public Pays getPays() {
		return pays;
	}
	public void setPays(Pays pays) {
		this.pays = pays;
	}
	@Override
	public String toString() {
		return "Ville [idVille=" + idVille + ", libelle=" + libelle + ", codePostal=" + codePostal + ", pays=" + pays
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codePostal == null) ? 0 : codePostal.hashCode());
		result = prime * result + ((idVille == null) ? 0 : idVille.hashCode());
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		result = prime * result + ((pays == null) ? 0 : pays.hashCode());
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
		Ville other = (Ville) obj;
		if (codePostal == null) {
			if (other.codePostal != null)
				return false;
		} else if (!codePostal.equals(other.codePostal))
			return false;
		if (idVille == null) {
			if (other.idVille != null)
				return false;
		} else if (!idVille.equals(other.idVille))
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		if (pays == null) {
			if (other.pays != null)
				return false;
		} else if (!pays.equals(other.pays))
			return false;
		return true;
	}
	
	
}
