package fr.afcepf.al29.dionychus.business.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Adresse;
import fr.afcepf.al29.dionychus.entity.CommandeClient;
import fr.afcepf.al29.dionychus.entity.LigneCommande;
import fr.afcepf.al29.dionychus.entity.Promotion;
import fr.afcepf.al29.dionychus.entity.StatutCommande;
import fr.afcepf.al29.dionychus.entity.TypeLivraison;
import fr.afcepf.al29.dionychus.entity.Utilisateur;

/**
 * Interface pour les méthodes de services relatives aux {@link CommandeClient}.
 *
 * @author ecala
 *
 */
public interface IBusinessCommandeClient {

    // Adresses
    /**
     * Récupère la liste des adresses d'un {@link Acteur}.
     * @param paramIdActeur l'identifiant de l'acteur.
     * @return la liste des {@link Adresse} d'un {@link Acteur}.
     */
    List<Adresse> getAdresseByIdActeur(Integer paramIdActeur);

    // Commandes Client
    /**
     * Récupère toutes les {@link CommandeClient}.
     * @return la liste des {@link CommandeClient}.
     */
    List<CommandeClient> getAllCommandeClient();
    /**
     * Récupère une {@link CommandeClient} par son identifiant.
     * @param paramIdCommandeClient l'identifiant de la {@link CommandeClient}.
     * @return la {@link CommandeClient}.
     */
    CommandeClient getCommandeById(Integer paramIdCommandeClient);
    /**
     * Récupère la liste des {@link CommandeClient} d'un {@link Utilisateur}.
     * @param paramIdUtilisateur l'identifiant de l'utilisateur.
     * @return la liste des {@link CommandeClient}.
     */
    List<CommandeClient> getCommandesByIdUtilisateur(Integer paramIdUtilisateur);
    /**
     * Valide la {@link CommandeClient}.
     * @param paramCommandeClient la {@link CommandeClient} à valider.
     * @param paramUtilisateur l'utilisateur qui a passé la {@link CommandeClient}.
     */
    void validerCommandeClient(CommandeClient paramCommandeClient, Utilisateur paramUtilisateur);
    /**
     * Ajouter une {@link CommandeClient} dans l'unité de persistence.
     * @param paramCommandeClient la {@link CommandeClient} à ajouter.
     * @return la {@link CommandeClient} ajoutée.
     */
    CommandeClient addCommandeClient(CommandeClient paramCommandeClient);
    /**
     * Met à jour une {@link CommandeClient} dans l'unité de persistence.
     * @param paramCommandeClient la {@link CommandeClient} à mettre à jour.
     */
    void updateCommandeClient(CommandeClient paramCommandeClient);
    /**
     * Supprime une {@link CommandeClient} de l'unité de persistence.
     * @param paramIdCommandeClient l'identifiant de la {@link CommandeClient} à supprimer.
     */
    void deleteCommandeClient(Integer paramIdCommandeClient);
    /**
     * Crée un panier.
     * @param panier le panier à créer.
     * @return le panier crée.
     */
    CommandeClient addPanier(CommandeClient panier);
    /**
     * Met à jour le {@link TypeLivraison} d'une {@link CommandeClient}.
     * @param paramCommandeClient la {@link CommandeClient} à mettre à jour.
     * @param paramIdTypeLivraison le {@link TypeLivraison} à modifier.
     */
    void updateTypeLivraison(CommandeClient paramCommandeClient, Integer paramIdTypeLivraison);
    /**
     * Valide le panier d'un client.
     * @param paramCommandeClient la {@link CommandeClient} à valider.
     */
    void updatePanierValider(CommandeClient paramCommandeClient);

    // Lignes de commande
    /**
     * Récupère toutes les {@link LigneCommande} d'une {@link Commande}.
     * @param paramIdCommande l'identifiant de la {@link Commande}.
     * @return la liste des {@link LigneCommande}.
     */
    List<LigneCommande> getAllLigneCommandeByIdCommande(Integer paramIdCommande);
    /**
     * Ajoute une {@link LigneCommande} à une {@link Commande}.
     * @param paramLigneCommande la {@link LigneCommande} à ajouter.
     * @param paramIdCommande l'identifiant de la {@link Commande}.
     */
    void addLigneCommande(LigneCommande paramLigneCommande, Integer paramIdCommande);
    /**
     * Met à jour une {@link LigneCommande}.
     * @param paramLigneCommande la {@link LigneCommande} à mettre à jour.
     */
    void updateLigneCommande(LigneCommande paramLigneCommande);
    /**
     * Supprime une {@link LigneCommande}.
     * @param paramIdLigneCommande l'identifiant de la {@link LigneCommande} à supprimer.
     */
    void deleteLigneCommande(Integer paramIdLigneCommande);

    // Promotion
    /**
     * Récupère toutes les {@link Promotion} de l'unité de persistence.
     * @return la liste des {@link Promotion}.
     */
    List<Promotion> getAllPromotion();

    // Types livraison
    /**
     * Récupère tous les {@link TypeLivraison} de l'unité de persistence.
     * @return la liste des {@link TypeLivraison}
     */
    List<TypeLivraison> getAll();
    /**
     * Récupère un {@link TypeLivraison} par son identifiant.
     * @param paramIdTypeLivraison l'identifiant du {@link TypeLivraison}.
     * @return le {@link TypeLivraison}.
     */
    TypeLivraison getTypeLivraisonById(Integer paramIdTypeLivraison);

    // Statut Commande
    /**
     * Récupère un {@link StatutCommande} par son identifiant.
     * @param paramIdStatutCommande l'identifiant du {@link StatutCommande}.
     * @return le {@link StatutCommande}.
     */
    StatutCommande getStatutCommandeById(Integer paramIdStatutCommande);
    /**
     * Récupère le tarif de livraison d'une {@link Commande}.
     * @param idCommande l'identifiant de la {@link Commande}.
     * @return le tarif.
     */
    Double getTarifLivraisonByIdCommande(Integer idCommande);
    /**
     * Met à jour le panier d'un {@link Utilisateur}.
     * @param panierUtilisateur le panier.
     */
    void updatePanierRefUtilisateur(CommandeClient panierUtilisateur);
    /**
     * Crée un nouveau panier à un {@link Utilisateur} après qu'il a finalisé sa {@link Commande}.
     * @param panier le panier à créer.
     * @return le panier crée.
     */
    CommandeClient addPanierPostCommande(CommandeClient panier);
}
