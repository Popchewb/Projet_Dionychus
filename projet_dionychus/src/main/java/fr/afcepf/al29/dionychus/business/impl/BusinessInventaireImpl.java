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
import fr.afcepf.al29.dionychus.data.itf.RegionDaoItf;
import fr.afcepf.al29.dionychus.data.itf.TypeVinDaoItf;
import fr.afcepf.al29.dionychus.data.itf.VinDaoItf;
import fr.afcepf.al29.dionychus.entity.Accessoire;
import fr.afcepf.al29.dionychus.entity.Appelation;
import fr.afcepf.al29.dionychus.entity.Arome;
import fr.afcepf.al29.dionychus.entity.Article;
import fr.afcepf.al29.dionychus.entity.Cepage;
import fr.afcepf.al29.dionychus.entity.Commentaire;
import fr.afcepf.al29.dionychus.entity.Promotion;
import fr.afcepf.al29.dionychus.entity.Region;
import fr.afcepf.al29.dionychus.entity.TypeAccessoire;
import fr.afcepf.al29.dionychus.entity.TypeVin;
import fr.afcepf.al29.dionychus.entity.Vin;

/**
 * Objet pour les services de gestion de l'inventaire de Dyonichus.
 *
 * @author ecala
 *
 */
@Service("proxyBusinessInventaire")
public class BusinessInventaireImpl implements IBusinessInventaire {
    /**
     * Le contexte de l'application.
     */
    private ApplicationContext context = new ClassPathXmlApplicationContext("classpath:Beans.xml");
    /**
     * Objet pour accéder aux données des {@link Accessoire}.
     *
     * @author ecala
     *
     */
    private AccessoireDaoItf proxyDaoAccessoire = (AccessoireDaoItf) context.getBean("accessoireJDBCtemplate");
    /**
     * Objet pour accéder aux données des {@link Vin}.
     *
     * @author ecala
     *
     */
    private VinDaoItf proxyDaoVin = (VinDaoItf) context.getBean("vinJDBCtemplate");
    /**
     * Objet pour accéder aux données des {@link Arome}.
     *
     * @author ecala
     *
     */
    private AromeDaoItf proxyDaoArome = (AromeDaoItf) context.getBean("aromeJDBCtemplate");
    /**
     * Objet pour accéder aux données des {@link Cepage}.
     *
     * @author ecala
     *
     */
    private CepageDaoItf proxyDaoCepage = (CepageDaoItf) context.getBean("cepageJDBCtemplate");
    /**
     * Objet pour accéder aux données des {@link Region}.
     *
     * @author ecala
     *
     */
    private RegionDaoItf proxyDaoRegion = (RegionDaoItf) context.getBean("regionJDBCtemplate");
    /**
     * Objet pour accéder aux données des {@link Appelation}.
     *
     * @author ecala
     *
     */
    private AppelationDaoItf proxyDaoAppellation = (AppelationDaoItf) context.getBean("appelationJDBCtemplate");
    /**
     * Objet pour accéder aux données des {@link TypeVin}.
     *
     * @author ecala
     *
     */
    private TypeVinDaoItf proxyDaoTypeVin = (TypeVinDaoItf) context.getBean("typeVinJDBCtemplate");
    /**
     * Objet pour accéder aux données des {@link Commentaire}.
     *
     * @author ecala
     *
     */
    private CommentaireDaoItf proxyDaoCommentaire = (CommentaireDaoItf) context.getBean("commentaireJDBCtemplate");

    @Override
    public List<Accessoire> getAllAccessoire() {
        return proxyDaoAccessoire.getAll();
    }

    @Override
    public List<Vin> getAllVin() {
        return proxyDaoVin.getAll();
    }

    @Override
    public List<Vin> getAllVinAromeCepage() {
        List<Vin> vins = proxyDaoVin.getAll();
        for (Vin vin : vins) {
            vin.setAromes(proxyDaoArome.getAromeByIdVin(vin.getIdArticle()));
            vin.setCepages(proxyDaoCepage.getCepageByIdVin(vin.getIdArticle()));
        }
        return vins;
    }

