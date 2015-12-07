package bank;

public class SavingsAccount extends Account {
	public static final String ACCOUNT_TYPE = "SPARKONTO";

	/**
	 * Konstruktor för SavingsAccount, anropar konstruktorn i superklassen
	 * Account
	 *
	 * @param accountId
	 *            kontonr
	 * @param rate
	 *            räntan på kontot
	 */
	public SavingsAccount(int accountId, double rate) {
		super(accountId);
		super.setType(ACCOUNT_TYPE);
		super.setRate(rate);
	}

	/**
	 * Uttag från konto
	 * 
	 * @param amount
	 *            belopp som skall ta ut på konto
	 * @return true om uttag lyckas annars false
	 * TODO Kontroll av tidpunkt för förra uttaget
	 */
	@Override
	public boolean withdraw(double amount) {
		
		if (amount < 0)
			return false;

		if (getBalance() - amount > 0) {
			setBalance(getBalance() - amount);
			return true;
		} else
			return false;
	}

	/**
	 * Beräknar och returnerar räntan
	 * 
	 * @return ränta på konto
	 */
	@Override
	public double calculateRate() {
		return getBalance() * getRate() / 100;
	}
}
