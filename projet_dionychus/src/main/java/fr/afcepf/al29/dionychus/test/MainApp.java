package fr.afcepf.al29.dionychus.test;

import java.math.BigInteger;
import java.security.SecureRandom;
/**
 * Une autre classe de test de qualit�.
 * @author ecala
 *
 */
public final class MainApp {
    /**
     * Constructeur par d�faut.
     */
    private MainApp() {
        super();
    }
    /**
     * Permet de g�n�rer un nombre al�atoire.
     */
    private static SecureRandom random = new SecureRandom();
    /**
     * Taille code session.
     */
    private static final int TAILLE_CODE_SESSION = 48;
    /**
     * Taille conversion code.
     */
    private static final int TAILLE_CONVERSION_CODE = 36;
    /**
    *
    * @return l'id de la prochaine session.
    */
    public static String nextSessionId() {
        return new BigInteger(TAILLE_CODE_SESSION, random).toString(TAILLE_CONVERSION_CODE).toUpperCase();
    }

    /**
     * M�thode main.
     *
     * @param args
     *            to set.
     */
    public static void main(String[] args) {
        System.out.println(nextSessionId());
        System.out.println(nextSessionId());
        System.out.println(nextSessionId());
    }
}
