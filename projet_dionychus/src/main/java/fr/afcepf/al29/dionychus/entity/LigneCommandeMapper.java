package fr.afcepf.al29.dionychus.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.afcepf.al29.dionychus.entity.Accessoire;
import fr.afcepf.al29.dionychus.entity.LigneCommande;
import fr.afcepf.al29.dionychus.entity.Vin;

public class LigneCommandeMapper implements RowMapper<LigneCommande> {

	@Override
	public LigneCommande mapRow(ResultSet rs, int intRow) throws SQLException {
		LigneCommande ligneCommande = new LigneCommande();
		ligneCommande.setIdLigneCommande(rs.getInt("lc.id_ligne_commande"));
		ligneCommande.setQuantite(rs.getInt("lc.quantite"));
		String typeArticle = rs.getString("a.type_article");
		if (typeArticle.equals("Vin")) {
			Vin article = new Vin();
			article.setIdArticle(rs.getInt("lc.id_article"));
			article.setTypeArticle(typeArticle);
			ligneCommande.setArticle(article);
		}
		if (typeArticle.equals("Accessoire")) {
			Accessoire article = new Accessoire();
			article.setIdArticle(rs.getInt("lc.id_article"));
			article.setTypeArticle(rs.getString("a.type_article"));
			ligneCommande.setArticle(article);
		}

		return ligneCommande;
	}

}
