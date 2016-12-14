package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.afcepf.al29.dionychus.data.itf.AccessoireDaoItf;
import fr.afcepf.al29.dionychus.entity.Accessoire;
import fr.afcepf.al29.dionychus.mapper.AccessoireMapper;

public class AccessoireDaoImpl implements AccessoireDaoItf {

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
	public List<Accessoire> getAll() {
		String SQL = "SELECT a.id_article, a.id_type_accessoire, a.reference, a.libelle, a.description, a.prix, a.quantite, a.seuil_alerte, a.url_image, tac.libelle FROM article a INNER JOIN type_accessoire tac WHERE a.id_type_accessoire = tac.id_type_accessoire AND a.type_article = 'Accessoire' ORDER BY a.libelle";
		return jdbcTemplate.query(SQL, new AccessoireMapper());
	}

	@Override
	public Accessoire getById(Integer paramIdAccessoire) {
		String SQL = "SELECT a.id_article, a.id_type_accessoire, a.reference, a.libelle, a.description, a.prix, a.quantite, a.seuil_alerte, a.url_image, tac.libelle FROM article a INNER JOIN type_accessoire tac WHERE a.id_type_accessoire = tac.id_type_accessoire AND a.id_article = ? AND a.type_article = 'Accessoire'";
		return jdbcTemplate.queryForObject(SQL, new Object[]{paramIdAccessoire}, new AccessoireMapper());
	}

}
