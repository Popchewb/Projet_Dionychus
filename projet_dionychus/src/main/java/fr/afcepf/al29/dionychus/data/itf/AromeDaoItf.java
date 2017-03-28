package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Arome;

/**
 * Interface pour les méthodes d'accès aux données des aromes.
 *
 * @author ecala
 *
 */
public interface AromeDaoItf {
    /**
     *
     * @return tous les arômes.
     */
    List<Arome> getAll();
    /**
     * Récupère la liste des arômes d'un vin.
     * @param paramIdVin l'id du vin.
     * @return la liste des arômes du vin.
     */
    List<Arome> getAromeByIdVin(int paramIdVin);
    /**
     *
     * @param aromeId l'id de l'arôme.
     * @return l'arôme.
     */
    Arome getAromeById(int aromeId);
}
