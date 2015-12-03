package bank;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

/**
 * Klassen Helper innehåler olika hjälp metoder för att 
 * checka format på en sträng.
 */
public class Helper {
	
	/**
	 * Checka om strängen är ett personnr
	 *
	 * @param pNr personnr som skall checka
	 * @return true om personnr är ett giltig nr annars false
	 */
	public static boolean isValidPNr(String pNr) {
		if (pNr.length() != 12)
			return false;
		
		for (int i = 0; i < pNr.length(); i++) {
			if (!Character.isDigit(pNr.charAt(i))) 
				return false;
		}

		String year = pNr.substring(0, 4);
		int y = Integer.parseInt(year);

		String month = pNr.substring(4, 6);
		int m = Integer.parseInt(month);		

		String date = pNr.substring(6, 8);
		int d = Integer.parseInt(date);	

		String lastFour = pNr.substring(8, 12);
		int lf = Integer.parseInt(lastFour);

		if (y>=1900 && y<=2015 && m>=1 && m<=12 && d>=1 && d<=31 && lf>0 && lf<=9999) {
			return true;
		}

		return false;
	}

	/**
	 * Checka om strängen är ett namn
	 *
	 * @param name namnet som skall checka
	 * @return true om namnet är giltig namn annars false
	 */
	public static boolean isValidName(String name) {

		String[] wordArray = name.split(" ");
		int wordCount = wordArray.length;
	
		if (wordCount > 1 && wordCount < 5 ) {
			if (name.matches("[a-zåäöA-ZÅÄÖ ]+"))
			      return true;
		} 
			
		return false;
	}

	/**
	 * Checka om strängen är ett giltig tal
	 *
	 * @param nr tal som skall checka
	 * @return true om ett tal är giltig annars false
	 */
	public static boolean isValidNr(String nr) {
		try {
			Double num = Double.parseDouble(nr);
			//String ss = num.toString().toString();
			String[] arrName = num.toString().split("\\.");

			if(!(arrName[1].length()<=2))
				return false;

			if(nr.endsWith("."))
				return false;
			
		} catch(NumberFormatException ex) {
			return false;
		}

		return true;
	}

	/**
	 * Checka om strängen är ett kontonr
	 *
	 * @param nr kontonr som skall checka
	 * @return true om kontonr är ett giltig nr annars false
	 */
	public static boolean isValidAccountId(String nr) {
		try {
			int number = Integer.parseInt(nr);
			if (number > 1000)	return true;
		
		} catch (NumberFormatException ex) {	
		}
		
		return false;
	}	

	/**
	 * Konvertera namnet till stora bokstäver
	 *
	 * @param name namn som skall konvertera
	 * @return namnet med stora bokstäver på första tecken
	 */
	public static String toUpperCaseLetter(String name) {
		String[] arrWord = name.split(" ");
		
		for (int i=0; i< arrWord.length; i++)
			arrWord[i] = arrWord[i].substring(0,1).toUpperCase() + arrWord[i].substring(1); 
		
		return String.join(" ", arrWord);
	}

	/**
	 * Spara till fil
	 *
	 * @param path sökväg till filen
	 * @param data sträng som skall spara
	 * @return true om filen lyckas sparat annars false
	 */
	public static boolean saveToFile(Path path, String data) {

		try {
			Files.write(path, data.getBytes("utf-8"), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
			return true;
		} catch (IOException ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
