package fr.afcepf.al29.dionychus.business.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Accessoire;
import fr.afcepf.al29.dionychus.entity.Vin;

public interface IBusinessInventaire {

	List<Accessoire> getAllAccessoires();

	List<Vin> getAllVins();
	
}
