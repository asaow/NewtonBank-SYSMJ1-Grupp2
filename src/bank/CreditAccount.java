package bank;

public class CreditAccount extends Account {
	public static final String ACCOUNT_TYPE = "KREDITKONTO";

	private double creditRate;
	private int credit;

	/**
	 * Konstruktor för CreditAccount, anropar konstruktorn i superklassen
	 * Account
	 * 
	 * @param accountId
	 */
	public CreditAccount(int accountId, double rate, double creditRate, int credit) {
		super(accountId);
		super.setType(ACCOUNT_TYPE);
		super.setRate(rate);
		this.creditRate = creditRate;
		this.credit = credit;
	}

	/**
	 * @return Kreditgräns
	 */
	public int getCredit() {
		return credit;
	}
		
	/**
	 * @return Kreditränta
	 */
	public double getCreditRate() {
		return creditRate;
	}

	/**
	 * Uttag ett belopp från konto
	 * 
	 * @param amount belopp som skall ta ut på konto
	 * @return true om uttag lyckas annars false
	 */
	@Override
	public boolean withdraw(double amount) {
		double balance = getBalance();
		
		if (balance - amount >= -credit) {
			setBalance(balance - amount);
			return true;
		} else
			return false;
	}

	/**
	 * Returnerar creditRate om saldo under 0, annars returneras rate
	 * 
	 * @return ränta på konto
	 */
	@Override
	public double calculateRate() {
//		if (super.getBalance() < 0) {
//			return creditRate;
//		}
//		return getRate();
		
		return 2.0;
	}
}
