package fr.afcepf.al29.dionychus.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.afcepf.al29.dionychus.entity.Cepage;

/**
 * Classe pour mapper un result set de cepage vers une entité {@link Cepage}.
 *
 * @author ecala
 *
 */
public class CepageMapper implements RowMapper<Cepage> {

    @Override
    public Cepage mapRow(ResultSet rs, int intRow) throws SQLException {
        Cepage cepage = new Cepage();
        cepage.setIdCepage(rs.getInt("id_cepage"));
        cepage.setLibelle(rs.getString("libelle"));
        return cepage;
    }

}
