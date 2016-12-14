package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Fournisseur;

public interface FournisseurDaoItf {
	List<Fournisseur> getAll();
	Fournisseur getById(Integer paramIdFournisseur);
	void addFournisseur(Fournisseur paramFournisseur);
	void updateFournisseur(Fournisseur paramFournisseur);
	void deleteFournisseur(Integer paramIdFournisseur);
}
