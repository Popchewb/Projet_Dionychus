package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.afcepf.al29.dionychus.data.itf.VilleDaoItf;
import fr.afcepf.al29.dionychus.entity.Ville;
import fr.afcepf.al29.dionychus.mapper.VilleMapper;

/**
 * Classe pour l'accès aux données des {@link Ville}.
 *
 * @author ecala
 *
 */
public class VilleDaoImpl implements VilleDaoItf {

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
    public List<Ville> getAll() {
        String sql = "SELECT v.id_ville, v.libelle, v.code_postal, v.id_pays, p.libelle FROM ville v INNER JOIN pays p WHERE v.id_pays = p.id_pays";
        return jdbcTemplate.query(sql, new VilleMapper());
    }

    @Override
    public List<Ville> getAllByIdPays(Integer paramIdPays) {
        String sql = "SELECT v.id_ville, v.libelle, v.code_postal, v.id_pays, p.libelle "
                + "FROM ville v INNER JOIN pays p WHERE v.id_pays = p.id_pays AND v.id_pays = ?";
        return jdbcTemplate.query(sql, new Object[] {paramIdPays }, new VilleMapper());
    }

    @Override
    public Ville getVilleById(Integer paramIdVille) {
        String sql = "SELECT v.id_ville, v.libelle, v.code_postal, v.id_pays, p.libelle "
                + "FROM ville v INNER JOIN pays p WHERE v.id_pays = p.id_pays AND v.id_ville = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {paramIdVille }, new VilleMapper());
    }

}
