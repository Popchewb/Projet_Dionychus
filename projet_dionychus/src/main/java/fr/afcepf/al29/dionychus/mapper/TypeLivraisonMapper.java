package fr.afcepf.al29.dionychus.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.afcepf.al29.dionychus.entity.TypeLivraison;

public class TypeLivraisonMapper implements RowMapper<TypeLivraison> {

	@Override
	public TypeLivraison mapRow(ResultSet rs, int intRow) throws SQLException {
		TypeLivraison typeLivraison = new TypeLivraison();
		typeLivraison.setIdTypeLivraison(rs.getInt("id_type_livraison"));
		typeLivraison.setLibelle(rs.getString("libelle"));
		typeLivraison.setDescription(rs.getString("description"));
		typeLivraison.setUrlImage(rs.getString("url_image"));
		return typeLivraison;
	}
	
}
