package fr.afcepf.al29.dionychus.business.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import fr.afcepf.al29.dionychus.business.itf.IBusinessCompte;
import fr.afcepf.al29.dionychus.data.itf.AdresseDaoItf;
import fr.afcepf.al29.dionychus.data.itf.CommentaireDaoItf;
import fr.afcepf.al29.dionychus.entity.Adresse;
import fr.afcepf.al29.dionychus.entity.Commentaire;
import fr.afcepf.al29.dionychus.entity.Pays;
import fr.afcepf.al29.dionychus.entity.TypeAcces;
import fr.afcepf.al29.dionychus.entity.Utilisateur;
import fr.afcepf.al29.dionychus.entity.Ville;

@Service
public class BusinessCompteImpl implements IBusinessCompte {

	private ApplicationContext context = new ClassPathXmlApplicationContext("classpath:Beans.xml");

	private AdresseDaoItf proxyAdresseDao = (AdresseDaoItf) context.getBean("adresseJDBCtemplate");
	private CommentaireDaoItf proxyCommentaireDao = (CommentaireDaoItf) context.getBean("commentaireJDBCtemplate");

	@Override
	public List<Adresse> getAllAdresse() {
		return proxyAdresseDao.getAll();
	}

	@Override
	public Adresse getAdresseById(Integer paramIdAdresse) {
		return proxyAdresseDao.getAdresseById(paramIdAdresse);
	}

	@Override
	public List<Adresse> getAdresseByIdActeur(Integer paramIdActeur) {
		return proxyAdresseDao.getAdresseByIdActeur(paramIdActeur);
	}

	@Override
	public void addAdresse(Adresse paramAdresse, Integer paramIdActeur) {
		proxyAdresseDao.addAdresse(paramAdresse, paramIdActeur);
	}

	@Override
	public void updateAdresse(Adresse paramAdresse) {
		proxyAdresseDao.updateAdresse(paramAdresse);
	}

	@Override
	public void deleteAdresse(Integer paramIdAdresse) {
		proxyAdresseDao.deleteAdresse(paramIdAdresse);
	}

	@Override
	public List<Commentaire> getAllCommentaireByUtilisateur(Integer paramIdUtilisateur) {
		return proxyCommentaireDao.getAllCommentaireByUtilisateur(paramIdUtilisateur);
	}

	@Override
	public List<Pays> getAllPays() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pays getPaysByIdVille(Integer paramIdVille) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ville> getAllVille() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ville> getAllVilleByIdPays(Integer paramIdPays) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TypeAcces> getAllTypeAcces() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utilisateur> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur getById(int paramIdUtilisateur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUtilisateur(Utilisateur paramUtilisateur) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUtilisateur(Utilisateur paramUtilisateur) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUtilisateur(Integer paramIdUtilisateur) {
		// TODO Auto-generated method stub

	}

}
