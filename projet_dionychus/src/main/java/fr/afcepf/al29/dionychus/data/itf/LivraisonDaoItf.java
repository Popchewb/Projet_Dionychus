package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Livraison;

public interface LivraisonDaoItf {
	List<Livraison> getAll();
	List<Livraison> getAllByIdUtilisateur(Integer paramIdUtilisateur);
	void addLivraison(Livraison paramLivraison);
	void updateLivraison(Livraison paramLivraison);
	void deleteLivraison(Integer paramIdLivraison);
}
