package bank;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.Properties;


public class Repository {
	
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/newtonbank";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private Connection _connection;

    /**
     * Koppla mot newtonbank databas
	 * @throws SQLException 
     */ 
    public void connect()  throws SQLException {
        if (_connection == null) {
             _connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        }
    }

    /**
     * Koppla från newtonbank databas
	 * @throws SQLException 
     */ 
    public void disconnect() throws SQLException {
        if (_connection != null) {
            _connection.close();
             _connection = null;
        }
    }

	/**
	 * Söka på en viss tabell med en SQL query
	 *
	 * @param query en SQL query
	 * @return ResultSet på sök resultat
	 * @throws SQLException 
	 */
	private ResultSet executeQuery(String query) throws SQLException {
		
		Statement _st = _connection.createStatement();
		ResultSet _rs = _st.executeQuery(query);

		System.out.println(query);
		return _rs;
	}

	/**
	 * Lägg till, uppdatera eller ta bort data på en viss tabell med en SQL query
	 *
	 * @param query en SQL query
	 * @param returnKey true om primärnyckel skall returnera
	 * @return affected rows eller primärnyckel
	 * @throws SQLException 
	 */
	private int executeUpdate(String query, boolean returnKey) throws SQLException {
		Statement _st = _connection.createStatement();
		int _result = -1;
		
		int _sel = returnKey ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS;
		_result = _st.executeUpdate(query, _sel);
		
		if (returnKey) {
			ResultSet _rs = _st.getGeneratedKeys();  
			
			if (_rs.next())  
	        	_result = _rs.getInt(1);
	    }
		
		System.out.println(query);
		return _result;
	}

	/**
	 * Söka på en kund
	 *
	 * @param pNr personnr
	 * @return Customer om kunden finns annars null
	 * @throws SQLException
	 */
	public Customer findCustomer(long pNr) throws SQLException {
		
		ArrayList<Customer> _cust = queryCustomer(String.format("SELECT * FROM Customer WHERE personNr=%d", pNr));

		return _cust.size() > 0 ? _cust.get(0) : null;
	}

	/**
	 * Hämta alla kunder på Customer tabell
	 *
	 * @return ArrayList<Customer> en arrayList av kunder
	 * @throws SQLException
	 */
	public ArrayList<Customer> findAllCustomer() throws SQLException {

		return queryCustomer("SELECT * FROM Customer ORDER BY name");
	}

	/**
	 * Sök Customer tabell med en SQL query
	 *
	 * @param query SQL query
	 * @return ArrayList<Customer> en arrayList av kunder
	 * @throws SQLException
	 */
	public ArrayList<Customer> queryCustomer(String query) throws SQLException {
		ArrayList<Customer> _cust = new ArrayList<>();

		ResultSet _rs = executeQuery(query);
		
		while (_rs.next()) {
			Customer _c = new Customer(_rs.getString("name"), _rs.getLong("personNr"));
			_cust.add(_c);
		}
		
		return _cust;
	}

	/**
	 * Söka på ett konto på en viss kund
	 *
	 * @param pNr personnr
	 * @param accountId kontonr
	 * @return Account om konto finns annars null
	 * @throws SQLException
	 */
	public Account findAccount(long pNr, int accountId) throws SQLException {
		ArrayList<Account> _ac;
		
		_ac = queryAccount(String.format("SELECT * FROM Account WHERE personNr=%d AND accountId=%d", pNr, accountId));

		return _ac.size() > 0 ? _ac.get(0) : null;
	}

	/**
	 * Hämta alla konto som tillhör en viss kund
	 *
	 * @return arrayList av konto
	 * @throws SQLException
	 */
	public ArrayList<Account> findAllAccount(long pNr) throws SQLException {

		return queryAccount(String.format("SELECT * FROM Account WHERE personNr=%d ORDER BY accountId", pNr));
	}

	/**
	 * Sök Account tabell med en SQL query
	 *
	 * @param query SQL query
	 * @return ArrayList<Account> en arrayList av konto
	 * @throws SQLException
	 */
	public ArrayList<Account> queryAccount(String query) throws SQLException {
		ArrayList<Account> _account = new ArrayList<>();
				
		ResultSet _rs = executeQuery(query);
		
		while (_rs.next()) {

			switch (_rs.getString("accountType")) {
				case SavingsAccount.ACCOUNT_TYPE:
					SavingsAccount _sa = new SavingsAccount(_rs.getInt("accountId"), _rs.getDouble("rate"));
			
					_sa.setBalance(_rs.getDouble("balance"));
					_sa.setType(_rs.getString("accountType"));
					_account.add(_sa);
					break;
				case CreditAccount.ACCOUNT_TYPE:
					CreditAccount _ca = new CreditAccount(_rs.getInt("accountId"), _rs.getDouble("rate"), _rs.getDouble("creditRate"), _rs.getInt("credit"));
					
					_ca.setBalance(_rs.getDouble("balance"));
					_ca.setType(_rs.getString("accountType"));
					_account.add(_ca);
			}				
		}
	
		return _account;
	}

