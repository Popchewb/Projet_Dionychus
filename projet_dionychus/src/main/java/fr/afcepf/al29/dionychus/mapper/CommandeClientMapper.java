package fr.afcepf.al29.dionychus.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.afcepf.al29.dionychus.entity.CommandeClient;
import fr.afcepf.al29.dionychus.entity.Promotion;
import fr.afcepf.al29.dionychus.entity.StatutCommande;
import fr.afcepf.al29.dionychus.entity.Utilisateur;

public class CommandeClientMapper implements RowMapper<CommandeClient> {

	@Override
	public CommandeClient mapRow(ResultSet rs, int intRow) throws SQLException {
		CommandeClient commandeClient = new CommandeClient();
		commandeClient.setIdCommande(rs.getInt("cc.id_commande"));
		commandeClient.setDateCreation(rs.getDate("cc.date_creation"));
		commandeClient.setDateValidation(rs.getDate("cc.date_validation"));
		commandeClient.setNumeroReference(rs.getString("cc.numero_reference"));
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setIdActeur(rs.getInt("cc.id_acteur"));
		commandeClient.setUtilisateur(utilisateur);
		Promotion promotion = new Promotion();
		promotion.setIdPromotion(rs.getInt("cc.id_promotion"));
		StatutCommande statutCommande = new StatutCommande();
		statutCommande.setIdStatutCommande(rs.getInt("cc.id_statut_commande"));
		statutCommande.setLibelle(rs.getString("sc.libelle"));
		commandeClient.setStatutCommande(statutCommande);		
		return commandeClient;
	}

}
