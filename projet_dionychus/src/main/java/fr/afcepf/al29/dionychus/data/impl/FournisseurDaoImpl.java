package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.afcepf.al29.dionychus.data.itf.FournisseurDaoItf;
import fr.afcepf.al29.dionychus.entity.Fournisseur;
import fr.afcepf.al29.dionychus.mapper.FournisseurMapper;

public class FournisseurDaoImpl implements FournisseurDaoItf {

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
	public List<Fournisseur> getAll() {
		String SQL = "SELECT f.id_acteur, f.nom_domaine, f.nom, f.prenom, f.adresse_mail, f.numero_telephone, f.civilite FROM acteur f WHERE f.type_acteur = 'Fournisseur'";
		return jdbcTemplate.query(SQL, new FournisseurMapper());
	}

	@Override
	public Fournisseur getById(Integer paramIdFournisseur) {
		String SQL = "SELECT f.id_acteur, f.nom_domaine, f.nom, f.prenom, f.adresse_mail, f.numero_telephone, f.civilite FROM acteur f WHERE f.id_acteur = ? AND f.type_acteur = 'Fournisseur'";
		return jdbcTemplate.queryForObject(SQL, new Object[] { paramIdFournisseur }, new FournisseurMapper());
	}

	@Override
	public void addFournisseur(Fournisseur paramFournisseur) {
		String SQL = "INSERT INTO `bdd_dionychus`.`acteur` (`nom_domaine`, `nom`, `prenom`, `numero_telephone`, `adresse_mail`, `civilite`,`type_acces`) VALUES (?,?,?,?,?,?,'Fournisseur')";
		jdbcTemplate.update(SQL,
				new Object[] { paramFournisseur.getNomDomaine(), paramFournisseur.getNom(),
						paramFournisseur.getPrenom(), paramFournisseur.getNumeroTelephone(),
						paramFournisseur.getAdresseMail(), paramFournisseur.getCivilite() });
	}

	@Override
	public void updateFournisseur(Fournisseur paramFournisseur) {
		String SQL = "UPDATE `bdd_dionychus`.`acteur` SET `nom_domaine`=?, `nom`=?, `prenom`=?, `numero_telephone`=?, `adresse_mail`=?, `civilite`=? WHERE `id_acteur`=?";
		jdbcTemplate.update(SQL, new Object[] { paramFournisseur.getNomDomaine(), paramFournisseur.getNom(),
				paramFournisseur.getPrenom(), paramFournisseur.getNumeroTelephone(), paramFournisseur.getAdresseMail(),
				paramFournisseur.getCivilite(), paramFournisseur.getIdActeur() });

	}

	@Override
	public void deleteFournisseur(Integer paramIdFournisseur) {
		String SQL = "DELETE FROM `bdd_dionychus`.`acteur` WHERE id_acteur = ?";
		jdbcTemplate.update(SQL, new Object[] { paramIdFournisseur });

	}

}
