package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.afcepf.al29.dionychus.data.itf.PromotionDaoItf;
import fr.afcepf.al29.dionychus.entity.Promotion;
import fr.afcepf.al29.dionychus.mapper.PromotionMapper;

public class PromotionDaoImpl implements PromotionDaoItf {

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
	public List<Promotion> getAll() {
		String SQL = "SELECT p.id_promotion, p.libelle, p.date_debut, p.date_fin,p.tarification,p.remise FROM promotion p ORDER BY p.date_fin";
		return jdbcTemplate.query(SQL, new PromotionMapper());
	}

	@Override
	public void addPromotion(Promotion paramPromotion) {
		String SQL = "INSERT INTO `bdd_dionychus`.`promotion` (`libelle`, `date_debut`, `date_fin`, `tarification`, `remise`) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(SQL, new Object[] { paramPromotion.getLibelle(), paramPromotion.getDateDebut(),
				paramPromotion.getDateFin(), paramPromotion.getTarification(), paramPromotion.getRemise() });
	}

	@Override
	public void updatePromotion(Promotion paramPromotion) {
		String SQL = "UPDATE `bdd_dionychus`.`promotion` SET `libelle`=?, `date_debut`=?, `date_fin`=?, `tarification`=?, `remise`=? WHERE `id_promotion`=?;";
		jdbcTemplate.update(SQL,
				new Object[] { paramPromotion.getLibelle(), paramPromotion.getDateDebut(), paramPromotion.getDateFin(),
						paramPromotion.getTarification(), paramPromotion.getRemise(),
						paramPromotion.getIdPromotion() });
	}

	@Override
	public void deletePromotion(Integer paramIdPromotion) {
		String SQL = "DELETE FROM `bdd_dionychus`.`promotion` WHERE id_promotion = ?"; 
		jdbcTemplate.update(SQL, new Object[]{paramIdPromotion});

	}

}
