package bank;

public class SavingsAccount {
	public static String SAVING_ACCOUNT_TYPE = "SPARKONTO";
	
	private double _balance;
	private double _rate;
	private int _accountId;
	private String _type;
	
	public SavingsAccount(int accountId, double rate) {
		_balance = 0;
		_rate = rate;
		_accountId = accountId; 
		_type = SavingsAccount.SAVING_ACCOUNT_TYPE;
	}
	
	public double getBalance() {
		return _balance;
	}

	public double getRate() {
		return _rate;
	}
	
	public String getType() {
		return _type;
	}
	
	public int getId() {
		return _accountId;
	}
	
	public void setType(String type) {
		_type = type;
	}
	
	public void setBalance(double balance) {
		_balance = balance;
	}
}
