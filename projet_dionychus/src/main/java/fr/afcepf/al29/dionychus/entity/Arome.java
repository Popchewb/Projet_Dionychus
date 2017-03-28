package fr.afcepf.al29.dionychus.entity;

/**
 * Entité pour les délicieux arômes des {@link Vin} de Dyonichus.
 *
 * @author ecala
 *
 */
public class Arome {
    /**
     * id de l'arôme.
     */
    private Integer idArome;
    /**
     * libelle de l'arôme.
     */
    private String libelle;

    /**
     * Constructeur par défaut de l'arôme.
     */
    public Arome() {
        super();
    }

    /**
     * Constructeur surchargé de l'arôme.
     *
     * @param paramIdArome
     *            l'id de l'arôme.
     * @param paramLibelle
     *            libelle de l'arôme.
     */
    public Arome(Integer paramIdArome, String paramLibelle) {
        super();
        idArome = paramIdArome;
        libelle = paramLibelle;
    }

    /**
     *
     * @return id de l'arome.
     */
    public Integer getIdArome() {
        return idArome;
    }

    /**
     *
     * @param paramIdArome
     *            id to set.
     */
    public void setIdArome(Integer paramIdArome) {
        idArome = paramIdArome;
    }

    /**
     *
     * @return le libellé de l'arôme.
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     *
     * @param paramLibelle
     *            le libellé de l'arôme to set.
     */
    public void setLibelle(String paramLibelle) {
        libelle = paramLibelle;
    }
    /**
     *
     * @return le texte des paramètres de l'arôme.
     */
    @Override
    public String toString() {
        return "Arome [idArome=" + idArome + ", libelle=" + libelle + "]";
    }

}
