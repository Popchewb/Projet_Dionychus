package fr.afcepf.al29.dionychus.data.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import fr.afcepf.al29.dionychus.data.itf.RegionDaoItf;
import fr.afcepf.al29.dionychus.entity.Region;
import fr.afcepf.al29.dionychus.mapper.RegionMapper;

public class RegionDaoImpl implements RegionDaoItf {
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;

	public RegionDaoImpl() {
		super();
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Region> getAll() {
		String SQL = "SELECT id_region, libelle FROM region ORDER BY libelle";
		List<Region> regions = jdbcTemplate.query(SQL, new RegionMapper());
		return regions;
	}

	@Override
	public Region getRegionById(Integer idRegion) {
		String SQL = "SELECT id_region, libelle FROM region WHERE id_region = ? ORDER BY libelle";
		Region region = jdbcTemplate.queryForObject(SQL, new Object[] { idRegion }, new RegionMapper());
		return region;
	}

	@Override
	public void addRegion(Region region) {
		String SQL = "INSERT INTO region (libelle) VALUES (?)";
		jdbcTemplate.update(SQL, region.getLibelle());
	}

}
