package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import fr.afcepf.al29.dionychus.data.itf.CommentaireDaoItf;
import fr.afcepf.al29.dionychus.entity.Commentaire;
import fr.afcepf.al29.dionychus.mapper.CommentaireMapper;

/**
 * Classe pour les accès aux données des {@link Commentaire}.
 *
 * @author ecala
 *
 */
@Service
public class CommentaireDaoImpl implements CommentaireDaoItf {
    /**
     * le template jdbc.
     */
    private JdbcTemplate jdbcTemplate;
    /**
     * la datasource.
     */
    private DataSource dataSource;

    /**
     *
     * @return le template jdbc.
     */
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    /**
     *
     * @param paramJdbcTemplate
     *            le template jdbc to set.
     */
    public void setJdbcTemplate(JdbcTemplate paramJdbcTemplate) {
        jdbcTemplate = paramJdbcTemplate;
    }

    /**
     *
     * @return la datasource.
     */
    public DataSource getDataSource() {
        return dataSource;
    }

    /**
     *
     * @param paramDataSource
     *            la datasource to set.
     */
    public void setDataSource(DataSource paramDataSource) {
        dataSource = paramDataSource;
        jdbcTemplate = new JdbcTemplate(paramDataSource);
    }

    @Override
    public List<Commentaire> getAllByVin(Integer paramIdVin) {
        String sql = "SELECT c.id_commentaire, c.note, c.description, c.date, v.id_article,"
                + " u.id_acteur, u.nom, u.prenom "
                + "FROM commentaire c INNER JOIN article v INNER JOIN acteur u "
                + "WHERE u.id_acteur = c.id_acteur AND v.id_article = c.id_article AND c.id_article = ?";
        return jdbcTemplate.query(sql, new Object[] {paramIdVin }, new CommentaireMapper());
    }

    @Override
    public List<Commentaire> getAllByAccessoire(Integer paramIdAccessoire) {
        String sql = "SELECT c.id_commentaire, c.note, c.description, c.date, a.id_article,"
                + " u.id_acteur, u.nom, u.prenom "
                + "FROM commentaire c INNER JOIN article a INNER JOIN acteur u "
                + "WHERE u.id_acteur = c.id_acteur AND a.id_article = c.id_article AND c.id_article = ?";
        return jdbcTemplate.query(sql, new Object[] {paramIdAccessoire }, new CommentaireMapper());
    }

    @Override
    public List<Commentaire> getAllCommentaireByUtilisateur(Integer paramIdUtilisateur) {
        String sql = "SELECT c.id_commentaire, c.note, c.description, c.date, u.id_acteur "
                + "FROM commentaire c INNER JOIN acteur u WHERE u.id_acteur = c.id_acteur AND c.id_acteur = ?";
        return jdbcTemplate.query(sql, new Object[] {paramIdUtilisateur }, new CommentaireMapper());
    }

    @Override
    public void addCommentaire(Commentaire paramCommentaire, Integer paramIdArticle, Integer paramIdUtilisateur) {
        String sql = "INSERT INTO `bdd_dionychus`.`commentaire` (`note`, `description`, `id_article`, `id_acteur`, `date`) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[] {paramCommentaire.getNote(), paramCommentaire.getDescription(),
                paramIdArticle, paramIdUtilisateur, paramCommentaire.getDate() });
    }

    @Override
    public void updateCommentaire(Commentaire paramCommentaire) {
        String sql = "UPDATE `bdd_dionychus`.`commentaire` SET `note`=?, `description`=?, `date`=? "
                + "WHERE `id_commentaire`=?";
        jdbcTemplate.update(sql, new Object[] {paramCommentaire.getNote(), paramCommentaire.getDescription(),
                paramCommentaire.getDate(), paramCommentaire.getIdCommentaire() });
    }

    @Override
    public void deleteCommentaire(Integer paramIdCommentaire) {
        String sql = "DELETE FROM `bdd_dionychus`.`commentaire` WHERE `id_commentaire`=?";
        jdbcTemplate.update(sql, new Object[] {paramIdCommentaire });
    }

}
