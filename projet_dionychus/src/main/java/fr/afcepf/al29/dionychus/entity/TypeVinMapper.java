package fr.afcepf.al29.dionychus.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.afcepf.al29.dionychus.entity.TypeVin;

public class TypeVinMapper implements RowMapper<TypeVin>{

	@Override
	public TypeVin mapRow(ResultSet rs, int intRow) throws SQLException {
		TypeVin typeVin = new TypeVin();
		typeVin.setIdTypeVin(rs.getInt("id_type_vin"));
		typeVin.setLibelle(rs.getString("libelle"));
		return typeVin;
	}

}
