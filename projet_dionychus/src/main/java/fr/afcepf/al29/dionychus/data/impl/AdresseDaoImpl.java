package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import fr.afcepf.al29.dionychus.data.itf.AdresseDaoItf;
import fr.afcepf.al29.dionychus.entity.Adresse;
import fr.afcepf.al29.dionychus.mapper.AdresseMapper;

/**
 * Classe d'accès aux données des {@link Adresse}.
 *
 * @author ecala
 *
 */
@Service
public class AdresseDaoImpl implements AdresseDaoItf {
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
    public List<Adresse> getAll() {
        String sql = "SELECT a.id_adresse, a.libelle, a.complement, a.adresse_facturation, a.adresse_livraison,"
                + " v.id_ville, v.libelle, v.code_postal, p.id_pays, p.libelle "
                + "FROM adresse a INNER JOIN ville v INNER JOIN pays p "
                + "WHERE a.id_ville = v.id_ville AND v.id_pays = p.id_pays ORDER BY a.libelle";
        return jdbcTemplate.query(sql, new AdresseMapper());
    }

    @Override
    public Adresse getAdresseById(Integer paramIdAdresse) {
        String sql = "SELECT a.id_adresse, a.libelle, a.complement, a.adresse_facturation, a.adresse_livraison,"
                + " v.id_ville, v.libelle, v.code_postal, p.id_pays, p.libelle "
                + "FROM adresse a INNER JOIN ville v INNER JOIN pays p "
                + "WHERE a.id_ville = v.id_ville AND v.id_pays = p.id_pays AND a.id_adresse = ? ORDER BY a.libelle";
        return jdbcTemplate.queryForObject(sql, new Object[] {paramIdAdresse }, new AdresseMapper());
    }

    @Override
    public List<Adresse> getAdresseByIdActeur(Integer paramIdActeur) {
        String sql = "SELECT a.id_adresse, a.libelle, a.complement, a.adresse_facturation, a.adresse_livraison, "
                + "v.id_ville, v.libelle, v.code_postal, p.id_pays, p.libelle "
                + "FROM adresse a INNER JOIN ville v INNER JOIN pays p "
                + "WHERE a.id_ville = v.id_ville AND v.id_pays = p.id_pays "
                + "AND a.id_acteur = ? AND a.adresse_livraison = true ORDER BY a.libelle";
        return jdbcTemplate.query(sql, new Object[] {paramIdActeur }, new AdresseMapper());
    }

    @Override
    public void addAdresse(Adresse paramAdresse, Integer paramIdActeur) {
        String sql = "INSERT INTO `bdd_dionychus`.`adresse`(`libelle`,`complement`,`id_ville`,`adresse_facturation`,"
                + "`adresse_livraison`,`id_acteur`) VALUES (?,?,?,?,?,?)";
        jdbcTemplate.update(sql,
                new Object[] {paramAdresse.getLibelle(), paramAdresse.getComplementAdresse(),
                        paramAdresse.getVille().getIdVille(), paramAdresse.getAdresseFacturation(),
                        paramAdresse.getAdresseLivraison(), paramIdActeur });
    }

    @Override
    public void updateAdresse(Adresse paramAdresse) {
        String sql = "UPDATE `bdd_dionychus`.`adresse` SET `libelle`=?, `complement`=?, `id_ville`=?,"
                + " `adresse_facturation`=?, `adresse_livraison`=? WHERE `id_adresse`=?";
        jdbcTemplate.update(sql,
                new Object[] {paramAdresse.getLibelle(), paramAdresse.getComplementAdresse(),
                        paramAdresse.getVille().getIdVille(), paramAdresse.getAdresseFacturation(),
                        paramAdresse.getAdresseLivraison(), paramAdresse.getIdAdresse() });
    }

    @Override
    public void deleteAdresse(Integer paramIdAdresse) {
        String sql = "DELETE FROM adresse WHERE id_adresse = ?";
        jdbcTemplate.update(sql, new Object[] {paramIdAdresse });
    }

}
