package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.afcepf.al29.dionychus.data.itf.LigneCommandeDaoItf;
import fr.afcepf.al29.dionychus.entity.LigneCommande;
import fr.afcepf.al29.dionychus.mapper.LigneCommandeMapper;

public class LigneCommandeDaoImpl implements LigneCommandeDaoItf{

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
	public List<LigneCommande> getAllByIdCommande(Integer paramIdCommande) {
		String SQL = "SELECT lc.id_ligne_commande, lc.quantite, lc.id_article, a.type_article FROM ligne_commande lc INNER JOIN article a WHERE lc.id_article = a.id_article AND lc.id_commande = ?";
		return jdbcTemplate.query(SQL, new Object[]{paramIdCommande}, new LigneCommandeMapper());
	}

	@Override
	public void addLigneCommande(LigneCommande paramLigneCommande, Integer paramIdCommande) {
		String SQL = "INSERT INTO `bdd_dionychus`.`ligne_commande` (`quantite`, `id_article`, `id_commande`) VALUES (?,?,?);";
		jdbcTemplate.update(SQL, new Object[]{paramLigneCommande.getQuantite(),paramLigneCommande.getArticle().getIdArticle(),paramIdCommande});
	}

	@Override
	public void updateLigneCommande(LigneCommande paramLigneCommande) {
		String SQL = "UPDATE `bdd_dionychus`.`ligne_commande` SET `quantite`=? WHERE `id_ligne_commande`=?";
		jdbcTemplate.update(SQL, new Object[]{paramLigneCommande.getQuantite(),paramLigneCommande.getIdLigneCommande()});
	}

	@Override
	public void deleteLigneCommande(Integer paramIdLigneCommande) {
		String SQL = "DELETE FROM `bdd_dionychus`.`ligne_commande` WHERE id_ligne_commande = ?";
		jdbcTemplate.update(SQL, new Object[]{paramIdLigneCommande});
		
	}

}
