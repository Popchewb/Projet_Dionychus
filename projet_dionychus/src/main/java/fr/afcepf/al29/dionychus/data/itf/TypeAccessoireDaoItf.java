package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.TypeAccessoire;

public interface TypeAccessoireDaoItf {
	List<TypeAccessoire> getAll();
	TypeAccessoire getById(Integer paramIdTypeAccessoire);
}
