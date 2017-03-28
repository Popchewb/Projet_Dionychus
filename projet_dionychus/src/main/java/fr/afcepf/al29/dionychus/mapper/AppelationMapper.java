package fr.afcepf.al29.dionychus.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.afcepf.al29.dionychus.entity.Appelation;
/**
 * Classe pour mapper un result set d'appellation vers une entité
 * {@link Appelation}.
 *
 * @author ecala
 *
 */
public class AppelationMapper implements RowMapper<Appelation> {

    @Override
    public Appelation mapRow(ResultSet rs, int intRow) throws SQLException {
        Appelation appelation = new Appelation();
        appelation.setIdAppelation(rs.getInt("id_appelation"));
        appelation.setLibelle(rs.getString("libelle"));
        return appelation;
    }

}
