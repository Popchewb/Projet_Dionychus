package fr.afcepf.al29.dionychus.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.afcepf.al29.dionychus.entity.Appelation;
import fr.afcepf.al29.dionychus.entity.Region;
import fr.afcepf.al29.dionychus.entity.TypeVin;
import fr.afcepf.al29.dionychus.entity.Vin;

/**
 * Classe pour mapper un result set de vin vers une entité {@link Vin}.
 *
 * @author ecala
 *
 */
public class VinMapper implements RowMapper<Vin> {

    @Override
    public Vin mapRow(ResultSet rs, int intRow) throws SQLException {
        Vin vin = new Vin();
        vin.setIdArticle(rs.getInt("a.id_article"));
        vin.setReference(rs.getString("a.reference"));
        vin.setLibelle(rs.getString("a.libelle"));
        vin.setDescription(rs.getString("a.description"));
        vin.setPrix(rs.getDouble("a.prix"));
        vin.setAnnee(rs.getInt("a.annee"));
        vin.setQuantite(rs.getInt("a.quantite"));
        vin.setSeuilAlerte(rs.getInt("a.seuil_alerte"));
        vin.setUrlImage(rs.getString("a.url_image"));
        Region region = new Region();
        region.setIdRegion(rs.getInt("a.id_region"));
        region.setLibelle(rs.getString("r.libelle"));
        vin.setRegion(region);
        TypeVin typeVin = new TypeVin();
        typeVin.setIdTypeVin(rs.getInt("a.id_type_vin"));
        typeVin.setLibelle(rs.getString("tv.libelle"));
        vin.setTypeVin(typeVin);
        Appelation appelation = new Appelation();
        appelation.setIdAppelation(rs.getInt("a.id_appelation"));
        appelation.setLibelle(rs.getString("ap.libelle"));
        vin.setAppelation(appelation);
        vin.setTypeArticle(rs.getString("a.type_article"));
        return vin;
    }

}