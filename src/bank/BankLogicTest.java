package bank;

import org.junit.Assert;
import org.junit.Test;

public class BankLogicTest {
	private BankLogic _banklogic = new BankLogic();
	
//	@Test
//	public void test() {
//
//	}
	
	// Test lägga till kunder
	@Test
	public void testAddNewCustomer() {
		// lägg till ny kund
		_banklogic.addCustomer("anna", 12345);
		Assert.assertEquals(_banklogic.getNrOfCustomers(), 1);

		// lägg till ny kund
		_banklogic.addCustomer("hampus", 234556);
		Assert.assertEquals(_banklogic.getNrOfCustomers(), 2);
		
		// lägg till existera kund
		_banklogic.addCustomer("anna", 12345);
		Assert.assertEquals(_banklogic.getNrOfCustomers(), 2);	
	}	

	// Test om en kund existera och inte existera
	@Test
	public void testgetCustomerByPNr() {
		_banklogic.addCustomer("anna", 12345);
		Assert.assertNotNull("Skall inte vara Null", _banklogic.getCustomerByPNr(12345));

		// Hämta en kund som inte existera
		Assert.assertNull("Skall vara Null", _banklogic.getCustomerByPNr(00000));
	}
	
	// Test hämta fram en kund och dess konto
	@Test
	public void testgetCustomer() {
		int pNr = 12345;
		
		// skapa en kund
		_banklogic.addCustomer("anna", pNr);
		
		// skapa ett konto
		_banklogic.addSavingsAccount(pNr);
		
		Assert.assertEquals(_banklogic.getCustomer(12345).get(0), "12345: anna");
		Assert.assertEquals(_banklogic.getCustomerByPNr(pNr).getNrOfAccounts(), 1);
	}
	
	// Test hämta fram ett konto
	@Test
	public void testgetAccountById() {
		int pNr = 12345;
		
		// Hämta från en kund som inte existera
		Assert.assertNull("Skall vara Null", _banklogic.getAccountById(null, pNr));
		
		// skapa en kund
		_banklogic.addCustomer("anna", pNr);
		
		// skapa ett konto
		_banklogic.addSavingsAccount(pNr);
		
		Assert.assertNotNull("Skall inte vara Null", _banklogic.getAccountById( _banklogic.getCustomerByPNr(pNr), 1001 ));
	}
}
