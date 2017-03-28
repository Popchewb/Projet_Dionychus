package fr.afcepf.al29.dionychus.data.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import com.mysql.jdbc.Statement;

import fr.afcepf.al29.dionychus.data.itf.VinDaoItf;
import fr.afcepf.al29.dionychus.entity.Arome;
import fr.afcepf.al29.dionychus.entity.Article;
import fr.afcepf.al29.dionychus.entity.Cepage;
import fr.afcepf.al29.dionychus.entity.Vin;
import fr.afcepf.al29.dionychus.mapper.ArticleMapper;
import fr.afcepf.al29.dionychus.mapper.VinMapper;

/**
 * Classe pour l'accès aux données des {@link Vin}.
 */
public class VinDaoImpl implements VinDaoItf {
    /**
     * Indice du premier paramètre de la requête SQL.
     */
    private static final int INDEX_PREMIER_PARAMETRE = 1;
    /**
     * Indice du second paramètre de la requête SQL.
     */
    private static final int INDEX_SECOND_PARAMETRE = 2;
    /**
     * Indice du troisième paramètre de la requête SQL.
     */
    private static final int INDEX_TROISIEME_PARAMETRE = 3;
    /**
     * Indice du quatrième paramètre de la requête SQL.
     */
    private static final int INDEX_QUATRIEME_PARAMETRE = 4;
    /**
     * Indice du cinquième paramètre de la requête SQL.
     */
    private static final int INDEX_CINQUIEME_PARAMETRE = 5;
    /**
     * Indice du sixième paramètre de la requête SQL.
     */
    private static final int INDEX_SIXIEME_PARAMETRE = 6;
    /**
     * Indice du premier paramètre de la requête SQL.
     */
    private static final int INDEX_SEPTIEME_PARAMETRE = 7;
    /**
     * Indice du second paramètre de la requête SQL.
     */
    private static final int INDEX_HUITIEME_PARAMETRE = 8;
    /**
     * Indice du troisième paramètre de la requête SQL.
     */
    private static final int INDEX_NEUVIEME_PARAMETRE = 9;
    /**
     * Indice du quatrième paramètre de la requête SQL.
     */
    private static final int INDEX_DIXIEME_PARAMETRE = 10;
    /**
     * Indice du cinquième paramètre de la requête SQL.
     */
    private static final int INDEX_ONZIEME_PARAMETRE = 11;
    /**
     * Indice du sixième paramètre de la requête SQL.
     */
    private static final int INDEX_DOUZIEME_PARAMETRE = 12;
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
    public List<Vin> getAll() {
        String sql = "SELECT a.id_article, a.reference, a.libelle, a.description, a.prix, a.annee, a.quantite, "
                + "a.seuil_alerte, a.url_image, "
                + "a.id_region, r.libelle, a.id_type_vin, tv.libelle, a.id_appelation, ap.libelle, a.type_article "
                + "FROM article a " + "INNER JOIN region r ON a.id_region = r.id_region "
                + "INNER JOIN type_vin tv ON a.id_type_vin = tv.id_type_vin "
                + "INNER JOIN appelation ap ON a.id_appelation = ap.id_appelation";
        return jdbcTemplate.query(sql, new VinMapper());
    }

    @Override
    public Vin getById(Integer paramIdVin) {
        String sql = "SELECT a.id_article, a.reference, a.libelle, a.description, a.prix, a.annee, a.quantite, a.seuil_alerte, a.url_image, "
                + "a.id_region, r.libelle, a.id_type_vin, tv.libelle, a.id_appelation, ap.libelle, a.type_article "
                + "FROM article a " + "INNER JOIN region r ON a.id_region = r.id_region "
                + "INNER JOIN type_vin tv ON a.id_type_vin = tv.id_type_vin "
                + "INNER JOIN appelation ap ON a.id_appelation = ap.id_appelation " + "WHERE a.id_article = ?";
        return (Vin) jdbcTemplate.queryForObject(sql, new Object[] {paramIdVin }, new VinMapper());
    }

    /**
     * Récupère l'id d'un vin par sa référence.
     *
     * @param paramReferenceVin
     *            la référence du vin.
     * @return l'id du vin.
     */
    public Integer getIdByReference(String paramReferenceVin) {
        String sql = "SELECT v.id_article FROM article v WHERE v.reference = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {paramReferenceVin }, Integer.class);
    }

