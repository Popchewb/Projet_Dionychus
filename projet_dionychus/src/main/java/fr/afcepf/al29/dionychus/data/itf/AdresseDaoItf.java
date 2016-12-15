package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Adresse;

public interface AdresseDaoItf {

	List<Adresse> getAll();

	Adresse getAdresseById(Integer paramIdAdresse);

	List<Adresse> getAdresseByIdActeur(Integer paramIdActeur);

	void addAdresse(Adresse paramAdresse, Integer paramIdActeur);

	void updateAdresse(Adresse paramAdresse);

	void deleteAdresse(Integer paramIdAdresse);

}
