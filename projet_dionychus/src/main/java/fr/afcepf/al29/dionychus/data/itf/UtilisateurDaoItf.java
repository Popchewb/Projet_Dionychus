package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Utilisateur;

/**
 * Interface pour les méthodes d'accès aux données des {@link Utilisateur}.
 *
 * @author ecala
 *
 */
public interface UtilisateurDaoItf {
    /**
     * Récupère tous les {@link Utilisateur} de l'unité de persistence.
     * @return la liste des {@link Utilisateur}.
     */
    List<Utilisateur> getAllUtilisateur();
    /**
     * Récupère un {@link Utilisateur} par son adresse e-mail.
     * @param email le mail de l'utilisateur.
     * @return l'utilisateur.
     */
    Utilisateur getUserByEmail(String email);
    /**
     * Récupère un {@link Utilisateur} par son identifiant.
     * @param paramIdUtilisateur l'id de l'utilisateur.
     * @return l'utilisateur.
     */
    Utilisateur getUtilisateurById(int paramIdUtilisateur);
    /**
     * Ajoute un {@link Utilisateur} dans l'unité de persistence.
     * @param paramUtilisateur l'utilisateur à ajouter.
     * @return l'utilisateur ajouté.
     */
    Utilisateur addUtilisateur(Utilisateur paramUtilisateur);
    /**
     * Met à jour un {@link Utilisateur} dans l'unité de persistence.
     * @param paramUtilisateur l'utilisateur à mettre à jour.
     */
    void updateUtilisateur(Utilisateur paramUtilisateur);
    /**
     * Supprime un {@link Utilisateur} de l'unité de persistence.
     * @param paramIdUtilisateur l'utilisateur à supprimer.
     */
    void deleteUtilisateur(Integer paramIdUtilisateur);

}