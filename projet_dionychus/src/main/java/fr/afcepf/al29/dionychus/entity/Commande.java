package fr.afcepf.al29.dionychus.entity;

import java.sql.Date;
import java.util.List;

/**
 * Entité générique pour les commandes, passées par les clients ou auprès des
 * fournisseurs.
 *
 * @author ecala
 *
 */
public class Commande {
    /**
     * l'id de la commande.
     */
    private Integer idCommande;
    /**
     * la date de validation de la commande.
     */
    private Date dateValidation;
    /**
     * le numéro de référence de la commande.
     */
    private String numeroReference;
    /**
     * le statut de la commande.
     */
    private StatutCommande statutCommande;
    /**
     * les lignes de commande de la commande.
     */
    private List<LigneCommande> lignesCommande;

    /**
     * Constructeur par défaut.
     */
    public Commande() {
        super();
    }
    /**
     * Constructeur surchargé.
     * @param paramIdCommande id to set.
     * @param paramDateValidation date validation to set.
     * @param paramNumeroReference numéro de référence to set.
     * @param paramStatutCommande statut de la commande to set.
     * @param paramLignesCommande lignes commande to set.
     */
    public Commande(Integer paramIdCommande, Date paramDateValidation, String paramNumeroReference,
            StatutCommande paramStatutCommande, List<LigneCommande> paramLignesCommande) {
        super();
        idCommande = paramIdCommande;
        dateValidation = paramDateValidation;
        numeroReference = paramNumeroReference;
        statutCommande = paramStatutCommande;
        lignesCommande = paramLignesCommande;
    }
    /**
     *
     * @return l'id de la commande.
     */
    public Integer getIdCommande() {
        return idCommande;
    }
    /**
     *
     * @param paramIdCommande id to set.
     */
    public void setIdCommande(Integer paramIdCommande) {
        idCommande = paramIdCommande;
    }
    /**
     *
     * @return la date de validation de la commande.
     */
    public Date getDateValidation() {
        return dateValidation;
    }
    /**
     *
     * @param paramDateValidation date de validation to set.
     */
    public void setDateValidation(Date paramDateValidation) {
        dateValidation = paramDateValidation;
    }
    /**
     *
     * @return le numéro de référence de la commande.
     */
    public String getNumeroReference() {
        return numeroReference;
    }
    /**
     *
     * @param paramNumeroReference to set.
     */
    public void setNumeroReference(String paramNumeroReference) {
        numeroReference = paramNumeroReference;
    }
    /**
     *
     * @return le statut de la commande.
     */
    public StatutCommande getStatutCommande() {
        return statutCommande;
    }
    /**
     *
     * @param paramStatutCommande  le statut de la commande to set.
     */
    public void setStatutCommande(StatutCommande paramStatutCommande) {
        statutCommande = paramStatutCommande;
    }
    /**
     *
     * @return les lignes de commande de la commande.
     */
    public List<LigneCommande> getLignesCommande() {
        return lignesCommande;
    }
    /**
     *
     * @param paramLignesCommande les lignes de commande to set.
     */
    public void setLignesCommande(List<LigneCommande> paramLignesCommande) {
        lignesCommande = paramLignesCommande;
    }
    /**
     * @return les paramètres de la commande en texte.
     */
    @Override
    public String toString() {
        return "Commande [idCommande=" + idCommande + ", dateValidation=" + dateValidation + ", numeroReference="
                + numeroReference + ", statutCommande=" + statutCommande + ", lignesCommande=" + lignesCommande + "]";
    }

}
