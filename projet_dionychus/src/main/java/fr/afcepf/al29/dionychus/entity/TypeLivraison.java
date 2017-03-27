package fr.afcepf.al29.dionychus.entity;
/**
 * Classe qui définit le type de livraison choisit par le client pour recevoir sa commande.
 * @author Nicolas
 *
 */
public class TypeLivraison {
    /**
     * Identifiant du type de livraison.
     */
    private Integer idTypeLivraison;
    /**
     * Libellé du type de livraison.
     */
    private String libelle;
    /**
     * Description du type de livraison choisi.
     */
    private String description;
    /**
     * Url de l'image associée au type de livraison choisi.
     */
    private String urlImage;
    /**
     * Tarification du type de livraison.
     */
    private Double tarification;
    /**
     * Constructeur par défaut.
     */
    public TypeLivraison() {
        super();
    }
    /**
     * @param paramIdTypeLivraison Identifiant du type de livraison
     * @param paramLibelle Libellé du type de livraison
     * @param paramDescription Description du type de livraison
     * @param paramUrlImage Url de l'image associée au type de livraison
     * @param paramTarification Tarification du type de livraison
     */
    public TypeLivraison(Integer paramIdTypeLivraison, String paramLibelle, String paramDescription,
            String paramUrlImage, Double paramTarification) {
        super();
        idTypeLivraison = paramIdTypeLivraison;
        libelle = paramLibelle;
        description = paramDescription;
        urlImage = paramUrlImage;
        tarification = paramTarification;
    }
    /**
     * @return L'identifiant du type de livraison
     */
    public Integer getIdTypeLivraison() {
        return idTypeLivraison;
    }
    /**
     * @param paramIdTypeLivraison Le nouvel identifiant du type de livraison
     */
    public void setIdTypeLivraison(Integer paramIdTypeLivraison) {
        idTypeLivraison = paramIdTypeLivraison;
    }
    /**
     * @return Le libellé du type de livraison
     */
    public String getLibelle() {
        return libelle;
    }
    /**
     * @param paramLibelle Le nouveau libellé du type de livraison
     */
    public void setLibelle(String paramLibelle) {
        libelle = paramLibelle;
    }
    /**
     * @return La description du type de livraison
     */
    public String getDescription() {
        return description;
    }
    /**
     * @param paramDescription La nouvelle description du type de livraison
     */
    public void setDescription(String paramDescription) {
        description = paramDescription;
    }
    /**
     * @return L'url de l'image associée au type de livraison
     */
    public String getUrlImage() {
        return urlImage;
    }
    /**
     * @param paramUrlImage La nouvelle url de l'image associée au type de livraison
     */
    public void setUrlImage(String paramUrlImage) {
        urlImage = paramUrlImage;
    }
    /**
     * @return La tarification du type de livraison
     */
    public Double getTarification() {
        return tarification;
    }
    /**
     * @param paramTarification La nouvelle tarification du type de livraison
     */
    public void setTarification(Double paramTarification) {
        tarification = paramTarification;
    }
    @Override
    public String toString() {
        return "TypeLivraison [idTypeLivraison=" + idTypeLivraison + ", libelle=" + libelle + ", description="
                + description + ", urlImage=" + urlImage + ", tarification=" + tarification + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result;
        if (idTypeLivraison != null) {
            result += idTypeLivraison.hashCode();
        }
        result = prime * result;
        if (libelle != null) {
            result += libelle.hashCode();
        }
        result = prime * result;
        if (description != null) {
            result += description.hashCode();
        }
        result = prime * result;
        if (tarification != null) {
            result += tarification.hashCode();
        }
        result = prime * result;
        if (urlImage != null) {
            result += urlImage.hashCode();
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
        TypeLivraison other = (TypeLivraison) obj;
        if (description == null) {
            if (other.description != null) {
                return false;
            }
        } else if (!description.equals(other.description)) {
            return false;
        }
        if (idTypeLivraison == null) {
            if (other.idTypeLivraison != null) {
                return false;
            }
        } else if (!idTypeLivraison.equals(other.idTypeLivraison)) {
            return false;
        }
        if (libelle == null) {
            if (other.libelle != null) {
                return false;
            }
        } else if (!libelle.equals(other.libelle)) {
            return false;
        }
        if (tarification == null) {
            if (other.tarification != null) {
                return false;
            }
        } else if (!tarification.equals(other.tarification)) {
            return false;
        }
        if (urlImage == null) {
            if (other.urlImage != null) {
                return false;
            }
        } else if (!urlImage.equals(other.urlImage)) {
            return false;
        }
        return true;
    }
}
