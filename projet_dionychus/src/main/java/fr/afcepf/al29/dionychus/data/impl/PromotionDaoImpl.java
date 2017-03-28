package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.afcepf.al29.dionychus.data.itf.PromotionDaoItf;
import fr.afcepf.al29.dionychus.entity.Promotion;
import fr.afcepf.al29.dionychus.mapper.PromotionMapper;

/**
 * Classe pour l'accès aux données des {@link Promotion}.
 *
 * @author ecala
 *
 */
public class PromotionDaoImpl implements PromotionDaoItf {
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
    public List<Promotion> getAll() {
        String sql = "SELECT p.id_promotion, p.libelle, p.date_debut, p.date_fin,p.tarification,p.remise FROM promotion p ORDER BY p.date_fin";
        return jdbcTemplate.query(sql, new PromotionMapper());
    }

    @Override
    public void addPromotion(Promotion paramPromotion) {
        String sql = "INSERT INTO `bdd_dionychus`.`promotion` (`libelle`, `date_debut`, `date_fin`, `tarification`, `remise`) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[] {paramPromotion.getLibelle(), paramPromotion.getDateDebut(),
                paramPromotion.getDateFin(), paramPromotion.getTarification(), paramPromotion.getRemise() });
    }

    @Override
    public void updatePromotion(Promotion paramPromotion) {
        String sql = "UPDATE `bdd_dionychus`.`promotion` SET `libelle`=?, `date_debut`=?, `date_fin`=?, `tarification`=?, `remise`=? WHERE `id_promotion`=?;";
        jdbcTemplate.update(sql,
                new Object[] {paramPromotion.getLibelle(), paramPromotion.getDateDebut(), paramPromotion.getDateFin(),
                        paramPromotion.getTarification(), paramPromotion.getRemise(),
                        paramPromotion.getIdPromotion() });
    }

    @Override
    public void deletePromotion(Integer paramIdPromotion) {
        String sql = "DELETE FROM `bdd_dionychus`.`promotion` WHERE id_promotion = ?";
        jdbcTemplate.update(sql, new Object[] {paramIdPromotion });

    }

}