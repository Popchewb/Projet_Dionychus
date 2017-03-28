package fr.afcepf.al29.dionychus.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.afcepf.al29.dionychus.entity.Commentaire;
import fr.afcepf.al29.dionychus.entity.Utilisateur;

/**
 * Classe pour mapper un result set de commentaire vers une entité
 * {@link Commentaire}.
 *
 * @author ecala
 *
 */
public class CommentaireMapper implements RowMapper<Commentaire> {

    @Override
    public Commentaire mapRow(ResultSet rs, int intRow) throws SQLException {
        Commentaire commentaire = new Commentaire();
        commentaire.setIdCommentaire(rs.getInt("c.id_commentaire"));
        commentaire.setNote(rs.getDouble("c.note"));
        commentaire.setDescription(rs.getString("c.description"));
        commentaire.setDate(rs.getDate("c.date"));
        Utilisateur auteur = new Utilisateur();
        auteur.setIdActeur(rs.getInt("u.id_acteur"));
        auteur.setNom(rs.getString("u.nom"));
        auteur.setPrenom(rs.getString("u.prenom"));
        commentaire.setAuteur(auteur);
        return commentaire;
    }

}
