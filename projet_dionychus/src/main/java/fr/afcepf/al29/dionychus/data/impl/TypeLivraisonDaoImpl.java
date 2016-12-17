package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.afcepf.al29.dionychus.data.itf.TypeLivraisonDaoItf;
import fr.afcepf.al29.dionychus.entity.TypeLivraison;
import fr.afcepf.al29.dionychus.mapper.TypeLivraisonMapper;

public class TypeLivraisonDaoImpl implements TypeLivraisonDaoItf{
	
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
	public List<TypeLivraison> getAll() {
		String SQL = "SELECT id_type_livraison, libelle, description, url_image, tarification FROM type_livraison ORDER BY id_type_livraison";
		List<TypeLivraison> typesLivraison = jdbcTemplate.query(SQL, new TypeLivraisonMapper());
		return typesLivraison;
	}

	@Override
	public TypeLivraison getById(Integer paramIdTypeLivraison) {
		String SQL = "SELECT id_type_livraison, libelle, description, url_image, tarification FROM type_livraison WHERE id_type_livraison = ?";
		return jdbcTemplate.queryForObject(SQL, new Object[]{paramIdTypeLivraison}, new TypeLivraisonMapper());
	}
	
}
