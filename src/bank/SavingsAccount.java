package bank;

public class SavingsAccount {
	public static String SAVING_ACCOUNT_TYPE = "SPARKONTO";
	
	private double _balance;
	private double _rate;
	private int _accountId;
	private String _type;
	
	/**
	 * Konstruktor
	 *
	 * @param accountId kontonr
	 * @param rate räntan på konto
	 */
	public SavingsAccount(int accountId, double rate) {
		_balance = 0;
		_rate = rate;
		_accountId = accountId; 
		_type = SavingsAccount.SAVING_ACCOUNT_TYPE;
	}
	
	/**
	 * @return saldo på konto
	 */
	public double getBalance() {
		return _balance;
	}

	/**
	 * @return ränta på konto
	 */
	public double getRate() {
		return _rate;
	}
	
	/**
	 * @return vilka typ av konto 
	 */	
	public String getType() {
		return _type;
	}
	
	/**
	 * @return kontonr 
	 */
	public int getId() {
		return _accountId;
	}
	
	/**
	 * sätta vilka kontotyp
	 * 
	 * @param type kontotyp 
	 */
	public void setType(String type) {
		_type = type;
	}
	
	/**
	 * sätta saldo på konto
	 * 
	 * @param balance saldo på beloppet 
	 */
	public void setBalance(double balance) {
		_balance = balance;
	}
}
