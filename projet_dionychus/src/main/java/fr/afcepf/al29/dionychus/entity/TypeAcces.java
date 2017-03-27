package fr.afcepf.al29.dionychus.entity;
/**
 * Classe qui représente le type d'accès dont dispose un utilisateur connecté sur l'application Dionychus.
 * @author Nicolas
 *
 */
public class TypeAcces {
    /**
     * Identifiant du type d'accès.
     */
    private Integer idTypeAcces;
    /**
     * Libellé du type d'accès.
     */
    private String libelle;
    /**
     * Constructeur par défaut.
     */
    public TypeAcces() {
        super();
    }
    /**
     * @param paramIdTypeAcces L'identifiant du type d'accès
     * @param paramLibelle Le libellé du type d'accès
     */
    public TypeAcces(Integer paramIdTypeAcces, String paramLibelle) {
        super();
        idTypeAcces = paramIdTypeAcces;
        libelle = paramLibelle;
    }
    /**
     * @return L'identifiant du type d'accès
     */
    public Integer getIdTypeAcces() {
        return idTypeAcces;
    }
    /**
     * @param paramIdTypeAcces Le nouvel identifiant du type d'accès
     */
    public void setIdTypeAcces(Integer paramIdTypeAcces) {
        idTypeAcces = paramIdTypeAcces;
    }
    /**
     * @return Le libellé du type d'accès
     */
    public String getLibelle() {
        return libelle;
    }
    /**
     * @param paramLibelle Le nouveau libellé du type d'accès
     */
    public void setLibelle(String paramLibelle) {
        libelle = paramLibelle;
    }
    @Override
    public String toString() {
        return "TypeAcces [idTypeAcces=" + idTypeAcces + ", libelle=" + this.libelle + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result;
        if (idTypeAcces != null) {
            result += idTypeAcces.hashCode();
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
        TypeAcces other = (TypeAcces) obj;
        if (idTypeAcces == null) {
            if (other.idTypeAcces != null) {
                return false;
            }
        } else if (!idTypeAcces.equals(other.idTypeAcces)) {
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
}
