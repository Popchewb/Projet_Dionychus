package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.afcepf.al29.dionychus.data.itf.TypeAccessoireDaoItf;
import fr.afcepf.al29.dionychus.entity.TypeAccessoire;
import fr.afcepf.al29.dionychus.mapper.TypeAccessoireMapper;

/**
 * Classe pour l'accès aux données des {@link TypeAccessoire}.
 *
 * @author ecala
 *
 */
public class TypeAccessoireDaoImpl implements TypeAccessoireDaoItf {
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
    public List<TypeAccessoire> getAll() {
        String sql = "SELECT id_type_accessoire, libelle FROM type_accessoire ORDER BY libelle";
        List<TypeAccessoire> typesAccessoire = jdbcTemplate.query(sql, new TypeAccessoireMapper());
        return typesAccessoire;
    }

    @Override
    public TypeAccessoire getById(Integer paramIdTypeAccessoire) {
        String sql = "SELECT id_type_accessoire, libelle FROM type_accessoire WHERE id_type_accessoire = ?";
        TypeAccessoire typeAccessoire = jdbcTemplate.queryForObject(sql, new Object[] {paramIdTypeAccessoire },
                new TypeAccessoireMapper());
        return typeAccessoire;
    }

}
