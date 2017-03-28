package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.TypeAcces;

/**
 * Interface pour les méthodes d'accès aux données des {@link TypeAcces}.
 *
 * @author ecala
 *
 */
public interface TypeAccesDaoItf {
    /**
     * Récupère tous les {@link TypeAcces}.
     * @return la liste de tous les {@link TypeAcces}.
     */
    List<TypeAcces> getAll();

}
