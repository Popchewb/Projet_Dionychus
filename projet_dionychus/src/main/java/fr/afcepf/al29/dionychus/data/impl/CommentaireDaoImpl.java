package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import fr.afcepf.al29.dionychus.data.itf.CommentaireDaoItf;
import fr.afcepf.al29.dionychus.entity.Commentaire;
import fr.afcepf.al29.dionychus.mapper.CommentaireMapper;

@Service
public class CommentaireDaoImpl implements CommentaireDaoItf {

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
	public List<Commentaire> getAllByVin(Integer paramIdVin) {
		String SQL = "SELECT c.id_commentaire, c.note, c.description, v.id_article, u.id_acteur FROM commentaire c INNER JOIN vin v INNER JOIN acteur u WHERE u.id_acteur = c.id_acteur AND v.id_article = c.id_article AND c.id_article = ?";
		return jdbcTemplate.query(SQL, new Object[] { paramIdVin }, new CommentaireMapper());
	}

	@Override
	public List<Commentaire> getAllByAccessoire(Integer paramIdAccessoire) {
		String SQL = "SELECT c.id_commentaire, c.note, c.description, a.id_article, u.id_acteur FROM commentaire c INNER JOIN accessoire a INNER JOIN acteur u WHERE u.id_acteur = c.id_acteur AND a.id_article = c.id_article AND c.id_article = ?";
		return jdbcTemplate.query(SQL, new Object[] { paramIdAccessoire }, new CommentaireMapper());
	}

	@Override
	public List<Commentaire> getAllCommentaireByUtilisateur(Integer paramIdUtilisateur) {
		String SQL = "SELECT c.id_commentaire, c.note, c.description, u.id_acteur FROM commentaire c INNER JOIN acteur u WHERE u.id_acteur = c.id_acteur AND c.id_acteur = ?";
		return jdbcTemplate.query(SQL, new Object[] { paramIdUtilisateur }, new CommentaireMapper());
	}

	@Override
	public void addCommentaire(Commentaire paramCommentaire, Integer paramIdArticle, Integer paramIdUtilisateur) {
		String SQL = "INSERT INTO `bdd_dionychus`.`commentaire` (`note`, `description`, `id_article`, `id_acteur`) VALUES (?,?,?,?)";
		jdbcTemplate.update(SQL, new Object[] { paramCommentaire.getNote(), paramCommentaire.getDescription(),
				paramIdArticle, paramIdUtilisateur });
	}

	@Override
	public void updateCommentaire(Commentaire paramCommentaire) {
		String SQL = "UPDATE `bdd_dionychus`.`commentaire` SET `note`=?, `description`=? WHERE `id_commentaire`=?";
		jdbcTemplate.update(SQL, new Object[] { paramCommentaire.getNote(), paramCommentaire.getDescription(),
				paramCommentaire.getIdCommentaire() });
	}

	@Override
	public void deleteCommentaire(Integer paramIdCommentaire) {
		String SQL = "DELETE FROM `bdd_dionychus`.`commentaire` WHERE `id_commentaire`=?";
		jdbcTemplate.update(SQL, new Object[] { paramIdCommentaire });
	}

}
