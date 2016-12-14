package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.afcepf.al29.dionychus.data.itf.VinDaoItf;
import fr.afcepf.al29.dionychus.entity.Arome;
import fr.afcepf.al29.dionychus.entity.Cepage;
import fr.afcepf.al29.dionychus.entity.Vin;
import fr.afcepf.al29.dionychus.mapper.VinMapper;

public class VinDaoImpl implements VinDaoItf {

	JdbcTemplate jdbcTemplate;
	DataSource dataSource;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Vin> getAll() {
		String SQL = "SELECT a.id_article, a.reference, a.libelle, a.description, a.prix, a.annee, a.quantite, a.seuil_alerte, a.url_image, "
				+ "a.id_region, r.libelle, a.id_type_vin, tv.libelle, a.id_appelation, ap.libelle, a.type_article "
				+ "FROM article a " + "INNER JOIN region r ON a.id_region = r.id_region "
				+ "INNER JOIN type_vin tv ON a.id_type_vin = tv.id_type_vin "
				+ "INNER JOIN appelation ap ON a.id_appelation = ap.id_appelation";
		return jdbcTemplate.query(SQL, new VinMapper());
	}

	@Override
	public Vin getById(Integer paramIdVin) {
		String SQL = "SELECT a.id_article, a.reference, a.libelle, a.description, a.prix, a.annee, a.quantite, a.seuil_alerte, a.url_image, "
				+ "a.id_region, r.libelle, a.id_type_vin, tv.libelle, a.id_appelation, ap.libelle, a.type_article "
				+ "FROM article a " + "INNER JOIN region r ON a.id_region = r.id_region "
				+ "INNER JOIN type_vin tv ON a.id_type_vin = tv.id_type_vin"
				+ "INNER JOIN appelation ap ON a.id_appelation = ap.id_appelation" + "WHERE a.id_article = ?";
		return jdbcTemplate.queryForObject(SQL, new Object[] { paramIdVin }, new VinMapper());
	}

	public Integer getIdByReference(String paramReferenceVin) {
		String SQL = "SELECT v.id_article FROM article v WHERE v.reference = ?";
		return jdbcTemplate.queryForInt(SQL, new Object[] { paramReferenceVin });
	}

	@Override
	public void addVin(Vin paramVin) {
		String SQLaddVin = "INSERT INTO `bdd_dionychus`.`article` (`reference`, `libelle`, `description`, `prix`, `annee`, `quantite`, `seuil_alerte`, `url_image`, `id_type_vin`, `id_appelation`, `id_region`, `type_article`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(SQLaddVin,
				new Object[] { paramVin.getReference(), paramVin.getLibelle(), paramVin.getDescription(),
						paramVin.getPrix(), paramVin.getAnnee(), paramVin.getQuantite(), paramVin.getSeuilAlerte(),
						paramVin.getUrlImage(), paramVin.getTypeVin().getIdTypeVin(),
						paramVin.getAppelation().getIdAppelation(), paramVin.getRegion().getIdRegion(),
						paramVin.getTypeArticle() });
		String SQLaddAromes = "INSERT INTO `bdd_dionychus`.`vin_arome` (`id_article`, `id_arome`) VALUES (?,?)";
		String SQLaddCepages = "INSERT INTO `bdd_dionychus`.`vin_cepage` (`id_article`, `id_cepage`) VALUES (?,?)";
		Integer idVin = getIdByReference(paramVin.getReference());
		for (Arome arome : paramVin.getAromes()) {
			jdbcTemplate.update(SQLaddAromes, new Object[] { idVin, arome.getIdArome() });
		}
		for (Cepage cepage : paramVin.getCepages()) {
			jdbcTemplate.update(SQLaddCepages, new Object[] { idVin, cepage.getIdCepage() });
		}
	}

	@Override
	public void updateVin(Vin paramVin) {
		String SQLupdateVin = "UPDATE `bdd_dionychus`.`article` SET `reference`=?, `libelle`=?, `description`=?, `prix`=?, `annee`=?, `quantite`=?, `seuil_alerte`=?, `url_image`=?, `id_type_vin`=?, `id_appelation`=?, `id_region`=? WHERE `id_article`=?";
		jdbcTemplate.update(SQLupdateVin,
				new Object[] { paramVin.getReference(), paramVin.getLibelle(), paramVin.getDescription(),
						paramVin.getPrix(), paramVin.getAnnee(), paramVin.getQuantite(), paramVin.getSeuilAlerte(),
						paramVin.getUrlImage(), paramVin.getTypeVin().getIdTypeVin(),
						paramVin.getAppelation().getIdAppelation(), paramVin.getRegion().getIdRegion(),
						paramVin.getIdArticle() });
		String SQLupdateArome = "UPDATE `bdd_dionychus`.`vin_arome` SET `id_arome`=? WHERE `id_article`=?";
		String SQLupdateCepage = "UPDATE `bdd_dionychus`.`vin_cepage` SET `id_cepage`=? WHERE `id_article`=?";
		for (Arome arome : paramVin.getAromes()) {
			jdbcTemplate.update(SQLupdateArome, new Object[] { arome.getIdArome(), paramVin.getIdArticle() });
		}
		for (Cepage cepage : paramVin.getCepages()) {
			jdbcTemplate.update(SQLupdateCepage, new Object[] { cepage.getIdCepage(), paramVin.getIdArticle() });
		}

	}

	@Override
	public void deleteVin(Integer paramIdVin) {
		String SQLdeleteVinArome = "DELETE FROM `bdd_dionychus`.`vin_arome` WHERE id_article =?";
		jdbcTemplate.update(SQLdeleteVinArome, new Object[] { paramIdVin });
		String SQLdeleteVinCepage = "DELETE FROM `bdd_dionychus`.`vin_cepage` WHERE id_article =?";
		jdbcTemplate.update(SQLdeleteVinCepage, new Object[] { paramIdVin });
		String SQLdeleteVin = "DELETE FROM `bdd_dionychus`.`article` WHERE id_article = ?";
		jdbcTemplate.update(SQLdeleteVin, new Object[] { paramIdVin });

	}

}
