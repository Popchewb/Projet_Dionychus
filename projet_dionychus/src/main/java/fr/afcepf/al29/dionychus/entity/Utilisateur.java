package fr.afcepf.al29.dionychus.entity;

import java.sql.Date;
/**
 * Classe qui définit le compte d'un utilisateur connecté sur l'application Dionychus.
 * @author Nicolas
 *
 */
public class Utilisateur extends Acteur {
    /**
     * La date de naissance de l'utilisateur.
     */
    private Date dateNaissance;
    /**
     * La profession de l'utilisateur.
     */
    private String profession;
    /**
     * Si l'utilisateur a choisi d'être abonné à la newsletter.
     */
    private Boolean optin;
    /**
     * Comment l'utilisateur a connu l'application Dionychus.
     */
    private String origine;
    /**
     * Le login de l'utilisateur.
     */
    private String login;
    /**
     * Le mot de passe de l'utilisateur.
     */
    private String password;
    /**
     * Type d'accès du compte utilisateur.
     */
    private TypeAcces typeAcces;
    /**
     * Constructeur par défaut.
     */
    public Utilisateur() {
        super();
    }
    /**
     * @param paramDateNaissance Date de naissance de l'utilisateur
     * @param paramProfession Profession de l'utilisateur
     * @param paramOptin Si l'utilisateur a choisi d'être abonné à la newsletter
     * @param paramOrigine Comment l'utilisateur a connu l'application Dionychus
     * @param paramLogin Login de l'utilisateur
     * @param paramPassword Mot de passe de l'utilisateur
     */
    public Utilisateur(Date paramDateNaissance, String paramProfession, Boolean paramOptin, String paramOrigine,
            String paramLogin, String paramPassword, TypeAcces paramTypeAcces) {
        super();
        dateNaissance = paramDateNaissance;
        profession = paramProfession;
        optin = paramOptin;
        origine = paramOrigine;
        login = paramLogin;
        password = paramPassword;
        typeAcces = paramTypeAcces;
    }

    /**
     * @return La date de naissance de l'utilisateur
     */
    public Date getDateNaissance() {
        return dateNaissance;
    }
    /**
     * @param paramDateNaissance La nouvelle date de naissance de l'utilisateur
     */
    public void setDateNaissance(Date paramDateNaissance) {
        dateNaissance = paramDateNaissance;
    }
    /**
     * @return La profession de l'utilisateur
     */
    public String getProfession() {
        return profession;
    }
    /**
     * @param paramProfession La nouvelle profession de l'utilisateur
     */
    public void setProfession(String paramProfession) {
        profession = paramProfession;
    }
    /**
     * @return Si l'utilisateur a choisi d'être abonné à la newsletter
     */
    public Boolean getOptin() {
        return optin;
    }
    /**
     * @param paramOptin Le nouveau choix d'abonnement de l'utilisateur à la newsletter
     */
    public void setOptin(Boolean paramOptin) {
        optin = paramOptin;
    }
    /**
     * @return Comment l'utilisateur a connu l'application Dionychus
     */
    public String getOrigine() {
        return origine;
    }
    /**
     * @param paramOrigine La nouvelle valeur sur la façon dont l'utilisateur a connu l'application Dionychus
     */
    public void setOrigine(String paramOrigine) {
        origine = paramOrigine;
    }
    /**
     * @return Le login de l'utilisateur
     */
    public String getLogin() {
        return login;
    }
    /**
     * @param paramLogin Le nouveau login de l'utilisateur
     */
    public void setLogin(String paramLogin) {
        login = paramLogin;
    }
    /**
     * @return Le mot de passe de l'utilisateur
     */
    public String getPassword() {
        return password;
    }
    /**
     * @param paramPassword Le nouveau mot de passe de l'utilisateur
     */
    public void setPassword(String paramPassword) {
        password = paramPassword;
    }
    /**
     * @return Type d'accès du compte utilisateur
     */
    public TypeAcces getTypeAcces() {
        return typeAcces;
    }
    /**
     * @param paramTypeAcces Le nouveau type d'accès du compte utilisateur
     */
    public void setTypeAcces(TypeAcces paramTypeAcces) {
        typeAcces = paramTypeAcces;
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
        result = prime * result;
        if (dateNaissance != null) {
            result += dateNaissance.hashCode();
        }
        result = prime * result;
        if (login != null) {
            result += login.hashCode();
        }
        result = prime * result;
        if (optin != null) {
            result += optin.hashCode();
        }
        result = prime * result;
        if (origine != null) {
            result += origine.hashCode();
        }
        result = prime * result;
        if (password != null) {
            result += password.hashCode();
        }
        result = prime * result;
        if (profession != null) {
            result += profession.hashCode();
        }
        result = prime * result;
        if (typeAcces != null) {
            result += typeAcces.hashCode();
        }
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Utilisateur other = (Utilisateur) obj;
        if (dateNaissance == null) {
            if (other.dateNaissance != null) {
                return false;
            }
        } else if (!dateNaissance.equals(other.dateNaissance)) {
            return false;
        }
        if (login == null) {
            if (other.login != null) {
                return false;
            }
        } else if (!login.equals(other.login)) {
            return false;
        }
        if (optin == null) {
            if (other.optin != null) {
                return false;
            }
        } else if (!optin.equals(other.optin)) {
            return false;
        }
        if (origine == null) {
            if (other.origine != null) {
                return false;
            }
        } else if (!origine.equals(other.origine)) {
            return false;
        }
        if (password == null) {
            if (other.password != null) {
                return false;
            }
        } else if (!password.equals(other.password)) {
            return false;
        }
        if (profession == null) {
            if (other.profession != null) {
                return false;
            }
        } else if (!profession.equals(other.profession)) {
            return false;
        }
        if (typeAcces == null) {
            if (other.typeAcces != null) {
                return false;
            }
        } else if (!typeAcces.equals(other.typeAcces)) {
            return false;
        }
        return true;
    }
}
