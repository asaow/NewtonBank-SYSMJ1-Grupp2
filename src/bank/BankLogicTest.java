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

/**
 * @author Grupp2
 */
public class BankLogicTest {

	private BankLogic _bankLogic;
	private String _name;
	private long _pNr;
	private int _accountId;
	private double _amount;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//BankLogic _bankLogic = new BankLogic();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		_name = "Test Name";
		_pNr = 201001012222L;
		_amount = 10000.00;

		_bankLogic = new BankLogic();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		_bankLogic.removeCustomer(_pNr);
	}

	/**
	 * Test method for {@link bank.BankLogic#BankLogic()}.
	 */
	@Test
	public void testBankLogic() {
		try {
			fail("Not yet implemented");
			throw new SQLException();
		} catch (SQLException ex) {
		}
	}

	/**
	 * Test method for {@link bank.BankLogic#getCustomers()}.
	 */
	@Test
	public void testGetCustomers() {
		try {
			int allCustomer = _bankLogic.getCustomers().size();
			_bankLogic.addCustomer(_name, _pNr);
			
			Assert.assertEquals(_bankLogic.getCustomers().size(), allCustomer + 1);
			
		} catch (SQLException ex) {
		}
	}

	/**
	 * Test method for {@link bank.BankLogic#addCustomer(java.lang.String, long)}.
	 */
	@Test
	public void testAddCustomer() {
		try {
			Assert.assertTrue(_bankLogic.addCustomer(_name, _pNr));
		} catch (SQLException ex) {
		}
	}

	/**
	 * Test method for {@link bank.BankLogic#getCustomer(long)}.
	 */
	@Test
	public void testGetCustomer() {
		try {
			_bankLogic.addCustomer(_name, _pNr);
			Assert.assertNotEquals(_bankLogic.getCustomer(_pNr).size(), 0);
			
		} catch (SQLException ex) {
		}
	}

	/**
	 * Test method for {@link bank.BankLogic#changeCustomerName(java.lang.String, long)}.
	 */
	@Test
	public void testChangeCustomerName() {
		try {
			_bankLogic.addCustomer(_name, _pNr);
			_bankLogic.changeCustomerName("New Name", _pNr);
			
			Assert.assertNotEquals(_bankLogic.getCustomer(_pNr).get(0).indexOf("New Name"), -1);
			
		} catch (SQLException ex) {
		}
	}

	/**
	 * Test method for {@link bank.BankLogic#removeCustomer(long)}.
	 */
	@Test
	public void testRemoveCustomer() {
		try {
			fail("Not yet implemented");
			throw new SQLException();
		} catch (SQLException ex) {
		}
	}

	/**
	 * Test method for {@link bank.BankLogic#addSavingsAccount(long)}.
	 */
	@Test
	public void testAddSavingsAccount() {
		try {
			_bankLogic.addCustomer(_name, _pNr);
			
			Assert.assertNotEquals(_bankLogic.addSavingsAccount(_pNr), -1);
			
		} catch (SQLException ex) {
		}
	}

	/**
	 * Test method for {@link bank.BankLogic#addCreditAccount(long)}.
	 */
	@Test
	public void testAddCreditAccount() {
		try {
			_bankLogic.addCustomer(_name, _pNr);
			
			Assert.assertNotEquals(_bankLogic.addCreditAccount(_pNr), -1);
			
		} catch (SQLException ex) {
		}
	}

	/**
	 * Test method for {@link bank.BankLogic#getAccount(long, int)}.
	 */
	@Test
	public void testGetAccount() {
		try {
			_bankLogic.addCustomer(_name, _pNr);
			_accountId = _bankLogic.addSavingsAccount(_pNr);
			
			Assert.assertNotNull(_bankLogic.getAccount(_pNr, _accountId));
			
		} catch (SQLException ex) {
		}
	}

	/**
	 * Test method for {@link bank.BankLogic#deposit(long, int, double)}.
	 */
	@Test
	public void testDeposit() {
		try {
			_bankLogic.addCustomer(_name, _pNr);
			_accountId = _bankLogic.addSavingsAccount(_pNr);
			
			Assert.assertTrue(_bankLogic.deposit(_pNr, _accountId, _amount));
		} catch (SQLException ex) {
		}
	}

	/**
	 * Test method for {@link bank.BankLogic#withdraw(long, int, double)}.
	 */
	@Test
	public void testWithdraw() {
		try {
			_bankLogic.addCustomer(_name, _pNr);
			_accountId = _bankLogic.addSavingsAccount(_pNr);
			_bankLogic.deposit(_pNr, _accountId, _amount);
			
			Assert.assertTrue(_bankLogic.withdraw(_pNr, _accountId, _amount));
			
		} catch (SQLException ex) {
		}
	}

	/**
	 * Test method for {@link bank.BankLogic#closeAccount(long, int)}.
	 */
	@Test
	public void testCloseAccount() {
		try {
			_bankLogic.addCustomer(_name, _pNr);
			_accountId = _bankLogic.addSavingsAccount(_pNr);
			
			Assert.assertNotNull(_bankLogic.closeAccount(_pNr, _accountId));
			
		} catch (SQLException ex) {
		}
	}

	/**
	 * Test method for {@link bank.BankLogic#getTransactions(long, int)}.
	 */
	@Test
	public void testGetTransactions() {
		try {
			_bankLogic.addCustomer(_name, _pNr);
			_accountId = _bankLogic.addSavingsAccount(_pNr);
			_bankLogic.deposit(_pNr, _accountId, _amount);
			
			Assert.assertNotEquals(_bankLogic.getTransactions(_pNr, _accountId).size(), 0);
			
		} catch (SQLException ex) {
		}
	}

	/**
	 * Test method for {@link bank.BankLogic#getAccountSummary(long)}.
	 */
	@Test
	public void testGetAccountSummary() {
		try {
			_bankLogic.addCustomer(_name, _pNr);
			_accountId = _bankLogic.addSavingsAccount(_pNr);
			_bankLogic.deposit(_pNr, _accountId, _amount);
			
			Assert.assertNotEquals(_bankLogic.getAccountSummary(_pNr).size(), 0);
			
		} catch (SQLException ex) {
		}
	}
}
