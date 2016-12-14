package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.afcepf.al29.dionychus.data.itf.CommandeClientDaoItf;
import fr.afcepf.al29.dionychus.entity.CommandeClient;
import fr.afcepf.al29.dionychus.mapper.CommandeClientMapper;

public class CommandeClientDaoImpl implements CommandeClientDaoItf {

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
	public List<CommandeClient> getAll() {
		String SQL = "SELECT cc.id_commande, cc.date_creation, cc.date_validation, cc.numero_reference, cc.id_acteur, cc.id_promotion, cc.id_statut_commande, sc.libelle FROM commande_client cc  INNER JOIN statut_commande sc WHERE cc.id_statut_commande = sc.id_statut_commande";
		return jdbcTemplate.query(SQL, new CommandeClientMapper());
	}

	@Override
	public List<CommandeClient> getCommandesByIdUtilisateur(Integer paramIdUtilisateur) {
		String SQL = "SELECT cc.id_commande, cc.date_creation, cc.date_validation, cc.numero_reference, cc.id_acteur, cc.id_promotion, cc.id_statut_commande, sc.libelle FROM commande_client cc INNER JOIN statut_commande sc WHERE cc.id_statut_commande = sc.id_statut_commande AND cc.id_acteur = ?";
		return jdbcTemplate.query(SQL, new Object[] { paramIdUtilisateur }, new CommandeClientMapper());
	}

	@Override
	public List<CommandeClient> getCommandesByIdStatutCommande(Integer paramIdStatutCommande) {
		String SQL = "SELECT cc.id_commande, cc.date_creation, cc.date_validation, cc.numero_reference, cc.id_acteur, cc.id_promotion, cc.id_statut_commande, sc.libelle FROM commande_client cc INNER JOIN statut_commande sc WHERE cc.id_statut_commande = sc.id_statut_commande AND cc.id_statut_commande = ?";
		return jdbcTemplate.query(SQL, new Object[] { paramIdStatutCommande }, new CommandeClientMapper());
	}

	@Override
	public void addCommandeClient(CommandeClient paramCommandeClient) {
		String SQL = "INSERT INTO `bdd_dionychus`.`commande_client` (`date_creation`, `id_promotion`, `date_validation`, `numero_reference`, `id_statut_commande`, `id_acteur`) VALUES (?,?,?,?,?,?)";
		jdbcTemplate.update(SQL, new Object[] { paramCommandeClient.getDateCreation(),
				paramCommandeClient.getPromotion().getIdPromotion(), paramCommandeClient.getDateValidation(),
				paramCommandeClient.getNumeroReference(), paramCommandeClient.getStatutCommande().getIdStatutCommande(),
				paramCommandeClient.getUtilisateur().getIdActeur() });
	}

	@Override
	public void updateCommandeClient(CommandeClient paramCommandeClient) {
		String SQL = "UPDATE `bdd_dionychus`.`commande_client` SET `date_creation`=?, `id_promotion`=?, `date_validation`=?, `numero_reference`=?, `id_statut_commande`=?, `id_acteur`=? WHERE `id_commande`=?";
		jdbcTemplate.update(SQL, new Object[]{ paramCommandeClient.getDateCreation(),
				paramCommandeClient.getPromotion().getIdPromotion(), paramCommandeClient.getDateValidation(),
				paramCommandeClient.getNumeroReference(), paramCommandeClient.getStatutCommande().getIdStatutCommande(),
				paramCommandeClient.getUtilisateur().getIdActeur(), paramCommandeClient.getIdCommande() });
	}

	@Override
	public void deleteCommandeClient(Integer paramIdCommandeClient) {
		String SQL = "DELETE FROM `bdd_dionychus`.`commande_client` WHERE id_commande = ?";
		jdbcTemplate.update(SQL, new Object[] {paramIdCommandeClient});

	}

}
