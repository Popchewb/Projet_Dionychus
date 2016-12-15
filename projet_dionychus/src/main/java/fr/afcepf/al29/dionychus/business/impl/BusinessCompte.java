package fr.afcepf.al29.dionychus.business.impl;

import java.util.List;

import fr.afcepf.al29.dionychus.business.itf.IBusinessCompte;
import fr.afcepf.al29.dionychus.entity.Adresse;
import fr.afcepf.al29.dionychus.entity.Commentaire;
import fr.afcepf.al29.dionychus.entity.Pays;
import fr.afcepf.al29.dionychus.entity.TypeAcces;
import fr.afcepf.al29.dionychus.entity.Utilisateur;
import fr.afcepf.al29.dionychus.entity.Ville;

public class BusinessCompte implements IBusinessCompte{

	@Override
	public List<Adresse> getAllAdresse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Adresse getAdresseById(Integer paramIdAdresse) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Adresse> getAdresseByIdActeur(Integer paramIdActeur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addAdresse(Adresse paramAdresse, Integer paramIdActeur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAdresse(Adresse paramAdresse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAdresse(Integer paramIdAdresse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Commentaire> getAllByUtilisateur(Integer paramIdUtilisateur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pays> getAllPays() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pays getPaysByIdVille(Integer paramIdVille) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ville> getAllVille() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ville> getAllVilleByIdPays(Integer paramIdPays) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TypeAcces> getAllTypeAcces() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Utilisateur> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur getById(int paramIdUtilisateur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUtilisateur(Utilisateur paramUtilisateur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUtilisateur(Utilisateur paramUtilisateur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUtilisateur(Integer paramIdUtilisateur) {
		// TODO Auto-generated method stub
		
	}

}
