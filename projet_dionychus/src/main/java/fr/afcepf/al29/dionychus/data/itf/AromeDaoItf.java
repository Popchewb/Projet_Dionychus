package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Arome;

public interface AromeDaoItf {
	List<Arome> getAll();
	List<Arome> getAromeByIdVin(int paramIdVin);
}
