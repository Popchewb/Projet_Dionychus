package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Livraison;

/**
 * Interface pour méthodes d'accès aux données des {@link Livraison}.
 *
 * @author ecala
 *
 */
public interface LivraisonDaoItf {
    /**
     * Récupère toutes les {@link Livraison}.
     * @return la liste de toutes les {@link Livraison}.
     */
    List<Livraison> getAll();
    /**
     * Récupère toutes les {@link Livraison} d'un utilisateur.
     * @param paramIdUtilisateur l'id de l'utilisateur.
     * @return la liste de ses {@link Livraison}.
     */
    List<Livraison> getAllByIdUtilisateur(Integer paramIdUtilisateur);
    /**
     * Ajoute une {@link Livraison} dans l'unité de persistence.
     * @param paramLivraison la {@link Livraison} à ajouter.
     */
    void addLivraison(Livraison paramLivraison);
    /**
     * Met à jour une {@link Livraison} dans l'unité de persistence.
     * @param paramLivraison la {@link Livraison} à mettre à jour.
     */
    void updateLivraison(Livraison paramLivraison);
    /**
     * Supprime une {@link Livraison} de l'unité de persistence.
     * @param paramIdLivraison l'id de la livraison à mettre à jour.
     */
    void deleteLivraison(Integer paramIdLivraison);
}
