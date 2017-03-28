package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Fournisseur;

/**
 * Interface pour les méthodes d'accès aux données des {@link Fournisseur}.
 *
 * @author ecala
 *
 */
public interface FournisseurDaoItf {
    /**
     * Récupère tous les {@link Fournisseur} de Dyonichus.
     * @return la liste des {@link Fournisseur}.
     */
    List<Fournisseur> getAll();
    /**
     * Récupère un {@link Fournisseur} par son identifiant.
     * @param paramIdFournisseur l'id du {@link Fournisseur}.
     * @return le {@link Fournisseur}.
     */
    Fournisseur getById(Integer paramIdFournisseur);
    /**
     * Ajoute un {@link Fournisseur} dans l'unité de persistence.
     * @param paramFournisseur le {@link Fournisseur} à ajouter.
     */
    void addFournisseur(Fournisseur paramFournisseur);
    /**
     * Met à jour un {@link Fournisseur} dans l'unité de persistence.
     * @param paramFournisseur le {@link Fournisseur} à mettre à jour.
     */
    void updateFournisseur(Fournisseur paramFournisseur);
    /**
     * Supprime un {@link Fournisseur} de l'unité de persistence.
     * @param paramIdFournisseur le {@link Fournisseur} à supprimer.
     */
    void deleteFournisseur(Integer paramIdFournisseur);
}
