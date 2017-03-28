package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.StatutCommande;

/**
 * Interface pour les méthodes d'accès aux données des {@link StatutCommande}.
 *
 * @author ecala
 *
 */
public interface StatutCommandeDaoItf {
    /**
     * Récupère tous les {@link StatutCommande} de l'unité de persistence.
     * @return la liste des {@link StatutCommande}.
     */
    List<StatutCommande> getAll();
    /**
     * Récupère un {@link StatutCommande} par son identifiant.
     * @param paramIdStatutCommande l'id du {@link StatutCommande}.
     * @return le {@link StatutCommande}.
     */
    StatutCommande getById(int paramIdStatutCommande);
}
