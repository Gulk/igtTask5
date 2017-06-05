package task5;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DiscountCalcTest {
	
	private DiscountCalc discountCalc;

	@Before
	public void setUp() throws Exception {
		discountCalc = new DiscountCalc();
	}

	@Test
	public void getDiscountAmount_NoDiscount() {
		assertEquals(0, discountCalc.getDiscountAmount("Deadpool"));
	}

	@Test
	public void getDiscountAmount_TopTenDiscount() {
		assertEquals(20, discountCalc.getDiscountAmount("Thing"));
	}

	@Test
	public void getDiscountAmount_TopTwentyDiscoun() {
		assertEquals(20, discountCalc.getDiscountAmount("X-23"));
	}

	@Test
	public void getDiscountAmount_NonExistingCustomer() {
		assertEquals(-1, discountCalc.getDiscountAmount("Batman"));
	}
}
