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
 *
 */
public class BankLogicTest {

	private BankLogic _bankLogic;
	private String _name;
	private long _pNr;
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
		_name = "Anna Nguey";
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
			fail("Not yet implemented");
			throw new SQLException();
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
			fail("Not yet implemented");
			throw new SQLException();
		} catch (SQLException ex) {
		}
	}

	/**
	 * Test method for {@link bank.BankLogic#changeCustomerName(java.lang.String, long)}.
	 */
	@Test
	public void testChangeCustomerName() {
		try {
			fail("Not yet implemented");
			throw new SQLException();
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
			fail("Not yet implemented");
			throw new SQLException();
		} catch (SQLException ex) {
		}
	}

	/**
	 * Test method for {@link bank.BankLogic#addCreditAccount(long)}.
	 */
	@Test
	public void testAddCreditAccount() {
		try {
			fail("Not yet implemented");
			throw new SQLException();
		} catch (SQLException ex) {
		}
	}

	/**
	 * Test method for {@link bank.BankLogic#getAccount(long, int)}.
	 */
	@Test
	public void testGetAccount() {
		try {
			fail("Not yet implemented");
			throw new SQLException();
		} catch (SQLException ex) {
		}
	}

	/**
	 * Test method for {@link bank.BankLogic#deposit(long, int, double)}.
	 */
	@Test
	public void testDeposit() {
		try {
			fail("Not yet implemented");
			throw new SQLException();
		} catch (SQLException ex) {
		}
	}

	/**
	 * Test method for {@link bank.BankLogic#withdraw(long, int, double)}.
	 */
	@Test
	public void testWithdraw() {
		try {
			fail("Not yet implemented");
			throw new SQLException();
		} catch (SQLException ex) {
		}
	}

	/**
	 * Test method for {@link bank.BankLogic#closeAccount(long, int)}.
	 */
	@Test
	public void testCloseAccount() {
		try {
			fail("Not yet implemented");
			throw new SQLException();
		} catch (SQLException ex) {
		}
	}

	/**
	 * Test method for {@link bank.BankLogic#getTransactions(long, int)}.
	 */
	@Test
	public void testGetTransactions() {
		try {
			fail("Not yet implemented");
			throw new SQLException();
		} catch (SQLException ex) {
		}
	}

	/**
	 * Test method for {@link bank.BankLogic#getAccountSummary(long)}.
	 */
	@Test
	public void testGetAccountSummary() {
		try {
			fail("Not yet implemented");
			throw new SQLException();
		} catch (SQLException ex) {
		}
	}
}
