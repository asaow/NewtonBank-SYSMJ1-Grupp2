package bank;

import org.junit.Assert;
import org.junit.Test;

public class BankLogicTest {
	private BankLogic _banklogic = new BankLogic();
	
//	@Test
//	public void test() {
//
//	}
	
	// Test l�gga till kunder
	@Test
	public void testAddNewCustomer() {
		// l�gg till ny kund
		_banklogic.addCustomer("anna", 12345);
		Assert.assertEquals(_banklogic.getNrOfCustomers(), 1);

		// l�gg till ny kund
		_banklogic.addCustomer("hampus", 234556);
		Assert.assertEquals(_banklogic.getNrOfCustomers(), 2);
		
		// l�gg till existera kund
		_banklogic.addCustomer("anna", 12345);
		Assert.assertEquals(_banklogic.getNrOfCustomers(), 2);	
	}	

	// Test om en kund existera
	@Test
	public void testgetCustomerByPNr() {
		_banklogic.addCustomer("anna", 12345);
		Assert.assertNotNull("Skall inte vara Null", _banklogic.getCustomerByPNr(12345));

		// H�mta en kund som inte existera
		Assert.assertNull("Skall vara Null", _banklogic.getCustomerByPNr(00000));
	}
	
	// Test h�mta fram en kund och dess konto
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
	
	// Test h�mta fram ett konto
	@Test
	public void testgetAccountById() {
		int pNr = 12345;
		
		// H�mta fr�n en kund som inte existera
		Assert.assertNull("Skall vara Null", _banklogic.getAccountById(null, pNr));
		
		// skapa en kund
		_banklogic.addCustomer("anna", pNr);
		
		// skapa ett konto
		_banklogic.addSavingsAccount(pNr);
		
		Assert.assertNotNull("Skall inte vara Null", _banklogic.getAccountById( _banklogic.getCustomerByPNr(pNr), 1001 ));
	}

	// Test �ndta namn p� en kund
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

		// test retur v�rde som inneh�ller 2 str�mg
		Assert.assertEquals(_banklogic.removeCustomer(pNr).size(), 2);

		_banklogic.addCustomer("anna", pNr);
		_banklogic.addSavingsAccount(pNr);
		_banklogic.addSavingsAccount(pNr);

		// test retur v�rde som inneh�ller 4 str�mg
		Assert.assertEquals(_banklogic.removeCustomer(pNr).size(), 4);
	}

	// Test l�gga till konto
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

	// h�mta ett konto
	@Test
	public void testgetAccount() {
		int pNr = 12345;

		// skapa en kund
		_banklogic.addCustomer("anna", pNr);

		// skapa ett konto till kunden
		_banklogic.addSavingsAccount(pNr);
//System.out.println(_banklogic.getCustomerByPNr(pNr).getAccounts().get(0).getId());
		// h�mta ett konto som existera
		Assert.assertNotNull("Skall inte vara Null", _banklogic.getAccount( pNr, 1001 ));

		// h�mta ett konto som inte existera
		//Assert.assertNull("Skall vara Null", _banklogic.getAccount( pNr, 1005 ));
		//Assert.assertNull("Skall vara Null", _banklogic.getAccount( 0, 1001 ));
	}

	// Test ins�ttning
	@Test
	public void testdeposit() {
		int pNr = 12345;

		// skapa en kund
		_banklogic.addCustomer("anna", pNr);

		// skapa ett konto till kunden
		_banklogic.addSavingsAccount(pNr);

		// Test ett lycka ins�ttning
		Assert.assertTrue(_banklogic.deposit(pNr, 1001, 10));

		// Test misslycka ins�ttning
		Assert.assertFalse(_banklogic.deposit(pNr, 1005, 10));
		Assert.assertFalse(_banklogic.deposit(0000, 1001, 10));
	}

	// Test uttag
	@Test
	public void testwithDraw() {
		int pNr = 12345;

		// skapa en kund
		_banklogic.addCustomer("anna", pNr);

		// skapa ett konto till kunden
		_banklogic.addSavingsAccount(pNr);

		// l�gga till 5000 p� konto
		_banklogic.deposit(pNr, 1001, 5000);

		// Test lycka uttag
		Assert.assertTrue(_banklogic.withdraw(pNr, 1001, 4000));

		// Test misslycka uttag
		Assert.assertFalse(_banklogic.withdraw(pNr, 1001, 1000000));
	}

	// Test st�nga konto
	@Test
	public void testcloseAccount() {
		int pNr = 12345;

		// skapa en kund
		_banklogic.addCustomer("anna", pNr);

		// skapa ett konto till kunden
		_banklogic.addSavingsAccount(pNr);

		// st�nger ett konto som existera
		Assert.assertNotNull("Skall inte vara Null", _banklogic.closeAccount( pNr, 1001 ));

		// st�nger ett konto som inte existera
		Assert.assertNull("Skall vara Null", _banklogic.closeAccount( pNr, 1005 ));
		Assert.assertNull("Skall vara Null", _banklogic.closeAccount( 0000, 1001 ));
	}
}
