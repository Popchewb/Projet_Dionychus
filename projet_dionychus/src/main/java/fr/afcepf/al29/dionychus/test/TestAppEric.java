package fr.afcepf.al29.dionychus.test;

import java.util.List;

import fr.afcepf.al29.dionychus.business.impl.BusinessInventaireImpl;
import fr.afcepf.al29.dionychus.entity.Accessoire;
import fr.afcepf.al29.dionychus.entity.Article;
import fr.afcepf.al29.dionychus.entity.Commentaire;
import fr.afcepf.al29.dionychus.entity.TypeVin;
import fr.afcepf.al29.dionychus.entity.Vin;

public class TestAppEric {
	public static void main(String[] args) {
		BusinessInventaireImpl buInventaire = new BusinessInventaireImpl();
		Article vin = buInventaire.getVinById(1);
		System.out.println(vin);
		List<Commentaire> commentaires = buInventaire.getAllByVin(vin.getIdArticle());
		for (Commentaire commentaire : commentaires) {
			System.out.println(commentaire);
		}
		List<Vin> vins = buInventaire.getAllVin();
		for (Vin vin2 : vins) {
			System.out.println(vin2);
			System.out.println(vin2.getDescription());
		}
		List<Accessoire> accessoires = buInventaire.getAllAccessoire();
		for (Accessoire accessoire : accessoires) {
			System.out.println(accessoire + accessoire.getDescription());
		}
		
		List<TypeVin> typesVin = buInventaire.getAllTypeVin();
		for (TypeVin typeVin : typesVin) {
			System.out.println(typeVin);
		}
		System.out.println(buInventaire.getAccessoireById(8));
	}
}
