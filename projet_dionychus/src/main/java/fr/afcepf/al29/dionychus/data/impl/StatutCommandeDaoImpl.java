package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.afcepf.al29.dionychus.data.itf.StatutCommandeDaoItf;
import fr.afcepf.al29.dionychus.entity.StatutCommande;
import fr.afcepf.al29.dionychus.mapper.StatutCommandeMapper;

/**
 * Classe pour l'accès aux données des {@link StatutCommande}.
 *
 * @author ecala
 *
 */
public class StatutCommandeDaoImpl implements StatutCommandeDaoItf {
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
    public List<StatutCommande> getAll() {
        String sql = "SELECT id_statut_commande, libelle FROM statut_commande ORDER BY libelle";
        List<StatutCommande> statutsCommande = jdbcTemplate.query(sql, new StatutCommandeMapper());
        return statutsCommande;
    }

    @Override
    public StatutCommande getById(int paramIdStatutCommande) {
        String sql = "SELECT id_statut_commande, libelle FROM statut_commande WHERE id_statut_commande = ?";
        StatutCommande statutCommande = jdbcTemplate.queryForObject(sql, new Object[] {paramIdStatutCommande },
                new StatutCommandeMapper());
        return statutCommande;
    }

}
