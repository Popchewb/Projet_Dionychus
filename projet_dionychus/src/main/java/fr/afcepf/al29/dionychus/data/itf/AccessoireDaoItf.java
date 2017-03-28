package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Accessoire;
import fr.afcepf.al29.dionychus.entity.Article;

/**
 * Interface pour les méthodes d'accès aux données des accessoires.
 *
 * @author ecala
 *
 */
public interface AccessoireDaoItf {
    /**
     *
     * @return tous les accessoires.
     */
    List<Accessoire> getAll();
    /**
     *
     * @param paramIdAccessoire l'id de l'accessoire to set.
     * @return l'accessoire en fonction de son id.
     */
    Accessoire getById(Integer paramIdAccessoire);
    /**
     * Ajoute un accessoire dans l'unité de persistence.
     * @param paramAccessoire l'accessoire à ajouter.
     * @param paramIdFournisseur l'id du fournisseur to set.
     */
    void addAccessoire(Accessoire paramAccessoire, Integer paramIdFournisseur);
    /**
     * Met à jour un accessoire dans l'unité de persistence.
     * @param paramAccessoire l'accessoire à mettre à jour.
     */
    void updateAccessoire(Accessoire paramAccessoire);
    /**
     * Supprime un accessoire de l'unité de persistence.
     * @param paramIdAccessoire l'id de l'accessoire à supprimer.
     */
    void deleteAccessoire(Integer paramIdAccessoire);
    /**
     *
     * @return la liste des 4 {@link Accessoire} les plus vendus.
     */
    List<Article> getBestSellerAccessoire();
}
