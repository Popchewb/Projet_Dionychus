package fr.afcepf.al29.dionychus.business.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import fr.afcepf.al29.dionychus.business.itf.IBusinessCommandeClient;
import fr.afcepf.al29.dionychus.data.itf.AccessoireDaoItf;
import fr.afcepf.al29.dionychus.data.itf.AdresseDaoItf;
import fr.afcepf.al29.dionychus.data.itf.CommandeClientDaoItf;
import fr.afcepf.al29.dionychus.data.itf.LigneCommandeDaoItf;
import fr.afcepf.al29.dionychus.data.itf.PromotionDaoItf;
import fr.afcepf.al29.dionychus.data.itf.StatutCommandeDaoItf;
import fr.afcepf.al29.dionychus.data.itf.TypeLivraisonDaoItf;
import fr.afcepf.al29.dionychus.data.itf.VinDaoItf;
import fr.afcepf.al29.dionychus.entity.Accessoire;
import fr.afcepf.al29.dionychus.entity.Adresse;
import fr.afcepf.al29.dionychus.entity.CommandeClient;
import fr.afcepf.al29.dionychus.entity.LigneCommande;
import fr.afcepf.al29.dionychus.entity.Promotion;
import fr.afcepf.al29.dionychus.entity.StatutCommande;
import fr.afcepf.al29.dionychus.entity.TypeLivraison;
import fr.afcepf.al29.dionychus.entity.Utilisateur;
import fr.afcepf.al29.dionychus.entity.Vin;

/**
 * Classe pour les services de gestion des {@link CommandeClient}.
 *
 * @author ecala
 *
 */
@Component
public class BusinessCommandeClient implements IBusinessCommandeClient {
    /**
     * Le contexte de l'application.
     */
    private ApplicationContext context = new ClassPathXmlApplicationContext("classpath:Beans.xml");
    /**
     * Objet pour accéder aux données des {@link Adresse}.
     */
    private AdresseDaoItf adDao = (AdresseDaoItf) context.getBean("adresseJDBCtemplate");
    /**
     * Objet pour accéder aux données des {@link CommandeClient}.
     */
    private CommandeClientDaoItf ccDao = (CommandeClientDaoItf) context.getBean("commandeClientJDBCtemplate");
    /**
     * Objet pour accéder aux données des {@link LigneCommande}.
     */
    private LigneCommandeDaoItf lcDao = (LigneCommandeDaoItf) context.getBean("ligneCommandeJDBCtemplate");
    /**
     * Objet pour accéder aux données des {@link Promotion}.
     */
    private PromotionDaoItf promDao = (PromotionDaoItf) context.getBean("promotionJDBCtemplate");
    /**
     * Objet pour accéder aux données des {@link TypeLivraison}.
     */
    private TypeLivraisonDaoItf tlDao = (TypeLivraisonDaoItf) context.getBean("typeLivraisonJDBCtemplate");
    /**
     * Objet pour accéder aux données des {@link Accessoire}.
     */
    private AccessoireDaoItf accDao = (AccessoireDaoItf) context.getBean("accessoireJDBCtemplate");
    /**
     * Objet pour accéder aux données des {@link Vin}.
     */
    private VinDaoItf vinDao = (VinDaoItf) context.getBean("vinJDBCtemplate");
    /**
     * Objet pour accéder aux données des {@link StatutCommande}.
     */
    private StatutCommandeDaoItf scDao = (StatutCommandeDaoItf) context.getBean("statutCommandeJDBCtemplate");

    @Override
    public List<Adresse> getAdresseByIdActeur(Integer paramIdActeur) {
        return adDao.getAdresseByIdActeur(paramIdActeur);
    }

    @Override
    public List<CommandeClient> getAllCommandeClient() {
        return ccDao.getAll();
    }

    @Override
    public CommandeClient getCommandeById(Integer paramIdCommandeClient) {
        return ccDao.getCommandeClientById(paramIdCommandeClient);
    }

    @Override
    public List<CommandeClient> getCommandesByIdUtilisateur(Integer paramIdUtilisateur) {
        return ccDao.getCommandesByIdUtilisateur(paramIdUtilisateur);
    }

    @Override
    public CommandeClient addCommandeClient(CommandeClient paramCommandeClient) {
        return ccDao.addCommandeClient(paramCommandeClient);
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
        List<LigneCommande> lignesCommande = lcDao.getAllByIdCommande(paramIdCommande);
        for (LigneCommande ligneCommande : lignesCommande) {
            if (ligneCommande.getArticle().getTypeArticle().equals("Vin")) {
                ligneCommande.setArticle(vinDao.getById(ligneCommande.getArticle().getIdArticle()));
            } else if (ligneCommande.getArticle().getTypeArticle().equals("Accessoire")) {
                ligneCommande.setArticle(accDao.getById(ligneCommande.getArticle().getIdArticle()));
            }
        }
        return lignesCommande;
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

    @Override
    public void validerCommandeClient(CommandeClient paramCommandeClient, Utilisateur paramUtilisateur) {
        List<LigneCommande> lignesCommande = lcDao.getAllByIdCommande(paramCommandeClient.getIdCommande());
        for (LigneCommande ligneCommande : lignesCommande) {
            if (ligneCommande.getArticle().getTypeArticle().equals("Accessoire")) {
                Accessoire article = (Accessoire) ligneCommande.getArticle();
                article.setQuantite(ligneCommande.getArticle().getQuantite() - ligneCommande.getQuantite());
                accDao.updateAccessoire(article);
            } else if (ligneCommande.getArticle().getTypeArticle().equals("Vin")) {
                Vin article = (Vin) ligneCommande.getArticle();
                article.setQuantite(ligneCommande.getArticle().getQuantite() - ligneCommande.getQuantite());
                vinDao.updateVin(article);
            }
        }

    }

    @Override
    public StatutCommande getStatutCommandeById(Integer paramIdStatutCommande) {
        return scDao.getById(paramIdStatutCommande);
    }

    @Override
    public CommandeClient addPanier(CommandeClient panier) {
        return ccDao.addPanier(panier);
    }

    @Override
    public TypeLivraison getTypeLivraisonById(Integer paramIdTypeLivraison) {
        return tlDao.getById(paramIdTypeLivraison);
    }

    @Override
    public void updateTypeLivraison(CommandeClient paramCommandeClient, Integer paramIdTypeLivraison) {
        ccDao.updateTypeLivraison(paramCommandeClient, paramIdTypeLivraison);
    }

    @Override
    public Double getTarifLivraisonByIdCommande(Integer idCommande) {
        return ccDao.getTarifLivraisonByIdCommande(idCommande);
    }

    @Override
    public void updatePanierValider(CommandeClient paramCommandeClient) {
        ccDao.updatePanierValider(paramCommandeClient);
    }

    @Override
    public void updatePanierRefUtilisateur(CommandeClient panierUtilisateur) {
        ccDao.updatePanierRefUtilisateur(panierUtilisateur);
    }

    @Override
    public CommandeClient addPanierPostCommande(CommandeClient panier) {
        return ccDao.addPanierPostCommande(panier);
    }

}
