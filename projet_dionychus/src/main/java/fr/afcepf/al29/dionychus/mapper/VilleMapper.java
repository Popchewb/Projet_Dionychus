package fr.afcepf.al29.dionychus.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.afcepf.al29.dionychus.entity.Pays;
import fr.afcepf.al29.dionychus.entity.Ville;

public class VilleMapper implements RowMapper<Ville>{

	@Override
	public Ville mapRow(ResultSet rs, int intRow) throws SQLException {
		Ville ville = new Ville();
		ville.setIdVille(rs.getInt("v.id_ville"));
		ville.setLibelle(rs.getString("v.libelle"));
		ville.setCodePostal(rs.getString("v.code_postal"));
		Pays pays = new Pays();
		pays.setIdPays(rs.getInt("v.id_pays"));
		pays.setLibelle(rs.getString("p.libelle"));
		ville.setPays(pays);
		return ville;
	}

}
