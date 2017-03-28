package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.afcepf.al29.dionychus.data.itf.FournisseurDaoItf;
import fr.afcepf.al29.dionychus.entity.Fournisseur;
import fr.afcepf.al29.dionychus.mapper.FournisseurMapper;

/**
 * Classe pour l'accès aux données des {@link Fournisseur}.
 *
 * @author ecala
 *
 */
public class FournisseurDaoImpl implements FournisseurDaoItf {

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
    public List<Fournisseur> getAll() {
        String sql = "SELECT f.id_acteur, f.nom_domaine, f.nom, f.prenom, f.adresse_mail,"
                + " f.numero_telephone, f.civilite FROM acteur f WHERE f.type_acteur = 'Fournisseur'";
        return jdbcTemplate.query(sql, new FournisseurMapper());
    }

    @Override
    public Fournisseur getById(Integer paramIdFournisseur) {
        String sql = "SELECT f.id_acteur, f.nom_domaine, f.nom, f.prenom, f.adresse_mail,"
                + " f.numero_telephone, f.civilite FROM acteur f "
                + "WHERE f.id_acteur = ? AND f.type_acteur = 'Fournisseur'";
        return jdbcTemplate.queryForObject(sql, new Object[] {paramIdFournisseur }, new FournisseurMapper());
    }

    @Override
    public void addFournisseur(Fournisseur paramFournisseur) {
        String sql = "INSERT INTO `bdd_dionychus`.`acteur` (`nom_domaine`, `nom`, `prenom`, `numero_telephone`,"
                + " `adresse_mail`, `civilite`,`type_acces`) VALUES (?,?,?,?,?,?,'Fournisseur')";
        jdbcTemplate.update(sql,
                new Object[] {paramFournisseur.getNomDomaine(), paramFournisseur.getNom(),
                        paramFournisseur.getPrenom(), paramFournisseur.getNumeroTelephone(),
                        paramFournisseur.getAdresseMail(), paramFournisseur.getCivilite() });
    }

    @Override
    public void updateFournisseur(Fournisseur paramFournisseur) {
        String sql = "UPDATE `bdd_dionychus`.`acteur` SET `nom_domaine`=?, `nom`=?, `prenom`=?, `numero_telephone`=?,"
                + " `adresse_mail`=?, `civilite`=? WHERE `id_acteur`=?";
        jdbcTemplate.update(sql, new Object[] {paramFournisseur.getNomDomaine(), paramFournisseur.getNom(),
                paramFournisseur.getPrenom(), paramFournisseur.getNumeroTelephone(), paramFournisseur.getAdresseMail(),
                paramFournisseur.getCivilite(), paramFournisseur.getIdActeur() });

    }

    @Override
    public void deleteFournisseur(Integer paramIdFournisseur) {
        String sql = "DELETE FROM `bdd_dionychus`.`acteur` WHERE id_acteur = ?";
        jdbcTemplate.update(sql, new Object[] {paramIdFournisseur });

    }

}
