package fr.afcepf.al29.dionychus.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.afcepf.al29.dionychus.business.impl.BusinessInventaireImpl;
import fr.afcepf.al29.dionychus.data.itf.RegionDaoItf;
import fr.afcepf.al29.dionychus.entity.Region;
import fr.afcepf.al29.dionychus.entity.Vin;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context =  new ClassPathXmlApplicationContext("classpath:Beans.xml");

		RegionDaoItf rDao = (RegionDaoItf) context.getBean("regionJDBCtemplate");
		BusinessInventaireImpl buInventaire = new BusinessInventaireImpl();

		System.out.println("Test Spring JDBC");

		Region region = rDao.getRegionById(1);
		System.out.printf("ID : %d\nNom région : %s\n_________\n", region.getIdRegion(), region.getLibelle());

//		region = new Region(null, "testNicoreretestRegion2");
//		rDao.addRegion(region);
		
		List<Region> regions = rDao.getAll();

		for (Region region2 : regions) {
			System.out.printf("ID : %d\nNom région : %s\n_________\n", region2.getIdRegion(), region2.getLibelle());
		}
		
		List<Vin> vins = buInventaire.getAllVin();
		for (Vin vin : vins) {
			System.out.println(vin);
		}

	}
}
