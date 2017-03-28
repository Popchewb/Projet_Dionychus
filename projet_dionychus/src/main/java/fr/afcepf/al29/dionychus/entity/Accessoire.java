package fr.afcepf.al29.dionychus.entity;

import java.util.List;

/**
 * Entité pour les accessoires de qualité vendus par Dyonichus.
 *
 * @author ecala
 */
public class Accessoire extends Article {
    /**
     * Type d'accessoire de l'{@link Accessoire}.
     */
    private TypeAccessoire typeAccessoire;

    /**
     * Constructeur par défaut de l'accessoire.
     */
    public Accessoire() {
        super();
    }

    /**
     * Constructeur surchargé de l'accessoire.
     *
     * @param paramTypeAccessoire
     *            le type de l'accessoire.
     */
    public Accessoire(TypeAccessoire paramTypeAccessoire) {
        super();
        typeAccessoire = paramTypeAccessoire;
    }

    /**
     * Constructeur surchargé de l'accessoire.
     *
     * @param paramIdArticle
     *            id de l'accessoire
     * @param paramReference
     *            référence de l'accessoire
     * @param paramLibelle
     *            libellé de l'accessoire
     * @param paramDescription
     *            description de l'accessoire
     * @param paramPrix
     *            prix de l'accessoire
     * @param paramQuantite
     *            stock restant de l'accessoire
     * @param paramSeuilAlerte
     *            seuil à partir duquel l'application averti du stock restant de
     *            l'accessoire
     * @param paramUrlImage
     *            url de l'image de l'accessoire qui apparait dans l'IHM
     * @param paramTypeArticle
     *            type d'article de l'accessoire
     * @param paramCommentaires
     *            les commentaires des clients sur l'accessoire
     * @param paramTypeAccessoire
     *            le type accessoire de l'accessoire.
     */
    public Accessoire(Integer paramIdArticle, String paramReference, String paramLibelle, String paramDescription,
            Double paramPrix, Integer paramQuantite, Integer paramSeuilAlerte, String paramUrlImage,
            String paramTypeArticle, List<Commentaire> paramCommentaires, TypeAccessoire paramTypeAccessoire) {
        super(paramIdArticle, paramReference, paramLibelle, paramDescription, paramPrix, paramQuantite,
                paramSeuilAlerte, paramUrlImage, paramTypeArticle, paramCommentaires);
        typeAccessoire = paramTypeAccessoire;
    }

    /**
     *
     * @return le type de l'accessoire.
     */
    public TypeAccessoire getTypeAccessoire() {
        return typeAccessoire;
    }

    /**
     *
     * @param paramTypeAccessoire
     *            le type de l'accessoire to set.
     */
    public void setTypeAccessoire(TypeAccessoire paramTypeAccessoire) {
        typeAccessoire = paramTypeAccessoire;
    }

    /**
     * @return le texte du type d'accessoire.
     */
    @Override
    public String toString() {
        return "Accessoire [typeAccessoire=" + typeAccessoire + "]";
    }

}
