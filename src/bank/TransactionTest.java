package bank;

import org.junit.Assert;
import org.junit.Test;

public class TransactionTest {

	@Test
	public void testGetAccountId() { 
		Transaction t = new Transaction(1002, "UT", 0, 0);
		Assert.assertEquals(t.getAccountId(), 1002);
	}

	@Test
	public void testSetAccountId() {
		Transaction t = new Transaction(1002, "UT", 0, 0);
		t.setAccountId(1005);
		Assert.assertEquals(t.getAccountId(), 1005);
	}

	@Test
	public void testGetAmount() {
		Transaction t = new Transaction(1002, "UT", 100.00, 0);
		Assert.assertEquals(t.getAmount(), 100.00, 0);
	}

	@Test
	public void testSetAmount() {
		Transaction t = new Transaction(1002, "UT", 0, 0);
		t.setAmount(100.00);
		Assert.assertEquals(t.getAmount(), 100.00, 0);
	}

	@Test
	public void testGetBalance() {
		Transaction t = new Transaction(1002, "UT", 0, 0);
		Assert.assertEquals(t.getBalance(), 0, 0);
	}

	@Test
	public void testSetBalance() {
		Transaction t = new Transaction(1002, "UT", 0, 0);
		t.setBalance(5000);
		Assert.assertEquals(t.getBalance(), 5000, 0);
	}

}
