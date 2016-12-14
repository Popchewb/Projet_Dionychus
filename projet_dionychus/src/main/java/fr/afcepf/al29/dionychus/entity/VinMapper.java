package fr.afcepf.al29.dionychus.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.afcepf.al29.dionychus.entity.Vin;

public class VinMapper implements RowMapper<Vin> {

	@Override
	public Vin mapRow(ResultSet rs, int intRow) throws SQLException {
		Vin vin = new Vin();
		vin.setIdArticle(rs.getInt("a.id_article"));
		return vin;
	}

}
