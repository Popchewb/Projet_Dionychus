package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.afcepf.al29.dionychus.data.itf.CommandeStockDaoItf;
import fr.afcepf.al29.dionychus.entity.CommandeStock;
import fr.afcepf.al29.dionychus.mapper.CommandeStockMapper;

public class CommandeStockDaoImpl implements CommandeStockDaoItf {

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
	public List<CommandeStock> getAll() {
		String SQL = "SELECT cs.id_commande, cs.date_validation, cs.date_reception, cs.numero_reference, cs.id_acteur, cs.id_statut_commande, sc.libelle FROM commande_stock cs INNER JOIN statut_commande sc WHERE cs.id_statut_commande = sc.id_statut_commande";
		return jdbcTemplate.query(SQL, new CommandeStockMapper());
	}

	@Override
	public List<CommandeStock> getCommandesByIdUtilisateur(Integer paramIdUtilisateur) {
		String SQL = "SELECT cs.id_commande, cs.date_validation, cs.date_reception, cs.numero_reference, cs.id_acteur, cs.id_statut_commande, sc.libelle FROM commande_stock cs INNER JOIN statut_commande sc WHERE cs.id_statut_commande = sc.id_statut_commande AND cs.id_acteur = ?";
		return jdbcTemplate.query(SQL, new Object[]{paramIdUtilisateur}, new CommandeStockMapper());
	}

	@Override
	public List<CommandeStock> getCommandesByIdStatutCommande(Integer paramIdStatutCommande) {
		String SQL = "SELECT cs.id_commande, cs.date_validation, cs.date_reception, cs.numero_reference, cs.id_acteur, cs.id_statut_commande, sc.libelle FROM commande_stock cs INNER JOIN statut_commande sc WHERE cs.id_statut_commande = sc.id_statut_commande AND cs.id_statut_commande = ?";
		return jdbcTemplate.query(SQL, new Object[]{paramIdStatutCommande}, new CommandeStockMapper());
	}

	@Override
	public void addCommandeStock(CommandeStock paramCommandeStock) {
		String SQL = "INSERT INTO `bdd_dionychus`.`commande_stock` (`date_reception`, `date_validation`, `numero_reference`, `id_statut_commande`, `id_acteur`) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(SQL, new Object[]{paramCommandeStock.getDateReception(),paramCommandeStock.getDateValidation(),paramCommandeStock.getNumeroReference(),paramCommandeStock.getIdCommande(),paramCommandeStock.getFournisseur().getIdActeur()});
	}

	@Override
	public void updateCommandeStock(CommandeStock paramCommandeStock) {
		String SQL ="UPDATE `bdd_dionychus`.`commande_stock` SET `date_reception`=?, `date_validation`=?, `numero_reference`=?, `id_statut_commande`=?, `id_acteur`=? WHERE `id_commande`=?";
		jdbcTemplate.update(SQL, new Object[]{paramCommandeStock.getDateReception(),paramCommandeStock.getDateValidation(),paramCommandeStock.getNumeroReference(),paramCommandeStock.getIdCommande(),paramCommandeStock.getFournisseur().getIdActeur(),paramCommandeStock.getIdCommande()});
		
	}

	@Override
	public void deleteCommandeStock(Integer paramIdCommandeStock) {
		String SQL = "DELETE FROM `bdd_dionychus`.`commande_client` WHERE id_commande = ?";
		jdbcTemplate.update(SQL, new Object[] {paramIdCommandeStock});
		
	}

}
