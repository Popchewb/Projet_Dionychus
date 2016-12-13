package fr.afcepf.al29.dionychus.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.afcepf.al29.dionychus.data.itf.RegionDaoItf;
import fr.afcepf.al29.dionychus.entity.Region;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context =  new ClassPathXmlApplicationContext("classpath:Beans.xml");

		RegionDaoItf rDao = (RegionDaoItf) context.getBean("regionJDBCtemplate");

		System.out.println("Test Spring JDBC");

		Region region = rDao.getRegionById(1);
		System.out.printf("ID : %d\nNom région : %s\n_________\n", region.getIdRegion(), region.getLibelle());

		region = new Region(null, "testNicoreretestRegion2");
		rDao.addRegion(region);
		
		List<Region> regions = rDao.getAll();

		for (Region region2 : regions) {
			System.out.printf("ID : %d\nNom région : %s\n_________\n", region2.getIdRegion(), region2.getLibelle());
		}
		

	}
}
