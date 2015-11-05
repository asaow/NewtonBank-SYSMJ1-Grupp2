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

	// Test om en kund existera och inte existera
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
}
