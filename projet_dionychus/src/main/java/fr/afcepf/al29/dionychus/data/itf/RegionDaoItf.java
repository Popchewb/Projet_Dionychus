package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Region;

public interface RegionDaoItf {
	Region getRegionById(Integer idRegion);
	List<Region> getAll();
	void addRegion(Region region);
}
