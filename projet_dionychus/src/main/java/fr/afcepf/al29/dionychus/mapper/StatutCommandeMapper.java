package fr.afcepf.al29.dionychus.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.afcepf.al29.dionychus.entity.StatutCommande;

/**
 * Classe pour mapper un result set de statut commande vers une entité
 * {@link StatutCommande}.
 *
 * @author ecala
 *
 */
public class StatutCommandeMapper implements RowMapper<StatutCommande> {

    @Override
    public StatutCommande mapRow(ResultSet rs, int intRow) throws SQLException {
        StatutCommande statutCommande = new StatutCommande();
        statutCommande.setIdStatutCommande(rs.getInt("id_statut_commande"));
        statutCommande.setLibelle(rs.getString("libelle"));
        return statutCommande;
    }

}
