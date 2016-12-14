package fr.afcepf.al29.dionychus.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.afcepf.al29.dionychus.entity.TypeAcces;
import fr.afcepf.al29.dionychus.entity.Utilisateur;

public class UtilisateurMapper implements RowMapper<Utilisateur> {

	@Override
	public Utilisateur mapRow(ResultSet rs, int intRow) throws SQLException {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setIdActeur(rs.getInt("u.id_acteur"));
		utilisateur.setDateNaissance(rs.getDate("u.date_naissance"));
		utilisateur.setOptin(rs.getBoolean("u.optin"));
		utilisateur.setOrigine(rs.getString("u.origine"));
		utilisateur.setLogin(rs.getString("u.login"));
		utilisateur.setPassword(rs.getString("u.password"));
		utilisateur.setProfession(rs.getString("u.profession"));
		utilisateur.setAdresseMail(rs.getString("u.adresse_mail"));
		TypeAcces typeAcces = new TypeAcces();
		typeAcces.setIdTypeAcces(rs.getInt("u.id_type_acces"));
		typeAcces.setLibelle(rs.getString("ta.libelle"));
		utilisateur.setTypeAcces(typeAcces);
		utilisateur.setNom(rs.getString("u.nom"));
		utilisateur.setPrenom(rs.getString("u.prenom"));
		utilisateur.setNumeroTelephone(rs.getString("u.numero_telephone"));
		utilisateur.setAdresseMail(rs.getString("u.adresse_mail"));
		utilisateur.setCivilite(rs.getString("u.civilite"));
		return utilisateur;
	}

}
