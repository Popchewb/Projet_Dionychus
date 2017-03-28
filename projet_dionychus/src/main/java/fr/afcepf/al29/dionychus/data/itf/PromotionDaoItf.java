package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Promotion;

/**
 * Interface pour les méthodes d'accès aux données des {@link Promotion}.
 *
 * @author ecala
 *
 */
public interface PromotionDaoItf {
    /**
     * Récupère la liste de toutes les {@link Promotion}.
     *
     * @return toutes les {@link Promotion}.
     */
    List<Promotion> getAll();

    /**
     * Ajoute une {@link Promotion} dans l'unité de persistence.
     *
     * @param paramPromotion
     *            la {@link Promotion} à ajouter.
     */
    void addPromotion(Promotion paramPromotion);

    /**
     * Met à jour une {@link Promotion} dans l'unité de persistence.
     *
     * @param paramPromotion
     *            la {@link Promotion} à mettre à jour.
     */
    void updatePromotion(Promotion paramPromotion);

    /**
     * Supprime une {@link Promotion} de l'unité de persistence.
     *
     * @param paramIdPromotion
     *            la {@link Promotion} à supprimer.
     */
    void deletePromotion(Integer paramIdPromotion);
}