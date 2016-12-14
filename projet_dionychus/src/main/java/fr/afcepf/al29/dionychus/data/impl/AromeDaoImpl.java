package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.afcepf.al29.dionychus.data.itf.AromeDaoItf;
import fr.afcepf.al29.dionychus.entity.Arome;
import fr.afcepf.al29.dionychus.mapper.AromeMapper;

public class AromeDaoImpl implements AromeDaoItf{
	
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
	public List<Arome> getAll() {
		String SQL = "SELECT id_arome,libelle FROM arome ORDER BY libelle";
		List<Arome> aromes = jdbcTemplate.query(SQL, new AromeMapper());
		return aromes;
	}

	@Override
	public List<Arome> getAromeByIdVin(int paramIdVin) {
		// TODO Auto-generated method stub
		return null;
	}

}
