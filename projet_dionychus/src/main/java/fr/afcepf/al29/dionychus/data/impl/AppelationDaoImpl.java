package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.afcepf.al29.dionychus.data.itf.AppelationDaoItf;
import fr.afcepf.al29.dionychus.entity.Appelation;
import fr.afcepf.al29.dionychus.mapper.AppelationMapper;

/**
 * Classe d'accès aux données des {@link Appelation}.
 *
 * @author ecala
 *
 */
public class AppelationDaoImpl implements AppelationDaoItf {
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
    public List<Appelation> getAll() {
        String sql = "SELECT id_appelation, libelle FROM appelation ORDER BY libelle";
        List<Appelation> appelations = jdbcTemplate.query(sql, new AppelationMapper());
        return appelations;
    }

    @Override
    public List<Appelation> getAppelationByIdVin(int paramIdVin) {
        String sql = "SELECT a.id_appelation, a.libelle FROM appelation a INNER JOIN vin v "
                + "WHERE a.id_appelation = v.id_appelation AND v.id_vin = ?";
        List<Appelation> appelations = jdbcTemplate.query(sql, new Object[] {paramIdVin }, new AppelationMapper());
        return appelations;
    }

    @Override
    public Appelation getAppelationById(Integer appellationId) {
        String sql = "SELECT id_appelation, libelle FROM appelation WHERE id_appelation = ?";
        Appelation appellation = jdbcTemplate.queryForObject(sql, new Object[] {appellationId },
                new AppelationMapper());
        return appellation;
    }

}
