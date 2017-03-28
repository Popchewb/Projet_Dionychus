package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.afcepf.al29.dionychus.data.itf.AccessoireDaoItf;
import fr.afcepf.al29.dionychus.entity.Accessoire;
import fr.afcepf.al29.dionychus.entity.Article;
import fr.afcepf.al29.dionychus.mapper.AccessoireMapper;
import fr.afcepf.al29.dionychus.mapper.ArticleMapper;

/**
 * Classe d'accès aux données des {@link Accessoire}.
 *
 * @author ecala
 *
 */
public class AccessoireDaoImpl implements AccessoireDaoItf {
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
    public List<Accessoire> getAll() {
        String sql = "SELECT a.id_article, a.id_type_accessoire, a.reference, a.libelle, a.description, a.prix,"
                + " a.quantite, a.seuil_alerte, a.url_image,a.type_article, tac.libelle " + "FROM article a "
                + "INNER JOIN type_accessoire tac " + "WHERE a.id_type_accessoire = tac.id_type_accessoire "
                + "AND a.type_article = 'Accessoire' ORDER BY a.libelle";
        return jdbcTemplate.query(sql, new AccessoireMapper());
    }

    @Override
    public Accessoire getById(Integer paramIdAccessoire) {
        String sql = "SELECT a.id_article, a.id_type_accessoire, a.reference, a.libelle, a.description,"
                + " a.prix, a.quantite, a.seuil_alerte, a.url_image,a.type_article, tac.libelle "
                + "FROM article a INNER JOIN type_accessoire tac "
                + "WHERE a.id_type_accessoire = tac.id_type_accessoire AND a.id_article = ? "
                + "AND a.type_article = 'Accessoire'";
        return jdbcTemplate.queryForObject(sql, new Object[] {paramIdAccessoire }, new AccessoireMapper());
    }

    @Override
    public void addAccessoire(Accessoire paramAccessoire, Integer paramIdFournisseur) {
        String sql = "INSERT INTO `bdd_dionychus`.`article` "
                + "(`reference`, `libelle`, `description`, `prix`, `quantite`,"
                + " `seuil_alerte`, `url_image`, `id_type_accessoire`, `type_article`,`id_acteur`) "
                + "VALUES (?,?,?,?,?,?,?,?,'Accessoire',?)";
        jdbcTemplate.update(sql,
                new Object[] {paramAccessoire.getReference(), paramAccessoire.getLibelle(),
                        paramAccessoire.getDescription(), paramAccessoire.getPrix(), paramAccessoire.getQuantite(),
                        paramAccessoire.getSeuilAlerte(), paramAccessoire.getUrlImage(),
                        paramAccessoire.getTypeAccessoire().getIdTypeAccessoire(), paramIdFournisseur });
    }

    @Override
    public void updateAccessoire(Accessoire paramAccessoire) {
        String sql = "UPDATE `bdd_dionychus`.`article` "
                + "SET `reference`=?, `libelle`=?, `description`=?, `prix`=?, `quantite`=?,"
                + " `seuil_alerte`=?, `url_image`=?, `id_type_accessoire`=? "
                + "WHERE `id_article`=?";
        jdbcTemplate.update(sql,
                new Object[] {paramAccessoire.getReference(), paramAccessoire.getLibelle(),
                        paramAccessoire.getDescription(), paramAccessoire.getPrix(), paramAccessoire.getQuantite(),
                        paramAccessoire.getSeuilAlerte(), paramAccessoire.getUrlImage(),
                        paramAccessoire.getTypeAccessoire().getIdTypeAccessoire(), paramAccessoire.getIdArticle() });
    }

    @Override
    public void deleteAccessoire(Integer paramIdAccessoire) {
        String sql = "DELETE FROM `bdd_dionychus`.`article` WHERE id_article = ?";
        jdbcTemplate.update(sql, new Object[] {paramIdAccessoire });

    }

    @Override
    public List<Article> getBestSellerAccessoire() {
        String sql = "SELECT a.id_article, a.url_image, a.prix, a.libelle, a.type_article "
                + "FROM bdd_dionychus.article a "
                + "INNER JOIN bdd_dionychus.ligne_commande lc ON a.id_article = lc.id_article "
                + "INNER JOIN bdd_dionychus.commande c "
                + "ON c.id_commande = lc.id_commande "
                + "WHERE a.type_article = 'Accessoire' "
                + "AND c.id_statut_commande <> 1 GROUP BY a.id_article "
                + "ORDER BY sum(lc.quantite) DESC LIMIT 4;";
        return jdbcTemplate.query(sql, new ArticleMapper());
    }

}
