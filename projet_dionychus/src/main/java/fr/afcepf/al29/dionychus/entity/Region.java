package fr.afcepf.al29.dionychus.entity;

/**
 * Classe qui permet de lister les différentes régions géographiques de provenance du vin.
 * @author Nicolas
 *
 */
public class Region {
    /**
     * Identifiant de la région.
     */
    private Integer idRegion;
    /**
     * Libellé de la région.
     */
    private String libelle;
    /**
     * Constructeur par défault.
     */
    public Region() {
        super();
    }
    /**
     * @param paramIdRegion identifiant de la région
     * @param paramLibelle libellé de la région
     */
    public Region(Integer paramIdRegion, String paramLibelle) {
        super();
        idRegion = paramIdRegion;
        libelle = paramLibelle;
    }
    /**
     * @return L'identifiant de la région
     */
    public Integer getIdRegion() {
        return idRegion;
    }
    /**
     * @param paramIdRegion Le nouvel identifiant de la région
     */
    public void setIdRegion(Integer paramIdRegion) {
        idRegion = paramIdRegion;
    }
    /**
     * @return Le libellé de la région
     */
    public String getLibelle() {
        return libelle;
    }
    /**
     * @param paramLibelle Le nouveau libellé de la région
     */
    public void setLibelle(String paramLibelle) {
        libelle = paramLibelle;
    }
    @Override
    public String toString() {
        return "Region [idRegion=" + idRegion + ", libelle=" + libelle + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result;
        if (idRegion != null) {
            result += idRegion.hashCode();
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
        Region other = (Region) obj;
        if (idRegion == null) {
            if (other.idRegion != null) {
                return false;
            }
        } else if (!idRegion.equals(other.idRegion)) {
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
