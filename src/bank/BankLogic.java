package bank;

import java.util.ArrayList;

/**
 *  Klassen ska innehålla en lista med alla kunder och ett 
 *  antal publika metoder som hanterar kunder och dess konton
 */
public class BankLogic {
	private ArrayList<Customer> _customers;
	private int _counter = 1000;	// räknare till kontonr
	
	public BankLogic() {
		_customers = new ArrayList<>();
	}
	
	/** 
	 * Hämta en lista som innehåler alla kunder
	 * 
	 * @return en lista med alla kunder
	 */
	public ArrayList<String> getCustomers() {
		ArrayList<String> _list = new ArrayList<>();
		
		for (Customer c : _customers) {
			_list.add(String.format("%s: %s", c.getpNr(), c.getName()));
		}
		
		return _list;
	}

	/**
	 * Skapar en ny kund, kunden skapas endast om det inte finns någon 
	 * kund med personnr
	 *
	 * @param name ett namn
	 * @param pNr ett personnr
	 * @return true om kund skapades annars false
	 */
	public boolean addCustomer(String name, long pNr) {

		if (getCustomerByPNr(pNr) != null)
			return false;		
 
		_customers.add(new Customer(name, pNr) );
		return true;		
	}

	/**
	 * Hämta en kund och dess konto som tillhör kunden
	 * 
	 * @param pNr ett personnr 
	 * @return en lista som innehåller informationen om kunden inklusive dennes konton
	 */
	public ArrayList<String> getCustomer(long pNr) {		
		ArrayList<String> _list = null;

		Customer _cust = getCustomerByPNr(pNr);
		if (_cust != null) {
		
			_list = new ArrayList<>();
			
			_list.add( String.format("%s: %s", _cust.getpNr(), _cust.getName()) );
			
			for (SavingsAccount ac : _cust.getAccounts()) {
				_list.add( String.format("%s, Kontonr: %d", ac.getType(), ac.getId()) );
			}		
		}
		
		return _list;
	}
	
	/**
	 * Byter namn på en kund
	 *
	 * @param name ett namn
	 * @param pNr ett personnr
	 * @return true om namnet ändrades annars returnerar false
	 */
	public boolean changeCustomerName(String name, long pNr) {

		Customer _cust = getCustomerByPNr(pNr);		
		if (_cust != null) {
			_cust.setName(name);			
			return true;
		}

		return false;	
	}
	
	/**
	 * Tar bort en kund med personnr ur banken, alla kundens eventuella 
	 * konton tas också bort och resultatet returneras
	 *
	 * @param pNr ett personnr
	 * @return Listan som returneras ska innehålla information om alla 
	 *         konton som togs bort, saldot som kunden får tillbaka samt 
	 *         vad räntan blev
	 */
	public ArrayList<String> removeCustomer(long pNr) {
		double _balance;
		double _totalBalance = 0;
		double _totalRate = 0;
		ArrayList<String> _result = new ArrayList<>();
		Customer _cust = getCustomerByPNr(pNr);
		
		if (_cust != null) {
			ArrayList<SavingsAccount>_account = _cust.getAccounts();
			
			for (SavingsAccount sa : _account ) {
				_balance = sa.getBalance();
				_result.add( String.format("%s, Kontonr: %d, Saldo: %.2f, Ränta: %.2f", sa.getType(), sa.getId(), _balance, sa.getRate() ));
				
				_totalBalance += _balance;
				_totalRate += _balance * sa.getRate() / 100;
			}
			
			_result.add("Totala saldo: " + _totalBalance );
			_result.add("Totala ränta:" + _totalRate);

			_customers.remove(_cust);
			
			return _result;
		}

		return null;
	}

	/**
	 * Skapar ett konto till kund
	 * 
	 * @param pNr ett persomnr
	 * @return kontonr som det skapade kontot fick, annars -1 om inget konto skapades
	 */
	public int addSavingsAccount(long pNr) {

		Customer _cust = getCustomerByPNr(pNr);
		if (_cust != null) {
			_counter += 1;
			
			SavingsAccount _sa = new SavingsAccount(_counter, 1);
			_cust.addAccount(_sa);
			return _counter;
			
		}

		return -1;		
	}

