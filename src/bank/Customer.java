package bank;
import java.util.ArrayList;


public class Customer {
	private String name;
	private long pNr;
	private ArrayList<SavingsAccount> savingsAccounts;
	
	public Customer(String name, long pNr){
		this.name=name;
		this.pNr=pNr;
		savingsAccounts = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public long getpNr() {
		return pNr;
	}
	
	public void setpNr(long pNr) {
		this.pNr = pNr;
	}
	
	public void addAccount(SavingsAccount sa){
		savingsAccounts.add(sa);
		
	}
	
	public ArrayList<SavingsAccount> getAccount(){
		return savingsAccounts;
	}

}
