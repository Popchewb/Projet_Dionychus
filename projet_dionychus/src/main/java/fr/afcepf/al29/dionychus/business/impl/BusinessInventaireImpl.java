<<<<<<< HEAD
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
import fr.afcepf.al29.dionychus.data.itf.RegionDaoItf;
import fr.afcepf.al29.dionychus.data.itf.TypeVinDaoItf;
import fr.afcepf.al29.dionychus.data.itf.VinDaoItf;
import fr.afcepf.al29.dionychus.entity.Accessoire;
import fr.afcepf.al29.dionychus.entity.Appelation;
import fr.afcepf.al29.dionychus.entity.Arome;
import fr.afcepf.al29.dionychus.entity.Cepage;
import fr.afcepf.al29.dionychus.entity.Region;
import fr.afcepf.al29.dionychus.entity.TypeVin;
import fr.afcepf.al29.dionychus.entity.Vin;

@Service("proxyBusinessInventaire")
public class BusinessInventaireImpl implements IBusinessInventaire {

	ApplicationContext context =  new ClassPathXmlApplicationContext("classpath:Beans.xml");
	
	private AccessoireDaoItf proxyDaoAccessoire = (AccessoireDaoItf) context.getBean("accessoireJDBCtemplate");
	
	private VinDaoItf proxyDaoVin = (VinDaoItf) context.getBean("vinJDBCtemplate");
	
	private AromeDaoItf proxyDaoArome = (AromeDaoItf) context.getBean("aromeJDBCtemplate");
	
	private CepageDaoItf proxyDaoCepage = (CepageDaoItf) context.getBean("cepageJDBCtemplate");
	
	private RegionDaoItf proxyDaoRegion = (RegionDaoItf) context.getBean("regionJDBCtemplate");
	
	private AppelationDaoItf proxyDaoAppellation = (AppelationDaoItf) context.getBean("appelationJDBCtemplate");
	
	private TypeVinDaoItf proxyDaoTypeVin = (TypeVinDaoItf) context.getBean("typeVinJDBCtemplate");
	
	@Override
	public List<Accessoire> getAllAccessoires() {
		return proxyDaoAccessoire.getAll();
	}

	@Override
	public List<Vin> getAllVins() {
		return proxyDaoVin.getAll();
	}

	@Override
	public List<Arome> getAllAromes() {
		return proxyDaoArome.getAll();
	}

	@Override
	public List<Cepage> getAllCepages() {
		return proxyDaoCepage.getAll();
	}

	@Override
	public List<Region> getAllRegions() {
		return proxyDaoRegion.getAll();
	}

	@Override
	public List<Appelation> getAllAppellation() {
		return proxyDaoAppellation.getAll();
	}

	@Override
	public List<TypeVin> getAllTypeVins() {
		return proxyDaoTypeVin.getAll();
	}

	@Override
	public Region getRegionById(Integer region) {
		return proxyDaoRegion.getRegionById(region);
	}

	@Override
	public Appelation getAppellationById(Integer appellation) {
		return proxyDaoAppellation.getAppelationById(appellation);
	}

	@Override
	public TypeVin getTypeVinById(Integer typeVin) {
		return proxyDaoTypeVin.getTypeVinById(typeVin);
	}

	@Override
	public Arome getAromeById(int aromeId) {
		return proxyDaoArome.getAromeById(aromeId);
	}

	@Override
	public Cepage getCepageById(int cepageId) {
		return proxyDaoCepage.getCepageById(cepageId);
	}

	@Override
	public void ajouterVin(Vin vin) {
		proxyDaoVin.addVin(vin);
	}

}
=======
package fr.afcepf.al29.dionychus.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import fr.afcepf.al29.dionychus.business.itf.IBusinessInventaire;
import fr.afcepf.al29.dionychus.data.itf.AccessoireDaoItf;
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

	ApplicationContext context =  new ClassPathXmlApplicationContext("classpath:Beans.xml");
	
	
	private AccessoireDaoItf rDao = (AccessoireDaoItf) context.getBean("accessoireJDBCtemplate");


	@Override
	public List<Accessoire> getAllAccessoire() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Accessoire getAccessoireById(Integer paramIdAccessoire) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void addAccessoire(Accessoire paramAccessoire) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateAccessoire(Accessoire paramAccessoire) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteAccessoire(Integer paramIdAccessoire) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Accessoire> getBestSellerAccessoire() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Appelation> getAllAppelation() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Arome> getAllArome() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Cepage> getAllCepage() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Commentaire> getAllByVin(Integer paramIdVin) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Commentaire> getAllByAccessoire(Integer paramIdAccessoire) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void addCommentaire(Commentaire paramCommentaire, Integer paramIdArticle, Integer paramIdUtilisateur) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateCommentaire(Commentaire paramCommentaire) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteCommentaire(Integer paramIdCommentaire) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addPromotion(Promotion paramPromotion) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updatePromotion(Promotion paramPromotion) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deletePromotion(Integer paramIdPromotion) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Region> getAllRegion() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<TypeAccessoire> getAllTypeAccessoire() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<TypeVin> getAllTypeVin() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Vin> getAllVin() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Vin getVinById(Integer paramIdVin) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void addVin(Vin paramVin) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateVin(Vin paramVin) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteVin(Integer paramIdVin) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Vin> getBestSellerVin() {
		// TODO Auto-generated method stub
		return null;
	}
	


}

>>>>>>> e1290bbdf0aea53cd3437da3ac62e934fbec4c53
