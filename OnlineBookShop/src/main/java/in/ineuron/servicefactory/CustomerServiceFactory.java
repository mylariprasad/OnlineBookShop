package in.ineuron.servicefactory;

import in.ineuron.service.CustomerService;
import in.ineuron.service.CustomerServiceImpl;

public class CustomerServiceFactory {
	private CustomerServiceFactory() {
		
	}
	
	private static CustomerService customerService = null;
	
	public static CustomerService getServiceFactory() {
		if(customerService == null) {
			customerService = new CustomerServiceImpl();
		}
		return customerService;
	}
}
