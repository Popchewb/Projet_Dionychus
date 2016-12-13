package fr.afcepf.al29.dionychus.entity;

public class LigneCommande {
	private Integer idLigneCommande;
	private Integer quantite;
	private Article article;
	public LigneCommande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LigneCommande(Integer idLigneCommande, Integer quantite, Article article) {
		super();
		this.idLigneCommande = idLigneCommande;
		this.quantite = quantite;
		this.article = article;
	}
	public Integer getIdLigneCommande() {
		return idLigneCommande;
	}
	public void setIdLigneCommande(Integer idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}
	public Integer getQuantite() {
		return quantite;
	}
	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	@Override
	public String toString() {
		return "LigneCommande [idLigneCommande=" + idLigneCommande + ", quantite=" + quantite + ", article=" + article
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((article == null) ? 0 : article.hashCode());
		result = prime * result + ((idLigneCommande == null) ? 0 : idLigneCommande.hashCode());
		result = prime * result + ((quantite == null) ? 0 : quantite.hashCode());
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
		LigneCommande other = (LigneCommande) obj;
		if (article == null) {
			if (other.article != null)
				return false;
		} else if (!article.equals(other.article))
			return false;
		if (idLigneCommande == null) {
			if (other.idLigneCommande != null)
				return false;
		} else if (!idLigneCommande.equals(other.idLigneCommande))
			return false;
		if (quantite == null) {
			if (other.quantite != null)
				return false;
		} else if (!quantite.equals(other.quantite))
			return false;
		return true;
	}
	
}
