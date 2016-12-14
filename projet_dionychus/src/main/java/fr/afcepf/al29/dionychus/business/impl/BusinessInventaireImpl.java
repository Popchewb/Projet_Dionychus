package fr.afcepf.al29.dionychus.business.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import fr.afcepf.al29.dionychus.business.itf.IBusinessInventaire;
import fr.afcepf.al29.dionychus.data.itf.AccessoireDaoItf;
import fr.afcepf.al29.dionychus.data.itf.AppelationDaoItf;
import fr.afcepf.al29.dionychus.data.itf.AromeDaoItf;
import fr.afcepf.al29.dionychus.data.itf.CepageDaoItf;
import fr.afcepf.al29.dionychus.data.itf.CommentaireDaoItf;
import fr.afcepf.al29.dionychus.data.itf.PromotionDaoItf;
import fr.afcepf.al29.dionychus.data.itf.RegionDaoItf;
import fr.afcepf.al29.dionychus.data.itf.TypeAccessoireDaoItf;
import fr.afcepf.al29.dionychus.data.itf.TypeVinDaoItf;
import fr.afcepf.al29.dionychus.data.itf.VinDaoItf;
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

@Service("proxyBusinessInventaire")
public class BusinessInventaireImpl implements IBusinessInventaire {

	ApplicationContext context = new ClassPathXmlApplicationContext("classpath:Beans.xml");

	private AccessoireDaoItf rDao = (AccessoireDaoItf) context.getBean("accessoireJDBCtemplate");
	private AppelationDaoItf appDao = (AppelationDaoItf) context.getBean("appelationJDBCtemplate");
	private AromeDaoItf arDao = (AromeDaoItf) context.getBean("aromeJDBCtemplate");
	private CepageDaoItf cepDao = (CepageDaoItf) context.getBean("cepageJDBCtemplate");
	private CommentaireDaoItf comDao = (CommentaireDaoItf) context.getBean("commentaireJDBCtemplate");
	private PromotionDaoItf promDao = (PromotionDaoItf) context.getBean("promotionJDBCtemplate");
	private RegionDaoItf regDao = (RegionDaoItf) context.getBean("regionJDBCtemplate");
	private TypeAccessoireDaoItf taDao = (TypeAccessoireDaoItf) context.getBean("typeAccessoireJDBCtemplate");
	private TypeVinDaoItf tvDao = (TypeVinDaoItf) context.getBean("typeVinJDBCtemplate");
	private VinDaoItf vinDao = (VinDaoItf) context.getBean("vinJDBCtemplate");

	@Override
	public List<Accessoire> getAllAccessoire() {
		return rDao.getAll();
	}

	@Override
	public Accessoire getAccessoireById(Integer paramIdAccessoire) {
		return rDao.getById(paramIdAccessoire);
	}

	@Override
	public void addAccessoire(Accessoire paramAccessoire) {
		rDao.addAccessoire(paramAccessoire);

	}

	@Override
	public void updateAccessoire(Accessoire paramAccessoire) {
		rDao.updateAccessoire(paramAccessoire);

	}

	@Override
	public void deleteAccessoire(Integer paramIdAccessoire) {
		rDao.deleteAccessoire(paramIdAccessoire);
	}

	@Override
	public List<Accessoire> getBestSellerAccessoire() {
		return rDao.getBestSellerAccessoire();
	}

	@Override
	public List<Appelation> getAllAppelation() {
		return appDao.getAll();
	}

	@Override
	public List<Arome> getAllArome() {
		return arDao.getAll();
	}

	@Override
	public List<Cepage> getAllCepage() {
		return cepDao.getAll();
	}

	@Override
	public List<Commentaire> getAllByVin(Integer paramIdVin) {
		return comDao.getAllByVin(paramIdVin);
	}

	@Override
	public List<Commentaire> getAllByAccessoire(Integer paramIdAccessoire) {
		return comDao.getAllByAccessoire(paramIdAccessoire);
	}

	@Override
	public void addCommentaire(Commentaire paramCommentaire, Integer paramIdArticle, Integer paramIdUtilisateur) {
		comDao.addCommentaire(paramCommentaire, paramIdArticle, paramIdUtilisateur);
	}

	@Override
	public void updateCommentaire(Commentaire paramCommentaire) {
		comDao.updateCommentaire(paramCommentaire);
	}

	@Override
	public void deleteCommentaire(Integer paramIdCommentaire) {
		comDao.deleteCommentaire(paramIdCommentaire);
	}

	@Override
	public void addPromotion(Promotion paramPromotion) {
		promDao.addPromotion(paramPromotion);
	}

	@Override
	public void updatePromotion(Promotion paramPromotion) {
		promDao.updatePromotion(paramPromotion);

	}

	@Override
	public void deletePromotion(Integer paramIdPromotion) {
		promDao.deletePromotion(paramIdPromotion);
	}

	@Override
	public List<Region> getAllRegion() {
		return regDao.getAll();
	}

	@Override
	public List<TypeAccessoire> getAllTypeAccessoire() {
		return taDao.getAll();
	}

	@Override
	public List<TypeVin> getAllTypeVin() {
		return tvDao.getAll();
	}

	@Override
	public List<Vin> getAllVin() {
		List<Vin> vins = vinDao.getAll();
		
		for (Vin vin : vins) {
			vin.setAromes(arDao.getAromeByIdVin(vin.getIdArticle()));
			vin.setCepages(cepDao.getCepageByIdVin(vin.getIdArticle()));
		}
		
		return vins;
	}

	@Override
	public Vin getVinById(Integer paramIdVin) {
		Vin vin = vinDao.getById(paramIdVin);
		vin.setAromes(arDao.getAromeByIdVin(paramIdVin));
		vin.setCepages(cepDao.getCepageByIdVin(paramIdVin));
		return vin;
	}

	@Override
	public void addVin(Vin paramVin) {
		vinDao.addVin(paramVin);
	}

	@Override
	public void updateVin(Vin paramVin) {
		vinDao.updateVin(paramVin);
	}

	@Override
	public void deleteVin(Integer paramIdVin) {
		vinDao.deleteVin(paramIdVin);
	}

	@Override
	public List<Vin> getBestSellerVin() {
		return vinDao.getBestSellerVin();
	}

}