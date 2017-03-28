package fr.afcepf.al29.dionychus.entity;

import java.util.List;

/**
 * Entité pour les acteurs présent dans l'application Dyonichus à savoir les
 * clients, les utilisateurs et les fournisseurs.
 *
 * @author ecala
 *
 */

public abstract class Acteur {
    /**
     * l'id de l'acteur.
     */
    private Integer idActeur;
    /**
     * le nom de l'acteur.
     */
    private String nom;
    /**
     * le prénom de l'acteur.
     */
    private String prenom;
    /**
     * le numéro de téléphone de l'acteur.
     */
    private String numeroTelephone;
    /**
     * l'adresse e-mail de l'acteur.
     */
    private String adresseMail;
    /**
     * la {@link Civilite} de l'acteur.
     */
    private String civilite;
    /**
     * les {@link Adresse} de l'utilisateur.
     */
    private List<Adresse> adresses;

    /**
     * Constructeur par défaut de l'acteur.
     */
    public Acteur() {
        super();
    }

    /**
     * Constructeur surchargé de l'acteur.
     *
     * @param paramIdActeur
     *            son id
     * @param paramNom
     *            son nom
     * @param paramPrenom
     *            son prénom
     * @param paramNumeroTelephone
     *            son numéro de téléphone
     * @param paramAdresseMail
     *            son adresse e-mail
     * @param paramCivilite
     *            sa civilité
     * @param paramAdresses
     *            la liste de ses adresses
     */
    public Acteur(Integer paramIdActeur, String paramNom, String paramPrenom, String paramNumeroTelephone,
            String paramAdresseMail, String paramCivilite, List<Adresse> paramAdresses) {
        super();
        idActeur = paramIdActeur;
        nom = paramNom;
        prenom = paramPrenom;
        numeroTelephone = paramNumeroTelephone;
        adresseMail = paramAdresseMail;
        civilite = paramCivilite;
        adresses = paramAdresses;
    }

    /**
     *
     * @return l'id de l'acteur.
     */
    public Integer getIdActeur() {
        return idActeur;
    }

    /**
     *
     * @param paramIdActeur
     *            id to set.
     */
    public void setIdActeur(Integer paramIdActeur) {
        idActeur = paramIdActeur;
    }

    /**
     *
     * @return le nom de l'acteur.
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @param paramNom
     *            nom to set.
     */
    public void setNom(String paramNom) {
        nom = paramNom;
    }

    /**
     *
     * @return le prénom de l'acteur.
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     *
     * @param paramPrenom
     *            prénom to set.
     */
    public void setPrenom(String paramPrenom) {
        prenom = paramPrenom;
    }

    /**
     *
     * @return le numéro de téléphone de l'acteur.
     */
    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    /**
     *
     * @param paramNumeroTelephone
     *            numéro de téléphone to set.
     */
    public void setNumeroTelephone(String paramNumeroTelephone) {
        numeroTelephone = paramNumeroTelephone;
    }

    /**
     *
     * @return l'adresse email de l'acteur.
     */
    public String getAdresseMail() {
        return adresseMail;
    }

    /**
     *
     * @param paramAdresseMail
     *            adresse email to set.
     */
    public void setAdresseMail(String paramAdresseMail) {
        adresseMail = paramAdresseMail;
    }

    /**
     *
     * @return la civilité de l'acteur.
     */
    public String getCivilite() {
        return civilite;
    }

    /**
     *
     * @param paramCivilite
     *            la civilité to set.
     */
    public void setCivilite(String paramCivilite) {
        civilite = paramCivilite;
    }

    /**
     *
     * @return les adresses de l'acteur.
     */
    public List<Adresse> getAdresses() {
        return adresses;
    }

    /**
     *
     * @param paramAdresses
     *            les adresses to set.
     */
    public void setAdresses(List<Adresse> paramAdresses) {
        adresses = paramAdresses;
    }

}
