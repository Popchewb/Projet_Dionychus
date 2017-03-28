package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.CommandeStock;

/**
 * Interface pour les méthodes d'accès aux données des {@link CommandeStock}.
 *
 * @author ecala
 *
 */
public interface CommandeStockDaoItf {
    /**
     * Récupère toutes les {@link CommandeStock}.
     * @return la liste de toutes les {@link CommandeStock}.
     */
    List<CommandeStock> getAll();
    /**
     * Récupère les {@link CommandeStock} d'un {@link Utilisateur}.
     * @param paramIdUtilisateur l'id de l'utilisateur.
     * @return la liste des {@link CommandeStock} de l'{@link Utilisateur}.
     */
    List<CommandeStock> getCommandesByIdUtilisateur(Integer paramIdUtilisateur);
    /**
     * Récupère les {@link CommandeStock} d'un {@link StatutCommande} donné.
     * @param paramIdStatutCommande le {@link StatutCommande}.
     * @return la liste des {@link CommandeStock} ayant ce {@link StatutCommande}.
     */
    List<CommandeStock> getCommandesByIdStatutCommande(Integer paramIdStatutCommande);
    /**
     * Ajoute une {@link CommandeStock} dans l'unité de persistence.
     * @param paramCommandeStock la {@link CommandeStock} à ajouter.
     */
    void addCommandeStock(CommandeStock paramCommandeStock);
    /**
     * Met à jour une {@link CommandeStock} dans l'unité de persistence.
     * @param paramCommandeStock la {@link CommandeStock} à mettre à jour.
     */
    void updateCommandeStock(CommandeStock paramCommandeStock);
    /**
     * Supprime une {@link CommandeStock} dans l'unité de persistence.
     * @param paramIdCommandeStock la {@link CommandeStock} à supprimer.
     */
    void deleteCommandeStock(Integer paramIdCommandeStock);
}