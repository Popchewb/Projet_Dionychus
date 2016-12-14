package fr.afcepf.al29.dionychus.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.afcepf.al29.dionychus.entity.CommandeStock;
import fr.afcepf.al29.dionychus.entity.Fournisseur;
import fr.afcepf.al29.dionychus.entity.StatutCommande;

public class CommandeStockMapper implements RowMapper<CommandeStock> {

	@Override
	public CommandeStock mapRow(ResultSet rs, int intRow) throws SQLException {
		CommandeStock commandeStock = new CommandeStock();
		commandeStock.setIdCommande(rs.getInt("cs.id_commande"));
		commandeStock.setDateValidation(rs.getDate("cs.date_validation"));
		commandeStock.setDateReception(rs.getDate("cs.date_reception"));
		commandeStock.setNumeroReference(rs.getString("cs.numero_reference"));
		Fournisseur fournisseur = new Fournisseur();
		fournisseur.setIdActeur(rs.getInt("cs.id_acteur"));
		commandeStock.setFournisseur(fournisseur);
		StatutCommande statutCommande = new StatutCommande();
		statutCommande.setIdStatutCommande(rs.getInt("cs.id_statut_commande"));
		statutCommande.setLibelle(rs.getString("sc.libelle"));
		commandeStock.setStatutCommande(statutCommande);		
		return commandeStock;
	}

}
