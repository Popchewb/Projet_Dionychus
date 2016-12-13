package fr.afcepf.al29.dionychus.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.al29.dionychus.business.itf.IBusinessTest;
import fr.afcepf.al29.dionychus.data.itf.RegionDaoItf;
import fr.afcepf.al29.dionychus.entity.Region;

@Service("proxyBusiness")
public class BusinessTestImpl implements IBusinessTest {

	@Autowired
	private RegionDaoItf proxy;
	
	@Override
	public List<Region> getAll() {
		return proxy.getAll();
	}

	
}
