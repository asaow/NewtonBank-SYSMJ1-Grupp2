package bank;
import java.util.ArrayList;

/**
 * Klassen Helper innehåler olika hjälp metoder för att 
 * checka format på en sträng.
 *
 */
public class Helper {
	
	/**
	 * Checka om strängen är ett personnr
	 *
	 * @param pNr personnr som skall checka
	 * @return true om personnr är ett giltig nr annars false
	 */
	public static boolean isValidPNr(String pNr) {

		return true;
	}

	/**
	 * Checka om strängen är ett namn
	 *
	 * @param name namnet som skall checka
	 * @return true om namnet är giltig namn annars false
	 */
	public static boolean isValidName(String name) {

		return true;
	}

	/**
	 * Checka om strängen är ett giltig tal
	 *
	 * @param nr tal som skall checka
	 * @return true om ett tal är giltig annars false
	 */
	public static boolean isValidNr(String nr) {

		return true;
	}

	/**
	 * Checka om strängen är ett kontonr
	 *
	 * @param nr kontonr som skall checka
	 * @return true om kontonr är ett giltig nr annars false
	 */
	public static boolean isValidAccountId(String nr) {

		return true;
	}	

	/**
	 * Konvertera namnet till stora bokstäver
	 *
	 * @param name namn som skall konvertera
	 * @return namnet med stora bokstäver på första tecken
	 */
	public static String toUpperCaseLetter(String name) {

		return "new string";
	}

	/**
	 * Spara en lista med kunden namn på en fil
	 *
	 * @param name Array med namn på kunden
	 * @return true på filen har sparat annars false
	 */
	public static boolean SaveToFile(ArrayList<String> name) {

		return true;
	}
}
