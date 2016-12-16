package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Utilisateur;

public interface UtilisateurDaoItf {

	List<Utilisateur> getAll();

	Utilisateur getById(int paramIdUtilisateur);
<<<<<<< HEAD

	void addUtilisateur(Utilisateur paramUtilisateur);

=======
	Utilisateur addUtilisateur(Utilisateur paramUtilisateur);
>>>>>>> 142e74daf1681f155f6256c7f5669b5ea8c70852
	void updateUtilisateur(Utilisateur paramUtilisateur);

	void deleteUtilisateur(Integer paramIdUtilisateur);

}
