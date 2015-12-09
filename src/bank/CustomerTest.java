package bank;

import static org.junit.Assert.fail;

import org.junit.Test;

import org.junit.Assert;

public class CustomerTest {
	
	

	@Test
	public void testSetName() {
	Customer c = new Customer("Hamid", 9229);
	c.setName("Hampus");
	Assert.assertEquals(c.getName(), "Hampus");
	
	}

	@Test
	public void testSetPNr() {
		Customer c = new Customer(" ", 1991);
		c.setPNr(1994);
		Assert.assertEquals(c.getPNr(), 1994);
	}

}
