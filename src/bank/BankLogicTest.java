/**
 * 
 */
package bank;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Grupp2
 */
public class RepositiryTest {

	private Repository _db;
	private String _name;
	private long _pNr;
	private double _amount;
	private int _Id;

	private Customer _cust;
	private Account _ac;
	private SavingsAccount _sa;
	private CreditAccount _ca;
	private Transaction _tr;
	
	private ArrayList<SavingsAccount> _sac;
	private ArrayList<CreditAccount> _cac;
	private ArrayList<Transaction> _trans;
	

//	/**
//	 * @throws java.lang.Exception
//	 */
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//	}
//
//	/**
//	 * @throws java.lang.Exception
//	 */
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//	}
//
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		_name = "Anna Nguey";
		_pNr = 201001012222L;
		_amount = 10000.00;
		
		_db = new Repository();
		_cust = new Customer(_name, _pNr);
		_sa = new SavingsAccount(1001, 0.5);
		_ca = new CreditAccount(1002, 1, 7, 5000);
		
		_db.connect();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		
		_db.removeCustomer(_cust.getPNr());
		_db.disconnect();
	}

//	/**
//	 * Test method for {@link bank.Repository#connect()}.
//	 */
//	@Test
//	public void testConnect() {
//		try {
//			fail("Not yet implemented");
//			throw new SQLException();
//		} catch (SQLException ex) {
//		}
//	}
//
//	/**
//	 * Test method for {@link bank.Repository#findCustomer(long)}.
//	 */
//	@Test
//	public void testFindCustomer() {
//		try {
//			fail("Not yet implemented");
//			throw new SQLException();
//		} catch (SQLException ex) {
//		}
//	}

	/**
	 * Test method for {@link bank.Repository#findAllCustomer()}.
	 */
	@Test
	public void testFindAllCustomer() {
		try {
			fail("Not yet implemented");
			throw new SQLException();
		} catch (SQLException ex) {
		}
	}

	/**
	 * Test method for {@link bank.Repository#queryCustomer(java.lang.String)}.
	 */
	@Test
	public void testQueryCustomer() {
		try {
			fail("Not yet implemented");
			throw new SQLException();
		} catch (SQLException ex) {
		}
	}

	/**
	 * Test method for {@link bank.Repository#findAccount(long, int)}.
	 */
	@Test
	public void testFindAccount() {
		try {
			fail("Not yet implemented");
			throw new SQLException();
		} catch (SQLException ex) {
		}
	}

	/**
	 * Test method for {@link bank.Repository#findAllAccount(long)}.
	 */
	@Test
	public void testFindAllAccount() {
		try {
			fail("Not yet implemented");
			throw new SQLException();
		} catch (SQLException ex) {
		}
	}

	/**
	 * Test method for {@link bank.Repository#queryAccount(java.lang.String)}.
	 */
	@Test
	public void testQueryAccount() {
		try {
			fail("Not yet implemented");
			throw new SQLException();
		} catch (SQLException ex) {
		}
	}

	/**
	 * Test method for {@link bank.Repository#findTransaction(int)}.
	 */
	@Test
	public void testFindTransaction() {
		try {
			fail("Not yet implemented");
			throw new SQLException();
		} catch (SQLException ex) {
		}
	}

	/**
	 * Test method for {@link bank.Repository#findLastTransaction(int)}.
	 */
	@Test
	public void testFindLastTransaction() {
		try {
			fail("Not yet implemented");
			throw new SQLException();
		} catch (SQLException ex) {
		}
	}

	/**
	 * Test method for {@link bank.Repository#queryTransaction(java.lang.String)}.
	 */
	@Test
	public void testQueryTransaction() {
		try {
			fail("Not yet implemented");
			throw new SQLException();
		} catch (SQLException ex) {
		}
	}

	/**
	 * Test method for {@link bank.Repository#addCustomer(bank.Customer)}.
	 */
	@Test
	public void testAddCustomer() {
		try {
			_db.addCustomer(_cust);
			Assert.assertNotNull(_db.findCustomer(_cust.getPNr()));
		} catch (SQLException ex) {
		}
	}

	/**
	 * Test method for {@link bank.Repository#addAccount(bank.Account, long)}.
	 */
	@Test
	public void testAddAccount() {
		try {
			_db.addCustomer(_cust);
			_cust = _db.findCustomer(_cust.getPNr());
			_Id = _db.addAccount(_sa, _cust.getPNr());
			
			Assert.assertNotNull(_db.findAccount(_cust.getPNr(), _Id));
			
		} catch (SQLException ex) {
		}
	}

	/**
	 * Test method for {@link bank.Repository#addTransaction(bank.Transaction)}.
	 */
	@Test
	public void testAddTransaction() {
		try {
			_db.addCustomer(_cust);
			_cust = _db.findCustomer(_cust.getPNr());
			_Id = _db.addAccount(_sa, _cust.getPNr());
			
			_tr = new Transaction(_Id, "IN", 0, 0);
			_db.addTransaction(_tr);
			
			Assert.assertEquals(_db.findTransaction(_Id).size(), 1);
			
		} catch (SQLException ex) {
		}
	}

	/**
	 * Test method for {@link bank.Repository#updateCustomer(bank.Customer)}.
	 */
	@Test
	public void testUpdateCustomer() {
		try {
			_db.addCustomer(_cust);
			_cust = _db.findCustomer(_cust.getPNr());
			_cust.setName("Cam Huynh");
			
			_db.updateCustomer(_cust);
			_cust = _db.findCustomer(_cust.getPNr());
			Assert.assertEquals(_cust.getName(), "Cam Huynh");
			
		} catch (SQLException ex) {
		}
	}

	/**
	 * Test method for {@link bank.Repository#updateAccount(bank.Account)}.
	 */
	@Test
	public void testUpdateAccount() {
		try {
			_db.addCustomer(_cust);
			_cust = _db.findCustomer(_cust.getPNr());
			_Id = _db.addAccount(_sa, _cust.getPNr());
			
			_ac = _db.findAccount(_cust.getPNr(), _Id);
			_ac.setBalance(5000);

			_db.updateAccount(_ac);
			_ac = _db.findAccount(_cust.getPNr(), _Id);

			Assert.assertEquals(new Double(_ac.getBalance()).intValue(), 5000);

		} catch (SQLException ex) {
		}
	}

	/**
	 * Test method for {@link bank.Repository#removeCustomer(long)}.
	 */
	@Test
	public void testRemoveCustomer() {
		try {
			_db.addCustomer(_cust);
			_db.removeCustomer(_cust.getPNr());
			Assert.assertNull(_db.findCustomer(_cust.getPNr()));
		} catch (SQLException ex) {
		}
	}

	/**
	 * Test method for {@link bank.Repository#removeAccount(int)}.
	 */
	@Test
	public void testRemoveAccount() {
		try {
			_db.addCustomer(_cust);
			_cust = _db.findCustomer(_cust.getPNr());
			_Id = _db.addAccount(_sa, _cust.getPNr());
			
			_db.removeAccount(_Id);
			
			Assert.assertNull(_db.findAccount(_cust.getPNr(), _Id));
		} catch (SQLException ex) {
		}
	}
}
