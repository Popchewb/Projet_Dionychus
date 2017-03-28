package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.TypeAccessoire;

/**
 * Interface pour les méthodes d'accès aux données des {@link TypeAccessoire}.
 *
 * @author ecala
 *
 */
public interface TypeAccessoireDaoItf {
    /**
     * Récupère tous les {@link TypeAccessoire} de l'unité de persistence.
     * @return la liste des {@link TypeAccessoire}.
     */
    List<TypeAccessoire> getAll();
    /**
     * Récupère un {@link TypeAccessoire} par son identifiant.
     * @param paramIdTypeAccessoire l'id du {@link TypeAccessoire}.
     * @return le {@link TypeAccessoire}.
     */
    TypeAccessoire getById(Integer paramIdTypeAccessoire);
}
