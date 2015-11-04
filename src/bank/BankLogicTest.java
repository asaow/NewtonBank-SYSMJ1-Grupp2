package bank;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class BankLogicTest {
	private BankLogic _banklogic = new BankLogic();
	
//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	
	@Test
	public void testAddCustomer() {
		_banklogic.addCustomer("anna", 12345);
		Assert.assertEquals(1, _banklogic.getCustomersCount());
		_banklogic.addCustomer("nicklas", 234556);
		Assert.assertEquals(2, _banklogic.getCustomersCount());
		_banklogic.addCustomer("anna", 12345);
		Assert.assertEquals(2, _banklogic.getCustomersCount());
		
	}	

}
