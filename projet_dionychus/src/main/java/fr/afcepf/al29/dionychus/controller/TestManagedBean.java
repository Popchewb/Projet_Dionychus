package fr.afcepf.al29.dionychus.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.afcepf.al29.dionychus.business.itf.IBusinessTest;
import fr.afcepf.al29.dionychus.entity.Region;

@RequestScoped
@ManagedBean
@Controller
public class TestManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Region region;
	
	private List<Region> regions;
	
	@Autowired
	private IBusinessTest proxy;

	public List<Region> getRegions() {
		System.out.println(proxy);
		return proxy.getAll();
	}

	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

}
