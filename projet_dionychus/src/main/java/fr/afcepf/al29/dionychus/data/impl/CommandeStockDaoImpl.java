package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.afcepf.al29.dionychus.data.itf.CommandeStockDaoItf;
import fr.afcepf.al29.dionychus.entity.CommandeStock;
import fr.afcepf.al29.dionychus.mapper.CommandeStockMapper;

/**
 * Classe pour les accès aux données des {@link CommandeStock}.
 *
 * @author ecala
 *
 */
public class CommandeStockDaoImpl implements CommandeStockDaoItf {
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
    public List<CommandeStock> getAll() {
        String sql = "SELECT cs.id_commande, cs.date_validation, cs.date_reception, cs.numero_reference, "
                + "cs.id_acteur, cs.id_statut_commande, sc.libelle " + "FROM commande cs INNER JOIN statut_commande sc "
                + "WHERE cs.id_statut_commande = sc.id_statut_commande";
        return jdbcTemplate.query(sql, new CommandeStockMapper());
    }

    @Override
    public List<CommandeStock> getCommandesByIdUtilisateur(Integer paramIdUtilisateur) {
        String sql = "SELECT cs.id_commande, cs.date_validation, cs.date_reception, cs.numero_reference, "
                + "cs.id_acteur, cs.id_statut_commande, sc.libelle " + "FROM commande cs INNER JOIN statut_commande sc "
                + "WHERE cs.id_statut_commande = sc.id_statut_commande AND cs.id_acteur = ?";
        return jdbcTemplate.query(sql, new Object[] {paramIdUtilisateur }, new CommandeStockMapper());
    }

    @Override
    public List<CommandeStock> getCommandesByIdStatutCommande(Integer paramIdStatutCommande) {
        String sql = "SELECT cs.id_commande, cs.date_validation, cs.date_reception, cs.numero_reference, "
                + "cs.id_acteur, cs.id_statut_commande, sc.libelle " + "FROM commande cs INNER JOIN statut_commande sc "
                + "WHERE cs.id_statut_commande = sc.id_statut_commande AND cs.id_statut_commande = ?";
        return jdbcTemplate.query(sql, new Object[] {paramIdStatutCommande }, new CommandeStockMapper());
    }

    @Override
    public void addCommandeStock(CommandeStock paramCommandeStock) {
        String sql = "INSERT INTO `bdd_dionychus`.`commande` (`date_reception`, `date_validation`, `numero_reference`, "
                + "`id_statut_commande`, `id_acteur`) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql,
                new Object[] {paramCommandeStock.getDateReception(), paramCommandeStock.getDateValidation(),
                        paramCommandeStock.getNumeroReference(), paramCommandeStock.getIdCommande(),
                        paramCommandeStock.getFournisseur().getIdActeur() });
    }

    @Override
    public void updateCommandeStock(CommandeStock paramCommandeStock) {
        String sql = "UPDATE `bdd_dionychus`.`commande` SET `date_reception`=?, `date_validation`=?, `numero_reference`=?,"
                + " `id_statut_commande`=?, `id_acteur`=? WHERE `id_commande`=?";
        jdbcTemplate.update(sql,
                new Object[] {paramCommandeStock.getDateReception(), paramCommandeStock.getDateValidation(),
                        paramCommandeStock.getNumeroReference(), paramCommandeStock.getIdCommande(),
                        paramCommandeStock.getFournisseur().getIdActeur(), paramCommandeStock.getIdCommande() });

    }

    @Override
    public void deleteCommandeStock(Integer paramIdCommandeStock) {
        String sql = "DELETE FROM `bdd_dionychus`.`commande` WHERE id_commande = ?";
        jdbcTemplate.update(sql, new Object[] {paramIdCommandeStock });

    }

}
