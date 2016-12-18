package fr.afcepf.al29.dionychus.business.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Adresse;
import fr.afcepf.al29.dionychus.entity.CommandeClient;
import fr.afcepf.al29.dionychus.entity.LigneCommande;
import fr.afcepf.al29.dionychus.entity.Promotion;
import fr.afcepf.al29.dionychus.entity.StatutCommande;
import fr.afcepf.al29.dionychus.entity.TypeLivraison;
import fr.afcepf.al29.dionychus.entity.Utilisateur;

public interface IBusinessCommandeClient {

	// Adresses
	List<Adresse> getAdresseByIdActeur(Integer paramIdActeur);

	// Commandes Client
	List<CommandeClient> getAllCommandeClient();

	CommandeClient getCommandeById(Integer paramIdCommandeClient);

	List<CommandeClient> getCommandesByIdUtilisateur(Integer paramIdUtilisateur);
	
	void validerCommandeClient(CommandeClient paramCommandeClient, Utilisateur paramUtilisateur);

	CommandeClient addCommandeClient(CommandeClient paramCommandeClient);

	void updateCommandeClient(CommandeClient paramCommandeClient);

	void deleteCommandeClient(Integer paramIdCommandeClient);
	
	CommandeClient addPanier(CommandeClient panier);
	
	void updateTypeLivraison(CommandeClient paramCommandeClient, Integer paramIdTypeLivraison);
	
	void updatePanierValider(CommandeClient paramCommandeClient);

	// Lignes de commande
	List<LigneCommande> getAllLigneCommandeByIdCommande(Integer paramIdCommande);

	void addLigneCommande(LigneCommande paramLigneCommande, Integer paramIdCommande);

	void updateLigneCommande(LigneCommande paramLigneCommande);

	void deleteLigneCommande(Integer paramIdLigneCommande);

	// Promotion
	List<Promotion> getAllPromotion();

	// Types livraison
	List<TypeLivraison> getAll();
	TypeLivraison getTypeLivraisonById(Integer paramIdTypeLivraison);
	
	//Statut Commande
	StatutCommande getStatutCommandeById(Integer paramIdStatutCommande);

	Double getTarifLivraisonByIdCommande(Integer idCommande);

	void updatePanierRefUtilisateur(CommandeClient panierUtilisateur);

	CommandeClient addPanierPostCommande(CommandeClient panier);
}
