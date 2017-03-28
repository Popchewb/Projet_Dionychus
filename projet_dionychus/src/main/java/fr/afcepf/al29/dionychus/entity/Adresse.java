package fr.afcepf.al29.dionychus.entity;

/**
 * Entité pour les adresses des {@link Acteur}.
 *
 * @author ecala
 *
 */
public class Adresse {
    /**
     * l'id de l'adresse.
     */
    private Integer idAdresse;
    /**
     * le libellé de l'adresse.
     */
    private String libelle;
    /**
     * le complément de l'adresse.
     */
    private String complementAdresse;
    /**
     * la ville de l'adresse.
     */
    private Ville ville;
    /**
     * true si l'adresse est une adresse de facturation.
     */
    private Boolean adresseFacturation;
    /**
     * true si l'adresse est une adresse de livraison.
     */
    private Boolean adresseLivraison;

    /**
     * Constructeur par défaut.
     */
    public Adresse() {
        super();
    }

    /**
     * Constructeur surchargé de l'adresse.
     *
     * @param paramIdAdresse
     *            id to set.
     * @param paramLibelle
     *            libelle to set.
     * @param paramComplementAdresse
     *            complément adresse to set.
     * @param paramVille
     *            ville to set.
     * @param paramAdresseFacturation
     *            isAdresseDeFacturation to set.
     * @param paramAdresseLivraison
     *            isAdresseDeLivraison to set.
     */
    public Adresse(Integer paramIdAdresse, String paramLibelle, String paramComplementAdresse, Ville paramVille,
            Boolean paramAdresseFacturation, Boolean paramAdresseLivraison) {
        super();
        idAdresse = paramIdAdresse;
        libelle = paramLibelle;
        complementAdresse = paramComplementAdresse;
        ville = paramVille;
        adresseFacturation = paramAdresseFacturation;
        adresseLivraison = paramAdresseLivraison;
    }

    /**
     *
     * @return l'id de l'adresse.
     */
    public Integer getIdAdresse() {
        return idAdresse;
    }

    /**
     *
     * @param paramIdAdresse
     *            id adresse to set.
     */
    public void setIdAdresse(Integer paramIdAdresse) {
        idAdresse = paramIdAdresse;
    }

    /**
     *
     * @return le libelle de l'adresse.
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     *
     * @param paramLibelle
     *            libelle to set.
     */
    public void setLibelle(String paramLibelle) {
        libelle = paramLibelle;
    }

    /**
     *
     * @return le complément d'adresse.
     */
    public String getComplementAdresse() {
        return complementAdresse;
    }

    /**
     *
     * @param paramComplementAdresse
     *            complément d'adresse to set.
     */
    public void setComplementAdresse(String paramComplementAdresse) {
        complementAdresse = paramComplementAdresse;
    }

    /**
     *
     * @return la ville de l'adresse.
     */
    public Ville getVille() {
        return ville;
    }

    /**
     *
     * @param paramVille
     *            la ville to set.
     */
    public void setVille(Ville paramVille) {
        ville = paramVille;
    }

    /**
     *
     * @return true si c'est une adresse de facturation.
     */
    public Boolean getAdresseFacturation() {
        return adresseFacturation;
    }

    /**
     *
     * @param paramAdresseFacturation
     *            isAdresseDeFacturation to set.
     */
    public void setAdresseFacturation(Boolean paramAdresseFacturation) {
        adresseFacturation = paramAdresseFacturation;
    }

    /**
     *
     * @return si c'est une adresse de livraison.
     */
    public Boolean getAdresseLivraison() {
        return adresseLivraison;
    }

    /**
     *
     * @param paramAdresseLivraison
     *            isAdresseDeLivraison to set.
     */
    public void setAdresseLivraison(Boolean paramAdresseLivraison) {
        adresseLivraison = paramAdresseLivraison;
    }

    /**
     * @return les paramètres de l'adresse en texte.
     */
    @Override
    public String toString() {
        return "Adresse [idAdresse=" + idAdresse + ", libelle=" + libelle + ", complementAdresse=" + complementAdresse
                + ", ville=" + ville + ", adresseFacturation=" + adresseFacturation + ", adresseLivraison="
                + adresseLivraison + "]";
    }

}
