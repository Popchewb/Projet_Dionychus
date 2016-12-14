package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.afcepf.al29.dionychus.data.itf.TypeAccesDaoItf;
import fr.afcepf.al29.dionychus.entity.TypeAcces;
import fr.afcepf.al29.dionychus.mapper.TypeAccesMapper;

public class TypeAccesDaoImpl implements TypeAccesDaoItf {
	
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
	public List<TypeAcces> getAll() {
		String SQL = "SELECT id_type_acces,libelle FROM type_acces ORDER BY libelle";
		List<TypeAcces> typeAcces = jdbcTemplate.query(SQL, new TypeAccesMapper());
		return typeAcces;
	}

}
