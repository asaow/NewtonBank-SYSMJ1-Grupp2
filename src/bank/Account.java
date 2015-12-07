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
	 * @return räntan i respektive kontoklass
	 */
	public abstract double calculateRate();

	/**
	 * Insättning på konto
	 * 
	 * @param amount belopp som skall lägga till konto
	 * @return true om insättning lyckades annars false
	 */
	public boolean deposit(double amount) {
		if (amount > 0) {
			setBalance(balance + amount);
			return true;
		}

		return false;
	}

	/**
	 * Abstrakt metod 
	 * Uttag från konto
	 * 
	 * @param amount belopp som skall ta ut på konto
	 * @return true om uttag lyckas annars false
	 */
	public abstract boolean withdraw(double amount);
}
