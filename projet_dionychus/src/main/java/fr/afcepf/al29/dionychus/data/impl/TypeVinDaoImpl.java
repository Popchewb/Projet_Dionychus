package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.afcepf.al29.dionychus.data.itf.TypeVinDaoItf;
import fr.afcepf.al29.dionychus.entity.TypeVin;
import fr.afcepf.al29.dionychus.mapper.TypeVinMapper;

/**
 * Classe pour l'accès aux données des {@link TypeVin}.
 *
 * @author ecala
 *
 */
public class TypeVinDaoImpl implements TypeVinDaoItf {
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
    public List<TypeVin> getAll() {
        String sql = "SELECT id_type_vin, libelle FROM type_vin ORDER BY libelle";
        List<TypeVin> typesVin = jdbcTemplate.query(sql, new TypeVinMapper());
        return typesVin;
    }

    @Override
    public TypeVin getTypeVinById(Integer typeVinId) {
        String sql = "SELECT id_type_vin, libelle FROM type_vin WHERE id_type_vin = ?";
        TypeVin typeVin = jdbcTemplate.queryForObject(sql, new Object[] {typeVinId }, new TypeVinMapper());
        return typeVin;
    }

}
