package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Adresse;

/**
 * Interface pour les méthodes d'accès aux données des adresses.
 *
 * @author ecala
 *
 */
public interface AdresseDaoItf {
    /**
     *
     * @return toutes les adresses.
     */
    List<Adresse> getAll();
    /**
     * Récupère une adresse par son id.
     * @param paramIdAdresse l'id de l'adresse.
     * @return l'adresse.
     */
    Adresse getAdresseById(Integer paramIdAdresse);
    /**
     * Récupère la liste des adresses d'un acteur.
     * @param paramIdActeur l'id de l'acteur.
     * @return la liste des adresses de l'acteur.
     */
    List<Adresse> getAdresseByIdActeur(Integer paramIdActeur);
    /**
     * Ajouter une adresse dans l'unité de persistence.
     * @param paramAdresse l'adresse à ajouter.
     * @param paramIdActeur l'id de l'acteur à qui appartient l'adresse.
     */
    void addAdresse(Adresse paramAdresse, Integer paramIdActeur);
    /**
     * Met à jour une adresse.
     * @param paramAdresse l'adresse à mettre à jour.
     */
    void updateAdresse(Adresse paramAdresse);
    /**
     * Supprime une adresse.
     * @param paramIdAdresse l'adresse à supprimer.
     */
    void deleteAdresse(Integer paramIdAdresse);

}
