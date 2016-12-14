package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Utilisateur;

public interface UtilisateurDaoItf {
	List<Utilisateur> getAll();
	Utilisateur getById(int paramIdUtilisateur);
	void addUtilisateur(Utilisateur paramUtilisateur);
	void updateUtilisateur(Utilisateur paramUtilisateur);
	void deleteUtilisateur(Integer paramIdUtilisateur);
}
