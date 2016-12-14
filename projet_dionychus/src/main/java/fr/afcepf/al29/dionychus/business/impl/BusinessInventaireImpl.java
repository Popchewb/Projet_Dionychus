<<<<<<< HEAD
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
=======
package fr.afcepf.al29.dionychus.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import fr.afcepf.al29.dionychus.business.itf.IBusinessInventaire;
import fr.afcepf.al29.dionychus.data.itf.AccessoireDaoItf;
import fr.afcepf.al29.dionychus.data.itf.VinDaoItf;
import fr.afcepf.al29.dionychus.entity.Accessoire;
import fr.afcepf.al29.dionychus.entity.Vin;

@Service("proxyBusinessInventaire")
public class BusinessInventaireImpl implements IBusinessInventaire {

	ApplicationContext context =  new ClassPathXmlApplicationContext("classpath:Beans.xml");
	
	
	private AccessoireDaoItf rDao = (AccessoireDaoItf) context.getBean("accessoireJDBCtemplate");
	
	private VinDaoItf proxyDao = (VinDaoItf) context.getBean("vinJDBCtemplate");
	
	@Override
	public List<Accessoire> getAllAccessoires() {
		return rDao.getAll();
	}

	@Override
	public List<Vin> getAllVins() {
		return proxyDao.getAll();
	}

}
>>>>>>> db48d7b7f97f9c02bd491338e2af140c001b6ba1
