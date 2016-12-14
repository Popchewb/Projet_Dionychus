package fr.afcepf.al29.dionychus.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.afcepf.al29.dionychus.entity.Commentaire;

public class CommentaireMapper implements RowMapper<Commentaire> {

	@Override
	public Commentaire mapRow(ResultSet rs, int intRow) throws SQLException {
		Commentaire commentaire = new Commentaire();
		commentaire.setIdCommentaire(rs.getInt("c.id_commentaire"));
		commentaire.setNote(rs.getDouble("c.note"));
		commentaire.setDescription(rs.getString("c.description"));
		return commentaire;
	}

}