    @Override
    public void addVin(Vin paramVin, Integer paramIdFournisseur) {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        String sqlAddVin = "INSERT INTO `bdd_dionychus`.`article` (`reference`, `libelle`, `description`, `prix`, "
                + "`annee`, `quantite`, `seuil_alerte`, `url_image`, `id_type_vin`, `id_appelation`, `id_region`, "
                + "`type_article`, `id_acteur`) VALUES (?,?,?,?,?,?,?,?,?,?,?,'Vin',?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement statement = con.prepareStatement(sqlAddVin, Statement.RETURN_GENERATED_KEYS);
                statement.setString(INDEX_PREMIER_PARAMETRE, paramVin.getReference());
                statement.setString(INDEX_SECOND_PARAMETRE, paramVin.getLibelle());
                statement.setString(INDEX_TROISIEME_PARAMETRE, paramVin.getDescription());
                statement.setDouble(INDEX_QUATRIEME_PARAMETRE, paramVin.getPrix());
                statement.setInt(INDEX_CINQUIEME_PARAMETRE, paramVin.getAnnee());
                statement.setInt(INDEX_SIXIEME_PARAMETRE, paramVin.getQuantite());
                statement.setInt(INDEX_SEPTIEME_PARAMETRE, paramVin.getSeuilAlerte());
                statement.setString(INDEX_HUITIEME_PARAMETRE, paramVin.getUrlImage());
                statement.setInt(INDEX_NEUVIEME_PARAMETRE, paramVin.getTypeVin().getIdTypeVin());
                statement.setInt(INDEX_DIXIEME_PARAMETRE, paramVin.getAppelation().getIdAppelation());
                statement.setInt(INDEX_ONZIEME_PARAMETRE, paramVin.getRegion().getIdRegion());
                statement.setInt(INDEX_DOUZIEME_PARAMETRE, paramIdFournisseur);
                return statement;
            }
        });
        String sqlAddAromes = "INSERT INTO `bdd_dionychus`.`vin_arome` (`id_article`, `id_arome`) VALUES (?,?)";
        String sqlAddCepages = "INSERT INTO `bdd_dionychus`.`vin_cepage` (`id_article`, `id_cepage`) VALUES (?,?)";
        Integer idVin = holder.getKey().intValue();
        for (Arome arome : paramVin.getAromes()) {
            jdbcTemplate.update(sqlAddAromes, new Object[] {idVin, arome.getIdArome() });
        }
        for (Cepage cepage : paramVin.getCepages()) {
            jdbcTemplate.update(sqlAddCepages, new Object[] {idVin, cepage.getIdCepage() });
        }
    }

    @Override
    public void updateVin(Vin paramVin) {
        String sqlUpdateVin = "UPDATE `bdd_dionychus`.`article` SET `reference`=?, `libelle`=?, `description`=?, "
                + "`prix`=?, `annee`=?, `quantite`=?, `seuil_alerte`=?, `url_image`=?, `id_type_vin`=?, "
                + "`id_appelation`=?, `id_region`=? WHERE `id_article`=?";
        jdbcTemplate.update(sqlUpdateVin,
                new Object[] {paramVin.getReference(), paramVin.getLibelle(), paramVin.getDescription(),
                        paramVin.getPrix(), paramVin.getAnnee(), paramVin.getQuantite(), paramVin.getSeuilAlerte(),
                        paramVin.getUrlImage(), paramVin.getTypeVin().getIdTypeVin(),
                        paramVin.getAppelation().getIdAppelation(), paramVin.getRegion().getIdRegion(),
                        paramVin.getIdArticle() });
        String sqlUpdateArome = "UPDATE `bdd_dionychus`.`vin_arome` SET `id_arome`=? WHERE `id_article`=?";
        String sqlUpdateCepage = "UPDATE `bdd_dionychus`.`vin_cepage` SET `id_cepage`=? WHERE `id_article`=?";
        for (Arome arome : paramVin.getAromes()) {
            jdbcTemplate.update(sqlUpdateArome, new Object[] {arome.getIdArome(), paramVin.getIdArticle() });
        }
        for (Cepage cepage : paramVin.getCepages()) {
            jdbcTemplate.update(sqlUpdateCepage, new Object[] {cepage.getIdCepage(), paramVin.getIdArticle() });
        }

    }

    @Override
    public void deleteVin(Integer paramIdVin) {
        String sqlDeleteVinArome = "DELETE FROM `bdd_dionychus`.`vin_arome` WHERE id_article =?";
        jdbcTemplate.update(sqlDeleteVinArome, new Object[] {paramIdVin });
        String sqlDeleteVinCepage = "DELETE FROM `bdd_dionychus`.`vin_cepage` WHERE id_article =?";
        jdbcTemplate.update(sqlDeleteVinCepage, new Object[] {paramIdVin });
        String sqlDeleteVin = "DELETE FROM `bdd_dionychus`.`article` WHERE id_article = ?";
        jdbcTemplate.update(sqlDeleteVin, new Object[] {paramIdVin });

    }

    @Override
    public List<Article> getBestSellerVin() {
        String sql = "SELECT a.id_article, a.url_image, a.prix, a.libelle, a.type_article "
                + "FROM bdd_dionychus.article a "
                + "INNER JOIN bdd_dionychus.ligne_commande lc ON a.id_article = lc.id_article "
                + "INNER JOIN bdd_dionychus.commande c ON c.id_commande = lc.id_commande "
                + "WHERE a.type_article = 'Vin' AND c.id_statut_commande <> 1 GROUP BY a.id_article "
                + "ORDER BY sum(lc.quantite) DESC LIMIT 4;";
        return jdbcTemplate.query(sql, new ArticleMapper());
    }

    @Override
    public List<Article> getArticlesAssocies(Integer idCommande) {
        String sql = "SELECT a.id_article, a.libelle, a.url_image, a.prix, a.type_article "
                + "FROM bdd_dionychus.article a " + "INNER JOIN " + "(SELECT lc.id_article "
                + "FROM bdd_dionychus.ligne_commande lc " + "INNER JOIN " + "(SELECT c.id_commande "
                + "FROM bdd_dionychus.commande c "
                + "INNER JOIN bdd_dionychus.ligne_commande lc ON c.id_commande = lc.id_commande "
                + "WHERE lc.id_article = ?) commandes ON lc.id_commande = commandes.id_commande "
                + "WHERE lc.id_article <> ? " + "GROUP BY lc.id_article " + "ORDER BY COUNT(lc.id_article) DESC "
                + "LIMIT 4) ids ON a.id_article = ids.id_article";
        return jdbcTemplate.query(sql, new Object[] {idCommande, idCommande }, new ArticleMapper());
    }

}