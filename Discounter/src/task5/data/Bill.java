package task5.data;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bill")
public class Bill {

	@Id
	@Column(name = "BillId", nullable = false)
	private int billId;
	
	@Column(name = "TotalValue", nullable = false)
	private int totalValue;
	
	@Column(name = "PurchaseDate", nullable = false)
	private LocalDate pruchaseDate;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "Bill_Customer_Id", nullable = false, insertable = false, updatable = false)
	private Customer customer;

	public int getBillId() {
		return billId;
	}

	public int getTotalValue() {
		return totalValue;
	}

	public LocalDate getPruchaseDate() {
		return pruchaseDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}

	public void setPruchaseDate(LocalDate pruchaseDate) {
		this.pruchaseDate = pruchaseDate;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
