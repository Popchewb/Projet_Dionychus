package fr.afcepf.al29.dionychus.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fr.afcepf.al29.dionychus.entity.Article;

/**
 * Classe pour mapper un result set d'article vers une entité {@link Article}.
 *
 * @author ecala
 *
 */
public class ArticleMapper implements RowMapper<Article> {

    @Override
    public Article mapRow(ResultSet rs, int intRow) throws SQLException {
        Article article = new Article();
        article.setIdArticle(rs.getInt("a.id_article"));
        article.setLibelle(rs.getString("a.libelle"));
        article.setPrix(rs.getDouble("a.prix"));
        article.setUrlImage(rs.getString("a.url_image"));
        article.setTypeArticle(rs.getString("a.type_article"));
        return article;
    }

}
