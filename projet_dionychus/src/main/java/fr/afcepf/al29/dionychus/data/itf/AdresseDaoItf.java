package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Adresse;

public interface AdresseDaoItf {
	List<Adresse> getAll();
	Adresse getById(Integer paramIdAdresse);
	List<Adresse> getAdresseByIdActeur(Integer paramIdActeur);
}
