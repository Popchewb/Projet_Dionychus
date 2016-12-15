package fr.afcepf.al29.dionychus.business.impl;

import java.util.List;

import fr.afcepf.al29.dionychus.business.itf.IBusinessCommandeClient;
import fr.afcepf.al29.dionychus.entity.Adresse;
import fr.afcepf.al29.dionychus.entity.Commande;
import fr.afcepf.al29.dionychus.entity.CommandeClient;
import fr.afcepf.al29.dionychus.entity.LigneCommande;
import fr.afcepf.al29.dionychus.entity.Promotion;
import fr.afcepf.al29.dionychus.entity.TypeLivraison;

public class BusinessCommandeClient implements IBusinessCommandeClient {

	@Override
	public List<Adresse> getAdresseByIdActeur(Integer paramIdActeur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommandeClient> getAllCommandeClient() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commande getCommandeById(Integer paramIdCommandeClient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommandeClient> getCommandesByIdUtilisateur(Integer paramIdUtilisateur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCommandeClient(CommandeClient paramCommandeClient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCommandeClient(CommandeClient paramCommandeClient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCommandeClient(Integer paramIdCommandeClient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<LigneCommande> getAllLigneCommandeByIdCommande(Integer paramIdCommande) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addLigneCommande(LigneCommande paramLigneCommande, Integer paramIdCommande) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateLigneCommande(LigneCommande paramLigneCommande) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteLigneCommande(Integer paramIdLigneCommande) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Promotion> getAllPromotion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TypeLivraison> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
