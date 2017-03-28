package fr.afcepf.al29.dionychus.business.itf;

import java.util.List;

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
 * Classe pour les services de gestion de l'inventaire.
 *
 * @author ecala
 *
 */
public interface IBusinessInventaire {

    // Accessoires
    /**
     * Récupère tous les {@link Accessoire} de l'unité de persistence.
     *
     * @return la liste des {@link Accessoire}.
     */
    List<Accessoire> getAllAccessoire();
    /**
     * Récupère un {@link Accessoire} par son identifiant.
     * @param paramIdAccessoire l'identifiant de l'{@link Accessoire}.
     * @return l'{@link Accessoire}.
     */
    Accessoire getAccessoireById(Integer paramIdAccessoire);
    /**
     * Ajoute un {@link Accessoire} à l'unité de persistence.
     * @param paramAccessoire l'{@link Accessoire ajouté.
     */
    void addAccessoire(Accessoire paramAccessoire);
    /**
     * Met à jour un {@link Accessoire} dans l'unité de persistence.
     * @param paramAccessoire l'{@link Accessoire} mis à jour.
     */
    void updateAccessoire(Accessoire paramAccessoire);
    /**
     * Supprime un {@link Accessoire} de l'unité de persistence.
     * @param paramIdAccessoire l'identifiant de l'{@link Accessoire}.
     */
    void deleteAccessoire(Integer paramIdAccessoire);
    /**
     * Récupère les best sellers des {@link Accessoire}.
     * @return la liste des best sellers.
     */
    List<Article> getBestSellerAccessoire();

    // Appelations
    /**
     * Récupère toutes les {@link Appelation} de l'unité de persistence.
     * @return la liste des {@link Appelation}.
     */
    List<Appelation> getAllAppelation();
    /**
     * Récupère une {@link Appelation} par son identifiant.
     * @param paramIdAppelation l'identifiant de l'{@link Appelation}.
     * @return l'{@link Appelation}.
     */
    Appelation getAppellationById(Integer paramIdAppelation);

    // Aromes
    /**
     * Récupère tous les {@link Arome} de l'unité de persistence.
     * @return la liste des {@link Arome}.
     */
    List<Arome> getAllArome();
    /**
     * Récupère un {@link Arome} par son identifiant.
     * @param paramIdArome l'identifiant.
     * @return l'{@link Arome}.
     */
    Arome getAromeById(int paramIdArome);

    // Cepage
    List<Cepage> getAllCepage();

    Cepage getCepageById(int paramIdCepage);

    // Commentaires
    List<Commentaire> getAllByVin(Integer paramIdVin);

    List<Commentaire> getAllByAccessoire(Integer paramIdAccessoire);

    void addCommentaire(Commentaire paramCommentaire, Integer paramIdArticle, Integer paramIdUtilisateur);

    void updateCommentaire(Commentaire paramCommentaire);

    void deleteCommentaire(Integer paramIdCommentaire);

    // Promotions
    void addPromotion(Promotion paramPromotion);

    void updatePromotion(Promotion paramPromotion);

    void deletePromotion(Integer paramIdPromotion);

    // Region
    List<Region> getAllRegion();

    Region getRegionById(Integer region);

    // Type Accessoire
    List<TypeAccessoire> getAllTypeAccessoire();

    // Type Vin
    List<TypeVin> getAllTypeVin();

    TypeVin getTypeVinById(Integer paramIdTypeVin);

    // Vin
    List<Vin> getAllVin();

    Article getVinById(Integer paramIdVin);

    void addVin(Vin paramVin, Integer paramIdFournisseur);

    void updateVin(Vin paramVin);

    void deleteVin(Integer paramIdVin);

    List<Article> getBestSellerVin();

    List<Vin> getAllVinAromeCepage();

    List<Article> getArticlesAssocies(Integer idCommande);

}