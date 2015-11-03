package bank;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CustomerTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

/*	@Test
	public void test() {
		fail("Not yet implemented");
	}*/
	
	@Test
	public void testCreateCustomer() {
		Customer customer = new Customer("Hampus", 656438);
		Assert.assertEquals(customer.getName(),"Hampus"); //testar om vi har skapat en ny kund som heter hampus
		
	}
}
