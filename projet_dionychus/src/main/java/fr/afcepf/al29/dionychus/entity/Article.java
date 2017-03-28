package fr.afcepf.al29.dionychus.entity;

import java.util.List;

/**
 * Entité pour les articles vendus par l'application Dyonichus.
 *
 * @author ecala
 *
 */
public class Article {
    /**
     * l'id de l'article.
     */
    private Integer idArticle;
    /**
     * la référence de l'article.
     */
    private String reference;
    /**
     * le libellé de l'article.
     */
    private String libelle;
    /**
     * la description de l'article.
     */
    private String description;
    /**
     * le prix de l'article.
     */
    private Double prix;
    /**
     * le stock restant de l'article.
     */
    private Integer quantite;
    /**
     * seuil à partir duquel l'application averti du bas niveau de stock.
     */
    private Integer seuilAlerte;
    /**
     * url de l'image de l'article.
     */
    private String urlImage;
    /**
     * le type de l'article.
     */
    private String typeArticle;
    /**
     * la liste des commentaires de l'article par les clients.
     */
    private List<Commentaire> commentaires;

    /**
     * Constructeur par défaut.
     */
    public Article() {
        super();
    }

    /**
     * Constructeur surchargé.
     *
     * @param paramIdArticle
     *            id to set.
     * @param paramReference
     *            référence to set.
     * @param paramLibelle
     *            libellé to set.
     * @param paramDescription
     *            description to set.
     * @param paramPrix
     *            prix to set.
     * @param paramQuantite
     *            stock to set.
     * @param paramSeuilAlerte
     *            seuil du stock to set.
     * @param paramUrlImage
     *            lien de l'image de l'article to set.
     * @param paramTypeArticle
     *            type de l'article to set.
     * @param paramCommentaires
     *            commentaires to set.
     */
    public Article(Integer paramIdArticle, String paramReference, String paramLibelle, String paramDescription,
            Double paramPrix, Integer paramQuantite, Integer paramSeuilAlerte, String paramUrlImage,
            String paramTypeArticle, List<Commentaire> paramCommentaires) {
        super();
        idArticle = paramIdArticle;
        reference = paramReference;
        libelle = paramLibelle;
        description = paramDescription;
        prix = paramPrix;
        quantite = paramQuantite;
        seuilAlerte = paramSeuilAlerte;
        urlImage = paramUrlImage;
        typeArticle = paramTypeArticle;
        commentaires = paramCommentaires;
    }

    /**
     *
     * @return l'id de l'article.
     */
    public Integer getIdArticle() {
        return idArticle;
    }
    /**
     *
     * @param paramIdArticle id to set.
     */
    public void setIdArticle(Integer paramIdArticle) {
        idArticle = paramIdArticle;
    }
    /**
     *
     * @return la référence de l'article.
     */
    public String getReference() {
        return reference;
    }
    /**
     *
     * @param paramReference référence to set.
     */
    public void setReference(String paramReference) {
        reference = paramReference;
    }
    /**
     *
     * @return le libelle de l'article.
     */
    public String getLibelle() {
        return libelle;
    }
    /**
     *
     * @param paramLibelle le libelle to set.
     */
    public void setLibelle(String paramLibelle) {
        libelle = paramLibelle;
    }
    /**
     *
     * @return la description de l'article.
     */
    public String getDescription() {
        return description;
    }
    /**
     *
     * @param paramDescription la description to set.
     */
    public void setDescription(String paramDescription) {
        description = paramDescription;
    }
    /**
     *
     * @return le prix de l'article.
     */
    public Double getPrix() {
        return prix;
    }
    /**
     *
     * @param paramPrix le prix to set.
     */
    public void setPrix(Double paramPrix) {
        prix = paramPrix;
    }
    /**
     *
     * @return le stock restant de l'article.
     */
    public Integer getQuantite() {
        return quantite;
    }
    /**
     *
     * @param paramQuantite stock to set.
     */
    public void setQuantite(Integer paramQuantite) {
        quantite = paramQuantite;
    }
    /**
     *
     * @return le seuil d'alerte pour le stock de l'article.
     */
    public Integer getSeuilAlerte() {
        return seuilAlerte;
    }
    /**
     *
     * @param paramSeuilAlerte seuil d'alerte to set.
     */
    public void setSeuilAlerte(Integer paramSeuilAlerte) {
        seuilAlerte = paramSeuilAlerte;
    }
    /**
     *
     * @return l'url de l'image de l'article.
     */
    public String getUrlImage() {
        return urlImage;
    }
    /**
     *
     * @param paramUrlImage url de l'image to set.
     */
    public void setUrlImage(String paramUrlImage) {
        urlImage = paramUrlImage;
    }
    /**
     *
     * @return le type d'article de l'article.
     */
    public String getTypeArticle() {
        return typeArticle;
    }
    /**
     *
     * @param paramTypeArticle type de l'article to set.
     */
    public void setTypeArticle(String paramTypeArticle) {
        typeArticle = paramTypeArticle;
    }
    /**
     *
     * @return les commentaires de l'article.
     */
    public List<Commentaire> getCommentaires() {
        return commentaires;
    }
    /**
     *
     * @param paramCommentaires les commentaires to set.
     */
    public void setCommentaires(List<Commentaire> paramCommentaires) {
        commentaires = paramCommentaires;
    }
    /**
     * @return les paramètres de l'article sous forme de texte.
     */
    @Override
    public String toString() {
        return "Article [idArticle=" + idArticle + ", reference=" + reference + ", libelle=" + libelle
                + ", description=" + description + ", prix=" + prix + ", quantite=" + quantite + ", seuilAlerte="
                + seuilAlerte + ", urlImage=" + urlImage + ", typeArticle=" + typeArticle + ", commentaires="
                + commentaires + "]";
    }

}
