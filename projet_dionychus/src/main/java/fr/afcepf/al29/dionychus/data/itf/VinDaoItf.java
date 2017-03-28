package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Article;
import fr.afcepf.al29.dionychus.entity.Vin;

/**
 * Interface pour les méthodes d'accès aux données des {@link Vin}.
 *
 * @author ecala
 *
 */
public interface VinDaoItf {
    /**
     * Récupère tous les {@link Vin} de l'unité de persistence.
     * @return la liste de tous les {@link Vin}.
     */
    List<Vin> getAll();
    /**
     * Récupère un {@link Vin} par son identifiant.
     * @param paramIdVin l'id du {@link Vin}.
     * @return le {@link Vin}.
     */
    Vin getById(Integer paramIdVin);
    /**
     * Ajoute un {@link Vin} dans l'unité de persistence.
     * @param paramVin le {@link Vin} à ajouter.
     * @param paramIdFournisseur le fournisseur du {@link Vin}.
     */
    void addVin(Vin paramVin, Integer paramIdFournisseur);
    /**
     * Met à jour un {@link Vin} dans l'unité de persistence.
     * @param paramVin le {@link Vin} à mettre à jour.
     */
    void updateVin(Vin paramVin);
    /**
     * Supprime un {@link Vin} de l'unité de persistence.
     * @param paramIdVin l'id du {@link Vin} à supprimer.
     */
    void deleteVin(Integer paramIdVin);
    /**
     * Récupère les 4 {@link Vin} les plus vendus.
     * @return la liste des meilleurs {@link Vin}.
     */
    List<Article> getBestSellerVin();
    /**
     * Récupère les {@link Vin} les plus achetés avec un article.
     * @param idCommande l'identifiant de la commande.
     * @return la liste des articles associés.
     */
    List<Article> getArticlesAssocies(Integer idCommande);
}