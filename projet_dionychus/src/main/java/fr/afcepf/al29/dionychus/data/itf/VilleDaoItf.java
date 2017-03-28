package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Ville;

/**
 * Interface pour les méthodes d'accès aux données des {@link Ville}.
 *
 * @author ecala
 *
 */
public interface VilleDaoItf {
    /**
     * Récupère toutes les {@link Ville} de l'unité de persistence.
     * @return la liste des {@link Ville}.
     */
    List<Ville> getAll();
    /**
     * Récupère toutes les {@link Ville} d'un pays.
     * @param paramIdPays l'id du pays.
     * @return la liste des {@link Ville} du pays.
     */
    List<Ville> getAllByIdPays(Integer paramIdPays);
    /**
     * Récupère une {@link Ville} par son identifiant.
     * @param paramIdVille l'identifiant de la {@link Ville}.
     * @return la {@link Ville}.
     */
    Ville getVilleById(Integer paramIdVille);

}
