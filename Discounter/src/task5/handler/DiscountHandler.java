package task5.handler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import task5.data.Bill;
import task5.data.Customer;

public class DiscountHandler {

	private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	private Session session;
	private Transaction transaction = null;
	
	public Customer getCustomer(String username) {
		Customer customer = null;
		String queryString = "from Customer c where c.username = " + "\'" + username +"\'";
		List<Customer> result = executeQuery(queryString);
		if(result != null &&!result.isEmpty())
			customer = result.get(0);
		return customer;
	}

	public boolean hasAtLeast20PercentRevenueInPeerGroup(Customer customer) {
		if(customer == null)
			throw new IllegalArgumentException("Customer does not exist");
		
		LocalDate fiveYearsYounger = calculatePeerRangeOneSide(customer.getBirthDate(), -5);
		LocalDate fiveYearsOlder = calculatePeerRangeOneSide(customer.getBirthDate(), 5);
		String queryString = "from Customer c where c.birthDate between " + "\'" + fiveYearsYounger + "\'" + 
		" and " +  "\'" + fiveYearsOlder + "\'";
		List<Customer> result = executeQuery(queryString);
		double revenueOfPeerGroup = calculatePeerGroupRevenue(result.stream().map(x -> x.getBills()).collect(Collectors.toList()));
		double revenueOfCustomer = calculateCustomerRevenue(customer.getBills());
		if(hasCertainPercentOfPeerGroupRevenue(revenueOfPeerGroup, revenueOfCustomer, 0.2))
			return true;
		return false;
	}

	private List<Customer> executeQuery(String queryString) {
		List<Customer> result = new ArrayList<>();
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Query<Customer> query = session.createQuery(queryString);
			result = query.list();
			transaction.commit();
			}catch (HibernateException e) {
				if(transaction != null)
					transaction.rollback();
				e.printStackTrace();
			}
		return result;
	}

	private boolean hasCertainPercentOfPeerGroupRevenue(double revenueOfGroup, double revenueOfCustomer, double percentAmount) {
		return (revenueOfCustomer / revenueOfGroup > percentAmount) ? true : false;
	}

	private double calculateCustomerRevenue(List<Bill> bills) {
		double totalRevenue = 0;
		for (Bill bill : bills) {
			totalRevenue += bill.getTotalValue();
		}
		return totalRevenue;
	}

	private double calculatePeerGroupRevenue(List<List<Bill>> billList) {
		double totalRevenue = 0;
		for (List<Bill> bills : billList) {
			for (Bill bill : bills) {
				totalRevenue += bill.getTotalValue();
			}
		}
		return totalRevenue;
	}

	private LocalDate calculatePeerRangeOneSide(LocalDate localDate, int i) {
		LocalDate resultDate = LocalDate.of(localDate.getYear()+i, localDate.getMonth(), localDate.getDayOfMonth());
		return resultDate;
	}

	public boolean hasAtLeast10PercentRevenueInGeneral(Customer customer) {
		if(customer == null)
			throw new IllegalArgumentException("Customer does not exist");
		
		String queryString = "from Customer c";
		List<Customer> result = executeQuery(queryString);
		double revenueOfGroup = calculatePeerGroupRevenue(result.stream().map(x -> x.getBills()).collect(Collectors.toList()));
		double revenueOfCustomer = calculateCustomerRevenue(customer.getBills());

		if(hasCertainPercentOfPeerGroupRevenue(revenueOfGroup, revenueOfCustomer, 0.1))
			return true;
		return false;
	}

}
