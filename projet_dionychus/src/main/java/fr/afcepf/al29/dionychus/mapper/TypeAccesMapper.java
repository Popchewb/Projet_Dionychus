package fr.afcepf.al29.dionychus.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.afcepf.al29.dionychus.entity.TypeAcces;

/**
 * Classe pour mapper un result set de type d'accès vers une entité
 * {@link TypeAcces}.
 *
 * @author ecala
 *
 */
public class TypeAccesMapper implements RowMapper<TypeAcces> {

    @Override
    public TypeAcces mapRow(ResultSet rs, int intRow) throws SQLException {
        TypeAcces typeAcces = new TypeAcces();
        typeAcces.setIdTypeAcces(rs.getInt("id_type_acces"));
        typeAcces.setLibelle(rs.getString("libelle"));
        return typeAcces;
    }

}
