package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Utilisateur;

public interface UtilisateurDaoItf {

	List<Utilisateur> getAllUtilisateur();

	Utilisateur getUserByEmail();

	Utilisateur getUtilisateurById(int paramIdUtilisateur);

	Utilisateur addUtilisateur(Utilisateur paramUtilisateur);

	void updateUtilisateur(Utilisateur paramUtilisateur);

	void deleteUtilisateur(Integer paramIdUtilisateur);

}