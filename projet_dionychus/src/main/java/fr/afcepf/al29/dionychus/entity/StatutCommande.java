package fr.afcepf.al29.dionychus.entity;
/**
 * Classe qui représente l'état d'une commande sur le site de l'application Dionychus.
 * @author Nicolas
 *
 */
public class StatutCommande {
    /**
     * Identifiant du statut de la commande.
     */
    private Integer idStatutCommande;
    /**
     * Libellé du statut de la commande.
     */
    private String libelle;
    /**
     * Constructeur par défaut.
     */
    public StatutCommande() {
        super();
    }
    /**
     * @param paramIdStatutCommande Identifiant du statut de la commande
     * @param paramLibelle Libellé du statut de la commande
     */
    public StatutCommande(Integer paramIdStatutCommande, String paramLibelle) {
        super();
        idStatutCommande = paramIdStatutCommande;
        libelle = paramLibelle;
    }
    /**
     * @return the idStatutCommande L'identifiant du statut de la commande
     */
    public Integer getIdStatutCommande() {
        return idStatutCommande;
    }
    /**
     * @param paramIdStatutCommande Le nouvel identifiant du statut de la commande
     */
    public void setIdStatutCommande(Integer paramIdStatutCommande) {
        idStatutCommande = paramIdStatutCommande;
    }
    /**
     * @return the libelle Le libelle du statut de la commande
     */
    public String getLibelle() {
        return libelle;
    }
    /**
     * @param paramLibelle Le nouveau libelle du statut de la commande
     */
    public void setLibelle(String paramLibelle) {
        libelle = paramLibelle;
    }
    @Override
    public String toString() {
        return "StatutCommande [idStatutCommande=" + idStatutCommande + ", libelle=" + libelle + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result;
        if (idStatutCommande != null) {
            result += idStatutCommande.hashCode();
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
        StatutCommande other = (StatutCommande) obj;
        if (idStatutCommande == null) {
            if (other.idStatutCommande != null) {
                return false;
            }
        } else if (!idStatutCommande.equals(other.idStatutCommande)) {
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
