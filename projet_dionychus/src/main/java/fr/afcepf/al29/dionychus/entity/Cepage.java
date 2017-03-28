package fr.afcepf.al29.dionychus.entity;

/**
 * Entité pour les cépages des {@link Vin} vendus par Dyonichus.
 *
 * @author ecala
 *
 */
public class Cepage {
    /**
     * l'id du cépage.
     */
    private Integer idCepage;
    /**
     * le libellé du cépage.
     */
    private String libelle;

    /**
     * Constructeur par défaut.
     */
    public Cepage() {
        super();
    }
    /**
     * Constructeur surchargé.
     * @param paramIdCepage id to set.
     * @param paramLibelle libellé to set.
     */
    public Cepage(Integer paramIdCepage, String paramLibelle) {
        super();
        idCepage = paramIdCepage;
        libelle = paramLibelle;
    }
    /**
     *
     * @return l'id du cépage.
     */
    public Integer getIdCepage() {
        return idCepage;
    }
    /**
     *
     * @param paramIdCepage id to set.
     */
    public void setIdCepage(Integer paramIdCepage) {
        idCepage = paramIdCepage;
    }
    /**
     *
     * @return libellé du cépage.
     */
    public String getLibelle() {
        return libelle;
    }
    /**
     * @param paramLibelle libellé to set.
     */
    public void setLibelle(String paramLibelle) {
        libelle = paramLibelle;
    }

    @Override
    public String toString() {
        return "Cepage [idCepage=" + idCepage + ", libelle=" + libelle + "]";
    }

}
