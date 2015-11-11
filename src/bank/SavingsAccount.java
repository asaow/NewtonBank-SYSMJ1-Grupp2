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
	 * @param kontonr
	 * @param ränta
	 */
	public SavingsAccount(int accountId, double rate) {
		_balance = 0;
		_rate = rate;
		_accountId = accountId; 
		_type = SavingsAccount.SAVING_ACCOUNT_TYPE;
	}
	
	/**
	 * @return saldo
	 */
	public double getBalance() {
		return _balance;
	}

	/**
	 * @return ränta 
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
	 * @param kontotyp 
	 */
	public void setType(String type) {
		_type = type;
	}
	
	/**
	 * sätta saldo på konto
	 * 
	 * @param saldo på beloppet 
	 */
	public void setBalance(double balance) {
		_balance = balance;
	}
}
