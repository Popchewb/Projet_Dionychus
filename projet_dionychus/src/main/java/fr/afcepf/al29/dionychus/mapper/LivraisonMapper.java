package fr.afcepf.al29.dionychus.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.afcepf.al29.dionychus.entity.Livraison;
import fr.afcepf.al29.dionychus.entity.TypeLivraison;

/**
 * Classe pour mapper un result set de livraison vers une entité
 * {@link Livraison}.
 *
 * @author ecala
 *
 */
public class LivraisonMapper implements RowMapper<Livraison> {

    @Override
    public Livraison mapRow(ResultSet rs, int intRow) throws SQLException {
        Livraison livraison = new Livraison();
        livraison.setIdLivraison(rs.getInt("l.id_livraison"));
        livraison.setTarification(rs.getDouble("l.tarification"));
        TypeLivraison typeLivraison = new TypeLivraison();
        typeLivraison.setIdTypeLivraison(rs.getInt("l.id_type_livraison"));
        typeLivraison.setLibelle(rs.getString("tl.libelle"));
        livraison.setTypeLivraison(typeLivraison);
        return livraison;
    }

}
