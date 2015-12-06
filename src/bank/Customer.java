package bank;

/**
 * Klassen lagra en kund namn och personnr
 */
public class Customer {
	private String name;
	private long pNr;

	public Customer(String name, long pNr){
		this.name=name;
		this.pNr=pNr;
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
	 * @param name namn på kunden
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Hämtar kundens personnummer
	 * @return kundens personnummer
	 */
	public long getPNr() {
		return pNr;
	}
	
	/**
	 * Sätter kundens personnummer
	 * @param pNr personnr
	 */
	public void setPNr(long pNr) {
		this.pNr = pNr;
	}	
}
