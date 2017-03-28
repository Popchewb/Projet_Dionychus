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

import fr.afcepf.al29.dionychus.data.itf.RegionDaoItf;
import fr.afcepf.al29.dionychus.entity.Region;
import fr.afcepf.al29.dionychus.mapper.RegionMapper;

/**
 * Classe pour l'accès aux données des {@link Region}.
 *
 * @author ecala
 *
 */
public class RegionDaoImpl implements RegionDaoItf {
    /**
     * le template jdbc.
     */
    private JdbcTemplate jdbcTemplate;
    /**
     * la datasource.
     */
    private DataSource dataSource;

    /**
     *
     * @return le template jdbc.
     */
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    /**
     *
     * @param paramJdbcTemplate
     *            le template jdbc to set.
     */
    public void setJdbcTemplate(JdbcTemplate paramJdbcTemplate) {
        jdbcTemplate = paramJdbcTemplate;
    }

    /**
     *
     * @return la datasource.
     */
    public DataSource getDataSource() {
        return dataSource;
    }

    /**
     *
     * @param paramDataSource
     *            la datasource to set.
     */
    public void setDataSource(DataSource paramDataSource) {
        dataSource = paramDataSource;
        jdbcTemplate = new JdbcTemplate(paramDataSource);
    }

    @Override
    public List<Region> getAll() {
        String sql = "SELECT id_region, libelle FROM region ORDER BY libelle";
        List<Region> regions = jdbcTemplate.query(sql, new RegionMapper());
        return regions;
    }

    @Override
    public Region getRegionById(Integer idRegion) {
        String sql = "SELECT id_region, libelle FROM region WHERE id_region = ? ORDER BY libelle";
        Region region = jdbcTemplate.queryForObject(sql, new Object[] {idRegion }, new RegionMapper());
        return region;
    }

    @Override
    public void addRegion(Region region) {
        String sql = "INSERT INTO region (libelle) VALUES (?)";
        jdbcTemplate.update(sql, region.getLibelle());
    }

    @Override
    public Region addRegionWithKey(Region region) {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        String sql = "INSERT INTO region (libelle) VALUES (?)";
        jdbcTemplate.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement statetement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                statetement.setString(1, region.getLibelle());
                return statetement;
            }
        }, holder);
        region.setIdRegion(holder.getKey().intValue());
        return region;
    }

}
