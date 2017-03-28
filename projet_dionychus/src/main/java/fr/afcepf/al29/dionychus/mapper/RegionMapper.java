package fr.afcepf.al29.dionychus.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.afcepf.al29.dionychus.entity.Region;

/**
 * Classe pour mapper un result set de région vers une entité {@link Region}.
 *
 * @author ecala
 *
 */
public class RegionMapper implements RowMapper<Region> {

    @Override
    public Region mapRow(ResultSet rs, int intRow) throws SQLException {
        Region region = new Region();
        region.setIdRegion(rs.getInt("id_region"));
        region.setLibelle(rs.getString("libelle"));
        return region;
    }

}
