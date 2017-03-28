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

import fr.afcepf.al29.dionychus.data.itf.CommandeClientDaoItf;
import fr.afcepf.al29.dionychus.entity.CommandeClient;
import fr.afcepf.al29.dionychus.mapper.CommandeClientMapper;

/**
 * Classe pour les accès aux bases de données des {@link CommandeClient}.
 *
 * @author ecala
 *
 */
public class CommandeClientDaoImpl implements CommandeClientDaoItf {
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
    public List<CommandeClient> getAll() {
        String sql = "SELECT cc.id_commande, cc.date_creation, cc.date_validation, cc.numero_reference, "
                + "cc.id_acteur, cc.id_promotion, cc.id_statut_commande, sc.libelle "
                + "FROM commande cc  INNER JOIN statut_commande sc "
                + "WHERE cc.id_statut_commande = sc.id_statut_commande";
        return jdbcTemplate.query(sql, new CommandeClientMapper());
    }

    @Override
    public List<CommandeClient> getCommandesByIdUtilisateur(Integer paramIdUtilisateur) {
        String sql = "SELECT cc.id_commande, cc.date_creation, cc.date_validation, cc.numero_reference, "
                + "cc.id_acteur, cc.id_promotion, cc.id_statut_commande, sc.libelle "
                + "FROM commande cc INNER JOIN statut_commande sc "
                + "WHERE cc.id_statut_commande = sc.id_statut_commande AND cc.id_acteur = ?";
        return jdbcTemplate.query(sql, new Object[] {paramIdUtilisateur }, new CommandeClientMapper());
    }

    @Override
    public List<CommandeClient> getCommandesByIdStatutCommande(Integer paramIdStatutCommande) {
        String sql = "SELECT cc.id_commande, cc.date_creation, cc.date_validation, cc.numero_reference,"
                + " cc.id_acteur, cc.id_promotion, cc.id_statut_commande, sc.libelle "
                + "FROM commande cc INNER JOIN statut_commande sc "
                + "WHERE cc.id_statut_commande = sc.id_statut_commande AND cc.id_statut_commande = ?";
        return jdbcTemplate.query(sql, new Object[] {paramIdStatutCommande }, new CommandeClientMapper());
    }

