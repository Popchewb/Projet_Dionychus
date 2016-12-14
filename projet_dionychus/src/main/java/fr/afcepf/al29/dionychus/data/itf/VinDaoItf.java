package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Vin;

public interface VinDaoItf {
	List<Vin> getAll();

	Vin getById(Integer paramIdVin);

	void addVin(Vin paramVin);

	void updateVin(Vin paramVin);

	void deleteVin(Integer paramIdVin);
}