package fr.afcepf.al29.dionychus.business.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Adresse;
import fr.afcepf.al29.dionychus.entity.Commentaire;
import fr.afcepf.al29.dionychus.entity.Pays;
import fr.afcepf.al29.dionychus.entity.TypeAcces;
import fr.afcepf.al29.dionychus.entity.Utilisateur;
import fr.afcepf.al29.dionychus.entity.Ville;

public interface IBusinessCompte {
	
	//Adresses
	List<Adresse> getAllAdresse();
	Adresse getAdresseById(Integer paramIdAdresse);
	List<Adresse> getAdresseByIdActeur(Integer paramIdActeur);
	void addAdresse (Adresse paramAdresse, Integer paramIdActeur);
	void updateAdresse (Adresse paramAdresse);
	void deleteAdresse (Integer paramIdAdresse);
	
	//Commentaires
	List<Commentaire> getAllByUtilisateur(Integer paramIdUtilisateur);
	
	//Pays
	List<Pays> getAllPays();
	Pays getPaysByIdVille(Integer paramIdVille);
	
	//Villes
	List<Ville> getAllVille();
	List<Ville> getAllVilleByIdPays(Integer paramIdPays);
	
	//Types Acces
	List<TypeAcces> getAllTypeAcces();
	
	//Utilisateurs
	List<Utilisateur> getAll();
	Utilisateur getById(int paramIdUtilisateur);
	void addUtilisateur(Utilisateur paramUtilisateur);
	void updateUtilisateur(Utilisateur paramUtilisateur);
	void deleteUtilisateur(Integer paramIdUtilisateur);
}
