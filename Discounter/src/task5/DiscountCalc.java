package task5;

import task5.data.Customer;
import task5.handler.DiscountHandler;

public class DiscountCalc {

	private DiscountHandler discHelper;
	
	public DiscountCalc() {
		this.discHelper = new DiscountHandler();
	}
	
	public static void main(String[] args) {
		System.out.println(new DiscountCalc().getDiscountAmount("Deadpool"));
	}
	
	public int getDiscountAmount(String username) {
		
		Customer customer = discHelper.getCustomer(username);
		if (customer == null)
			return -1;
		return verifyDiscount(customer);
	}


	private int verifyDiscount(Customer customer) {
		if (discHelper.hasAtLeast20PercentRevenueInPeerGroup(customer) || 
				discHelper.hasAtLeast10PercentRevenueInGeneral(customer)) {
			return 20;
		}else
			return 0;
	}
	
}
