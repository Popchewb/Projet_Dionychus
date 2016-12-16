package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.CommandeClient;

public interface CommandeClientDaoItf {
	List<CommandeClient> getAll();
	List<CommandeClient> getCommandesByIdUtilisateur(Integer paramIdUtilisateur);
	List<CommandeClient> getCommandesByIdStatutCommande(Integer paramIdStatutCommande);
	CommandeClient getCommandeClientById(Integer paramIdCommandeClient);
	CommandeClient addCommandeClient(CommandeClient paramCommandeClient);
	void updateCommandeClient(CommandeClient paramCommandeClient);
	void deleteCommandeClient(Integer paramIdCommandeClient);
}
