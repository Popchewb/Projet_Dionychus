package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.CommandeClient;

/**
 * Interface pour les méthodes d'accès aux données des {@link CommandeClient}.
 *
 * @author ecala
 *
 */
public interface CommandeClientDaoItf {
    /**
     * @return toutes les commandes des clients.
     */
    List<CommandeClient> getAll();

    /**
     * Récupère toutes les commandes d'un client.
     *
     * @param paramIdUtilisateur
     *            l'id du client.
     * @return les commandes du client.
     */
    List<CommandeClient> getCommandesByIdUtilisateur(Integer paramIdUtilisateur);

    /**
     * Récupère toutes les commandes à un statut donné.
     *
     * @param paramIdStatutCommande
     *            l'id du statut de la commande.
     * @return les commandes ayant le statut choisi.
     */
    List<CommandeClient> getCommandesByIdStatutCommande(Integer paramIdStatutCommande);

    /**
     * Récupère une commande client par son id.
     *
     * @param paramIdCommandeClient
     *            l'id de la {@link CommandeClient}.
     * @return la {@link CommandeClient}.
     */
    CommandeClient getCommandeClientById(Integer paramIdCommandeClient);

    /**
     * Ajouter une {@link CommandeClient} dans l'unité de persistence.
     *
     * @param paramCommandeClient
     *            la {@link CommandeClient} à ajouter.
     * @return la {@link CommandeClient} ajoutée.
     */
    CommandeClient addCommandeClient(CommandeClient paramCommandeClient);

    /**
     * Met à jour une {@link CommandeClient} dans l'unité de persistence.
     *
     * @param paramCommandeClient
     *            la {@link CommandeClient} à mettre à jour.
     */
    void updateCommandeClient(CommandeClient paramCommandeClient);

    /**
     * Supprime une {@link CommandeClient} de l'unité de persistence.
     *
     * @param paramIdCommandeClient l'id de la {@link CommandeClient} à supprimer.
     */
    void deleteCommandeClient(Integer paramIdCommandeClient);
    /**
     *
     * @param panier le panier à ajouter.
     * @return le panier ajouté.
     */
    CommandeClient addPanier(CommandeClient panier);
    /**
     * Met à jour le type de livraison d'une commande.
     * @param paramCommandeClient la commande à mettre à jour.
     * @param paramIdTypeLivraison le type de livraison à modifier.
     */
    void updateTypeLivraison(CommandeClient paramCommandeClient, Integer paramIdTypeLivraison);
    /**
     *
     * @param paramIdCommande la commande dont on veut le tarif de livraison.
     * @return le montant du tarif de livraison.
     */
    Double getTarifLivraisonByIdCommande(Integer paramIdCommande);
    /**
     *
     * @param paramCommandeClient le panier à mettre à jour.
     */
    void updatePanierValider(CommandeClient paramCommandeClient);
    /**
     *
     * @param panierUtilisateur le panier de l'utilisateur à mettre à jour.
     */
    void updatePanierRefUtilisateur(CommandeClient panierUtilisateur);
    /**
     *
     * @param paramPanier le panier à créer.
     * @return le panier crée.
     */
    CommandeClient addPanierPostCommande(CommandeClient paramPanier);
}
