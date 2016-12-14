package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Promotion;

public interface PromotionDaoItf {
	List<Promotion> getAll();
	void addPromotion(Promotion paramPromotion);
	void updatePromotion(Promotion paramPromotion);
	void deletePromotion(Integer paramIdPromotion);
}
