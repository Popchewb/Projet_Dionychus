package fr.afcepf.al29.dionychus.business.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Adresse;
import fr.afcepf.al29.dionychus.entity.Commentaire;
import fr.afcepf.al29.dionychus.entity.Pays;
import fr.afcepf.al29.dionychus.entity.TypeAcces;
import fr.afcepf.al29.dionychus.entity.Utilisateur;
import fr.afcepf.al29.dionychus.entity.Ville;

/**
 * Interface pour les méthodes de services relatives aux {@link Utilisateur}.
 *
 * @author ecala
 *
 */
public interface IBusinessCompte {

    // ADRESSE
    /**
     * Récupère toutes les {@link Adresse} de l'unité de persistence.
     *
     * @return la liste des {@link Adresse}.
     */
    List<Adresse> getAllAdresse();
    /**
     * Récupère une {@link Adresse} par son identifiant.
     * @param paramIdAdresse l'identifiant de l'{@link Adresse}.
     * @return l'{@link Adresse}.
     */
    Adresse getAdresseById(Integer paramIdAdresse);
    /**
     * Récupère toutes les {@link Adresse} d'un {@link Acteur}.
     * @param paramIdActeur l'identifiant de l'{@link Acteur}.
     * @return la liste des {@link Adresse}.
     */
    List<Adresse> getAdresseByIdActeur(Integer paramIdActeur);
    /**
     * Ajoute une {@link Adresse} dans l'unité de persistence.
     * @param paramAdresse l'{@link Adresse} à ajouter.
     * @param paramIdActeur l'identifiant de l'{@link Acteur} à qui appartient cette {@link Adresse}.
     */
    void addAdresse(Adresse paramAdresse, Integer paramIdActeur);
    /**
     * Met à jour une {@link Adresse} dans l'unité de persistence.
     * @param paramAdresse l'{@link Adresse} à mettre à jour.
     */
    void updateAdresse(Adresse paramAdresse);
    /**
     * Supprime une {@link Adresse} de l'unité de persistence.
     * @param paramIdAdresse l'identifiant de l'{@link Adresse} à mettre à jour.
     */
    void deleteAdresse(Integer paramIdAdresse);

    // COMMENTAIRE
    /**
     * Récupère tous les {@link Commentaire} d'un {@link Utilisateur}.
     * @param paramIdUtilisateur l'identifiant de l'{@link Utilisateur}.
     * @return la liste des {@link Commentaire}.
     */
    List<Commentaire> getAllCommentaireByUtilisateur(Integer paramIdUtilisateur);

    // Pays
    /**
     * Récupère tous les {@link Pays} de l'unité de persistence.
     * @return la liste tous les {@link Pays}.
     */
    List<Pays> getAllPays();
    /**
     * Récupère le {@link Pays} par l'identifiant d'une {@link Ville}.
     * @param paramIdVille l'identifiant de la {@link Ville}.
     * @return le {@link Pays}.
     */
    Pays getPaysByIdVille(Integer paramIdVille);

    // VILLE
    /**
     * Récupère toutes les {@link Ville} de l'unité de persistence.
     * @return la liste des {@link Ville}.
     */
    List<Ville> getAllVille();
    /**
     * Récupère toutes les {@link Ville} d'un {@link Pays}.
     * @param paramIdPays l'identifiant du {@link Pays}.
     * @return la liste des {@link Ville} du {@link Pays}.
     */
    List<Ville> getAllVilleByIdPays(Integer paramIdPays);
    /**
     * Récupère une {@link Ville} par son identifiant.
     * @param paramIdVille l'identifiant de la {@link Ville}.
     * @return la {@link Ville}.
     */
    Ville getVilleById(Integer paramIdVille);

    // TYPE ACCES
    /**
     * Récupère tous les {@link TypeAcces} de l'unité de persistence.
     * @return la liste des {@link TypeAcces}.
     */
    List<TypeAcces> getAllTypeAcces();

    // UTILISATEUR
    /**
     * Récupère tous les {@link Utilisateur} de l'unité de persistence.
     * @return la liste des {@link Utilisateur}.
     */
    List<Utilisateur> getAllUtilisateur();
    /**
     * Récupère un {@link Utilisateur} par son adresse e-mail.
     * @param email le mail de l'{@link Utilisateur}.
     * @return l'{@link Utilisateur}.
     */
    Utilisateur getUserByEmail(String email);
    /**
     * Récupère un {@link Utilisateur} par son identifiant.
     * @param paramIdUtilisateur l'identifiant de l'{@link Utilisateur}.
     * @return l'{@link Utilisateur}.
     */
    Utilisateur getUtilisateurById(int paramIdUtilisateur);
    /**
     * Ajoute un {@link Utilisateur} dans l'unité de persistence.
     * @param paramUtilisateur l'{@link Utilisateur} ajouté.
     */
    void addUtilisateur(Utilisateur paramUtilisateur);
    /**
     * Met à jour un {@link Utilisateur} dans l'unité de persistence.
     * @param paramUtilisateur l'{@link Utilisateur} mis à jour.
     */
    void updateUtilisateur(Utilisateur paramUtilisateur);
    /**
     * Supprime un {@link Utilisateur} de l'unité de persistence.
     * @param paramIdUtilisateur l'{@link Utilisateur} supprimé.
     */
    void deleteUtilisateur(Integer paramIdUtilisateur);
}
