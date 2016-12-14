package fr.afcepf.al29.dionychus.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.afcepf.al29.dionychus.entity.Pays;

public class PaysMapper implements RowMapper<Pays>{

	@Override
	public Pays mapRow(ResultSet rs, int intRow) throws SQLException {
		Pays pays = new Pays();
		pays.setIdPays(rs.getInt("id_pays"));
		pays.setLibelle(rs.getString("libelle"));
		return pays;
	}

}
