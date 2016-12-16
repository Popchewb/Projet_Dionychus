package fr.afcepf.al29.dionychus.test;

import java.sql.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.afcepf.al29.dionychus.business.impl.BusinessCommandeClient;
import fr.afcepf.al29.dionychus.business.impl.BusinessInventaireImpl;
import fr.afcepf.al29.dionychus.data.impl.RegionDaoImpl;
import fr.afcepf.al29.dionychus.data.itf.CommandeClientDaoItf;
import fr.afcepf.al29.dionychus.data.itf.LigneCommandeDaoItf;
import fr.afcepf.al29.dionychus.data.itf.RegionDaoItf;
import fr.afcepf.al29.dionychus.entity.Accessoire;
import fr.afcepf.al29.dionychus.entity.Article;
import fr.afcepf.al29.dionychus.entity.CommandeClient;
import fr.afcepf.al29.dionychus.entity.Commentaire;
import fr.afcepf.al29.dionychus.entity.LigneCommande;
import fr.afcepf.al29.dionychus.entity.Promotion;
import fr.afcepf.al29.dionychus.entity.Region;
import fr.afcepf.al29.dionychus.entity.StatutCommande;
import fr.afcepf.al29.dionychus.entity.TypeVin;
import fr.afcepf.al29.dionychus.entity.Utilisateur;
import fr.afcepf.al29.dionychus.entity.Vin;

public class TestAppEric {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
//		BusinessInventaireImpl buInventaire = new BusinessInventaireImpl();
//		Article vin = buInventaire.getVinById(1);
//		System.out.println(vin);
//		List<Commentaire> commentaires = buInventaire.getAllByVin(vin.getIdArticle());
//		for (Commentaire commentaire : commentaires) {
//			System.out.println(commentaire);
//		}
//		List<Vin> vins = buInventaire.getAllVin();
//		for (Vin vin2 : vins) {
//			System.out.println(vin2);
//			System.out.println(vin2.getDescription());
//		}
//		List<Accessoire> accessoires = buInventaire.getAllAccessoire();
//		for (Accessoire accessoire : accessoires) {
//			System.out.println(accessoire + accessoire.getDescription());
//		}
//		
//		List<TypeVin> typesVin = buInventaire.getAllTypeVin();
//		for (TypeVin typeVin : typesVin) {
//			System.out.println(typeVin);
//		}
//		System.out.println(buInventaire.getAccessoireById(8));
//		RegionDaoItf regionDao = (RegionDaoItf) context.getBean("regionJDBCtemplate");
//		Region region = new Region(null, "testRegion");
//		region = regionDao.addRegionWithKey(region);
//		System.out.println(region);
		CommandeClientDaoItf ccDao = (CommandeClientDaoItf) context.getBean("commandeClientJDBCtemplate");
		LigneCommandeDaoItf lcDao = (LigneCommandeDaoItf) context.getBean("ligneCommandeJDBCtemplate");
//		Promotion promo = new Promotion(1, null, null, null, null, null);
//		Utilisateur user = new Utilisateur(5, null, null, null, null, null, null, null, null, null, null, null, null, null);
//		StatutCommande sc = new StatutCommande(1, null);
//		CommandeClient cc = new CommandeClient(new Date(0), user, promo);
//		cc.setStatutCommande(sc);
//		cc = ccDao.addCommandeClient(cc);
//		System.out.println(cc.getIdCommande());
		CommandeClient cc = ccDao.getCommandeClientById(1);
		BusinessCommandeClient ccBu = new BusinessCommandeClient();
		List<LigneCommande> lc = ccBu.getAllLigneCommandeByIdCommande(1);
		Double total = 0.0;
		for (LigneCommande ligneCommande : lc) {
			total += ligneCommande.getArticle().getPrix() * ligneCommande.getQuantite();
		}
		System.out.println(total + "€");
		
		
	}
}
