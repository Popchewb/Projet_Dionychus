package fr.afcepf.al29.dionychus.entity;
/**
 * Classe qui repr�sente le type d'acc�s dont dispose un utilisateur connect� sur l'application Dionychus.
 * @author Nicolas
 *
 */
public class TypeAcces {
    /**
     * Identifiant du type d'acc�s.
     */
    private Integer idTypeAcces;
    /**
     * Libell� du type d'acc�s.
     */
    private String libelle;
    /**
     * Constructeur par d�faut.
     */
    public TypeAcces() {
        super();
    }
    /**
     * @param paramIdTypeAcces L'identifiant du type d'acc�s
     * @param paramLibelle Le libell� du type d'acc�s
     */
    public TypeAcces(Integer paramIdTypeAcces, String paramLibelle) {
        super();
        idTypeAcces = paramIdTypeAcces;
        libelle = paramLibelle;
    }
    /**
     * @return L'identifiant du type d'acc�s
     */
    public Integer getIdTypeAcces() {
        return idTypeAcces;
    }
    /**
     * @param paramIdTypeAcces Le nouvel identifiant du type d'acc�s
     */
    public void setIdTypeAcces(Integer paramIdTypeAcces) {
        idTypeAcces = paramIdTypeAcces;
    }
    /**
     * @return Le libell� du type d'acc�s
     */
    public String getLibelle() {
        return libelle;
    }
    /**
     * @param paramLibelle Le nouveau libell� du type d'acc�s
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
