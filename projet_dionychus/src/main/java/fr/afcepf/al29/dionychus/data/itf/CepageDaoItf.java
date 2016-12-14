package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Cepage;

public interface CepageDaoItf {
	List<Cepage> getAll();
	List<Cepage> getCepageByIdVin(int paramIdVin);
	
}
