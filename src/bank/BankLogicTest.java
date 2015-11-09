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

	// Test om en kund existerar
	@Test
	public void testgetCustomerByPNr() {
		// Hämta en kund som existerar
		_banklogic.addCustomer("anna", 12345);
		Assert.assertNotNull("Skall inte vara Null", _banklogic.getCustomerByPNr(12345));

		// Hämta en kund som inte existerar
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
		
		// Hämta från en kund som inte existerar
		Assert.assertNull("Skall vara Null", _banklogic.getAccountById(null, pNr));
		
		// skapa en kund
		_banklogic.addCustomer("anna", pNr);
		
		// skapa ett konto
		_banklogic.addSavingsAccount(pNr);
		
		Assert.assertNotNull("Skall inte vara Null", _banklogic.getAccountById( _banklogic.getCustomerByPNr(pNr), 1001 ));
	}

	// Test ändra namn på en kund
	@Test
	public void testchangeCustomerName() {
		int pNr = 12345;

		// skapa en kund
		_banklogic.addCustomer("anna", pNr);
		_banklogic.changeCustomerName("hampus", pNr);

		Assert.assertEquals(_banklogic.getCustomerByPNr(pNr).getName(), "hampus");
	}

	// Test ta bort en kund
	@Test
	public void testremoveCustomer() {
		int pNr = 12345;

		// skapa en kund
		_banklogic.addCustomer("anna", pNr);

		// test returvärde som innehåller 2 strängar
		Assert.assertEquals(_banklogic.removeCustomer(pNr).size(), 2);

		_banklogic.addCustomer("anna", pNr);
		_banklogic.addSavingsAccount(pNr);
		_banklogic.addSavingsAccount(pNr);

		// test returvärde som innehåller 4 strängar
		Assert.assertEquals(_banklogic.removeCustomer(pNr).size(), 4);
	}

	// Test lägga till konto
	@Test
	public void testaddSavingsAccount() {
		int pNr = 12345;

		// skapa en kund
		_banklogic.addCustomer("anna", pNr);

		// test om ett konto har skapat
		Assert.assertEquals(_banklogic.addSavingsAccount(pNr), 1001);

		// test om ett konto inte hade skapat
		Assert.assertEquals(_banklogic.addSavingsAccount(0000), -1);
	}

	// hämta ett konto
	@Test
	public void testgetAccount() {
		int pNr = 12345;

		// skapa en kund
		_banklogic.addCustomer("anna", pNr);

		// skapa ett konto till kunden
		_banklogic.addSavingsAccount(pNr);

		// hämta ett konto som existera
		Assert.assertNotNull("Skall inte vara Null", _banklogic.getAccount( pNr, 1001 ));

		// hämta ett konto som inte existera
		Assert.assertNull("Skall vara Null", _banklogic.getAccount( pNr, 1005 ));
		Assert.assertNull("Skall vara Null", _banklogic.getAccount( 0, 1001 ));
	}

	// Test insättning
	@Test
	public void testdeposit() {
		int pNr = 12345;

		// skapa en kund
		_banklogic.addCustomer("anna", pNr);

		// skapa ett konto till kunden
		_banklogic.addSavingsAccount(pNr);

		// Test en lyckad insättning
		Assert.assertTrue(_banklogic.deposit(pNr, 1001, 10));

		// Test misslyckad insättning
		Assert.assertFalse(_banklogic.deposit(pNr, 1005, 10));
		Assert.assertFalse(_banklogic.deposit(0000, 1001, 10));
	}

	// Test uttag
	@Test
	public void testwithdraw() {
		int pNr = 12345;

		// skapa en kund
		_banklogic.addCustomer("anna", pNr);

		// skapa ett konto till kunden
		_banklogic.addSavingsAccount(pNr);

		// lägga till 5000 på konto
		_banklogic.deposit(pNr, 1001, 5000);

		// Test lyckat uttag
		Assert.assertTrue(_banklogic.withdraw(pNr, 1001, 4000));

		// Test misslyckat uttag
		Assert.assertFalse(_banklogic.withdraw(pNr, 1001, 1000000));
	}

	// Test stänga konto
	@Test
	public void testcloseAccount() {
		int pNr = 12345;

		// skapa en kund
		_banklogic.addCustomer("anna", pNr);

		// skapa ett konto till kunden
		_banklogic.addSavingsAccount(pNr);

		// stänger ett konto som existerar
		Assert.assertNotNull("Skall inte vara Null", _banklogic.closeAccount( pNr, 1001 ));

		// stänger ett konto som inte existerar
		Assert.assertNull("Skall vara Null", _banklogic.closeAccount( pNr, 1005 ));
		Assert.assertNull("Skall vara Null", _banklogic.closeAccount( 0000, 1001 ));
	}
}
