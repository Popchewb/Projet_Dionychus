package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.afcepf.al29.dionychus.data.itf.TypeAccessoireDaoItf;
import fr.afcepf.al29.dionychus.entity.TypeAccessoire;
import fr.afcepf.al29.dionychus.mapper.TypeAccessoireMapper;

public class TypeAccessoireDaoImpl implements TypeAccessoireDaoItf {
	
	JdbcTemplate jdbcTemplate;
	DataSource dataSource;
	
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}



	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}



	public DataSource getDataSource() {
		return dataSource;
	}



	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}



	@Override
	public List<TypeAccessoire> getAll() {
		String SQL = "SELECT id_type_accessoire, libelle FROM type_accessoire ORDER BY libelle";
		List<TypeAccessoire> typesAccessoire = jdbcTemplate.query(SQL, new TypeAccessoireMapper());
		return typesAccessoire;
	}



	@Override
	public TypeAccessoire getById(Integer paramIdTypeAccessoire) {
		String SQL = "SELECT id_type_accessoire, libelle FROM type_accessoire WHERE id_type_accessoire = ?";
		TypeAccessoire typeAccessoire = jdbcTemplate.queryForObject(SQL, new Object[] {paramIdTypeAccessoire}, new TypeAccessoireMapper());
		return typeAccessoire;
	}

}
