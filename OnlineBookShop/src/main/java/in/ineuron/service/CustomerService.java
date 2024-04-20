package in.ineuron.service;

import in.ineuron.dto.Customer;

public interface CustomerService {

	public String addCustomer(Customer customer);
	
	public String verifyCustomer(String email, String password);
	
	public int getCustometerId(String email);
	
	public Customer searchCustomer(Integer cid);
	
	public String updateCustomer(Customer customer);
	
	public String deleteCustomer(Integer cid);
}