	/**
	 * @return en sträng som innehåller kontonr, saldo, kontotyp, räntesats
	 */
	public String getAccount(long pNr, int accountId) {

		Customer _cust = getCustomerByPNr(pNr); 
		
		if (_cust != null) {
			SavingsAccount _account = getAccountById(_cust, accountId);
			if (_account != null)
				return String.format("Typ: %s\nKontonr: %d\nSaldo:  %.2f\nRänta: %.2f", _account.getType(), _account.getId(), _account.getBalance(), _account.getRate()); 
		}

		return null;
	}
	
	/**
	 * Gör en insättning på konto med kontonr som tillhör kunden
	 * 
	 * @param pNr personnr
	 * @param accountId ett kontonr
	 * @param belopp som sätts in
	 * @return true om det lyckades annars false
	 */
	public boolean deposit(long pNr, int accountId, double amount) {
		boolean _status = false;

		Customer _cust = getCustomerByPNr(pNr); 

		if (_cust != null) {
			SavingsAccount _account = getAccountById(_cust, accountId);

			if (_account != null) {
				_account.setBalance(_account.getBalance() + amount );

				_status = true;
			}
		}

		return _status;
	}
	
	/**
	 * Gör ett uttag på konto med kontonr som tillhör kunden
	 * 
	 * @param pNr personnr
	 * @param accountId ett kontonr
	 * @param belopp som dras från konto
	 * @return true om det lyckades annars false
	 */
	public boolean withdraw(long pNr, int accountId, double amount) {
		boolean _status = false;

		Customer _cust = getCustomerByPNr(pNr); 

		if (_cust != null) {
			SavingsAccount _account = getAccountById(_cust, accountId);

			if (_account != null) {
				if (_account.getBalance() - amount >= 0 ) {
					_account.setBalance(_account.getBalance() - amount );
					_status = true;
				}
			}
		}

		return _status;
	}

	/**
	 * Stänger ett konto med kontonr som tillhör kunden
	 *
	 * @param pNr ett personnr
	 * @param accountId ett kontonr
	 * @return en sträng med saldo och ränta
	 */
	public String closeAccount(long pNr, int accountId) {
		double _totalRate = 0;
		Customer _cust = getCustomerByPNr(pNr); 


		if (_cust != null) {
			SavingsAccount _account = getAccountById(_cust, accountId);

			if (_account != null) {
				_totalRate += _account.getBalance() * _account.getRate() / 100;
				_cust.removeAccount(_account);
				
				return String.format("Saldo: %.2f\nRänta: %.2f", _account.getBalance(), _totalRate);
			}
		}

		return null;
	}
	
	/**
	 * Visa antal kunder som finns
	 * 
	 * @return antal kunder i arrayList
	 */
	public int getNrOfCustomers() {
		return _customers.size();
	}
	
	/**
	 * Söka på en kund
	 *
	 * @param pNr personnr
	 * @return Customer om kunden finns annars null
	 */
	public Customer getCustomerByPNr(long pNr) {
		Customer _cust = null;

		for (Customer c : _customers) {
			if (c.getpNr() == pNr) 
				_cust = c;
				break;
		}
		
		return _cust;
	}
	
	/**
	 * Söka på ett konto i en viss kund
	 *
	 * @param cust en kund
	 * @param accountId ett kontonr
	 * @return SavingsAccount om konto finns annars null
	 */
	public SavingsAccount getAccountById(Customer cust, int accountId) {
		if (cust == null)	return null;
		
		SavingsAccount _account = null;
		
		for (SavingsAccount _ac : cust.getAccounts()) {
			if (_ac.getId() == accountId) {
				_account = _ac;
				break;
			}
		}
		
		return _account;
	}
}
