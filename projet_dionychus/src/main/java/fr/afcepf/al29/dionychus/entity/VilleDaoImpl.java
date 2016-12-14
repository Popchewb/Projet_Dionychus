package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.afcepf.al29.dionychus.data.itf.VilleDaoItf;
import fr.afcepf.al29.dionychus.entity.Ville;
import fr.afcepf.al29.dionychus.mapper.VilleMapper;

public class VilleDaoImpl implements VilleDaoItf {
	
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
	public List<Ville> getAll() {
		String SQL = "SELECT v.id_ville, v.libelle, v.code_postal, v.id_pays, p.libelle FROM ville v INNER JOIN pays p WHERE v.id_pays = p.id_pays";
		return jdbcTemplate.query(SQL, new VilleMapper());
	}

	@Override
	public List<Ville> getAllByIdPays(Integer paramIdPays) {
		String SQL = "SELECT v.id_ville, v.libelle, v.code_postal, v.id_pays, p.libelle FROM ville v INNER JOIN pays p WHERE v.id_pays = p.id_pays AND v.id_pays = ?";
		return jdbcTemplate.query(SQL, new Object[]{paramIdPays}, new VilleMapper());
	}

}