    @Override
    public CommandeClient addCommandeClient(CommandeClient paramCommandeClient) {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        String sql = "INSERT INTO `bdd_dionychus`.`commande` (`date_creation`, `id_promotion`, `date_validation`, "
                + "`numero_reference`, `id_statut_commande`, `id_acteur`) VALUES (?,?,?,?,?,?)";
        jdbcTemplate.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                statement.setDate(INDEX_PREMIER_PARAMETRE, paramCommandeClient.getDateCreation());
                statement.setInt(INDEX_SECOND_PARAMETRE, paramCommandeClient.getPromotion().getIdPromotion());
                statement.setDate(INDEX_TROISIEME_PARAMETRE, paramCommandeClient.getDateValidation());
                statement.setString(INDEX_QUATRIEME_PARAMETRE, paramCommandeClient.getNumeroReference());
                statement.setInt(INDEX_CINQUIEME_PARAMETRE,
                        paramCommandeClient.getStatutCommande().getIdStatutCommande());
                statement.setInt(INDEX_SIXIEME_PARAMETRE, paramCommandeClient.getUtilisateur().getIdActeur());
                return statement;
            }
        }, holder);
        paramCommandeClient.setIdCommande(holder.getKey().intValue());
        return paramCommandeClient;
    }

    @Override
    public void updateCommandeClient(CommandeClient paramCommandeClient) {
        String sql = "UPDATE `bdd_dionychus`.`commande` "
                + "SET `date_creation`=?, `id_promotion`=?, `date_validation`=?, `numero_reference`=?, "
                + "`id_statut_commande`=?, `id_acteur`=? WHERE `id_commande`=?";
        jdbcTemplate.update(sql, new Object[] {paramCommandeClient.getDateCreation(),
                paramCommandeClient.getPromotion().getIdPromotion(), paramCommandeClient.getDateValidation(),
                paramCommandeClient.getNumeroReference(), paramCommandeClient.getStatutCommande().getIdStatutCommande(),
                paramCommandeClient.getUtilisateur().getIdActeur(), paramCommandeClient.getIdCommande() });
    }

    @Override
    public void deleteCommandeClient(Integer paramIdCommandeClient) {
        String sql = "DELETE FROM `bdd_dionychus`.`commande` WHERE id_commande = ?";
        jdbcTemplate.update(sql, new Object[] {paramIdCommandeClient });

    }

    @Override
    public CommandeClient getCommandeClientById(Integer paramIdCommandeClient) {
        String sql = "SELECT cc.id_commande, cc.date_creation, cc.date_validation, "
                + "cc.numero_reference, cc.id_acteur, cc.id_promotion, cc.id_statut_commande, sc.libelle "
                + "FROM commande cc  INNER JOIN statut_commande sc "
                + "WHERE cc.id_statut_commande = sc.id_statut_commande AND cc.id_commande = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {paramIdCommandeClient }, new CommandeClientMapper());
    }

    @Override
    public CommandeClient addPanier(CommandeClient panier) {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        String sql = "INSERT INTO `bdd_dionychus`.`commande` (`date_creation`, `id_statut_commande`,`numero_reference`)"
                + " VALUES (?,'1',?)";
        jdbcTemplate.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                statement.setDate(1, panier.getDateCreation());
                statement.setString(2, panier.getNumeroReference());
                return statement;
            }
        }, holder);
        panier.setIdCommande(holder.getKey().intValue());
        return panier;
    }

    @Override
    public void updateTypeLivraison(CommandeClient paramCommandeClient, Integer paramIdTypeLivraison) {
        String sql = "UPDATE `bdd_dionychus`.`commande` SET `id_type_livraison`=? WHERE `id_commande`=?";
        jdbcTemplate.update(sql, new Object[] {paramIdTypeLivraison, paramCommandeClient.getIdCommande() });
    }

    @Override
    public Double getTarifLivraisonByIdCommande(Integer idCommande) {
        String sql = "SELECT tl.tarification FROM type_livraison tl "
                + "INNER JOIN commande c ON tl.id_type_livraison = c.id_type_livraison WHERE c.id_commande = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {idCommande }, Double.class);
    }

    @Override
    public void updatePanierValider(CommandeClient paramCommandeClient) {
        String sql = "UPDATE `bdd_dionychus`.`commande` SET `id_statut_commande`=? WHERE `id_commande`=?";
        jdbcTemplate.update(sql, new Object[] {paramCommandeClient.getStatutCommande().getIdStatutCommande(),
                paramCommandeClient.getIdCommande() });
    }

    @Override
    public void updatePanierRefUtilisateur(CommandeClient panierUtilisateur) {
        String sql = "UPDATE `bdd_dionychus`.`commande` SET `id_acteur`=? WHERE `id_commande`=?";
        jdbcTemplate.update(sql,
                new Object[] {panierUtilisateur.getUtilisateur().getIdActeur(), panierUtilisateur.getIdCommande() });
    }

    @Override
    public CommandeClient addPanierPostCommande(CommandeClient panier) {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        String sql = "INSERT INTO `bdd_dionychus`.`commande` (`date_creation`, `id_statut_commande`,`numero_reference`, `id_acteur` ) VALUES (?,'1',?,?)";
        jdbcTemplate.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                statement.setDate(INDEX_PREMIER_PARAMETRE, panier.getDateCreation());
                statement.setString(INDEX_SECOND_PARAMETRE, panier.getNumeroReference());
                statement.setInt(INDEX_TROISIEME_PARAMETRE, panier.getUtilisateur().getIdActeur());
                return statement;
            }
        }, holder);
        panier.setIdCommande(holder.getKey().intValue());
        return panier;
    }

}
