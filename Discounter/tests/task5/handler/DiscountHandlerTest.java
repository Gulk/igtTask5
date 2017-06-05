package task5.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import task5.data.Customer;

public class DiscountHandlerTest {

	private DiscountHandler discountHandler;

	@Before
	public void setUp() throws Exception {
		discountHandler = new DiscountHandler();
	}


	@Test
	public void testGetCustomerGetExistingCustomer() {
		//given
		String expected = "Hulk";
		//when
		Customer customer = discountHandler.getCustomer("Hulk");
		//then
		assertNotNull(customer);
		assertEquals(expected, customer.getUsername());
	}

	@Test
	public void testGetCustomerGetNonExistingCustomer() {
		//given
		//when
		Customer customer = discountHandler.getCustomer("Batman");
		//then
		assertNull(customer);
	}

	@Test
	public void testGetCustomerNull() {
		//given
		//when
		Customer customer = discountHandler.getCustomer(null);
		//then
		assertNull(customer);
	}

	@Test
	public void testHasTop10ProzentUmsatz() {
		//given
		Customer customer = discountHandler.getCustomer("Thing");
		//when
		boolean result = discountHandler.hasAtLeast10PercentRevenueInGeneral(customer);
		//then
		assertTrue(result);
	}

	@Test
	public void testHasNotTop10ProzentUmsatz() {
		//given
		Customer customer = discountHandler.getCustomer("X-23");
		//when
		boolean result = discountHandler.hasAtLeast10PercentRevenueInGeneral(customer);
		//then
		assertFalse(result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testHasTop10ProzentUmsatzUserDoesNotExist() {
		//given
		Customer customer = discountHandler.getCustomer("Batman");
		//when
		boolean result = discountHandler.hasAtLeast10PercentRevenueInGeneral(customer);
		//then
		assertFalse(result);
	}

	@Test
	public void testHasTop20ProzentUmsatzInPeerGroup() {
		//given
		Customer customer = discountHandler.getCustomer("X-23");
		//when
		boolean result = discountHandler.hasAtLeast20PercentRevenueInPeerGroup(customer);
		//then
		assertTrue(result);
	}

	@Test
	public void testHasNotTop20ProzentUmsatzInPeerGroup() {
		//given
		Customer customer = discountHandler.getCustomer("Deadpool");
		//when
		boolean result = discountHandler.hasAtLeast20PercentRevenueInPeerGroup(customer);
		//then
		assertFalse(result);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testHasTop20ProzentUmsatzInPeerGroupUserDoesNotExist() {
		//given
		Customer customer = discountHandler.getCustomer("Batman");
		//when
		boolean result = discountHandler.hasAtLeast20PercentRevenueInPeerGroup(customer);
		//then
		assertFalse(result);
	}

}
