package bank;

import static org.junit.Assert.*;

import java.util.ArrayList;

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
	//Testar om en customer har skapats
	public void testCreateCustomer() {
		Customer customer = new Customer("Hampus", 656438);
		Assert.assertEquals(customer.getName(),"Hampus"); //testar om vi har skapat en ny kund som heter hampus
		
	}
	@Test
	//Testar om det finns ett account som tillhör en customer
	public void testAddAccountToCustomer() {
		SavingsAccount sa = new SavingsAccount(1003, 0.1);
		Customer c = new Customer("ggg", 455);
		c.addAccount(sa);
		ArrayList <SavingsAccount> al = c.getAccount();
		Assert.assertEquals(al.size(),1); //Checkar hur många accounts det finns i listan. (Vi vet listan var tom från början och att värdet är nu 1)
	}
	
}
