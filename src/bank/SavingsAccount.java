package bank;

public class SavingsAccount {
		public static String SAVING_ACCOUNT_TYPE = "SPARKONTO";
		private double balance;
		private double rate;
		private int accountId;
		private String type;
		
		public SavingsAccount(int accountId, double rate) {
			balance = 0;
			rate = rate;
			accountId = accountId; 
			type = SavingsAccount.SAVING_ACCOUNT_TYPE;
		}
		
		
		public double getBalance() {
			return balance;
		}

		public double getRate() {
			return rate;
		}
		
		public String getType() {
			return type;
		}
		
		public int getId() {
			return accountId;
		}
		
		public void setType(String type) {
			type = type;
		}
		
		public void setBalance(double balance) {
			balance = balance;
		}
	}



