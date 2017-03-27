package fr.afcepf.al29.dionychus.entity;

import java.util.List;
/**
 * Classe qui permet de définit les caractéristiques d'un vin.
 * @author Nicolas
 *
 */
public class Vin extends Article {
    /**
     * L'année de production du vin.
     */
    private Integer annee;
    /**
     * L'appellation du vin.
     */
    private Appelation appelation;
    /**
     * La région de provenance du vin.
     */
    private Region region;
    /**
     * Le type de vin.
     */
    private TypeVin typeVin;
    /**
     * Les arômes présents dans ce vin.
     */
    private List<Arome> aromes;
    /**
     * Les cépages dont sont issus le raisin.
     */
    private List<Cepage> cepages;
    /**
     * Constructeur par défaut.
     */
    public Vin() {
        super();
    }
    /**
     * @return L'année de production du vin
     */
    public Integer getAnnee() {
        return annee;
    }
    /**
     * @param paramAnnee La nouvelle année de production du vin
     */
    public void setAnnee(Integer paramAnnee) {
        annee = paramAnnee;
    }
    /**
     * @return L'appellation du vin
     */
    public Appelation getAppelation() {
        return appelation;
    }
    /**
     * @param paramAppelation La nouvelle appellation du vin
     */
    public void setAppelation(Appelation paramAppelation) {
        appelation = paramAppelation;
    }
    /**
     * @return La région de provenance du vin
     */
    public Region getRegion() {
        return region;
    }
    /**
     * @param paramRegion La nouvelle région de provenance du vin
     */
    public void setRegion(Region paramRegion) {
        region = paramRegion;
    }
    /**
     * @return Le type de vin
     */
    public TypeVin getTypeVin() {
        return typeVin;
    }
    /**
     * @param paramTypeVin Le nouveau type de vin
     */
    public void setTypeVin(TypeVin paramTypeVin) {
        typeVin = paramTypeVin;
    }
    /**
     * @return Les arômes présents dans le vin
     */
    public List<Arome> getAromes() {
        return aromes;
    }
    /**
     * @param paramAromes Les nouveaux arômes présents dans le vin
     */
    public void setAromes(List<Arome> paramAromes) {
        aromes = paramAromes;
    }
    /**
     * @return Les cépages dont sont issus le raisin.
     */
    public List<Cepage> getCepages() {
        return cepages;
    }
    /**
     * @param paramCepages Les nouveaux cépages dont sont issus le raisin.
     */
    public void setCepages(List<Cepage> paramCepages) {
        cepages = paramCepages;
    }
    @Override
    public String toString() {
        return "Vin [annee=" + annee + ", appelation=" + appelation + ", region=" + region + ", typeVin=" + typeVin
                + ", aromes=" + aromes + ", cepages=" + cepages + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result;
        if (annee != null) {
            result += annee.hashCode();
        }
        result = prime * result;
        if (appelation != null) {
            result += appelation.hashCode();
        }
        result = prime * result;
        if (aromes != null) {
            result += aromes.hashCode();
        }
        result = prime * result;
        if (cepages != null) {
            result += cepages.hashCode();
        }
        result = prime * result;
        if (region != null) {
            result += region.hashCode();
        }
        result = prime * result;
        if (typeVin != null) {
            result += typeVin.hashCode();
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
        Vin other = (Vin) obj;
        if (annee == null) {
            if (other.annee != null) {
                return false;
            }
        } else if (!annee.equals(other.annee)) {
            return false;
        }
        if (appelation == null) {
            if (other.appelation != null) {
                return false;
            }
        } else if (!appelation.equals(other.appelation)) {
            return false;
        }
        if (aromes == null) {
            if (other.aromes != null) {
                return false;
            }
        } else if (!aromes.equals(other.aromes)) {
            return false;
        }
        if (cepages == null) {
            if (other.cepages != null) {
                return false;
            }
        } else if (!cepages.equals(other.cepages)) {
            return false;
        }
        if (region == null) {
            if (other.region != null) {
                return false;
            }
        } else if (!region.equals(other.region)) {
            return false;
        }
        if (typeVin == null) {
            if (other.typeVin != null) {
                return false;
            }
        } else if (!typeVin.equals(other.typeVin)) {
            return false;
        }
        return true;
    }
}
