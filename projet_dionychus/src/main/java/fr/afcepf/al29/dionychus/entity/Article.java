package fr.afcepf.al29.dionychus.entity;

import java.util.List;

public class Article {
	private Integer idArticle;
	private String reference;
	private String libelle;
	private String description;
	private Double prix;
	private Integer quantite;
	private Integer seuilAlerte;
	private String urlImage;
	private String typeArticle;
	private List<Commentaire> commentaires;
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Article(Integer idArticle, String reference, String libelle, String description, Double prix,
			Integer quantite, Integer seuilAlerte, String urlImage, String typeArticle,
			List<Commentaire> commentaires) {
		super();
		this.idArticle = idArticle;
		this.reference = reference;
		this.libelle = libelle;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.seuilAlerte = seuilAlerte;
		this.urlImage = urlImage;
		this.typeArticle = typeArticle;
		this.commentaires = commentaires;
	}
	public Integer getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(Integer idArticle) {
		this.idArticle = idArticle;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public Integer getQuantite() {
		return quantite;
	}
	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}
	public Integer getSeuilAlerte() {
		return seuilAlerte;
	}
	public void setSeuilAlerte(Integer seuilAlerte) {
		this.seuilAlerte = seuilAlerte;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	public String getTypeArticle() {
		return typeArticle;
	}
	public void setTypeArticle(String typeArticle) {
		this.typeArticle = typeArticle;
	}
	public List<Commentaire> getCommentaires() {
		return commentaires;
	}
	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}
	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", reference=" + reference + ", libelle=" + libelle
				+ ", description=" + description + ", prix=" + prix + ", quantite=" + quantite + ", seuilAlerte="
				+ seuilAlerte + ", urlImage=" + urlImage + ", typeArticle=" + typeArticle + ", commentaires="
				+ commentaires + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commentaires == null) ? 0 : commentaires.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((idArticle == null) ? 0 : idArticle.hashCode());
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		result = prime * result + ((prix == null) ? 0 : prix.hashCode());
		result = prime * result + ((quantite == null) ? 0 : quantite.hashCode());
		result = prime * result + ((reference == null) ? 0 : reference.hashCode());
		result = prime * result + ((seuilAlerte == null) ? 0 : seuilAlerte.hashCode());
		result = prime * result + ((typeArticle == null) ? 0 : typeArticle.hashCode());
		result = prime * result + ((urlImage == null) ? 0 : urlImage.hashCode());
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
		Article other = (Article) obj;
		if (commentaires == null) {
			if (other.commentaires != null)
				return false;
		} else if (!commentaires.equals(other.commentaires))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (idArticle == null) {
			if (other.idArticle != null)
				return false;
		} else if (!idArticle.equals(other.idArticle))
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		if (prix == null) {
			if (other.prix != null)
				return false;
		} else if (!prix.equals(other.prix))
			return false;
		if (quantite == null) {
			if (other.quantite != null)
				return false;
		} else if (!quantite.equals(other.quantite))
			return false;
		if (reference == null) {
			if (other.reference != null)
				return false;
		} else if (!reference.equals(other.reference))
			return false;
		if (seuilAlerte == null) {
			if (other.seuilAlerte != null)
				return false;
		} else if (!seuilAlerte.equals(other.seuilAlerte))
			return false;
		if (typeArticle == null) {
			if (other.typeArticle != null)
				return false;
		} else if (!typeArticle.equals(other.typeArticle))
			return false;
		if (urlImage == null) {
			if (other.urlImage != null)
				return false;
		} else if (!urlImage.equals(other.urlImage))
			return false;
		return true;
	}
	
	
	
	
}
