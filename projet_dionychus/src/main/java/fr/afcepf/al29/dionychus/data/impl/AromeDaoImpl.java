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
		String SQL = "SELECT a.id_arome, a.libelle FROM arome a INNER JOIN vin_arome va WHERE a.id_arome = va.id_arome AND va.id_article = ?";
		return jdbcTemplate.query(SQL, new Object[] {paramIdVin}, new AromeMapper());
	}

	@Override
	public Arome getAromeById(int aromeId) {
		String SQL = "SELECT id_arome, libelle FROM arome WHERE id_arome = ?";
		return jdbcTemplate.queryForObject(SQL, new Object[] {aromeId}, new AromeMapper());
	}

}
