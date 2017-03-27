package fr.afcepf.al29.dionychus.entity;
/**
 * Ville de résidence de l'utilisateur connecté à l'application Dionychus.
 * @author Nicolas
 *
 */
public class Ville {
    /**
     * Identifiant de la ville.
     */
    private Integer idVille;
    /**
     * Nom de la ville.
     */
    private String libelle;
    /**
     * Code postal de la ville.
     */
    private String codePostal;
    /**
     * Pays dans lequel se trouve la ville.
     */
    private Pays pays;
    /**
     * Constructeur par défaut.
     */
    public Ville() {
        super();
    }

    /**
     * @param paramIdVille Identifiant de la ville
     * @param paramLibelle Nom de la ville
     * @param paramCodePostal Code postal de la ville
     * @param paramPays Pays dans lequel se trouve la ville
     */
    public Ville(Integer paramIdVille, String paramLibelle, String paramCodePostal, Pays paramPays) {
        super();
        idVille = paramIdVille;
        libelle = paramLibelle;
        codePostal = paramCodePostal;
        pays = paramPays;
    }
    /**
     * @return L'identifiant de la ville
     */
    public Integer getIdVille() {
        return idVille;
    }

    /**
     * @param paramIdVille Le nouvel identifiant de la ville
     */
    public void setIdVille(Integer paramIdVille) {
        idVille = paramIdVille;
    }

    /**
     * @return Le nom de la ville
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * @param paramLibelle Le nouveau nom de la ville
     */
    public void setLibelle(String paramLibelle) {
        libelle = paramLibelle;
    }

    /**
     * @return Le code postal de la ville
     */
    public String getCodePostal() {
        return codePostal;
    }

    /**
     * @param paramCodePostal Le nouveau code postal de la ville
     */
    public void setCodePostal(String paramCodePostal) {
        codePostal = paramCodePostal;
    }

    /**
     * @return Le pays dans lequel se trouve la ville
     */
    public Pays getPays() {
        return pays;
    }

    /**
     * @param paramPays Le nouveau pays dans lequel se trouve la ville
     */
    public void setPays(Pays paramPays) {
        pays = paramPays;
    }

    @Override
    public String toString() {
        return "Ville [idVille=" + idVille + ", libelle=" + libelle + ", codePostal=" + codePostal + ", pays=" + pays
                + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result;
        if (idVille != null) {
            result += idVille.hashCode();
        }
        result = prime * result;
        if (codePostal != null) {
            result += codePostal.hashCode();
        }
        result = prime * result;
        if (libelle != null) {
            result += libelle.hashCode();
        }
        result = prime * result;
        if (pays != null) {
            result += pays.hashCode();
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
        Ville other = (Ville) obj;
        if (codePostal == null) {
            if (other.codePostal != null) {
                return false;
            }
        } else if (!codePostal.equals(other.codePostal)) {
            return false;
        }
        if (idVille == null) {
            if (other.idVille != null) {
                return false;
            }
        } else if (!idVille.equals(other.idVille)) {
            return false;
        }
        if (libelle == null) {
            if (other.libelle != null) {
                return false;
            }
        } else if (!libelle.equals(other.libelle)) {
            return false;
        }
        if (pays == null) {
            if (other.pays != null) {
                return false;
            }
        } else if (!pays.equals(other.pays)) {
            return false;
        }
        return true;
    }
}
