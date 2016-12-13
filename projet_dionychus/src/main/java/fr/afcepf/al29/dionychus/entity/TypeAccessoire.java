package fr.afcepf.al29.dionychus.entity;

public class TypeAccessoire {
	private Integer id_type_accessoire;
	private String libelle;
	public TypeAccessoire() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypeAccessoire(Integer id_type_accessoire, String libelle) {
		super();
		this.id_type_accessoire = id_type_accessoire;
		this.libelle = libelle;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_type_accessoire == null) ? 0 : id_type_accessoire.hashCode());
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
		TypeAccessoire other = (TypeAccessoire) obj;
		if (id_type_accessoire == null) {
			if (other.id_type_accessoire != null)
				return false;
		} else if (!id_type_accessoire.equals(other.id_type_accessoire))
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Typeaccessoire [id_type_accessoire=" + id_type_accessoire + ", libelle=" + libelle + "]";
	}
	public Integer getId_type_accessoire() {
		return id_type_accessoire;
	}
	public void setId_type_accessoire(Integer id_type_accessoire) {
		this.id_type_accessoire = id_type_accessoire;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
}
