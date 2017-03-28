package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Region;

/**
 * Interface pour les méthodes d'accès aux données des {@link Region}.
 *
 * @author ecala
 *
 */
public interface RegionDaoItf {
    /**
     * Récupère une {@link Region} par son identifiant.
     * @param idRegion l'id de la {@link Region}.
     * @return la {@link Region}.
     */
    Region getRegionById(Integer idRegion);
    /**
     * Récupère toutes les {@link Region} de l'unité de persistence.
     * @return la liste des {@link Region}.
     */
    List<Region> getAll();
    /**
     * Ajoute une {@link Region} à l'unité de persistence.
     * @param region la {@link Region} à ajouter.
     */
    void addRegion(Region region);
    /**
     * Ajoute une {@link Region} avec une clé.
     * @param region la {@link Region} à ajouter.
     * @return la {@link Region} ajoutée.
     */
    Region addRegionWithKey(Region region);
}
