package fr.afcepf.al29.dionychus.business.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.afcepf.al29.dionychus.business.itf.IBusinessCommandeClient;
import fr.afcepf.al29.dionychus.data.itf.AdresseDaoItf;
import fr.afcepf.al29.dionychus.data.itf.CommandeClientDaoItf;
import fr.afcepf.al29.dionychus.data.itf.LigneCommandeDaoItf;
import fr.afcepf.al29.dionychus.data.itf.PromotionDaoItf;
import fr.afcepf.al29.dionychus.data.itf.TypeLivraisonDaoItf;
import fr.afcepf.al29.dionychus.entity.Adresse;
import fr.afcepf.al29.dionychus.entity.Commande;
import fr.afcepf.al29.dionychus.entity.CommandeClient;
import fr.afcepf.al29.dionychus.entity.LigneCommande;
import fr.afcepf.al29.dionychus.entity.Promotion;
import fr.afcepf.al29.dionychus.entity.TypeLivraison;

public class BusinessCommandeClient implements IBusinessCommandeClient {

	ApplicationContext context = new ClassPathXmlApplicationContext("classpath:Beans.xml");
	
	AdresseDaoItf adDao = (AdresseDaoItf) context.getBean("adresseJDBCtemplate");
	CommandeClientDaoItf ccDao = (CommandeClientDaoItf) context.getBean("commandeClientJDBCtemplate");
	LigneCommandeDaoItf lcDao = (LigneCommandeDaoItf) context.getBean("ligneCommandeJDBCtemplate");
	PromotionDaoItf promDao = (PromotionDaoItf) context.getBean("promotionJDBCtemplate");
	TypeLivraisonDaoItf tlDao = (TypeLivraisonDaoItf) context.getBean("typeLivraisonJDBCtemplate");

	@Override
	public List<Adresse> getAdresseByIdActeur(Integer paramIdActeur) {
		return adDao.getAdresseByIdActeur(paramIdActeur);
	}

	@Override
	public List<CommandeClient> getAllCommandeClient() {
		return ccDao.getAll();
	}

	@Override
	public Commande getCommandeById(Integer paramIdCommandeClient) {
//		return ccDao.getCommandeClientById(paramIdCommandeClient);
		return null;
	}

	@Override
	public List<CommandeClient> getCommandesByIdUtilisateur(Integer paramIdUtilisateur) {
		return ccDao.getCommandesByIdUtilisateur(paramIdUtilisateur);
	}

	@Override
	public void addCommandeClient(CommandeClient paramCommandeClient) {
		ccDao.addCommandeClient(paramCommandeClient);
	}

	@Override
	public void updateCommandeClient(CommandeClient paramCommandeClient) {
		ccDao.updateCommandeClient(paramCommandeClient);
	}

	@Override
	public void deleteCommandeClient(Integer paramIdCommandeClient) {
		ccDao.deleteCommandeClient(paramIdCommandeClient);
		
	}

	@Override
	public List<LigneCommande> getAllLigneCommandeByIdCommande(Integer paramIdCommande) {
		return lcDao.getAllByIdCommande(paramIdCommande);
	}

	@Override
	public void addLigneCommande(LigneCommande paramLigneCommande, Integer paramIdCommande) {
		lcDao.addLigneCommande(paramLigneCommande, paramIdCommande);
	}

	@Override
	public void updateLigneCommande(LigneCommande paramLigneCommande) {
		lcDao.updateLigneCommande(paramLigneCommande);
	}

	@Override
	public void deleteLigneCommande(Integer paramIdLigneCommande) {
		lcDao.deleteLigneCommande(paramIdLigneCommande);
	}

	@Override
	public List<Promotion> getAllPromotion() {
		return promDao.getAll();
	}

	@Override
	public List<TypeLivraison> getAll() {
		return tlDao.getAll();
	}

}
