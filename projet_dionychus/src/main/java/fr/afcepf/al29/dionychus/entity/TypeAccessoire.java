package fr.afcepf.al29.dionychus.entity;
/**
 * Classe qui définit le type d'article à laquel l'article de type accessoire appartient.
 * @author Nicolas
 *
 */
public class TypeAccessoire {
    /**
     * Identifiant du type d'accessoire.
     */
    private Integer idTypeAccessoire;
    /**
     * Libellé du type d'accessoire.
     */
    private String libelle;
    /**
     * Constructeur par défaut.
     */
    public TypeAccessoire() {
        super();
    }
    /**
     * @param paramIdTypeAccessoire L'identifiant du type d'accessoire
     * @param paramLibelle Le libellé du type d'accessoire
     */
    public TypeAccessoire(Integer paramIdTypeAccessoire, String paramLibelle) {
        super();
        idTypeAccessoire = paramIdTypeAccessoire;
        libelle = paramLibelle;
    }
    /**
     * @return L'identifiant du type d'accessoire
     */
    public Integer getIdTypeAccessoire() {
        return idTypeAccessoire;
    }
    /**
     * @param paramIdTypeAccessoire Le nouvel identifiant du type d'accessoire
     */
    public void setIdTypeAccessoire(Integer paramIdTypeAccessoire) {
        idTypeAccessoire = paramIdTypeAccessoire;
    }
    /**
     * @return Le libellé du type d'accessoire
     */
    public String getLibelle() {
        return libelle;
    }
    /**
     * @param paramLibelle Le nouveau libellé du type d'accessoire
     */
    public void setLibelle(String paramLibelle) {
        libelle = paramLibelle;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result;
        if (idTypeAccessoire != null) {
            result += idTypeAccessoire.hashCode();
        }
        result = prime * result;
        if (libelle != null) {
            result += libelle.hashCode();
        }
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        TypeAccessoire other = (TypeAccessoire) obj;
        if (idTypeAccessoire == null) {
            if (other.idTypeAccessoire != null) {
                return false;
            }
        } else if (!idTypeAccessoire.equals(other.idTypeAccessoire)) {
            return false;
        }
        if (libelle == null) {
            if (other.libelle != null) {
                return false;
            }
        } else if (!libelle.equals(other.libelle)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "Typeaccessoire [id_type_accessoire=" + idTypeAccessoire + ", libelle=" + libelle + "]";
    }
}
