package fr.afcepf.al29.dionychus.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.afcepf.al29.dionychus.entity.Fournisseur;

/**
 * Classe pour mapper un result set de fournisseur vers une entité
 * {@link Fournisseur}.
 *
 * @author ecala
 *
 */
public class FournisseurMapper implements RowMapper<Fournisseur> {

    @Override
    public Fournisseur mapRow(ResultSet rs, int intRow) throws SQLException {
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setIdActeur(rs.getInt("f.id_acteur"));
        fournisseur.setNomDomaine(rs.getString("f.nom_domaine"));
        fournisseur.setNom(rs.getString("f.nom"));
        fournisseur.setPrenom(rs.getString("f.prenom"));
        fournisseur.setNumeroTelephone(rs.getString("f.numero_telephone"));
        fournisseur.setAdresseMail(rs.getString("f.adresse_mail"));
        fournisseur.setCivilite(rs.getString("f.civilite"));
        return fournisseur;
    }

}
