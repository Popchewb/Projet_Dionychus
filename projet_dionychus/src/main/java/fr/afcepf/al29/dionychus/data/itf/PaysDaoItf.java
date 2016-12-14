package fr.afcepf.al29.dionychus.data.itf;

import java.util.List;

import fr.afcepf.al29.dionychus.entity.Pays;

public interface PaysDaoItf {
	List<Pays> getAll();
	Pays getPaysByIdVille(Integer paramIdVille);
}
