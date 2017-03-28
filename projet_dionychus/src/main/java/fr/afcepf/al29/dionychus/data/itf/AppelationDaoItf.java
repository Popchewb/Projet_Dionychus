package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Appelation;

/**
 * Interface pour les méthodes d'accès aux données des appellations..
 *
 * @author ecala
 *
 */
public interface AppelationDaoItf {
    /**
     *
     * @return toutes les appellations.
     */
    List<Appelation> getAll();
    /**
     * Récupère la liste des appellations d'un vin.
     * @param paramIdVin l'id du vin.
     * @return la liste des appellations du vin.
     */
    List<Appelation> getAppelationByIdVin(int paramIdVin);
    /**
     *
     * @param paramIdAppellation l'id de l'appellation.
     * @return l'appellation.
     */
    Appelation getAppelationById(Integer paramIdAppellation);
}
