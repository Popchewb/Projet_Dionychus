package fr.afcepf.al29.dionychus.business.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.CommandeStock;
import fr.afcepf.al29.dionychus.entity.Fournisseur;

/**
 * Interface pour les méthodes de services relatives aux {@link CommandeStock}.
 *
 * @author ecala
 *
 */
public interface IBusinessCommandeStock {
    // Commandes Stock
    /**
     * Récupère toutes les {@link CommandeStock} de l'unité de persistence.
     * @return la liste des {@link CommandeStock}.
     */
    List<CommandeStock> getAllCommandesStock();
    /**
     * Ajoute une {@link CommandeStock} à l'unité de persistence.
     * @param paramCommandeStock la {@link CommandeStock} ajoutée.
     */
    void addCommandeStock(CommandeStock paramCommandeStock);
    /**
     * Met à jour une {@link CommandeStock} dans l'unité de persistence.
     * @param paramCommandeStock la {@link CommandeStock} mise à jour.
     */
    void updateCommandeStock(CommandeStock paramCommandeStock);
    /**
     * Supprime une {@link CommandeStock} de l'unité de persistence.
     * @param paramIdCommandeStock l'identifiant de la {@link CommandeStock}.
     */
    void deleteCommandeStock(Integer paramIdCommandeStock);

    // Fournisseurs
    /**
     * Récupère tous les {@link Fournisseur} de l'unité de persistence.
     * @return la liste de tous les {@link Fournisseur}.
     */
    List<Fournisseur> getAllFournisseur();
    /**
     * Récupère un {@link Fournisseur} par son identifiant.
     * @param paramIdFournisseur l'identifiant du {@link Fournisseur}.
     * @return le {@link Fournisseur}.
     */
    Fournisseur getById(Integer paramIdFournisseur);
    /**
     * Ajoute un {@link Fournisseur} à l'unité de persistence.
     * @param paramFournisseur le {@link Fournisseur} ajouté.
     */
    void addFournisseur(Fournisseur paramFournisseur);
    /**
     * Met à jour un {@link Fournisseur} dans l'unité de persistence.
     * @param paramFournisseur le {@link Fournisseur} à mettre à jour.
     */
    void updateFournisseur(Fournisseur paramFournisseur);
    /**
     * Supprime le {@link Fournisseur} de l'unité de persistence.
     * @param paramIdFournisseur l'identifiant du {@link Fournisseur}.
     */
    void deleteFournisseur(Integer paramIdFournisseur);

    //
}
