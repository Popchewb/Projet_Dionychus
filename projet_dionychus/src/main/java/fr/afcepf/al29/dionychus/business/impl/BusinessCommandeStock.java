package fr.afcepf.al29.dionychus.business.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import fr.afcepf.al29.dionychus.business.itf.IBusinessCommandeStock;
import fr.afcepf.al29.dionychus.data.itf.CommandeStockDaoItf;
import fr.afcepf.al29.dionychus.data.itf.FournisseurDaoItf;
import fr.afcepf.al29.dionychus.entity.CommandeStock;
import fr.afcepf.al29.dionychus.entity.Fournisseur;

/**
 * Classe pour les services de gestion des {@link CommandeStock}.
 *
 * @author ecala
 *
 */
@Component
public class BusinessCommandeStock implements IBusinessCommandeStock {
    /**
     * Le contexte de l'application.
     */
    private ApplicationContext context = new ClassPathXmlApplicationContext("classpath:Beans.xml");
    /**
     * Objet pour accéder aux données des {@link CommandeStock}.
     */
    private CommandeStockDaoItf csDao = (CommandeStockDaoItf) context.getBean("commandeStockJDBCtemplate");
    /**
     * Objet pour accéder aux données des {@link Fournisseur}.
     */
    private FournisseurDaoItf fDao = (FournisseurDaoItf) context.getBean("fournisseurJDBCtemplate");

    @Override
    public List<CommandeStock> getAllCommandesStock() {
        return csDao.getAll();
    }

    @Override
    public void addCommandeStock(CommandeStock paramCommandeStock) {
        csDao.addCommandeStock(paramCommandeStock);
    }

    @Override
    public void updateCommandeStock(CommandeStock paramCommandeStock) {
        csDao.updateCommandeStock(paramCommandeStock);
    }

    @Override
    public void deleteCommandeStock(Integer paramIdCommandeStock) {
        csDao.deleteCommandeStock(paramIdCommandeStock);
    }

    @Override
    public List<Fournisseur> getAllFournisseur() {
        return fDao.getAll();
    }

    @Override
    public Fournisseur getById(Integer paramIdFournisseur) {
        return fDao.getById(paramIdFournisseur);
    }

    @Override
    public void addFournisseur(Fournisseur paramFournisseur) {
        fDao.addFournisseur(paramFournisseur);
    }

    @Override
    public void updateFournisseur(Fournisseur paramFournisseur) {
        fDao.updateFournisseur(paramFournisseur);
    }

    @Override
    public void deleteFournisseur(Integer paramIdFournisseur) {
        fDao.deleteFournisseur(paramIdFournisseur);
    }

}
