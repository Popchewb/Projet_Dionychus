package fr.afcepf.al29.dionychus.business.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import fr.afcepf.al29.dionychus.business.itf.IBusinessInventaire;
import fr.afcepf.al29.dionychus.data.itf.AccessoireDaoItf;
import fr.afcepf.al29.dionychus.data.itf.AppelationDaoItf;
import fr.afcepf.al29.dionychus.data.itf.AromeDaoItf;
import fr.afcepf.al29.dionychus.data.itf.CepageDaoItf;
import fr.afcepf.al29.dionychus.data.itf.RegionDaoItf;
import fr.afcepf.al29.dionychus.data.itf.TypeVinDaoItf;
import fr.afcepf.al29.dionychus.data.itf.VinDaoItf;
import fr.afcepf.al29.dionychus.entity.Accessoire;
import fr.afcepf.al29.dionychus.entity.Appelation;
import fr.afcepf.al29.dionychus.entity.Arome;
import fr.afcepf.al29.dionychus.entity.Cepage;
import fr.afcepf.al29.dionychus.entity.Region;
import fr.afcepf.al29.dionychus.entity.TypeVin;
import fr.afcepf.al29.dionychus.entity.Vin;

@Service("proxyBusinessInventaire")
public class BusinessInventaireImpl implements IBusinessInventaire {

	ApplicationContext context =  new ClassPathXmlApplicationContext("classpath:Beans.xml");
	
	private AccessoireDaoItf proxyDaoAccessoire = (AccessoireDaoItf) context.getBean("accessoireJDBCtemplate");
	
	private VinDaoItf proxyDaoVin = (VinDaoItf) context.getBean("vinJDBCtemplate");
	
	private AromeDaoItf proxyDaoArome = (AromeDaoItf) context.getBean("aromeJDBCtemplate");
	
	private CepageDaoItf proxyDaoCepage = (CepageDaoItf) context.getBean("cepageJDBCtemplate");
	
	private RegionDaoItf proxyDaoRegion = (RegionDaoItf) context.getBean("regionJDBCtemplate");
	
	private AppelationDaoItf proxyDaoAppellation = (AppelationDaoItf) context.getBean("appelationJDBCtemplate");
	
	private TypeVinDaoItf proxyDaoTypeVin = (TypeVinDaoItf) context.getBean("typeVinJDBCtemplate");
	
	@Override
	public List<Accessoire> getAllAccessoires() {
		return proxyDaoAccessoire.getAll();
	}

	@Override
	public List<Vin> getAllVins() {
		return proxyDaoVin.getAll();
	}

	@Override
	public List<Arome> getAllAromes() {
		return proxyDaoArome.getAll();
	}

	@Override
	public List<Cepage> getAllCepages() {
		return proxyDaoCepage.getAll();
	}

	@Override
	public List<Region> getAllRegions() {
		return proxyDaoRegion.getAll();
	}

	@Override
	public List<Appelation> getAllAppellation() {
		return proxyDaoAppellation.getAll();
	}

	@Override
	public List<TypeVin> getAllTypeVins() {
		return proxyDaoTypeVin.getAll();
	}

	@Override
	public Region getRegionById(Integer region) {
		return proxyDaoRegion.getRegionById(region);
	}

	@Override
	public Appelation getAppellationById(Integer appellation) {
		return proxyDaoAppellation.getAppelationById(appellation);
	}

	@Override
	public TypeVin getTypeVinById(Integer typeVin) {
		return proxyDaoTypeVin.getTypeVinById(typeVin);
	}

	@Override
	public Arome getAromeById(int aromeId) {
		return proxyDaoArome.getAromeById(aromeId);
	}

	@Override
	public Cepage getCepageById(int cepageId) {
		return proxyDaoCepage.getCepageById(cepageId);
	}

	@Override
	public void ajouterVin(Vin vin) {
		proxyDaoVin.addVin(vin);
	}

}
