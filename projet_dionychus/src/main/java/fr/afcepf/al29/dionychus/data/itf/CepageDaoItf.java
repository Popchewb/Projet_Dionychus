package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Cepage;

/**
 * Interface pour les méthodes d'accès aux données des cépages.
 *
 * @author ecala
 *
 */
public interface CepageDaoItf {
    /**
     *
     * @return tous les cépages.
     */
    List<Cepage> getAll();

    /**
     *
     * @param paramIdVin
     *            l'id du vin.
     * @return la liste des cépages du vin.
     */
    List<Cepage> getCepageByIdVin(int paramIdVin);
    /**
     *
     * @param cepageId l'id du cépage.
     * @return le cépage.
     */
    Cepage getCepageById(int cepageId);

}
