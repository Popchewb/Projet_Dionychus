package fr.afcepf.al29.dionychus.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.afcepf.al29.dionychus.entity.TypeAccessoire;

public class TypeAccessoireMapper implements RowMapper<TypeAccessoire> {

	@Override
	public TypeAccessoire mapRow(ResultSet rs, int intRow) throws SQLException {
		TypeAccessoire typeAccessoire = new TypeAccessoire();
		typeAccessoire.setIdTypeAccessoire(rs.getInt("id_type_accessoire"));
		typeAccessoire.setLibelle(rs.getString("libelle"));
		return typeAccessoire;
	}

}