	/**
	 * Hämta alla transaktion som tillhör en viss konto
	 *
	 * @param accountId kontonr
	 * @return arrayList av transaktion
	 * @throws SQLException
	 */
	public ArrayList<Transactions> findTransaction(int accountId) throws SQLException {
		
		return queryTransaction(String.format("SELECT * FROM Transaction WHERE accountId=%d ORDER BY transDate", accountId));
	}

	/**
	 * Sök transaktion tabell med en SQL query
	 *
	 * @param query SQL query
	 * @return arrayList av transaktionen
	 * @throws SQLException
	 */
	public ArrayList<Transactions> queryTransaction(String query) throws SQLException {
		ArrayList<Transactions> _trans = new ArrayList<>();
		
		ResultSet _rs = executeQuery(query);
		
		while (_rs.next()) {
			Transactions _tr = new Transactions(_rs.getInt("accountId"), _rs.getString("transType"), _rs.getString("date"), _rs.getDouble("amount"),  _rs.getDouble("balance"));
			_trans.add(_tr);
		}

		return _trans;
	}

	/**
	 * Lägg till ny kund
	 *
	 * @param ct Customer objekt
	 * @return affected row
	 * @throws SQLException
	 */
	public int addCustomer(Customer ct) throws SQLException {
		
		return executeUpdate(String.format("INSERT INTO Customer (personNr, name) VALUES(%d, '%s')", ct.getPNr(), ct.getName()), false);
	}

	/**
	 * Lägg till nytt konto
	 *
	 * @param ac SavingsAccount eller CreditAccount objekt
	 * @param pNr personnr till konto
	 * @return generera nyckel om inläggning lyckas annars 0
	 * @throws SQLException
	 */
	public int addAccount(Account ac, long pNr) throws SQLException {
		int _primaryKey;
//
		if (ac instanceof CreditAccount) {
			CreditAccount _ca = (CreditAccount) ac;
			_primaryKey = executeUpdate(String.format("INSERT INTO Account (personNr, rate, accountType, creditRate, credit) VALUES(%d, %s, '%s', %s, %d)",	
					pNr, Double.toString(ac.getRate()), ac.getType(), Double.toString(_ca.getCreditRate()), _ca.getCredit()), true);			
		} else 
			_primaryKey = executeUpdate(String.format("INSERT INTO Account (personNr, rate, accountType) VALUES(%d, %s, '%s')",	
					pNr, Double.toString(ac.getRate()), ac.getType()), true);

		return _primaryKey == 0 ? -1 : _primaryKey;
	}

	/**
	 * Lägg till ny transaktion
	 *
	 * @param ct Transaction objekt
	 * @return generera nyckel om inläggning lyckas annars -1
	 * @throws SQLException
	 */
	public int addTransaction(Transactions tr) throws SQLException {

		return executeUpdate(String.format("INSERT INTO Transaction (accountId, transType, amount, balance) VALUES(%d, '%s', %s, %s)", 
							tr.getAccountId(), tr.getType(), Double.toString(tr.getAmount()), Double.toString(tr.getBalance())), false);
	}

	/**
	 * Uppdatera kund info
	 *
	 * @param ct Customer objekt
	 * @return true om uppdatering lyckas annars false
	 * @throws SQLException
	 */	
	public boolean updateCustomer(Customer ct) throws SQLException {
		
		return executeUpdate(String.format("UPDATE Customer SET name='%s' WHERE personNr=%d", ct.getName(), ct.getPNr()), false) > 0 ? true : false;
	}

	/**
	 * Uppdatera ett konto
	 *
	 * @param ac SavingsAccount eller CreditAccount objekt
	 * @return true om uppdatering lyckas annars false
	 * @throws SQLException
	 */
	public boolean updateAccount(Account ac) throws SQLException {
//		int _id;
//		double _balance;
//		
//		if (ac instanceof SavingsAccount) {
//			SavingsAccount _sa = (SavingsAccount) ac;
//			_id = _sa.getId();
//			_balance = _sa.getBalance();
//			
//		} else if (ac instanceof CreditAccount) {
//			CreditAccount _ca = (CreditAccount) ac;
//			_id = _ca.getId();
//			_balance = _ca.getBalance();
//		} else
//			return false;
		
		//return executeUpdate(String.format("UPDATE Account SET balance=%s WHERE accountId=%d", Double.toString(_balance), _id), false) > 0 ? true : false;
		
		return executeUpdate(String.format("UPDATE Account SET balance=%s WHERE accountId=%d", 
				Double.toString(ac.getBalance()), ac.getId()), false) > 0 ? true : false;
	}

	/**
	 * Ta bort en kund
	 *
	 * @param pNr personnr
	 * @return true om borttagning lyckas annars false
	 * @throws SQLException
	 */	
	public boolean removeCustomer(long pNr) throws SQLException {
		
		return executeUpdate(String.format("DELETE FROM Customer WHERE personNr=%d", pNr), false) > 0 ? true : false;
	}
	
	/**
	 * Ta bort ett konto
	 *
	 * @param accountId kontonr
	 * @return true om borttagning lyckas annars false
	 * @throws SQLException
	 */
	public boolean removeAccount(int accountId) throws SQLException {
		
		return executeUpdate(String.format("DELETE FROM Account WHERE accountId=%d", accountId), false) > 0 ? true : false;
 	}
}