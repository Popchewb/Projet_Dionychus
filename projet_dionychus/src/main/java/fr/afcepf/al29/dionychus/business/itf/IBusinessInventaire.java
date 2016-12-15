package fr.afcepf.al29.dionychus.business.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Accessoire;
import fr.afcepf.al29.dionychus.entity.Appelation;
import fr.afcepf.al29.dionychus.entity.Arome;
import fr.afcepf.al29.dionychus.entity.Cepage;
import fr.afcepf.al29.dionychus.entity.Region;
import fr.afcepf.al29.dionychus.entity.TypeVin;
import fr.afcepf.al29.dionychus.entity.Vin;

public interface IBusinessInventaire {

	List<Accessoire> getAllAccessoires();

	List<Vin> getAllVins();

	List<Arome> getAllAromes();

	List<Cepage> getAllCepages();

	List<Region> getAllRegions();

	List<Appelation> getAllAppellation();

	List<TypeVin> getAllTypeVins();

	Region getRegionById(Integer region);

	Appelation getAppellationById(Integer appellation);

	TypeVin getTypeVinById(Integer typeVin);

	Arome getAromeById(int parseInt);

	Cepage getCepageById(int parseInt);

	void ajouterVin(Vin vin);
	
}
