package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.afcepf.al29.dionychus.data.itf.TypeLivraisonDaoItf;
import fr.afcepf.al29.dionychus.entity.TypeLivraison;
import fr.afcepf.al29.dionychus.mapper.TypeLivraisonMapper;

/**
 * Classe pour l'accès aux données des {@link TypeLivraison}.
 *
 * @author ecala
 *
 */
public class TypeLivraisonDaoImpl implements TypeLivraisonDaoItf {
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
    public List<TypeLivraison> getAll() {
        String sql = "SELECT id_type_livraison, libelle, description, url_image, tarification FROM type_livraison ORDER BY id_type_livraison";
        List<TypeLivraison> typesLivraison = jdbcTemplate.query(sql, new TypeLivraisonMapper());
        return typesLivraison;
    }

    @Override
    public TypeLivraison getById(Integer paramIdTypeLivraison) {
        String sql = "SELECT id_type_livraison, libelle, description, url_image, tarification FROM type_livraison WHERE id_type_livraison = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {paramIdTypeLivraison }, new TypeLivraisonMapper());
    }

}
