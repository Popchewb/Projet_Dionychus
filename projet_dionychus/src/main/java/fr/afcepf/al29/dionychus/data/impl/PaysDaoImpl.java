package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.afcepf.al29.dionychus.data.itf.PaysDaoItf;
import fr.afcepf.al29.dionychus.entity.Pays;
import fr.afcepf.al29.dionychus.mapper.PaysMapper;
/**
 * Classe pour l'accès aux données des {@link Pays}.
 * @author ecala
 *
 */
public class PaysDaoImpl implements PaysDaoItf {
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
    public List<Pays> getAllPays() {
        String sql = "SELECT id_pays, libelle FROM pays ORDER BY libelle";
        return jdbcTemplate.query(sql, new PaysMapper());
    }

    @Override
    public Pays getPaysByIdVille(Integer paramIdVille) {
        String sql = "SELECT p.id_pays, p.libelle FROM pays p INNER JOIN ville v WHERE p.id_ville = v.id_ville AND v.id_ville = ?";
        Pays pays = jdbcTemplate.queryForObject(sql, new Object[] {paramIdVille }, new PaysMapper());
        return pays;
    }

}