    @Override
    public List<Arome> getAllArome() {
        return proxyDaoArome.getAll();
    }

    @Override
    public List<Cepage> getAllCepage() {
        return proxyDaoCepage.getAll();
    }

    @Override
    public List<Region> getAllRegion() {
        return proxyDaoRegion.getAll();
    }

    @Override
    public List<Appelation> getAllAppelation() {
        return proxyDaoAppellation.getAll();
    }

    @Override
    public List<TypeVin> getAllTypeVin() {
        return proxyDaoTypeVin.getAll();
    }

    @Override
    public Region getRegionById(Integer region) {
        return proxyDaoRegion.getRegionById(region);
    }

    @Override
    public Appelation getAppellationById(Integer paramIdAppelation) {
        return proxyDaoAppellation.getAppelationById(paramIdAppelation);
    }

    @Override
    public TypeVin getTypeVinById(Integer paramIdTypeVin) {
        return proxyDaoTypeVin.getTypeVinById(paramIdTypeVin);
    }

    @Override
    public Arome getAromeById(int paramIdArome) {
        return proxyDaoArome.getAromeById(paramIdArome);
    }

    @Override
    public Cepage getCepageById(int paramIdCepage) {
        return proxyDaoCepage.getCepageById(paramIdCepage);
    }

    @Override
    public void addVin(Vin paramVin, Integer paramIdFournisseur) {
        proxyDaoVin.addVin(paramVin, paramIdFournisseur);
    }

    @Override
    public Accessoire getAccessoireById(Integer paramIdAccessoire) {
        return proxyDaoAccessoire.getById(paramIdAccessoire);
    }

    @Override
    public void addAccessoire(Accessoire paramAccessoire) {

    }

    @Override
    public void updateAccessoire(Accessoire paramAccessoire) {

    }

    @Override
    public void deleteAccessoire(Integer paramIdAccessoire) {

    }

    @Override
    public List<Article> getBestSellerAccessoire() {
        return proxyDaoAccessoire.getBestSellerAccessoire();
    }

    @Override
    public List<Commentaire> getAllByVin(Integer paramIdVin) {
        return proxyDaoCommentaire.getAllByVin(paramIdVin);
    }

    @Override
    public List<Commentaire> getAllByAccessoire(Integer paramIdAccessoire) {
        return proxyDaoCommentaire.getAllByAccessoire(paramIdAccessoire);
    }

    @Override
    public void addCommentaire(Commentaire paramCommentaire, Integer paramIdArticle, Integer paramIdUtilisateur) {

    }

    @Override
    public void updateCommentaire(Commentaire paramCommentaire) {

    }

    @Override
    public void deleteCommentaire(Integer paramIdCommentaire) {

    }

    @Override
    public void addPromotion(Promotion paramPromotion) {

    }

    @Override
    public void updatePromotion(Promotion paramPromotion) {

    }

    @Override
    public void deletePromotion(Integer paramIdPromotion) {

    }

    @Override
    public List<TypeAccessoire> getAllTypeAccessoire() {
        return null;
    }

    @Override
    public Article getVinById(Integer paramIdVin) {
        Vin vin = proxyDaoVin.getById(paramIdVin);
        vin.setAromes(proxyDaoArome.getAromeByIdVin(paramIdVin));
        vin.setCepages(proxyDaoCepage.getCepageByIdVin(paramIdVin));
        return vin;
    }

    @Override
    public void updateVin(Vin paramVin) {

    }

    @Override
    public void deleteVin(Integer paramIdVin) {

    }

    @Override
    public List<Article> getBestSellerVin() {
        return proxyDaoVin.getBestSellerVin();
    }

    @Override
    public List<Article> getArticlesAssocies(Integer idCommande) {
        return proxyDaoVin.getArticlesAssocies(idCommande);
    }

}
