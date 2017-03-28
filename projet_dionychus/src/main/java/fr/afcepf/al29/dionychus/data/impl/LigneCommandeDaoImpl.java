package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.afcepf.al29.dionychus.data.itf.LigneCommandeDaoItf;
import fr.afcepf.al29.dionychus.entity.LigneCommande;
import fr.afcepf.al29.dionychus.mapper.LigneCommandeMapper;
/**
 * Classe pour l'accès aux données des {@link LigneCommande}.
 * @author ecala
 *
 */
public class LigneCommandeDaoImpl implements LigneCommandeDaoItf {
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
    public List<LigneCommande> getAllByIdCommande(Integer paramIdCommande) {
        String sql = "SELECT lc.id_ligne_commande, lc.quantite, lc.id_article, a.type_article "
                + "FROM ligne_commande lc INNER JOIN article a "
                + "WHERE lc.id_article = a.id_article AND lc.id_commande = ?";
        return jdbcTemplate.query(sql, new Object[] {paramIdCommande }, new LigneCommandeMapper());
    }

    @Override
    public void addLigneCommande(LigneCommande paramLigneCommande, Integer paramIdCommande) {
        String sql = "INSERT INTO `bdd_dionychus`.`ligne_commande` (`quantite`, `id_article`, `id_commande`,`type_article`) VALUES (?,?,?,?);";
        jdbcTemplate.update(sql,
                new Object[] {paramLigneCommande.getQuantite(), paramLigneCommande.getArticle().getIdArticle(),
                        paramIdCommande, paramLigneCommande.getArticle().getTypeArticle() });
    }

    @Override
    public void updateLigneCommande(LigneCommande paramLigneCommande) {
        String sql = "UPDATE `bdd_dionychus`.`ligne_commande` SET `quantite`=? WHERE `id_ligne_commande`=?";
        jdbcTemplate.update(sql,
                new Object[] {paramLigneCommande.getQuantite(), paramLigneCommande.getIdLigneCommande() });
    }

    @Override
    public void deleteLigneCommande(Integer paramIdLigneCommande) {
        String sql = "DELETE FROM `bdd_dionychus`.`ligne_commande` WHERE id_ligne_commande = ?";
        jdbcTemplate.update(sql, new Object[] {paramIdLigneCommande });

    }

}
