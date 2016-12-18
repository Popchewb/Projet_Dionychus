package fr.afcepf.al29.dionychus.test;

import java.math.BigInteger;
import java.security.SecureRandom;

public class MainApp {
	private static SecureRandom random = new SecureRandom();

	public static String nextSessionId() {
		return new BigInteger(48, random).toString(36).toUpperCase();
	}

	public static void main(String[] args) {
		System.out.println(nextSessionId());
		System.out.println(nextSessionId());
		System.out.println(nextSessionId());
	}
}
