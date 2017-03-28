package fr.afcepf.al29.dionychus.business.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import fr.afcepf.al29.dionychus.business.itf.IBusinessCompte;
import fr.afcepf.al29.dionychus.data.impl.PaysDaoImpl;
import fr.afcepf.al29.dionychus.data.impl.TypeAccesDaoImpl;
import fr.afcepf.al29.dionychus.data.impl.UtilisateurDaoImpl;
import fr.afcepf.al29.dionychus.data.impl.VilleDaoImpl;
import fr.afcepf.al29.dionychus.data.itf.AdresseDaoItf;
import fr.afcepf.al29.dionychus.data.itf.CommentaireDaoItf;
import fr.afcepf.al29.dionychus.entity.Adresse;
import fr.afcepf.al29.dionychus.entity.Commentaire;
import fr.afcepf.al29.dionychus.entity.Pays;
import fr.afcepf.al29.dionychus.entity.TypeAcces;
import fr.afcepf.al29.dionychus.entity.Utilisateur;
import fr.afcepf.al29.dionychus.entity.Ville;

/**
 * Classe pour les services de gestion des {@link Utilisateur}.
 *
 * @author ecala
 *
 */
@Service
public class BusinessCompteImpl implements IBusinessCompte {
    /**
     * Le contexte de l'application.
     */
    private ApplicationContext context = new ClassPathXmlApplicationContext("classpath:Beans.xml");
    /**
     * Objet pour accéder aux données des {@link Adresse}.
     */
    private AdresseDaoItf proxyAdresseDao = (AdresseDaoItf) context.getBean("adresseJDBCtemplate");
    /**
     * Objet pour accéder aux données des {@link Commentaire}.
     */
    private CommentaireDaoItf proxyCommentaireDao = (CommentaireDaoItf) context.getBean("commentaireJDBCtemplate");
    /**
     * Objet pour accéder aux données des {@link Pays}.
     */
    private PaysDaoImpl proxyPaysDao = (PaysDaoImpl) context.getBean("paysJDBCtemplate");
    /**
     * Objet pour accéder aux données des {@link Ville}.
     */
    private VilleDaoImpl proxyVilleDao = (VilleDaoImpl) context.getBean("villeJDBCtemplate");
    /**
     * Objet pour accéder aux données des {@link Utilisateur}.
     */
    private UtilisateurDaoImpl proxyUtilisateurDao = (UtilisateurDaoImpl) context.getBean("utilisateurJDBCtemplate");
    /**
     * Objet pour accéder aux données des {@link TypeAcces}.
     */
    private TypeAccesDaoImpl proxyTypeAccesDao = (TypeAccesDaoImpl) context.getBean("typeAccesJDBCtemplate");

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
        return proxyPaysDao.getAllPays();
    }

    @Override
    public Pays getPaysByIdVille(Integer paramIdVille) {
        return proxyPaysDao.getPaysByIdVille(paramIdVille);
    }

    @Override
    public List<Ville> getAllVille() {
        return proxyVilleDao.getAll();
    }

    @Override
    public List<Ville> getAllVilleByIdPays(Integer paramIdPays) {
        return proxyVilleDao.getAllByIdPays(paramIdPays);
    }

    @Override
    public List<TypeAcces> getAllTypeAcces() {
        return proxyTypeAccesDao.getAll();
    }

    @Override
    public List<Utilisateur> getAllUtilisateur() {
        return proxyUtilisateurDao.getAllUtilisateur();
    }

    @Override
    public Utilisateur getUserByEmail(String email) {
        return proxyUtilisateurDao.getUserByEmail(email);
    }

    @Override
    public Utilisateur getUtilisateurById(int paramIdUtilisateur) {
        return proxyUtilisateurDao.getUtilisateurById(paramIdUtilisateur);
    }

    @Override
    public void addUtilisateur(Utilisateur paramUtilisateur) {
        proxyUtilisateurDao.addUtilisateur(paramUtilisateur);
    }

    @Override
    public void updateUtilisateur(Utilisateur paramUtilisateur) {
        proxyUtilisateurDao.updateUtilisateur(paramUtilisateur);
    }

    @Override
    public void deleteUtilisateur(Integer paramIdUtilisateur) {
        proxyUtilisateurDao.deleteUtilisateur(paramIdUtilisateur);
    }

    @Override
    public Ville getVilleById(Integer paramIdVille) {
        return proxyVilleDao.getVilleById(paramIdVille);
    }

}
