package fr.afcepf.al29.dionychus.data.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import com.mysql.jdbc.Statement;

import fr.afcepf.al29.dionychus.data.itf.UtilisateurDaoItf;
import fr.afcepf.al29.dionychus.entity.Utilisateur;
import fr.afcepf.al29.dionychus.mapper.UtilisateurMapper;

/**
 * Classe pour l'accès aux données des {@link Utilisateur}.
 *
 * @author ecala
 *
 */
public class UtilisateurDaoImpl implements UtilisateurDaoItf {
    /**
     * Indice du premier paramètre de la requête SQL.
     */
    private static final int INDEX_PREMIER_PARAMETRE = 1;
    /**
     * Indice du second paramètre de la requête SQL.
     */
    private static final int INDEX_SECOND_PARAMETRE = 2;
    /**
     * Indice du troisième paramètre de la requête SQL.
     */
    private static final int INDEX_TROISIEME_PARAMETRE = 3;
    /**
     * Indice du quatrième paramètre de la requête SQL.
     */
    private static final int INDEX_QUATRIEME_PARAMETRE = 4;
    /**
     * Indice du cinquième paramètre de la requête SQL.
     */
    private static final int INDEX_CINQUIEME_PARAMETRE = 5;
    /**
     * Indice du sixième paramètre de la requête SQL.
     */
    private static final int INDEX_SIXIEME_PARAMETRE = 6;
    /**
     * Indice du premier paramètre de la requête SQL.
     */
    private static final int INDEX_SEPTIEME_PARAMETRE = 7;
    /**
     * Indice du second paramètre de la requête SQL.
     */
    private static final int INDEX_HUITIEME_PARAMETRE = 8;
    /**
     * Indice du troisième paramètre de la requête SQL.
     */
    private static final int INDEX_NEUVIEME_PARAMETRE = 9;
    /**
     * Indice du quatrième paramètre de la requête SQL.
     */
    private static final int INDEX_DIXIEME_PARAMETRE = 10;
    /**
     * Indice du cinquième paramètre de la requête SQL.
     */
    private static final int INDEX_ONZIEME_PARAMETRE = 11;
    /**
     * Indice du sixième paramètre de la requête SQL.
     */
    private static final int INDEX_DOUZIEME_PARAMETRE = 12;
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
    public List<Utilisateur> getAllUtilisateur() {
        String sql = "SELECT u.id_acteur, u.date_naissance, u.optin, u.origine, u.login, u.password, "
                + "u.id_type_acces, u.nom, u.prenom, u.numero_telephone, u.adresse_mail, u.civilite,"
                + " u.profession, ta.libelle FROM acteur u INNER JOIN type_acces ta "
                + "WHERE u.id_type_acces = ta.id_type_acces AND u.type_acteur = 'Utilisateur' ORDER BY u.nom";
        return jdbcTemplate.query(sql, new UtilisateurMapper());
    }

    @Override
    public Utilisateur getUserByEmail(String email) {
        String sql = "SELECT u.id_acteur, u.nom, u.prenom, u.numero_telephone, u.adresse_mail,"
                + " u.date_naissance, u.optin, u.origine, u.login, u.password, u.id_type_acces,"
                + " u.civilite, u.profession, u.type_acteur, ta.libelle FROM acteur u "
                + "INNER JOIN type_acces ta WHERE ta.id_type_acces = u.id_type_acces AND u.adresse_mail = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {email }, new UtilisateurMapper());
    }

    @Override
    public Utilisateur getUtilisateurById(int paramIdUtilisateur) {
        String sql = "SELECT u.id_acteur, u.date_naissance, u.optin, u.origine, u.login, u.password, "
                + "u.id_type_acces, u.nom, u.prenom, u.numero_telephone, u.adresse_mail, u.civilite, "
                + "u.profession, ta.libelle FROM acteur u INNER JOIN type_acces ta "
                + "WHERE u.id_type_acces = ta.id_type_acces AND u.id_acteur = ? AND u.type_acteur = 'Utilisateur' "
                + "ORDER BY u.nom";
        return jdbcTemplate.queryForObject(sql, new Object[] {paramIdUtilisateur }, new UtilisateurMapper());
    }

    @Override
    public Utilisateur addUtilisateur(Utilisateur paramUtilisateur) {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        String sql = "INSERT INTO `bdd_dionychus`.`acteur`(`date_naissance`,`optin`,`login`,`password`,`id_type_acces`,"
                + "`nom`,`prenom`,`numero_telephone`,`adresse_mail`,`origine`,`civilite`, `profession`, `type_acteur`) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,'Utilisateur')";
        jdbcTemplate.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                statement.setDate(INDEX_PREMIER_PARAMETRE, paramUtilisateur.getDateNaissance());
                statement.setBoolean(INDEX_SECOND_PARAMETRE, paramUtilisateur.getOptin());
                statement.setString(INDEX_TROISIEME_PARAMETRE, paramUtilisateur.getLogin());
                statement.setString(INDEX_QUATRIEME_PARAMETRE, paramUtilisateur.getPassword());
                statement.setInt(INDEX_CINQUIEME_PARAMETRE, paramUtilisateur.getTypeAcces().getIdTypeAcces());
                statement.setString(INDEX_SIXIEME_PARAMETRE, paramUtilisateur.getNom());
                statement.setString(INDEX_SEPTIEME_PARAMETRE, paramUtilisateur.getPrenom());
                statement.setString(INDEX_HUITIEME_PARAMETRE, paramUtilisateur.getNumeroTelephone());
                statement.setString(INDEX_NEUVIEME_PARAMETRE, paramUtilisateur.getAdresseMail());
                statement.setString(INDEX_DIXIEME_PARAMETRE, paramUtilisateur.getOrigine());
                statement.setString(INDEX_ONZIEME_PARAMETRE, paramUtilisateur.getCivilite());
                statement.setString(INDEX_DOUZIEME_PARAMETRE, paramUtilisateur.getProfession());
                return statement;
            }
        }, holder);
        paramUtilisateur.setIdActeur(holder.getKey().intValue());
        return paramUtilisateur;
    }

    @Override
    public void updateUtilisateur(Utilisateur paramUtilisateur) {
        String sql = "UPDATE `bdd_dionychus`.`acteur` SET `date_naissance`= ?,`optin`=?, `origine`=?, `login`=?,"
                + " `password`=?, `id_type_acces`=?, `nom`=?, `prenom`=?, `numero_telephone`=?, `adresse_mail`=?,"
                + " `civilite`=?, `profession`=? WHERE `id_acteur`=?";
        jdbcTemplate.update(sql, new Object[] {paramUtilisateur.getDateNaissance(), paramUtilisateur.getOptin(),
                paramUtilisateur.getOrigine(), paramUtilisateur.getLogin(), paramUtilisateur.getPassword(),
                paramUtilisateur.getTypeAcces().getIdTypeAcces(), paramUtilisateur.getNom(),
                paramUtilisateur.getPrenom(), paramUtilisateur.getNumeroTelephone(), paramUtilisateur.getAdresseMail(),
                paramUtilisateur.getCivilite(), paramUtilisateur.getProfession(), paramUtilisateur.getIdActeur() });
    }

    @Override
    public void deleteUtilisateur(Integer paramIdUtilisateur) {
        String sql = "DELETE FROM `bdd_dionychus`.`acteur` WHERE id_acteur = ?";
        jdbcTemplate.update(sql, new Object[] {paramIdUtilisateur });
    }

}
