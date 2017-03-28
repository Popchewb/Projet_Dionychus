package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Pays;

/**
 * Interface pour les méthodes d'accès aux données des {@link Pays}.
 *
 * @author ecala
 *
 */
public interface PaysDaoItf {
    /**
     * Récupère la liste de tous les {@link Pays}.
     * @return la liste des {@link Pays}.
     */
    List<Pays> getAllPays();
    /**
     * Récupère un {@link Pays} par l'identifiant d'une ville.
     * @param paramIdVille l'identifiant de la ville
     * @return le {@link Pays}.
     */
    Pays getPaysByIdVille(Integer paramIdVille);

}
