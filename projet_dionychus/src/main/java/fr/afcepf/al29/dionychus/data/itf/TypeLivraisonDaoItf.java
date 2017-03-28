package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.TypeLivraison;

/**
 * Interface pour les méthodes d'accès aux données des {@link TypeLivraison}.
 *
 * @author ecala
 *
 */
public interface TypeLivraisonDaoItf {
    /**
     * Récupère tous les {@link TypeLivraison} de l'unité de persistence.
     *
     * @return la liste des {@link TypeLivraison}.
     */
    List<TypeLivraison> getAll();

    /**
     * Récupère un {@link TypeLivraison} par son identifiant.
     *
     * @param paramIdTypeLivraison
     *            l'id du {@link TypeLivraison}.
     * @return le {@link TypeLivraison}.
     */
    TypeLivraison getById(Integer paramIdTypeLivraison);
}
