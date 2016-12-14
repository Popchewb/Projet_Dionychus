package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.afcepf.al29.dionychus.data.itf.LivraisonDaoItf;
import fr.afcepf.al29.dionychus.entity.Livraison;
import fr.afcepf.al29.dionychus.mapper.LivraisonMapper;

public class LivraisonDaoImpl implements LivraisonDaoItf {
	
	JdbcTemplate JdbcTemplate;
	DataSource dataSource;
	
	

	public JdbcTemplate getJdbcTemplate() {
		return JdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		JdbcTemplate = jdbcTemplate;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.JdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Livraison> getAll() {
		String SQL = "SELECT l.id_livraison, l.tarification, l.id_type_livraison, tl.libelle FROM livraison l INNER JOIN type_livraison tl WHERE l.id_type_livraison = tl.id_type_livraison";
		return JdbcTemplate.query(SQL, new LivraisonMapper());
	}

	@Override
	public List<Livraison> getAllByIdUtilisateur(Integer paramIdUtilisateur) {
		String SQL = "SELECT l.id_livraison, l.tarification, l.id_type_livraison, tl.libelle FROM livraison l INNER JOIN type_livraison tl INNER JOIN commande_client cc INNER JOIN acteur a WHERE l.id_type_livraison = tl.id_type_livraison AND l.id_commande = cc.id_commande AND cc.id_acteur = a.id_acteur";
		return JdbcTemplate.query(SQL, new Object[]{paramIdUtilisateur}, new LivraisonMapper());
	}

	@Override
	public void addLivraison(Livraison paramLivraison) {
		String SQL = "INSERT INTO `bdd_dionychus`.`livraison` (`tarification`, `id_type_livraison`, `id_commande`) VALUES (?,?,?)";
		JdbcTemplate.update(SQL, new Object[]{paramLivraison.getTarification(), paramLivraison.getIdLivraison(), paramLivraison.getCommandeClient().getIdCommande()});
	}

	@Override
	public void updateLivraison(Livraison paramLivraison) {
		String SQL = "UPDATE `bdd_dionychus`.`livraison` SET `tarification`=?, `id_type_livraison`=?, `id_commande`=? WHERE `id_livraison`=?;";
		JdbcTemplate.update(SQL, new Object[]{paramLivraison.getTarification(), paramLivraison.getTypeLivraison().getIdTypeLivraison(), paramLivraison.getCommandeClient().getIdCommande(), paramLivraison.getIdLivraison()});
	}

	@Override
	public void deleteLivraison(Integer paramIdLivraison) {
		String SQL = "DELETE FROM `bdd_dionychus`.`livraison` WHERE id_livraison = ?";
		JdbcTemplate.update(SQL, new Object[]{paramIdLivraison});
		
	}

}
