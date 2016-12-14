package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Ville;

public interface VilleDaoItf {
	List<Ville> getAll();
	List<Ville> getAllByIdPays(Integer paramIdPays);
}
