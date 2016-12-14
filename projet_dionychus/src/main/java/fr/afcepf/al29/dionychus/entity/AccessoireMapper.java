package fr.afcepf.al29.dionychus.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.afcepf.al29.dionychus.entity.Accessoire;
import fr.afcepf.al29.dionychus.entity.TypeAccessoire;

public class AccessoireMapper implements RowMapper<Accessoire> {
	

	@Override
	public Accessoire mapRow(ResultSet rs, int intRow) throws SQLException {
		Accessoire accessoire = new Accessoire();
		accessoire.setIdArticle(rs.getInt("a.id_article"));
		TypeAccessoire typeAccessoire = new TypeAccessoire();
		typeAccessoire.setId_type_accessoire(rs.getInt("a.id_type_accessoire"));
		typeAccessoire.setLibelle(rs.getString("tac.libelle"));
		accessoire.setTypeAccessoire(typeAccessoire);
		accessoire.setReference(rs.getString("a.reference"));
		accessoire.setLibelle(rs.getString("a.libelle"));
		accessoire.setDescription(rs.getString("a.description"));
		accessoire.setPrix(rs.getDouble("a.prix"));
		accessoire.setQuantite(rs.getInt("a.quantite"));
		accessoire.setSeuilAlerte(rs.getInt("a.seuil_alerte"));
		accessoire.setUrlImage(rs.getString("a.url_image"));		
		return accessoire;
	}

}
