package fr.afcepf.al29.dionychus.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.afcepf.al29.dionychus.entity.Adresse;
import fr.afcepf.al29.dionychus.entity.Pays;
import fr.afcepf.al29.dionychus.entity.Ville;

public class AdresseMapper implements RowMapper<Adresse> {

	@Override
	public Adresse mapRow(ResultSet rs, int intRow) throws SQLException {
		Adresse adresse = new Adresse();
		adresse.setIdAdresse(rs.getInt("a.id_adresse"));
		adresse.setAdresseFacturation(rs.getBoolean("a.adresse_facturation"));
		adresse.setAdresseLivraison(rs.getBoolean("a.adresse_livraison"));
		adresse.setLibelle(rs.getString("a.libelle"));
		adresse.setComplementAdresse(rs.getString("a.complement"));
		Pays pays = new Pays();
		pays.setIdPays(rs.getInt("p.id_pays"));
		pays.setLibelle(rs.getString("p.libelle"));
		Ville ville = new Ville();
		ville.setIdVille(rs.getInt("v.id_ville"));
		ville.setCodePostal(rs.getString("v.code_postal"));
		ville.setLibelle(rs.getString("v.libelle"));
		ville.setPays(pays);
		adresse.setVille(ville);
		return adresse;
	}

}
