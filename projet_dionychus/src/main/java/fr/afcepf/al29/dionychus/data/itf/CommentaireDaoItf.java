package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Commentaire;

/**
 * Interface pour les méthodes d'accès aux données des {@link Commentaire}.
 *
 * @author ecala
 *
 */
public interface CommentaireDaoItf {
    /**
     * Récupère tous les {@link Commentaire} d'un {@link Vin}.
     *
     * @param paramIdVin
     *            l'id du {@link Vin}.
     * @return la liste des {@link Commentaire} de ce vin.
     */
    List<Commentaire> getAllByVin(Integer paramIdVin);

    /**
     * Récupère tous les {@link Commentaire} d'un {@link Accessoire}.
     *
     * @param paramIdAccessoire
     *            l'id de l'{@link Accessoire};
     * @return la liste des {@link Commentaire} de cet {@link Accessoire}.
     */
    List<Commentaire> getAllByAccessoire(Integer paramIdAccessoire);
    /**
     * Récupère tous les {@link Commentaire} d'un {@link Utilisateur}.
     * @param paramIdUtilisateur l'utilisateur.
     * @return la liste des {@link Commentaire} de cet {@link Utilisateur}.
     */
    List<Commentaire> getAllCommentaireByUtilisateur(Integer paramIdUtilisateur);
    /**
     * Ajoute un {@link Commentaire} dans l'unité de persistence.
     * @param paramCommentaire le {@link Commentaire} à ajouter.
     * @param paramIdArticle l'id de l'article commenté.
     * @param paramIdUtilisateur l'utilisateur qui commente.
     */
    void addCommentaire(Commentaire paramCommentaire, Integer paramIdArticle, Integer paramIdUtilisateur);
    /**
     * Met à jour un {@link Commentaire}.
     * @param paramCommentaire le {@link Commentaire} à mettre à jour.
     */
    void updateCommentaire(Commentaire paramCommentaire);
    /**
     * Supprime un {@link Commentaire}.
     * @param paramIdCommentaire le {@link Commentaire} à supprimer.
     */
    void deleteCommentaire(Integer paramIdCommentaire);

}
