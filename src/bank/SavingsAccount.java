package bank;

public class SavingsAccount extends Account {
	public static final String ACCOUNT_TYPE = "SPARKONTO";

	/**
	 * Konstruktor för SavingsAccount, anropar konstruktorn i superklassen
	 * Account
	 *
	 * @param accountId kontonr
	 * @param rate räntan på kontot
	 */
	public SavingsAccount(int accountId, double rate) {
		super(accountId);
		super.setType(ACCOUNT_TYPE);
		super.setRate(rate);
	}

	/**
	 * @return ränta på konto
	 */
	@Override
	public double calculateRate() {
		return 1.0;
	}
}
