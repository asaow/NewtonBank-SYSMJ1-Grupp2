package bank;
import java.util.ArrayList;

/**
 * Klassen Customer innehåller en kunds namn, personnummer och en lista på kundens konton
 * Finns publika metoder som lägger till och tar bort konton från listan
 *
 */
public class Customer {
	private String name;
	private long pNr;
	private ArrayList<SavingsAccount> savingsAccounts;

	public Customer(String name, long pNr){
		this.name=name;
		this.pNr=pNr;
		savingsAccounts = new ArrayList<>();
	}
	
	/**
	 * Hämtar kundens namn
	 * @return namn på kund
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sätter kundens namn
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Hämtar kundens personnummer
	 * @return kundens personnummer
	 */
	public long getpNr() {
		return pNr;
	}
	
	/**
	 * Sätter kundens personnummer
	 * @param pNr
	 */
	public void setpNr(long pNr) {
		this.pNr = pNr;
	}
	
	/**
	 * Lägger till ett konto i en lista till kund 
	 * @param sa
	 */
	public void addAccount(SavingsAccount sa){
		savingsAccounts.add(sa);
	}
	
	/**
	 * Hämtar lista med alla konton
	 * @return en lista med kundens alla konton
	 */
	public ArrayList<SavingsAccount> getAccounts(){
		return savingsAccounts;
	}
	
	/**
	 * Ta bort konto från kundens lista
	 * @param sa
	 */
	public void removeAccount(SavingsAccount sa){
		savingsAccounts.remove(sa);
	}
	
	/**
	 * Hämta storlek på listan med kundens konton
	 * @return antalet konton som kunden har
	 */
	public int getNrOfAccounts(){
		return savingsAccounts.size();
	}

}
