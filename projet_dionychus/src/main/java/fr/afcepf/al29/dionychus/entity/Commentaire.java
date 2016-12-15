package fr.afcepf.al29.dionychus.entity;

import java.sql.Date;

public class Commentaire {
	private Integer idCommentaire;
	private Double note;
	private String description;
	private Utilisateur auteur;
	private Date date;
	public Commentaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Commentaire(Integer idCommentaire, Double note, String description, Utilisateur auteur, Date date) {
		super();
		this.idCommentaire = idCommentaire;
		this.note = note;
		this.description = description;
		this.auteur = auteur;
		this.date = date;
	}
	public Integer getIdCommentaire() {
		return idCommentaire;
	}
	public void setIdCommentaire(Integer idCommentaire) {
		this.idCommentaire = idCommentaire;
	}
	public Double getNote() {
		return note;
	}
	public void setNote(Double note) {
		this.note = note;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Utilisateur getAuteur() {
		return auteur;
	}
	public void setAuteur(Utilisateur auteur) {
		this.auteur = auteur;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Commentaire [idCommentaire=" + idCommentaire + ", note=" + note + ", description=" + description
				+ ", auteur=" + auteur + ", date=" + date + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auteur == null) ? 0 : auteur.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((idCommentaire == null) ? 0 : idCommentaire.hashCode());
		result = prime * result + ((note == null) ? 0 : note.hashCode());
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
		Commentaire other = (Commentaire) obj;
		if (auteur == null) {
			if (other.auteur != null)
				return false;
		} else if (!auteur.equals(other.auteur))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (idCommentaire == null) {
			if (other.idCommentaire != null)
				return false;
		} else if (!idCommentaire.equals(other.idCommentaire))
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		return true;
	}
	
	
}
