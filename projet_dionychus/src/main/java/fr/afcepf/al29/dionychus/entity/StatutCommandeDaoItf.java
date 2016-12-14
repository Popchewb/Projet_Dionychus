package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.StatutCommande;

public interface StatutCommandeDaoItf {
	List<StatutCommande> getAll();
	StatutCommande getById(int paramIdStatutCommande);
}
