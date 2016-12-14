package fr.afcepf.al29.dionychus.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.afcepf.al29.dionychus.entity.Arome;

public class AromeMapper implements RowMapper<Arome> {

	@Override
	public Arome mapRow(ResultSet rs, int intRow) throws SQLException {
		Arome arome = new Arome();
		arome.setIdArome(rs.getInt("id_arome"));
		arome.setLibelle(rs.getString("libelle"));
		return arome;
	}

}
