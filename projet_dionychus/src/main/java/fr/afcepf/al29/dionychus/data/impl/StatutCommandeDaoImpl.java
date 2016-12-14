package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.afcepf.al29.dionychus.data.itf.StatutCommandeDaoItf;
import fr.afcepf.al29.dionychus.entity.StatutCommande;
import fr.afcepf.al29.dionychus.mapper.StatutCommandeMapper;

public class StatutCommandeDaoImpl implements StatutCommandeDaoItf {

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
	public List<StatutCommande> getAll() {
		String SQL = "SELECT id_statut_commande, libelle FROM statut_commande ORDER BY libelle";
		List<StatutCommande> statutsCommande = jdbcTemplate.query(SQL, new StatutCommandeMapper());
		return statutsCommande;
	}

	@Override
	public StatutCommande getById(int paramIdStatutCommande) {
		String SQL = "SELECT id_statut_commande, libelle FROM statut_commande WHERE id_statut_commande = ?";
		StatutCommande statutCommande = jdbcTemplate.queryForObject(SQL, new Object[] { paramIdStatutCommande },
				new StatutCommandeMapper());
		return statutCommande;
	}

}
