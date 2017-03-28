package fr.afcepf.al29.dionychus.entity;

/**
 * Entités pour les appellations des {@link Vin} de Dyonichus.
 *
 * @author ecala
 *
 */
public class Appelation {
    /**
     * id de l'appellation.
     */
    private Integer idAppelation;
    /**
     * libelle de l'appellation.
     */
    private String libelle;

    /**
     * Constructeur par défaut de l'appellation.
     */
    public Appelation() {
        super();
    }

    /**
     * Constructeur surchargé de l'appellation.
     *
     * @param paramIdAppelation
     *            id to set.
     * @param paramLibelle
     *            libelle to set.
     */
    public Appelation(Integer paramIdAppelation, String paramLibelle) {
        super();
        idAppelation = paramIdAppelation;
        libelle = paramLibelle;
    }

    /**
     *
     * @return l'id de l'appellation.
     */
    public Integer getIdAppelation() {
        return idAppelation;
    }

    /**
     *
     * @param paramIdAppelation
     *            id to set.
     */
    public void setIdAppelation(Integer paramIdAppelation) {
        idAppelation = paramIdAppelation;
    }

    /**
     *
     * @return le libellé de l'appellation.
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     *
     * @param paramLibelle
     *            libellé to set.
     */
    public void setLibelle(String paramLibelle) {
        libelle = paramLibelle;
    }

    /**
     * @return les paramètres de l'appellation en texte.
     */
    @Override
    public String toString() {
        return "Appelation [idAppelation=" + idAppelation + ", libelle=" + libelle + "]";
    }

}
