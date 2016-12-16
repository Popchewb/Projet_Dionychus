package fr.afcepf.al29.dionychus.data.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import com.mysql.jdbc.Statement;

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
	public List<Utilisateur> getAllUtilisateur() {
		String SQL = "SELECT u.id_acteur, u.date_naissance, u.optin, u.origine, u.login, u.password, u.id_type_acces, u.nom, u.prenom, u.numero_telephone, u.adresse_mail, u.civilite, u.profession, ta.libelle FROM acteur u INNER JOIN type_acces ta WHERE u.id_type_acces = ta.id_type_acces AND u.type_acteur = 'Utilisateur' ORDER BY u.nom";
		return jdbcTemplate.query(SQL, new UtilisateurMapper());
	}

	@Override
	public Utilisateur getUserByEmail() {
		String SQL = "SELECT a.id_acteur, a.nom, a.prenom, a.numero_telephone, a.adresse_mail, a.date_naissance, a.optin, a.origine, a.login, a.password, a.id_type_acces, a.civilite, a.profession, a.type_acteur, ta.libelle FROM acteur a INNER JOIN type_acces ta WHERE ta.id_type_acces = a.id_type_acces AND a.adresse_mail = ?";
		return jdbcTemplate.queryForObject(SQL, new UtilisateurMapper());
	}

	@Override
	public Utilisateur getUtilisateurById(int paramIdUtilisateur) {
		String SQL = "SELECT u.id_acteur, u.date_naissance, u.optin, u.origine, u.login, u.password, u.id_type_acces, u.nom, u.prenom, u.numero_telephone, u.adresse_mail, u.civilite, u.profession, ta.libelle FROM acteur u INNER JOIN type_acces ta WHERE u.id_type_acces = ta.id_type_acces AND u.id_acteur = ? AND u.type_acteur = 'Utilisateur' ORDER BY u.nom";
		return jdbcTemplate.queryForObject(SQL, new Object[] { paramIdUtilisateur }, new UtilisateurMapper());
	}

	@Override
	public Utilisateur addUtilisateur(Utilisateur paramUtilisateur) {
		GeneratedKeyHolder holder = new GeneratedKeyHolder();
		String SQL = "INSERT INTO `bdd_dionychus`.`acteur`(`date_naissance`,`optin`,`login`,`password`,`id_type_acces`,`nom`,`prenom`,`numero_telephone`,`adresse_mail`,`origine`,`civilite`, `profession`, `type_acteur`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,'Utilisateur')";
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement statement = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
				statement.setDate(1, paramUtilisateur.getDateNaissance());
				statement.setBoolean(2, paramUtilisateur.getOptin());
				statement.setString(3, paramUtilisateur.getLogin());
				statement.setString(4, paramUtilisateur.getPassword());
				statement.setInt(5, paramUtilisateur.getTypeAcces().getIdTypeAcces());
				statement.setString(6, paramUtilisateur.getNom());
				statement.setString(7, paramUtilisateur.getPrenom());
				statement.setString(8, paramUtilisateur.getNumeroTelephone());
				statement.setString(9, paramUtilisateur.getAdresseMail());
				statement.setString(10, paramUtilisateur.getOrigine());
				statement.setString(11, paramUtilisateur.getCivilite());
				statement.setString(12, paramUtilisateur.getProfession());
				return statement;
			}
		}, holder);
		paramUtilisateur.setIdActeur(holder.getKey().intValue());
		return paramUtilisateur;
	}

	@Override
	public void updateUtilisateur(Utilisateur paramUtilisateur) {
		String SQL = "UPDATE `bdd_dionychus`.`acteur` SET `date_naissance`= ?,`optin`=?, `origine`=?, `login`=?, `password`=?, `id_type_acces`=?, `nom`=?, `prenom`=?, `numero_telephone`=?, `adresse_mail`=?, `civilite`=?, `profession`=? WHERE `id_acteur`=?";
		jdbcTemplate.update(SQL, new Object[] { paramUtilisateur.getDateNaissance(), paramUtilisateur.getOptin(),
				paramUtilisateur.getOrigine(), paramUtilisateur.getLogin(), paramUtilisateur.getPassword(),
				paramUtilisateur.getTypeAcces().getIdTypeAcces(), paramUtilisateur.getNom(),
				paramUtilisateur.getPrenom(), paramUtilisateur.getNumeroTelephone(), paramUtilisateur.getAdresseMail(),
				paramUtilisateur.getCivilite(), paramUtilisateur.getProfession(), paramUtilisateur.getIdActeur() });
	}

	@Override
	public void deleteUtilisateur(Integer paramIdUtilisateur) {
		String SQL = "DELETE FROM `bdd_dionychus`.`acteur` WHERE id_acteur = ?";
		jdbcTemplate.update(SQL, new Object[] { paramIdUtilisateur });
	}

}
