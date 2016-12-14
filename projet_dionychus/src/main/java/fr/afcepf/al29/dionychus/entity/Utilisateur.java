package fr.afcepf.al29.dionychus.entity;

import java.sql.Date;
import java.util.List;

public class Utilisateur extends Acteur {
	private Date dateNaissance;
	private String profession;
	private Boolean optin;
	private String origine;
	private String login;
	private String password;
	private TypeAcces typeAcces;
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Utilisateur(Integer idActeur, String nom, String prenom, String numeroTelephone, String adresseMail,
			String civilite, List<Adresse> adresses) {
		super(idActeur, nom, prenom, numeroTelephone, adresseMail, civilite, adresses);
		// TODO Auto-generated constructor stub
	}
	public Utilisateur(Integer idActeur, String nom, String prenom, String numeroTelephone, String adresseMail,
			String civilite, List<Adresse> adresses, Date dateNaissance, String profession, Boolean optin,
			String origine, String login, String password, TypeAcces typeAcces) {
		super(idActeur, nom, prenom, numeroTelephone, adresseMail, civilite, adresses);
		this.dateNaissance = dateNaissance;
		this.profession = profession;
		this.optin = optin;
		this.origine = origine;
		this.login = login;
		this.password = password;
		this.typeAcces = typeAcces;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public Boolean getOptin() {
		return optin;
	}
	public void setOptin(Boolean optin) {
		this.optin = optin;
	}
	public String getOrigine() {
		return origine;
	}
	public void setOrigine(String origine) {
		this.origine = origine;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public TypeAcces getTypeAcces() {
		return typeAcces;
	}
	public void setTypeAcces(TypeAcces typeAcces) {
		this.typeAcces = typeAcces;
	}
	@Override
	public String toString() {
		return "Utilisateur [dateNaissance=" + dateNaissance + ", profession=" + profession + ", optin=" + optin
				+ ", origine=" + origine + ", login=" + login + ", password=" + password + ", typeAcces=" + typeAcces
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dateNaissance == null) ? 0 : dateNaissance.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((optin == null) ? 0 : optin.hashCode());
		result = prime * result + ((origine == null) ? 0 : origine.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((profession == null) ? 0 : profession.hashCode());
		result = prime * result + ((typeAcces == null) ? 0 : typeAcces.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		if (dateNaissance == null) {
			if (other.dateNaissance != null)
				return false;
		} else if (!dateNaissance.equals(other.dateNaissance))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (optin == null) {
			if (other.optin != null)
				return false;
		} else if (!optin.equals(other.optin))
			return false;
		if (origine == null) {
			if (other.origine != null)
				return false;
		} else if (!origine.equals(other.origine))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (profession == null) {
			if (other.profession != null)
				return false;
		} else if (!profession.equals(other.profession))
			return false;
		if (typeAcces == null) {
			if (other.typeAcces != null)
				return false;
		} else if (!typeAcces.equals(other.typeAcces))
			return false;
		return true;
	}
	
	
	
	
	
}
