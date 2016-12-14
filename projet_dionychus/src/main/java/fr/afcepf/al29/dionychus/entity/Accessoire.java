package fr.afcepf.al29.dionychus.entity;

import java.util.List;

public class Accessoire extends Article{
	private TypeAccessoire typeAccessoire;

	public Accessoire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Accessoire(Integer idArticle, String reference, String libelle, String description, Double prix,
			Integer quantite, Integer seuilAlerte, String urlImage, String typeArticle,
			List<Commentaire> commentaires) {
		super(idArticle, reference, libelle, description, prix, quantite, seuilAlerte, urlImage, typeArticle, commentaires);
		// TODO Auto-generated constructor stub
	}

	public Accessoire(Integer idArticle, String reference, String libelle, String description, Double prix,
			Integer quantite, Integer seuilAlerte, String urlImage, String typeArticle, List<Commentaire> commentaires,
			TypeAccessoire typeAccessoire) {
		super(idArticle, reference, libelle, description, prix, quantite, seuilAlerte, urlImage, typeArticle,
				commentaires);
		this.typeAccessoire = typeAccessoire;
	}

	public TypeAccessoire getTypeAccessoire() {
		return typeAccessoire;
	}

	public void setTypeAccessoire(TypeAccessoire typeAccessoire) {
		this.typeAccessoire = typeAccessoire;
	}

	@Override
	public String toString() {
		return "Accessoire [typeAccessoire=" + typeAccessoire + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((typeAccessoire == null) ? 0 : typeAccessoire.hashCode());
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
		Accessoire other = (Accessoire) obj;
		if (typeAccessoire == null) {
			if (other.typeAccessoire != null)
				return false;
		} else if (!typeAccessoire.equals(other.typeAccessoire))
			return false;
		return true;
	}

	
	
	
}
