package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.afcepf.al29.dionychus.data.itf.CepageDaoItf;
import fr.afcepf.al29.dionychus.entity.Cepage;
import fr.afcepf.al29.dionychus.mapper.CepageMapper;
/**
 * Classe pour les accès aux données des {@link Cepage}.
 * @author ecala
 *
 */
public class CepageDaoImpl implements CepageDaoItf {
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
    public List<Cepage> getAll() {
        String sql = "SELECT id_cepage, libelle FROM cepage ORDER BY libelle";
        List<Cepage> cepages = jdbcTemplate.query(sql, new CepageMapper());
        return cepages;
    }

    @Override
    public List<Cepage> getCepageByIdVin(int paramIdVin) {
        String sql = "SELECT c.id_cepage, c.libelle FROM cepage c INNER JOIN vin_cepage vc "
                + "WHERE vc.id_cepage = c.id_cepage AND vc.id_article = ? ORDER BY libelle";
        List<Cepage> cepages = jdbcTemplate.query(sql, new CepageMapper(), paramIdVin);
        return cepages;
    }

    @Override
    public Cepage getCepageById(int paramCepageId) {
        String sql = "SELECT id_cepage, libelle FROM cepage WHERE id_cepage = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {paramCepageId }, new CepageMapper());
    }

}