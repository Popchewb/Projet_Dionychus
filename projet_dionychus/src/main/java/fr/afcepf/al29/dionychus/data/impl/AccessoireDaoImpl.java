package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.afcepf.al29.dionychus.data.itf.AccessoireDaoItf;
import fr.afcepf.al29.dionychus.entity.Accessoire;
import fr.afcepf.al29.dionychus.entity.Article;
import fr.afcepf.al29.dionychus.mapper.AccessoireMapper;
import fr.afcepf.al29.dionychus.mapper.ArticleMapper;

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
		String SQL = "SELECT a.id_article, a.id_type_accessoire, a.reference, a.libelle, a.description, a.prix, a.quantite, a.seuil_alerte, a.url_image,a.type_article, tac.libelle FROM article a INNER JOIN type_accessoire tac WHERE a.id_type_accessoire = tac.id_type_accessoire AND a.type_article = 'Accessoire' ORDER BY a.libelle";
		return jdbcTemplate.query(SQL, new AccessoireMapper());
	}

	@Override
	public Accessoire getById(Integer paramIdAccessoire) {
		String SQL = "SELECT a.id_article, a.id_type_accessoire, a.reference, a.libelle, a.description, a.prix, a.quantite, a.seuil_alerte, a.url_image,a.type_article, tac.libelle FROM article a INNER JOIN type_accessoire tac WHERE a.id_type_accessoire = tac.id_type_accessoire AND a.id_article = ? AND a.type_article = 'Accessoire'";
		return jdbcTemplate.queryForObject(SQL, new Object[] { paramIdAccessoire }, new AccessoireMapper());
	}

	@Override
	public void addAccessoire(Accessoire paramAccessoire, Integer paramIdFournisseur) {
		String SQL = "INSERT INTO `bdd_dionychus`.`article` (`reference`, `libelle`, `description`, `prix`, `quantite`, `seuil_alerte`, `url_image`, `id_type_accessoire`, `type_article`,`id_acteur`) VALUES (?,?,?,?,?,?,?,?,'Accessoire',?)";
		jdbcTemplate.update(SQL,
				new Object[] { paramAccessoire.getReference(), paramAccessoire.getLibelle(),
						paramAccessoire.getDescription(), paramAccessoire.getPrix(), paramAccessoire.getQuantite(),
						paramAccessoire.getSeuilAlerte(), paramAccessoire.getUrlImage(),
						paramAccessoire.getTypeAccessoire().getId_type_accessoire(),paramIdFournisseur });
	}

	@Override
	public void updateAccessoire(Accessoire paramAccessoire) {
		String SQL = "UPDATE `bdd_dionychus`.`article` SET `reference`=?, `libelle`=?, `description`=?, `prix`=?, `quantite`=?, `seuil_alerte`=?, `url_image`=?, `id_type_accessoire`=? WHERE `id_article`=?";
		jdbcTemplate.update(SQL,
				new Object[] { paramAccessoire.getReference(), paramAccessoire.getLibelle(),
						paramAccessoire.getDescription(), paramAccessoire.getPrix(), paramAccessoire.getQuantite(),
						paramAccessoire.getSeuilAlerte(), paramAccessoire.getUrlImage(),
						paramAccessoire.getTypeAccessoire().getId_type_accessoire(), paramAccessoire.getIdArticle() });
	}

	@Override
	public void deleteAccessoire(Integer paramIdAccessoire) {
		String SQL = "DELETE FROM `bdd_dionychus`.`article` WHERE id_article = ?";
		jdbcTemplate.update(SQL, new Object[]{paramIdAccessoire});

	}

	@Override
	public List<Article> getBestSellerAccessoire() {
		String SQL = "SELECT a.id_article, a.url_image, a.prix, a.libelle, a.type_article FROM bdd_dionychus.article a INNER JOIN bdd_dionychus.ligne_commande lc ON a.id_article = lc.id_article WHERE a.type_article = 'Accessoire' GROUP BY a.id_article ORDER BY sum(lc.quantite) DESC LIMIT 4;";
		return jdbcTemplate.query(SQL, new ArticleMapper());
	}

}
