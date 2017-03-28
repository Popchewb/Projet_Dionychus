package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.afcepf.al29.dionychus.data.itf.LivraisonDaoItf;
import fr.afcepf.al29.dionychus.entity.Livraison;
import fr.afcepf.al29.dionychus.mapper.LivraisonMapper;
/**
 * Classe pour l'accès aux données des {@link Livraison}.
 * @author ecala
 *
 */
public class LivraisonDaoImpl implements LivraisonDaoItf {
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
    public List<Livraison> getAll() {
        String sql = "SELECT l.id_livraison, l.tarification, l.id_type_livraison, tl.libelle "
                + "FROM livraison l INNER JOIN type_livraison tl " + "WHERE l.id_type_livraison = tl.id_type_livraison";
        return jdbcTemplate.query(sql, new LivraisonMapper());
    }

    @Override
    public List<Livraison> getAllByIdUtilisateur(Integer paramIdUtilisateur) {
        String sql = "SELECT l.id_livraison, l.tarification, l.id_type_livraison, tl.libelle "
                + "FROM livraison l INNER JOIN type_livraison tl INNER JOIN commande_client cc INNER JOIN acteur a "
                + "WHERE l.id_type_livraison = tl.id_type_livraison AND l.id_commande = cc.id_commande AND cc.id_acteur = a.id_acteur";
        return jdbcTemplate.query(sql, new Object[] {paramIdUtilisateur }, new LivraisonMapper());
    }

    @Override
    public void addLivraison(Livraison paramLivraison) {
        String sql = "INSERT INTO `bdd_dionychus`.`livraison` (`tarification`, `id_type_livraison`, `id_commande`) VALUES (?,?,?)";
        jdbcTemplate.update(sql, new Object[] {paramLivraison.getTarification(), paramLivraison.getIdLivraison(),
                paramLivraison.getCommandeClient().getIdCommande() });
    }

    @Override
    public void updateLivraison(Livraison paramLivraison) {
        String sql = "UPDATE `bdd_dionychus`.`livraison` SET `tarification`=?, `id_type_livraison`=?, `id_commande`=? "
                + "WHERE `id_livraison`=?;";
        jdbcTemplate.update(sql,
                new Object[] {paramLivraison.getTarification(), paramLivraison.getTypeLivraison().getIdTypeLivraison(),
                        paramLivraison.getCommandeClient().getIdCommande(), paramLivraison.getIdLivraison() });
    }

    @Override
    public void deleteLivraison(Integer paramIdLivraison) {
        String sql = "DELETE FROM `bdd_dionychus`.`livraison` WHERE id_livraison = ?";
        jdbcTemplate.update(sql, new Object[] {paramIdLivraison });

    }

}
