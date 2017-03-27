package fr.afcepf.al29.dionychus.entity;
/**
 * Classe qui permet de préciser de quel type est le vin.
 * @author Nicolas
 *
 */
public class TypeVin {
    /**
     * Identifiant du type de vin.
     */
    private Integer idTypeVin;
    /**
     * Libellé du type de vin.
     */
    private String libelle;
    /**
     * Constructeur par défaut.
     */
    public TypeVin() {
        super();
    }
    /**
     * @param paramIdTypeVin Identifiant du type de vin
     * @param paramLibelle Libellé du type de vin
     */
    public TypeVin(Integer paramIdTypeVin, String paramLibelle) {
        super();
        idTypeVin = paramIdTypeVin;
        libelle = paramLibelle;
    }
    /**
     * @return L'identifiant du type de vin
     */
    public Integer getIdTypeVin() {
        return idTypeVin;
    }
    /**
     * @param paramIdTypeVin Le nouvel identifiant du type de vin
     */
    public void setIdTypeVin(Integer paramIdTypeVin) {
        idTypeVin = paramIdTypeVin;
    }
    /**
     * @return Le libellé du type de vin
     */
    public String getLibelle() {
        return libelle;
    }
    /**
     * @param paramLibelle Le nouveau libellé du type de vin
     */
    public void setLibelle(String paramLibelle) {
        libelle = paramLibelle;
    }
    @Override
    public String toString() {
        return "TypeVin [idTypeVin=" + idTypeVin + ", libelle=" + libelle + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result;
        if (idTypeVin != null) {
            result += idTypeVin.hashCode();
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
        TypeVin other = (TypeVin) obj;
        if (idTypeVin == null) {
            if (other.idTypeVin != null) {
                return false;
            }
        } else if (!idTypeVin.equals(other.idTypeVin)) {
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
