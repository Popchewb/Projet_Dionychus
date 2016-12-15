package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Accessoire;

public interface AccessoireDaoItf {
	List<Accessoire> getAll();
	Accessoire getById(Integer paramIdAccessoire);
	void addAccessoire (Accessoire paramAccessoire, Integer paramIdFournisseur);
	void updateAccessoire (Accessoire paramAccessoire);
	void deleteAccessoire (Integer paramIdAccessoire);
	List<Accessoire> getBestSellerAccessoire();
}
