package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.TypeVin;

public interface TypeVinDaoItf {
	List<TypeVin> getAll();
	TypeVin getTypeVinById(Integer typeVin);
}
