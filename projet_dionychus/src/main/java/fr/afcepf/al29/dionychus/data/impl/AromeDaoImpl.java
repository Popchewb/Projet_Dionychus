package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.afcepf.al29.dionychus.data.itf.AromeDaoItf;
import fr.afcepf.al29.dionychus.entity.Arome;
import fr.afcepf.al29.dionychus.mapper.AromeMapper;
/**
 * Interface pour les méthodes d'accès aux données des {@link Arome}.
 * @author ecala
 *
 */
public class AromeDaoImpl implements AromeDaoItf {
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
    public List<Arome> getAll() {
        String sql = "SELECT id_arome,libelle FROM arome ORDER BY libelle";
        List<Arome> aromes = jdbcTemplate.query(sql, new AromeMapper());
        return aromes;
    }

    @Override
    public List<Arome> getAromeByIdVin(int paramIdVin) {
        String sql = "SELECT a.id_arome, a.libelle FROM arome a INNER JOIN vin_arome va WHERE a.id_arome = va.id_arome AND va.id_article = ?";
        return jdbcTemplate.query(sql, new Object[] {paramIdVin }, new AromeMapper());
    }

    @Override
    public Arome getAromeById(int paramAromeId) {
        String sql = "SELECT id_arome, libelle FROM arome WHERE id_arome = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {paramAromeId }, new AromeMapper());
    }

}
