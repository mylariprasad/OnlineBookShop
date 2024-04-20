package in.ineuron.dao;

import in.ineuron.dto.Customer;

public interface CustomerDao {
	
	public String addCustomer(Customer customer);
	
	public Customer searchCustomer(Integer cid);
	
	public String updateCustomer(Customer customer);
	
	public String deleteCustomer(Integer cid);
	
	public String verifyCustomer(String email, String password);

	public int getCustomerId(String email);
}
