package fr.afcepf.al29.dionychus.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.afcepf.al29.dionychus.entity.Promotion;

/**
 * Classe pour mapper un result set de promotion vers une entité
 * {@link Promotion}.
 *
 * @author ecala
 *
 */
public class PromotionMapper implements RowMapper<Promotion> {

    @Override
    public Promotion mapRow(ResultSet rs, int intRow) throws SQLException {
        Promotion promotion = new Promotion();
        promotion.setIdPromotion(rs.getInt("p.id_promotion"));
        promotion.setLibelle(rs.getString("p.libelle"));
        promotion.setDateDebut(rs.getDate("p.date_debut"));
        promotion.setDateFin(rs.getDate("p.date_fin"));
        promotion.setTarification(rs.getDouble("p.tarification"));
        promotion.setRemise(rs.getDouble("p.remise"));
        return promotion;
    }

}