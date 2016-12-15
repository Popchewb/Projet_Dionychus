package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Appelation;

public interface AppelationDaoItf {
	List<Appelation> getAll();
	List<Appelation> getAppelationByIdVin(int paramIdVin);
	Appelation getAppelationById(Integer appellation);
}
