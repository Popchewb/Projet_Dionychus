package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.TypeVin;

/**
 * Interface pour les méthodes d'accès aux données des {@link TypeVin}.
 *
 * @author ecala
 *
 */
public interface TypeVinDaoItf {
    /**
     * Récupère tous les {@link TypeVin} de l'unité de persistence.
     *
     * @return la liste des {@link TypeVin}.
     */
    List<TypeVin> getAll();

    /**
     * Récupère un {@link TypeVin} par son identifiant.
     *
     * @param typeVin
     *            l'id du {@link TypeVin}.
     * @return le {@link TypeVin}.
     */
    TypeVin getTypeVinById(Integer typeVin);
}
