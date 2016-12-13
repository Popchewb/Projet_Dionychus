package fr.afcepf.al29.dionychus.entity;

public class Commentaire {
	private Integer idCommentaire;
	private Double note;
	private String description;
	public Commentaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Commentaire(Integer idCommentaire, Double note, String description) {
		super();
		this.idCommentaire = idCommentaire;
		this.note = note;
		this.description = description;
	}
	@Override
	public String toString() {
		return "Commentaire [idCommentaire=" + idCommentaire + ", note=" + note + ", description=" + description + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
	
	
}
