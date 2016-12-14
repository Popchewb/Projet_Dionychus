package fr.afcepf.al29.dionychus.entity;

import java.sql.Date;

public class Promotion {
	private Integer idPromotion;
	private String libelle;
	private Date dateDebut;
	private Date dateFin;
	private Double remise;
	private Double tarification;

	public Promotion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Promotion(Integer idPromotion, String libelle, Date dateDebut, Date dateFin, Double remise,
			Double tarification) {
		super();
		this.idPromotion = idPromotion;
		this.libelle = libelle;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.remise = remise;
		this.tarification = tarification;
	}

	public Integer getIdPromotion() {
		return idPromotion;
	}

	public void setIdPromotion(Integer idPromotion) {
		this.idPromotion = idPromotion;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Double getRemise() {
		return remise;
	}

	public void setRemise(Double remise) {
		this.remise = remise;
	}

	public Double getTarification() {
		return tarification;
	}

	public void setTarification(Double tarification) {
		this.tarification = tarification;
	}

	@Override
	public String toString() {
		return "Promotion [idPromotion=" + idPromotion + ", libelle=" + libelle + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + ", remise=" + remise + ", tarification=" + tarification + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateDebut == null) ? 0 : dateDebut.hashCode());
		result = prime * result + ((dateFin == null) ? 0 : dateFin.hashCode());
		result = prime * result + ((idPromotion == null) ? 0 : idPromotion.hashCode());
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		result = prime * result + ((remise == null) ? 0 : remise.hashCode());
		result = prime * result + ((tarification == null) ? 0 : tarification.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Promotion other = (Promotion) obj;
		if (dateDebut == null) {
			if (other.dateDebut != null)
				return false;
		} else if (!dateDebut.equals(other.dateDebut))
			return false;
		if (dateFin == null) {
			if (other.dateFin != null)
				return false;
		} else if (!dateFin.equals(other.dateFin))
			return false;
		if (idPromotion == null) {
			if (other.idPromotion != null)
				return false;
		} else if (!idPromotion.equals(other.idPromotion))
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		if (remise == null) {
			if (other.remise != null)
				return false;
		} else if (!remise.equals(other.remise))
			return false;
		if (tarification == null) {
			if (other.tarification != null)
				return false;
		} else if (!tarification.equals(other.tarification))
			return false;
		return true;
	}

}