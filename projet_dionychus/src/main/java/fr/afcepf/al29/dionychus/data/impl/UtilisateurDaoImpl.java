package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.afcepf.al29.dionychus.data.itf.UtilisateurDaoItf;
import fr.afcepf.al29.dionychus.entity.Utilisateur;
import fr.afcepf.al29.dionychus.mapper.UtilisateurMapper;

public class UtilisateurDaoImpl implements UtilisateurDaoItf {

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
	public List<Utilisateur> getAll() {
		String SQL = "SELECT u.id_acteur, u.date_naissance, u.optin, u.origine, u.login, u.password, u.id_type_acces, u.nom, u.prenom, u.numero_telephone, u.adresse_mail, u.civilite, u.profession, ta.libelle FROM acteur u INNER JOIN type_acces ta WHERE u.id_type_acces = ta.id_type_acces AND u.type_acteur = 'Utilisateur' ORDER BY u.nom";
		return jdbcTemplate.query(SQL, new UtilisateurMapper());
	}

	@Override
	public Utilisateur getById(int paramIdUtilisateur) {
		String SQL = "SELECT u.id_acteur, u.date_naissance, u.optin, u.origine, u.login, u.password, u.id_type_acces, u.nom, u.prenom, u.numero_telephone, u.adresse_mail, u.civilite, u.profession, ta.libelle FROM acteur u INNER JOIN type_acces ta WHERE u.id_type_acces = ta.id_type_acces AND u.id_acteur = ? AND u.type_acteur = 'Utilisateur' ORDER BY u.nom";
		return jdbcTemplate.queryForObject(SQL, new Object[] { paramIdUtilisateur }, new UtilisateurMapper());
	}

	@Override
	public void addUtilisateur(Utilisateur paramUtilisateur) {
		String SQL = "INSERT INTO `bdd_dionychus`.`acteur`(`date_naissance`,`optin`,`login`,`password`,`id_type_acces`,`nom`,`prenom`,`numero_telephone`,`adresse_mail`,`origine`,`civilite`,`type_acteur`) VALUES (?,?,?,?,?,?,?,?,?,?,?,'Utilisateur')";
		jdbcTemplate.update(SQL, new Object[] { paramUtilisateur.getDateNaissance(), paramUtilisateur.getOptin(),
				paramUtilisateur.getLogin(), paramUtilisateur.getPassword(),
				paramUtilisateur.getTypeAcces().getIdTypeAcces(), paramUtilisateur.getNom(),
				paramUtilisateur.getPrenom(), paramUtilisateur.getNumeroTelephone(), paramUtilisateur.getAdresseMail(),
				paramUtilisateur.getOrigine(), paramUtilisateur.getCivilite() });

	}

	@Override
	public void updateUtilisateur(Utilisateur paramUtilisateur) {
		String SQL = "UPDATE `bdd_dionychus`.`acteur` SET `date_naissance`= ?,`optin`=?, `origine`=?, `login`=?, `password`=?, `id_type_acces`=?, `nom`=?, `prenom`=?, `numero_telephone`=?, `adresse_mail`=?, `civilite`=?, `profession`=? WHERE `id_acteur`=?";
		jdbcTemplate.update(SQL, new Object[] { paramUtilisateur.getDateNaissance(), paramUtilisateur.getOptin(),
				paramUtilisateur.getOrigine(), paramUtilisateur.getLogin(), paramUtilisateur.getPassword(),
				paramUtilisateur.getTypeAcces().getIdTypeAcces(), paramUtilisateur.getNom(),
				paramUtilisateur.getPrenom(), paramUtilisateur.getNumeroTelephone(), paramUtilisateur.getAdresseMail(),
				paramUtilisateur.getCivilite(),paramUtilisateur.getProfession(), paramUtilisateur.getIdActeur() });

	}

	@Override
	public void deleteUtilisateur(Integer paramIdUtilisateur) {
		String SQL = "DELETE FROM `bdd_dionychus`.`acteur` WHERE id_acteur = ?";
		jdbcTemplate.update(SQL, new Object[] { paramIdUtilisateur });

	}

}
