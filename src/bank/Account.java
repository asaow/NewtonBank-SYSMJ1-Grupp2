package bank;

public abstract class Account {
	private double balance;
	private double rate;
	private int accountId;
	private String type;

	/**
	 * Konstruktor
	 * 
	 * @param accountId
	 */
	public Account(int accountId) {
		this.accountId = accountId;
		balance = 0;
	}

	/**
	 * @return saldo på konto
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @return ränta på konto
	 */
	public double getRate() {
		return rate;
	}

	/**
	 * @return kontonr
	 */
	public int getId() {
		return accountId;
	}

	/**
	 * sätta ränta på konto
	 * 
	 * @param rate ränta på konto
	 */
	public void setRate(double rate) {
		this.rate = rate;
	}

	/**
	 * sätta saldo på konto
	 * 
	 * @param balance saldo på beloppet
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * @return vilken typ av konto
	 */
	public String getType() {
		return type;
	}

	/**
	 * sätta kontotyp
	 * 
	 * @param type kontotyp
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Abstrakt metod
	 * 
	 * @return rate i respektive kontoklass
	 */
	public abstract double calculateRate();

	/**
	 * Insättning på konto
	 * 
	 * @param amount belopp som skall lägga till konto
	 */
	public boolean deposit(double amount) {
		if (amount > 0)	{
			setBalance(balance + amount);
			return true;
		}
		
		return false;
	}

	/**
	 * Uttag från konto
	 * 
	 * @param amount belopp som skall ta ut på konto
	 * @return true om uttag lyckas annars false
	 */
	public boolean withdraw(double amount) {
		if (amount < 0)	return false;
		
		if (balance - amount > 0) {
			setBalance(balance - amount);
			return true;
		} else
			return false;
	}
}
