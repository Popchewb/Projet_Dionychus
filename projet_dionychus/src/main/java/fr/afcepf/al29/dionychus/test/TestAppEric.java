package fr.afcepf.al29.dionychus.test;

import java.util.List;

import fr.afcepf.al29.dionychus.business.impl.BusinessInventaireImpl;
import fr.afcepf.al29.dionychus.entity.Article;
import fr.afcepf.al29.dionychus.entity.Commentaire;

public class TestAppEric {
	public static void main(String[] args) {
		BusinessInventaireImpl buInventaire = new BusinessInventaireImpl();
		Article vin = buInventaire.getVinById(1);
		System.out.println(vin);
		List<Commentaire> commentaires = buInventaire.getAllByVin(vin.getIdArticle());
		for (Commentaire commentaire : commentaires) {
			System.out.println(commentaire);
		}
	}
}
