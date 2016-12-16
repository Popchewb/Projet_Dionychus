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
	
	@Override
	public Region addRegionWithKey(Region region) {
		GeneratedKeyHolder holder = new GeneratedKeyHolder();
		String SQL = "INSERT INTO region (libelle) VALUES (?)";
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement statetement = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
				statetement.setString(1, region.getLibelle());
				return statetement;
			}
		}, holder);
		region.setIdRegion(holder.getKey().intValue());
		return region;
	}

}
