package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.afcepf.al29.dionychus.data.itf.TypeVinDaoItf;
import fr.afcepf.al29.dionychus.entity.TypeVin;
import fr.afcepf.al29.dionychus.mapper.TypeVinMapper;

public class TypeVinDaoImpl implements TypeVinDaoItf{
	
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
	public List<TypeVin> getAll() {
		String SQL = "SELECT id_type_vin, libelle FROM type_vin ORDER BY libelle";
		List<TypeVin> typesVin = jdbcTemplate.query(SQL, new TypeVinMapper());
		return typesVin;
	}

}
