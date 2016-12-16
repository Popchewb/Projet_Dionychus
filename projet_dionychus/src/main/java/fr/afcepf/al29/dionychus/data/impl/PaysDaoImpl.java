package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.afcepf.al29.dionychus.data.itf.PaysDaoItf;
import fr.afcepf.al29.dionychus.entity.Pays;
import fr.afcepf.al29.dionychus.mapper.PaysMapper;

public class PaysDaoImpl implements PaysDaoItf {

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
	public List<Pays> getAllPays() {
		System.out.println("je passe dans le DAO Impl");
		String SQL = "SELECT id_pays, libelle FROM pays ORDER BY libelle";
		return jdbcTemplate.query(SQL, new PaysMapper());
	}

	@Override
	public Pays getPaysByIdVille(Integer paramIdVille) {
		String SQL = "SELECT p.id_pays, p.libelle FROM pays p INNER JOIN ville v WHERE p.id_ville = v.id_ville AND v.id_ville = ?";
		Pays pays = jdbcTemplate.queryForObject(SQL, new Object[] { paramIdVille }, new PaysMapper());
		return pays;
	}

}
