package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.afcepf.al29.dionychus.data.itf.AppelationDaoItf;
import fr.afcepf.al29.dionychus.entity.Appelation;
import fr.afcepf.al29.dionychus.mapper.AppelationMapper;

public class AppelationDaoImpl implements AppelationDaoItf {
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
	public List<Appelation> getAll() {
		String SQL = "SELECT id_appelation, libelle FROM appelation ORDER BY libelle";
		List<Appelation> appelations = jdbcTemplate.query(SQL, new AppelationMapper());
		return appelations;
	}
	@Override
	public List<Appelation> getAppelationByIdVin(int paramIdVin) {
		String SQL = "SELECT a.id_appelation, a.libelle FROM appelation a INNER JOIN vin v WHERE a.id_appelation = v.id_appelation AND v.id_vin = ?";
		List<Appelation> appelations = jdbcTemplate.query(SQL, new Object[] {paramIdVin}, new AppelationMapper());
		return appelations;
	}
	
	
}
