package fr.afcepf.al29.dionychus.business.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.CommandeStock;
import fr.afcepf.al29.dionychus.entity.Fournisseur;

public interface IBusinessCommandeStock {
	// Commandes Stock
	List<CommandeStock> getAllCommandesStock();

	void addCommandeStock(CommandeStock paramCommandeStock);

	void updateCommandeStock(CommandeStock paramCommandeStock);

	void deleteCommandeStock(Integer paramIdCommandeStock);

	// Fournisseurs

	List<Fournisseur> getAllFournisseur();

	Fournisseur getById(Integer paramIdFournisseur);

	void addFournisseur(Fournisseur paramFournisseur);

	void updateFournisseur(Fournisseur paramFournisseur);

	void deleteFournisseur(Integer paramIdFournisseur);
	
	//
}
