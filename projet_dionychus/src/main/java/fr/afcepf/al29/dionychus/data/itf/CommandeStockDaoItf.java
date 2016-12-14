<<<<<<< HEAD
package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.CommandeStock;

public interface CommandeStockDaoItf {
	List<CommandeStock> getAll();
	List<CommandeStock> getCommandesByIdUtilisateur(Integer paramIdUtilisateur);
	List<CommandeStock> getCommandesByIdStatutCommande(Integer paramIdStatutCommande);
	void addCommandeStock(CommandeStock paramCommandeStock);
	void updateCommandeStock(CommandeStock paramCommandeStock);
	void deleteCommandeStock(Integer paramIdCommandeStock);
}
=======
package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.CommandeStock;

public interface CommandeStockDaoItf {
	List<CommandeStock> getAll();
	List<CommandeStock> getCommandesByIdUtilisateur(Integer paramIdUtilisateur);
	List<CommandeStock> getCommandesByIdStatutCommande(Integer paramIdStatutCommande);
	void addCommandeStock(CommandeStock paramCommandeStock);
	void updateCommandeStock(CommandeStock paramCommandeStock);
	void deleteCommandeStock(Integer paramIdCommandeStock);
}
>>>>>>> 1792abc527a882b03523d1dc209ac03379bcf72c
