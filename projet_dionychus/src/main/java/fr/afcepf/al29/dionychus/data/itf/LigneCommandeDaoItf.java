package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.LigneCommande;

public interface LigneCommandeDaoItf {
	List<LigneCommande> getAllByIdCommande(Integer paramIdCommande);
	void addLigneCommande(LigneCommande paramLigneCommande,Integer paramIdCommande);
	void updateLigneCommande(LigneCommande paramLigneCommande);
	void deleteLigneCommande(Integer paramIdLigneCommande);
}
