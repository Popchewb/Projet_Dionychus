<<<<<<< HEAD
package fr.afcepf.al29.dionychus.business.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Accessoire;
import fr.afcepf.al29.dionychus.entity.Appelation;
import fr.afcepf.al29.dionychus.entity.Arome;
import fr.afcepf.al29.dionychus.entity.Cepage;
import fr.afcepf.al29.dionychus.entity.Commentaire;
import fr.afcepf.al29.dionychus.entity.Promotion;
import fr.afcepf.al29.dionychus.entity.Region;
import fr.afcepf.al29.dionychus.entity.TypeAccessoire;
import fr.afcepf.al29.dionychus.entity.TypeVin;
import fr.afcepf.al29.dionychus.entity.Vin;

public interface IBusinessInventaire {

	// Accessoires
	List<Accessoire> getAllAccessoire();

	Accessoire getAccessoireById(Integer paramIdAccessoire);

	void addAccessoire(Accessoire paramAccessoire);

	void updateAccessoire(Accessoire paramAccessoire);

	void deleteAccessoire(Integer paramIdAccessoire);

	List<Accessoire> getBestSellerAccessoire();

	// Appelations
	List<Appelation> getAllAppelation();

	// Aromes
	List<Arome> getAllArome();

	// Cepage
	List<Cepage> getAllCepage();

	// Commentaires
	List<Commentaire> getAllByVin(Integer paramIdVin);

	List<Commentaire> getAllByAccessoire(Integer paramIdAccessoire);

	void addCommentaire(Commentaire paramCommentaire, Integer paramIdArticle, Integer paramIdUtilisateur);

	void updateCommentaire(Commentaire paramCommentaire);

	void deleteCommentaire(Integer paramIdCommentaire);

	// Promotions
	void addPromotion(Promotion paramPromotion);

	void updatePromotion(Promotion paramPromotion);

	void deletePromotion(Integer paramIdPromotion);

	// Region
	List<Region> getAllRegion();

	// Type Accessoire
	List<TypeAccessoire> getAllTypeAccessoire();

	// Type Vin
	List<TypeVin> getAllTypeVin();

	// Vin
	List<Vin> getAllVin();

	Vin getVinById(Integer paramIdVin);

	void addVin(Vin paramVin);

	void updateVin(Vin paramVin);

	void deleteVin(Integer paramIdVin);

	List<Vin> getBestSellerVin();

}
=======
package fr.afcepf.al29.dionychus.business.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Accessoire;
import fr.afcepf.al29.dionychus.entity.Vin;

public interface IBusinessInventaire {

	List<Accessoire> getAllAccessoires();

	List<Vin> getAllVins();
	
}
>>>>>>> db48d7b7f97f9c02bd491338e2af140c001b6ba1
