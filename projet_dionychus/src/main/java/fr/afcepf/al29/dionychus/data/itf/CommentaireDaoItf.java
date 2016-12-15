package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Commentaire;

public interface CommentaireDaoItf {

	List<Commentaire> getAllByVin(Integer paramIdVin);

	List<Commentaire> getAllByAccessoire(Integer paramIdAccessoire);

	List<Commentaire> getAllCommentaireByUtilisateur(Integer paramIdUtilisateur);

	void addCommentaire(Commentaire paramCommentaire, Integer paramIdArticle, Integer paramIdUtilisateur);

	void updateCommentaire(Commentaire paramCommentaire);

	void deleteCommentaire(Integer paramIdCommentaire);

}
