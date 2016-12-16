package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.afcepf.al29.dionychus.data.itf.CepageDaoItf;
import fr.afcepf.al29.dionychus.entity.Cepage;
import fr.afcepf.al29.dionychus.mapper.CepageMapper;

public class CepageDaoImpl implements CepageDaoItf{
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	
	

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
	public List<Cepage> getAll() {
		String SQL = "SELECT id_cepage, libelle FROM cepage ORDER BY libelle";
		List<Cepage> cepages = jdbcTemplate.query(SQL, new CepageMapper());
		return cepages;
	}

	@Override
	public List<Cepage> getCepageByIdVin(int paramIdVin) {
		String SQL = "SELECT c.id_cepage, c.libelle FROM cepage c INNER JOIN vin_cepage vc WHERE vc.id_cepage = c.id_cepage AND vc.id_article = ? ORDER BY libelle";
		List<Cepage> cepages = jdbcTemplate.query(SQL, new CepageMapper(), paramIdVin);
		return cepages;
	}

	@Override
	public Cepage getCepageById(int cepageId) {
		String SQL = "SELECT id_cepage, libelle FROM cepage WHERE id_cepage = ?";
		return jdbcTemplate.queryForObject(SQL, new Object[] {cepageId}, new CepageMapper());
	}

}