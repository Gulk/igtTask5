package task5.data;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@Column(name = "CustomerId", nullable = false)
	private int customerId;
	
	@Column(name = "Surname", nullable = false)
	private String name;
	
	@Column(name = "Forename", nullable = false)
	private String forename;
	
	@Column(name = "BirthDate", nullable = false)
	private LocalDate birthDate;
	
	@Column(name = "Username", nullable = false)
	private String username;
	
	@OneToMany(mappedBy="customer")
	private List<Bill> bills;

	public int getCustomerId() {
		return customerId;
	}

	public String getName() {
		return name;
	}

	public String getForename() {
		return forename;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public List<Bill> getBills() {
		return bills;
	}
	
	public String getUsername() {
		return username;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}
	
}