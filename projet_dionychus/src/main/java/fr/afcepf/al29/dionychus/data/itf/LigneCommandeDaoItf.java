package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.LigneCommande;

/**
 * Interface pour les méthodes d'accès aux données des {@link LigneCommande}.
 *
 * @author ecala
 *
 */
public interface LigneCommandeDaoItf {
    /**
     * Récupère toutes les {@link LigneCommande} d'une {@link Commande}.
     * @param paramIdCommande l'id de la commande.
     * @return la liste des {@link LigneCommande}.
     */
    List<LigneCommande> getAllByIdCommande(Integer paramIdCommande);
    /**
     * Ajoute une {@link LigneCommande} dans l'unité de persistence.
     * @param paramLigneCommande la {@link LigneCommande} à ajouter.
     * @param paramIdCommande l'id de la commande.
     */
    void addLigneCommande(LigneCommande paramLigneCommande, Integer paramIdCommande);
    /**
     * Met à jour une {@link LigneCommande} dans l'unité de persistence.
     * @param paramLigneCommande la {@link LigneCommande} à mettre à jour.
     */
    void updateLigneCommande(LigneCommande paramLigneCommande);
    /**
     * Supprime une {@link LigneCommande} de l'unité de persistence.
     * @param paramIdLigneCommande l'id de la {@link LigneCommande} à supprimer.
     */
    void deleteLigneCommande(Integer paramIdLigneCommande);
}
